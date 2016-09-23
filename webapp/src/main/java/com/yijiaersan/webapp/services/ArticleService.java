package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.Article;

public interface ArticleService {

    int insert(Article record);

    int insertSelective(Article record);
    
    Article selectArticle(Long articleId);
    
    List<Article> selectAllArticle();
    
    List<Article> selectKindArticle();
}
