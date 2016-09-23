package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class Result implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5373275441765056885L;
	private String err_code;
	private String model;
	private String success;
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	
}
