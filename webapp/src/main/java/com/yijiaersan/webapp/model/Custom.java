package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class Custom implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2266577505642947755L;

	private Long customId;

    private String sharesCode;

    private Long userId;

    private Date addDate;

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode == null ? null : sharesCode.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}