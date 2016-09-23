package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class SharesModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5677411779549946384L;
	private String sharesCode;
	private String sharesName;
	private String currentPrice;
	private String increase;
	public String getSharesCode() {
		return sharesCode;
	}
	public void setSharesCode(String sharesCode) {
		this.sharesCode = sharesCode;
	}
	public String getSharesName() {
		return sharesName;
	}
	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getIncrease() {
		return increase;
	}
	public void setIncrease(String increase) {
		this.increase = increase;
	}
	
	
}
