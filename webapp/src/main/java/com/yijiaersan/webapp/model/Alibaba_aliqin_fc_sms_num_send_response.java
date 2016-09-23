package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class Alibaba_aliqin_fc_sms_num_send_response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3085386629898735003L;
	private Result result;
	private String request_id;
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	
	
}
