package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class TokenInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6349037408486827649L;

	private Long mainId;

    private String token;

    private String userInfo;
    
    private String phoneNum;
    

    public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }
}