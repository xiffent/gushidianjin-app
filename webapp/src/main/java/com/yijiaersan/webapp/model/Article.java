package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class Article
  implements Serializable
{
  private static final long serialVersionUID = 2157197308632129617L;
  private Long articleId;
  private Long userId;
  private String articleTitle;
  private String articleAuthor;
  private String articleCoverUrl;
  private String isVipArticle;
  private String creatDate;
  private Long articleTypeId;
  private String isDraft;
  private String kind;
  private Date kindDate;
  private String auditingFlag;
  private String articleContent;
  private String cDate;

  public String getcDate()
  {
    return this.cDate;
  }

  public void setcDate(String cDate) {
    this.cDate = cDate;
  }

  public Long getArticleId() {
    return this.articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getArticleTitle() {
    return this.articleTitle;
  }

  public void setArticleTitle(String articleTitle) {
    this.articleTitle = ((articleTitle == null) ? null : articleTitle.trim());
  }

  public String getArticleAuthor() {
    return this.articleAuthor;
  }

  public void setArticleAuthor(String articleAuthor) {
    this.articleAuthor = ((articleAuthor == null) ? null : articleAuthor.trim());
  }

  public String getArticleCoverUrl() {
    return this.articleCoverUrl;
  }

  public void setArticleCoverUrl(String articleCoverUrl) {
    this.articleCoverUrl = ((articleCoverUrl == null) ? null : articleCoverUrl.trim());
  }

  public String getIsVipArticle() {
    return this.isVipArticle;
  }

  public void setIsVipArticle(String isVipArticle) {
    this.isVipArticle = ((isVipArticle == null) ? null : isVipArticle.trim());
  }

  public String getCreatDate() {
    return this.creatDate;
  }

  public void setCreatDate(String creatDate) {
    this.creatDate = creatDate;
  }

  public Long getArticleTypeId() {
    return this.articleTypeId;
  }

  public void setArticleTypeId(Long articleTypeId) {
    this.articleTypeId = articleTypeId;
  }

  public String getIsDraft() {
    return this.isDraft;
  }

  public void setIsDraft(String isDraft) {
    this.isDraft = ((isDraft == null) ? null : isDraft.trim());
  }

  public String getKind() {
    return this.kind;
  }

  public void setKind(String kind) {
    this.kind = ((kind == null) ? null : kind.trim());
  }

  public Date getKindDate() {
    return this.kindDate;
  }

  public void setKindDate(Date kindDate) {
    this.kindDate = kindDate;
  }

  public String getAuditingFlag() {
    return this.auditingFlag;
  }

  public void setAuditingFlag(String auditingFlag) {
    this.auditingFlag = ((auditingFlag == null) ? null : auditingFlag.trim());
  }

  public String getArticleContent() {
    return this.articleContent;
  }

  public void setArticleContent(String articleContent) {
    this.articleContent = ((articleContent == null) ? null : articleContent.trim());
  }
}