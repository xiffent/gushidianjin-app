package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1559354008693867027L;

	private Long userId;

	private String userName;

	private String password;

	private String userTel;

	private String userEmail;

	private String headPic;

	private String userType;

	private Date creatDate;

	private String useEquipment;
	
	private String token;
	
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel == null ? null : userTel.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic == null ? null : headPic.trim();
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getUseEquipment() {
		return useEquipment;
	}

	public void setUseEquipment(String useEquipment) {
		this.useEquipment = useEquipment == null ? null : useEquipment.trim();
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", userTel=" + userTel
				+ ", userEmail=" + userEmail + ", headPic=" + headPic
				+ ", userType=" + userType + ", creatDate=" + creatDate
				+ ", useEquipment=" + useEquipment + "]";
	}

}