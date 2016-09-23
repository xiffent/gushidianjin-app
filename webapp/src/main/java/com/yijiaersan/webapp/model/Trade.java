package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Trade implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1477605158390956357L;

	private Long tradeId;

    private String tradeCode;

    private String tradeName;

    private BigDecimal tradeChangeRote;

    private Date tradeDate;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName == null ? null : tradeName.trim();
    }

    public BigDecimal getTradeChangeRote() {
        return tradeChangeRote;
    }

    public void setTradeChangeRote(BigDecimal tradeChangeRote) {
        this.tradeChangeRote = tradeChangeRote;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
}