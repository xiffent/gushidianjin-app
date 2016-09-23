package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class Share implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6343506397930240318L;

	private Long sharesId;

    private Long stockId;

    private String sharesCode;

    private String sharesName;
    
    private String sharesPy;
    
    private int version;
    
    
    public String getSharesPy() {
		return sharesPy;
	}

	public void setSharesPy(String sharesPy) {
		this.sharesPy = sharesPy;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getSharesId() {
        return sharesId;
    }

    public void setSharesId(Long sharesId) {
        this.sharesId = sharesId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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
}