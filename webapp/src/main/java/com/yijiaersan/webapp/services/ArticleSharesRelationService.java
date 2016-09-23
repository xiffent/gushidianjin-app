package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.ArticleSharesRelation;

public interface ArticleSharesRelationService {

	int insert(ArticleSharesRelation record);

    int insertSelective(ArticleSharesRelation record);
    
    List<ArticleSharesRelation> selectArticleSharesRelation(Long articleId);
    
    int insertArticleSharesRelationsList(List<ArticleSharesRelation> articleSharesRelations);
}
