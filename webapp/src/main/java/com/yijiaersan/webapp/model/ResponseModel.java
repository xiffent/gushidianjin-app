package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5982428839255912990L;

	private Article article;

	private ArticleType articleType;

	private List<ArticleSharesRelation> articleSharesRelations;

	private DayReference dayReference;
	

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleType getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public List<ArticleSharesRelation> getArticleSharesRelations() {
		return articleSharesRelations;
	}

	public void setArticleSharesRelations(
			List<ArticleSharesRelation> articleSharesRelations) {
		this.articleSharesRelations = articleSharesRelations;
	}

	public DayReference getDayReference() {
		return dayReference;
	}

	public void setDayReference(DayReference dayReference) {
		this.dayReference = dayReference;
	}

}
