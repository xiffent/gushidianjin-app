package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class ArticleSharesRelation implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2387396225202609418L;

	private Long id;

    private Long articleId;

    private String sharesId;

    private String sharesName;

    private Date creatDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getSharesId() {
        return sharesId;
    }

    public void setSharesId(String sharesId) {
        this.sharesId = sharesId;
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName == null ? null : sharesName.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}