package com.yijiaersan.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.model.ArticleList;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserCollection;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.ArticleWeblogic;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;
import com.yijiaersan.webapp.weblogic.UserCollectionWeblogic;

@RequestMapping("/userCollection")
@Controller
public class UserCollectionController {

	@Resource
	private UserCollectionWeblogic userCollectionWeblogic;

	@Resource
	private TokenWeblogic tokenWeblogic;
	@Resource
	private ArticleWeblogic articleWeblogic;

	@RequestMapping(value = "/addUserCollection", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity addUserCollection(String token, String articleid) {
		ResultEntity result = new ResultEntity();
		if (token == null || token.equals("")) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}
		TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
		if (tokenInfo == null) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}

		String str = tokenInfo.getUserInfo();
		UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

		UserCollection userCollection = userCollectionWeblogic.selectUserCollection(Long.parseLong(articleid),
				userInfo.getUserId());
		if (userCollection != null) {
			result.setRetCode("18");
			// result.setRetContent("");
			result.setRetMessage("你已添加改文章，请不要重复添加");
			return result;
		}

		try {
			userCollectionWeblogic.insertUserCollection(Long.parseLong(articleid), userInfo.getUserId());
			result.setRetCode("1");
			// result.setRetContent("");
			result.setRetMessage("添加收藏成功");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("添加收藏失败");
		}

		return result;
	}

	@RequestMapping(value = "/queryUserCollection", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity selectUserCollections(String token) {
		ResultEntity result = new ResultEntity();
		if (token == null || token.equals("")) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}
		TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
		if (tokenInfo == null) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}

		String str = tokenInfo.getUserInfo();
		UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);
		List<UserCollection> userCollections = new ArrayList<UserCollection>();
		try {
			userCollections = userCollectionWeblogic.selectUserCollectionList(userInfo.getUserId());

			List<Article> articles = new ArrayList<Article>();
			// articleWeblogic.queryArticle(articleId);

			for (int i = 0; i < userCollections.size(); i++) {
				Article article = new Article();
				UserCollection userCollection = userCollections.get(i);
				article = articleWeblogic.queryArticle(userCollection.getArticleId());
				articles.add(article);
			}

			List<ArticleList> articleList = new ArrayList<ArticleList>();
			articleList = articleWeblogic.queryList(articles);

			result.setRetCode("1");
			result.setRetContent(articleList);
			result.setRetMessage("查询用户收藏成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent();
			result.setRetMessage("服务器内部错误，查询用户收藏失败");
		}
		return result;
	}

	@RequestMapping(value = "/deleteUserCollection", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity deleteUserCollection(String token, String articleid) {
		ResultEntity result = new ResultEntity();
		if (token == null || token.equals("")) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}
		TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
		if (tokenInfo == null) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}

		String str = tokenInfo.getUserInfo();
		UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

		try {
			userCollectionWeblogic.deleteUserCollection(Long.parseLong(articleid), userInfo.getUserId());
			result.setRetCode("1");
			// result.setRetContent("");
			result.setRetMessage("删除收藏成功");
			return result;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("内部错误，删除收藏失败");
		}
		return result;
	}

}
