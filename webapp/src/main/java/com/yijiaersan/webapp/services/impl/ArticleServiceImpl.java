package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.ArticleMapper;
import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.services.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	@Override
	public int insert(Article record) {
		// TODO Auto-generated method stub
		return articleMapper.insert(record);
	}

	@Override
	public int insertSelective(Article record) {
		// TODO Auto-generated method stub
		return articleMapper.insertSelective(record);
	}

	@Override
	public Article selectArticle(Long articleId) {
		// TODO Auto-generated method stub
		return articleMapper.selectArticle(articleId);
	}

	@Override
	public List<Article> selectAllArticle() {
		// TODO Auto-generated method stub
		return articleMapper.selectAllArticle();
	}

	@Override
	public List<Article> selectKindArticle() {
		// TODO Auto-generated method stub
		return articleMapper.selectKindArticle();
	}

}
