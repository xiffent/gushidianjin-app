package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class VipPackage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2693709019733743660L;

	private Long pkgId;

	private String pkgName;

	private String pkgType;

	private Integer pkgPrice;

	private Integer pkgMouthPrice;

	private Integer pkgDate;

	public Integer getPkgDate() {
		return pkgDate;
	}

	public void setPkgDate(Integer pkgDate) {
		this.pkgDate = pkgDate;
	}

	public Long getPkgId() {
		return pkgId;
	}

	public void setPkgId(Long pkgId) {
		this.pkgId = pkgId;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName == null ? null : pkgName.trim();
	}

	public String getPkgType() {
		return pkgType;
	}

	public void setPkgType(String pkgType) {
		this.pkgType = pkgType == null ? null : pkgType.trim();
	}

	public Integer getPkgPrice() {
		return pkgPrice;
	}

	public void setPkgPrice(Integer pkgPrice) {
		this.pkgPrice = pkgPrice;
	}

	public Integer getPkgMouthPrice() {
		return pkgMouthPrice;
	}

	public void setPkgMouthPrice(Integer pkgMouthPrice) {
		this.pkgMouthPrice = pkgMouthPrice;
	}
}