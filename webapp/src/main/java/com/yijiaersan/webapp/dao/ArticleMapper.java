package com.yijiaersan.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.model.QueryArticleReqParams;

public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);
    
    Article selectArticle(@Param("articleId")Long articleId);
    
    List<Article> selectAllArticle();
    
    List<Article> selectKindArticle();
    
    List<Article> selectArticleList(QueryArticleReqParams paramQueryArticleReqParams);
}