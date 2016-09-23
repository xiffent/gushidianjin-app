package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.ArticleTypeMapper;
import com.yijiaersan.webapp.model.ArticleType;
import com.yijiaersan.webapp.services.ArticleTypeService;

@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {

	@Resource
	private ArticleTypeMapper articleTypeMapper;
	@Override
	public int insert(ArticleType record) {
		// TODO Auto-generated method stub
		return articleTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(ArticleType record) {
		// TODO Auto-generated method stub
		return articleTypeMapper.insertSelective(record);
	}

	@Override
	public ArticleType selectArticleType(Long articleTypeId) {
		// TODO Auto-generated method stub
		return articleTypeMapper.selectArticleType(articleTypeId);
	}

}
