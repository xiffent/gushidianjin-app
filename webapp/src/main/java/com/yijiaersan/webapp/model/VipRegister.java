package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class VipRegister implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8918525283717652374L;

	private Long vipId;

    private Long userId;

    private Long pkgId;

    private Date cteatDate;

    private Date failureDate;
    
    private String status;
    
    
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPkgId() {
        return pkgId;
    }

    public void setPkgId(Long pkgId) {
        this.pkgId = pkgId;
    }

    public Date getCteatDate() {
        return cteatDate;
    }

    public void setCteatDate(Date cteatDate) {
        this.cteatDate = cteatDate;
    }

    public Date getFailureDate() {
        return failureDate;
    }

    public void setFailureDate(Date failureDate) {
        this.failureDate = failureDate;
    }
}