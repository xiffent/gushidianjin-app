package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.ArticleSharesRelationMapper;
import com.yijiaersan.webapp.model.ArticleSharesRelation;
import com.yijiaersan.webapp.services.ArticleSharesRelationService;

@Service("articleSharesRelationService")
public class ArticleSharesRelationServiceImpl implements ArticleSharesRelationService{
	
	@Resource
	private ArticleSharesRelationMapper articleSharesRelationMapper;
	
	@Override
	public int insert(ArticleSharesRelation record) {
		// TODO Auto-generated method stub
		return articleSharesRelationMapper.insert(record);
	}

	@Override
	public int insertSelective(ArticleSharesRelation record) {
		// TODO Auto-generated method stub
		return articleSharesRelationMapper.insertSelective(record);
	}

	@Override
	public List<ArticleSharesRelation> selectArticleSharesRelation(
			Long articleId) {
		// TODO Auto-generated method stub
		return articleSharesRelationMapper.selectArticleSharesRelation(articleId);
	}

	@Override
	public int insertArticleSharesRelationsList(
			List<ArticleSharesRelation> articleSharesRelations) {
		// TODO Auto-generated method stub
		return articleSharesRelationMapper.insertArticleSharesRelationsList(articleSharesRelations);
	}

}
