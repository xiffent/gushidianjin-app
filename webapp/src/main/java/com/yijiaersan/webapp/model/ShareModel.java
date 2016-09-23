package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class ShareModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6343506397930240318L;


    private String sharesCode;

    private String sharesName;
    
    private String sharesPy;
    
    public String getSharesPy() {
		return sharesPy;
	}

	public void setSharesPy(String sharesPy) {
		this.sharesPy = sharesPy;
	}

	public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode == null ? null : sharesCode.trim();
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName == null ? null : sharesName.trim();
    }
}