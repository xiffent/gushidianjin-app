package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DayStock implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3316882754227581390L;

	private Long stockId;

    private String stockName;

    private BigDecimal stockYesterdayPoint;

    private BigDecimal stockCurrentPoint;

    private BigDecimal stockChange;

    private Integer stockChangeRote;

    private Date stockCurrentDate;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public BigDecimal getStockYesterdayPoint() {
        return stockYesterdayPoint;
    }

    public void setStockYesterdayPoint(BigDecimal stockYesterdayPoint) {
        this.stockYesterdayPoint = stockYesterdayPoint;
    }

    public BigDecimal getStockCurrentPoint() {
        return stockCurrentPoint;
    }

    public void setStockCurrentPoint(BigDecimal stockCurrentPoint) {
        this.stockCurrentPoint = stockCurrentPoint;
    }

    public BigDecimal getStockChange() {
        return stockChange;
    }

    public void setStockChange(BigDecimal stockChange) {
        this.stockChange = stockChange;
    }

    public Integer getStockChangeRote() {
        return stockChangeRote;
    }

    public void setStockChangeRote(Integer stockChangeRote) {
        this.stockChangeRote = stockChangeRote;
    }

    public Date getStockCurrentDate() {
        return stockCurrentDate;
    }

    public void setStockCurrentDate(Date stockCurrentDate) {
        this.stockCurrentDate = stockCurrentDate;
    }
}