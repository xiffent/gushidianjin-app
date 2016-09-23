package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class Carousel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6143431074220592525L;

	private Long carouselId;

    private String carouselUrl;

    private Integer carouselOrder;
    
    private Long articleId;
    

    public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Long getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Long carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl == null ? null : carouselUrl.trim();
    }

    public Integer getCarouselOrder() {
        return carouselOrder;
    }

    public void setCarouselOrder(Integer carouselOrder) {
        this.carouselOrder = carouselOrder;
    }
}