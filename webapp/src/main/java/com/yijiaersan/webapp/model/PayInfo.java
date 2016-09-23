package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class PayInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7805215724719267011L;

	private Long payId;

    private Long userId;

    private Integer payQuota;

    private String payType;

    private Date payDate;

    private String payState;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPayQuota() {
        return payQuota;
    }

    public void setPayQuota(Integer payQuota) {
        this.payQuota = payQuota;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }
}