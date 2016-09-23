package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class ArticleType implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1383195229394493810L;

	private Long articleTypeId;

    private String articleTypeName;

    private String articleTypeIcon;

    private String articleTypeRemarks;

    private Date creatDate;

    public Long getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Long articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName == null ? null : articleTypeName.trim();
    }

    public String getArticleTypeIcon() {
        return articleTypeIcon;
    }

    public void setArticleTypeIcon(String articleTypeIcon) {
        this.articleTypeIcon = articleTypeIcon == null ? null : articleTypeIcon.trim();
    }

    public String getArticleTypeRemarks() {
        return articleTypeRemarks;
    }

    public void setArticleTypeRemarks(String articleTypeRemarks) {
        this.articleTypeRemarks = articleTypeRemarks == null ? null : articleTypeRemarks.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}