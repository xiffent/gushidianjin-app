package com.yijiaersan.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.ArticleSharesRelation;

public interface ArticleSharesRelationMapper {
    int insert(ArticleSharesRelation record);

    int insertSelective(ArticleSharesRelation record);
    
    List<ArticleSharesRelation> selectArticleSharesRelation(@Param("articleId")Long articleId);
    
    
    int insertArticleSharesRelationsList(List<ArticleSharesRelation> articleSharesRelations);
}