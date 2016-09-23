package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class QueryArticleReqParams implements Serializable {
	private static final long serialVersionUID = -1137165277308759397L;
	private String createDateTime;
	private String articleTypeName;
	private String isVip;
	private int pageNo;
	private int pageSize;
	private int startRow;

	public int getStartRow() {
		return this.startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getArticleTypeName() {
		return this.articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	public String getIsVip() {
		return this.isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String toString() {
		return "QueryArticleReqParams [createDateTime=" + this.createDateTime
				+ ", articleTypeName=" + this.articleTypeName + ", isVip="
				+ this.isVip + ", pageNo=" + this.pageNo + ", pageSize="
				+ this.pageSize + "]";
	}
}