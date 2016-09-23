package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class ArticleSharesRelations implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2572220787992308163L;
	private String sharesName;
	
	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}
	
	public String getSharesName() {
		return sharesName;
	}
	
}
