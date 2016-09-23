package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DayShare implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 117646510134491227L;

	private Long daySharesId;

    private String sharesCode;

    private String sharesName;

    private BigDecimal yesterdayClosedPrice;

    private BigDecimal tadayOpingPrice;

    private BigDecimal tadayHighPrice;

    private BigDecimal tadayLowPrice;

    private BigDecimal tadayClosedPrice;

    private BigDecimal changeData;

    private Date tadayDate;

    public Long getDaySharesId() {
        return daySharesId;
    }

    public void setDaySharesId(Long daySharesId) {
        this.daySharesId = daySharesId;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode == null ? null : sharesCode.trim();
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName == null ? null : sharesName.trim();
    }

    public BigDecimal getYesterdayClosedPrice() {
        return yesterdayClosedPrice;
    }

    public void setYesterdayClosedPrice(BigDecimal yesterdayClosedPrice) {
        this.yesterdayClosedPrice = yesterdayClosedPrice;
    }

    public BigDecimal getTadayOpingPrice() {
        return tadayOpingPrice;
    }

    public void setTadayOpingPrice(BigDecimal tadayOpingPrice) {
        this.tadayOpingPrice = tadayOpingPrice;
    }

    public BigDecimal getTadayHighPrice() {
        return tadayHighPrice;
    }

    public void setTadayHighPrice(BigDecimal tadayHighPrice) {
        this.tadayHighPrice = tadayHighPrice;
    }

    public BigDecimal getTadayLowPrice() {
        return tadayLowPrice;
    }

    public void setTadayLowPrice(BigDecimal tadayLowPrice) {
        this.tadayLowPrice = tadayLowPrice;
    }

    public BigDecimal getTadayClosedPrice() {
        return tadayClosedPrice;
    }

    public void setTadayClosedPrice(BigDecimal tadayClosedPrice) {
        this.tadayClosedPrice = tadayClosedPrice;
    }

    public BigDecimal getChangeData() {
        return changeData;
    }

    public void setChangeData(BigDecimal changeData) {
        this.changeData = changeData;
    }

    public Date getTadayDate() {
        return tadayDate;
    }

    public void setTadayDate(Date tadayDate) {
        this.tadayDate = tadayDate;
    }
}