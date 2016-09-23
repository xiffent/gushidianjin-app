package com.yijiaersan.webapp.utils.result;


public class ResultEntity<T> extends Result  {

	private static final long serialVersionUID = -6547341289120281153L;
	
	public ResultEntity() {
		
	}
	
	public ResultEntity(String retCode, String retMessage) {
		super(retCode, retMessage);
	}
	
	public ResultEntity(String retCode, String retMessage,T retContent) {
		super(retCode, retMessage);
		this.retContent = retContent;
	}

	private T retContent;

	public T getRetContent() {
		return retContent;
	}

	public void setRetContent(T retContent) {
		this.retContent = retContent;
	}
	
	
}
