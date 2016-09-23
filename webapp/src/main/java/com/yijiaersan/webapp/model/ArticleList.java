package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.List;

public class ArticleList implements Serializable {
	private static final long serialVersionUID = -567919587335779138L;
	private Long articleId;
	private String articleTitle;
	private String articleCoverUrl;
	private String isVipArticle;
	private Long articleTypeId;
	private String articleTypeName;
	private List<ArticleSharesRelations> articleSharesRelations;
	private String isCollection = "0";

	public String getIsCollection() {
		return this.isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	public Long getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleCoverUrl() {
		return this.articleCoverUrl;
	}

	public void setArticleCoverUrl(String articleCoverUrl) {
		this.articleCoverUrl = articleCoverUrl;
	}

	public String getIsVipArticle() {
		return this.isVipArticle;
	}

	public void setIsVipArticle(String isVipArticle) {
		this.isVipArticle = isVipArticle;
	}

	public Long getArticleTypeId() {
		return this.articleTypeId;
	}

	public void setArticleTypeId(Long articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public String getArticleTypeName() {
		return this.articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	public List<ArticleSharesRelations> getArticleSharesRelations() {
		return this.articleSharesRelations;
	}

	public void setArticleSharesRelations(
			List<ArticleSharesRelations> articleSharesRelations) {
		this.articleSharesRelations = articleSharesRelations;
	}
}