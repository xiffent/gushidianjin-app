package com.yijiaersan.webapp.utils.result;


public class Result extends BaseEntity {

	private static final long serialVersionUID = -6547341289120281153L;
	
	public static final String SUCCESS_CODE = "1";
	
	public static final String FAIL_CODE="0";
	
	private String retCode;
	
	private String retMessage;
	
	public Result() {
	}
	
	public Result(String retCode, String retMessage) {
		super();
		this.retCode = retCode;
		this.retMessage = retMessage;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	
	public boolean isSuccess() {
		return SUCCESS_CODE.equals(getRetCode());
	}
	
}
