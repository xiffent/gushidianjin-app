package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.ArticleType;

public interface ArticleTypeService {
	int insert(ArticleType record);

    int insertSelective(ArticleType record);
    
    ArticleType selectArticleType(Long articleTypeId);
}
