package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
	private static final long serialVersionUID = -9059264653006642215L;
	private Long mainId;
	private String username;
	private String password;
	private String adminname;
	private String sex;
	private Integer age;
	private String tel;
	private Date createDatetime;
	private String status;

	public Long getMainId() {
		return this.mainId;
	}

	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = ((username == null) ? null : username.trim());
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = ((password == null) ? null : password.trim());
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = ((adminname == null) ? null : adminname.trim());
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = ((sex == null) ? null : sex.trim());
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = ((tel == null) ? null : tel.trim());
	}

	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = ((status == null) ? null : status.trim());
	}

	public String toString() {
		return "Admin [mainId=" + this.mainId + ", username=" + this.username
				+ ", password=" + this.password + ", adminname="
				+ this.adminname + ", sex=" + this.sex + ", age=" + this.age
				+ ", tel=" + this.tel + ", createDatetime="
				+ this.createDatetime + ", status=" + this.status + "]";
	}
}