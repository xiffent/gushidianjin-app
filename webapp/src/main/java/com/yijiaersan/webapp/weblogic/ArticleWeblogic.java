package com.yijiaersan.webapp.weblogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.model.ArticleList;
import com.yijiaersan.webapp.model.ArticleSharesRelation;
import com.yijiaersan.webapp.model.ArticleSharesRelations;
import com.yijiaersan.webapp.model.ArticleType;
import com.yijiaersan.webapp.model.DayReference;
import com.yijiaersan.webapp.model.QueryArticleRespModel;
import com.yijiaersan.webapp.model.ResponseModel;
import com.yijiaersan.webapp.services.ArticleService;
import com.yijiaersan.webapp.services.ArticleSharesRelationService;
import com.yijiaersan.webapp.services.ArticleTypeService;
import com.yijiaersan.webapp.services.DayReferenceService;
import com.yijiaersan.webapp.utils.DateUtil;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.utils.Sequence;
import com.yijiaersan.webapp.utils.common.Content;
import com.yijiaersan.webapp.utils.result.ResultEntity;

public class ArticleWeblogic {

	@Resource
	private ArticleService articleService;

	@Resource
	private ArticleSharesRelationService articleSharesRelationService;

	@Resource
	private ArticleTypeService articleTypeService;

	@Resource
	private DayReferenceService dayReferenceService;

	public ResultEntity<String> insertArticleInfo(Long userId, String jsonData) {
		ResultEntity result = new ResultEntity();
		try {
			Long articleId = Sequence.nextId();
			Long articleTypeId = Sequence.nextId();

			ResponseModel responseModel = (ResponseModel) JSONUtil.json2Bean(
					jsonData, ResponseModel.class);

			Article article = responseModel.getArticle();
			article.setArticleId(articleId);
			article.setUserId(userId);
			article.setCreatDate(DateUtil.getTime());
			System.out.println(DateUtil.getNowDate());
			article.setArticleTypeId(articleTypeId);
			article.setIsDraft("1");
			article.setKind("1");
			article.setAuditingFlag("1");
			this.articleService.insertSelective(article);
			ArticleType articleType = responseModel.getArticleType();
			articleType.setArticleTypeId(articleTypeId);
			articleType.setCreatDate(DateUtil.getNowDate());
			articleType.setArticleTypeRemarks(articleType.getArticleTypeName());
			this.articleTypeService.insertSelective(articleType);
			List articleSharesRelations = responseModel
					.getArticleSharesRelations();

			List articleSharesRelationsNew = new ArrayList();

			for (int i = 0; i < articleSharesRelations.size(); ++i) {
				ArticleSharesRelation articleSharesRelation = (ArticleSharesRelation) articleSharesRelations
						.get(i);
				articleSharesRelation.setArticleId(articleId);
				articleSharesRelation.setCreatDate(DateUtil.getNowDate());
				articleSharesRelation.setId(Sequence.nextId());
				articleSharesRelation.setCreatDate(new Date());
				articleSharesRelationsNew.add(articleSharesRelation);
			}

			this.articleSharesRelationService
					.insertArticleSharesRelationsList(articleSharesRelationsNew);

			if (responseModel.getDayReference() != null) {
				DayReference dayReference = responseModel.getDayReference();
				dayReference.setArticleId(articleId);
				dayReference.setId(Sequence.nextId());
				this.dayReferenceService.insertSelective(dayReference);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setRetCode(Content.FAILD);

			result.setRetMessage("添加文章信息失败");
		}

		return result;
	}

	public ResultEntity<ResponseModel> queryArticleDetail(Long articleId) {
		ResultEntity resultEntity = new ResultEntity();
		ResponseModel responseModel = new ResponseModel();
		Article article = this.articleService.selectArticle(articleId);
		if (article != null) {
			responseModel.setArticle(article);
		}
		ArticleType articleType = this.articleTypeService
				.selectArticleType(article.getArticleTypeId());
		if (articleType != null) {
			responseModel.setArticleType(articleType);
		}

		List articleSharesRelations = this.articleSharesRelationService
				.selectArticleSharesRelation(articleId);
		if ((articleSharesRelations.size() != 0)
				&& (articleSharesRelations != null)) {
			responseModel.setArticleSharesRelations(articleSharesRelations);
		}

		DayReference dayReference = this.dayReferenceService
				.selectDayReference(articleId);
		if (dayReference != null) {
			responseModel.setDayReference(dayReference);
		}
		resultEntity.setRetContent(responseModel);
		resultEntity.setRetCode(Content.OK);
		resultEntity.setRetMessage("查询成功！");
		return resultEntity;
	}

	public ResultEntity<List<ArticleList>> queryArticleList() {
		ResultEntity resultEntity = new ResultEntity();

		List articleList = new ArrayList();

		List articleKind = this.articleService.selectKindArticle();
		if ((articleKind != null) && (articleKind.size() != 0)) {
			articleList = queryList(articleKind);
		}

		List articles = this.articleService.selectAllArticle();
		if ((articles != null) || (articles.size() != 0)) {
			articleList.addAll(queryList(articles));
		}

		resultEntity.setRetContent(articleList);
		resultEntity.setRetCode(Content.OK);
		resultEntity.setRetMessage("查询成功！");
		return resultEntity;
	}

	public List<ArticleList> queryList(List<Article> articles) {
		List articleLists = new ArrayList();

		for (int i = 0; i < articles.size(); ++i) {
			Article article = (Article) articles.get(i);
			ArticleList articleList = new ArticleList();
			List articleSharesRelations = new ArrayList();

			articleList.setArticleCoverUrl(article.getArticleCoverUrl());
			articleList.setArticleId(article.getArticleId());
			articleList.setArticleTitle(article.getArticleTitle());
			articleList.setArticleTypeId(article.getArticleTypeId());
			articleList.setIsVipArticle(article.getIsVipArticle());

			List asr = this.articleSharesRelationService
					.selectArticleSharesRelation(article.getArticleId());

			for (int j = 0; j < asr.size(); ++j) {
				ArticleSharesRelations asrs = new ArticleSharesRelations();
				ArticleSharesRelation articleSharesRelation = (ArticleSharesRelation) asr
						.get(j);
				asrs.setSharesName(articleSharesRelation.getSharesName());
				articleSharesRelations.add(asrs);
			}
			articleList.setArticleSharesRelations(articleSharesRelations);

			ArticleType articleType = this.articleTypeService
					.selectArticleType(article.getArticleTypeId());
			if(articleType != null && articleType.getArticleTypeName()!=null&&!articleType.getArticleTypeName().endsWith("")){
				articleList.setArticleTypeName(articleType.getArticleTypeName());
			}
			

			articleLists.add(articleList);
		}

		return articleLists;
	}

	public Article queryArticle(Long articleId) {
		return this.articleService.selectArticle(articleId);
	}

	public List<QueryArticleRespModel> adminQueryArticleList() {
		return null;
	}
}