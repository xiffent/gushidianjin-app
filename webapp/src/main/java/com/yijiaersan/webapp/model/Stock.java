package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class Stock implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6402762191754076286L;

	private Long stockId;

    private String stockName;

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
}