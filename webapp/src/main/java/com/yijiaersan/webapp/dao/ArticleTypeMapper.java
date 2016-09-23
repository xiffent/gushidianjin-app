package com.yijiaersan.webapp.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.ArticleType;

public interface ArticleTypeMapper {
    int insert(ArticleType record);

    int insertSelective(ArticleType record);
    
    ArticleType selectArticleType(@Param("articleTypeId")Long articleTypeId);
}