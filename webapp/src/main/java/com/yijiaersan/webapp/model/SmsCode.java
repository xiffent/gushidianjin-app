package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class SmsCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6257753584704443064L;
	private Long mainId;
	private String code;

	private String telphone;

	private Date sendtime;

	public Long getMainId() {
		return mainId;
	}

	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone == null ? null : telphone.trim();
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
}