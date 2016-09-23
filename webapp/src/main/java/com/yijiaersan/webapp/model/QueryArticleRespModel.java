package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class QueryArticleRespModel implements Serializable {
	private static final long serialVersionUID = 1450893773230642809L;
	private Long articleId;
	private String articleTitle;
	private String articleAuthor;
	private String articleTypeName;
	private String articleType;
	private String creatDate;

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

	public String getArticleAuthor() {
		return this.articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleTypeName() {
		return this.articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	public String getArticleType() {
		return this.articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getCreatDate() {
		return this.creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String toString() {
		return "QueryArticleRespModel [articleId=" + this.articleId
				+ ", articleTitle=" + this.articleTitle + ", articleAuthor="
				+ this.articleAuthor + ", articleTypeName="
				+ this.articleTypeName + ", articleType=" + this.articleType
				+ ", creatDate=" + this.creatDate + "]";
	}
}