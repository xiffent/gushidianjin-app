package com.yijiaersan.webapp.model;

import java.io.Serializable;

public class DayReference implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7288962060540844541L;

	private Long id;

    private Long articleId;

    private String storeNum;

    private String shortDate;

    private String longDate;

    private String hotPoint;

    private String operStrategy;

    private String dangerCue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum == null ? null : storeNum.trim();
    }

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate == null ? null : shortDate.trim();
    }

    public String getLongDate() {
        return longDate;
    }

    public void setLongDate(String longDate) {
        this.longDate = longDate == null ? null : longDate.trim();
    }

    public String getHotPoint() {
        return hotPoint;
    }

    public void setHotPoint(String hotPoint) {
        this.hotPoint = hotPoint == null ? null : hotPoint.trim();
    }

    public String getOperStrategy() {
        return operStrategy;
    }

    public void setOperStrategy(String operStrategy) {
        this.operStrategy = operStrategy == null ? null : operStrategy.trim();
    }

    public String getDangerCue() {
        return dangerCue;
    }

    public void setDangerCue(String dangerCue) {
        this.dangerCue = dangerCue == null ? null : dangerCue.trim();
    }
}