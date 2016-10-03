package com.yijiaersan.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiaersan.webapp.model.Custom;
import com.yijiaersan.webapp.model.SharesModel;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.CustomWeblogic;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;

@Controller
@RequestMapping("/customShares")
public class CustomController {

	@Resource
	private CustomWeblogic customWeblogic;

	@Resource
	private TokenWeblogic tokenWeblogic;

	@RequestMapping(value = "/addCustomShare", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<String> insertCustomShareInfo(String sharecode, String token) {
		ResultEntity<String> result = new ResultEntity<String>();

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
			result.setRetMessage("用户信息无效");
			return result;
		}
		String str = tokenInfo.getUserInfo();
		UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

		Custom custom = customWeblogic.selectCustom(sharecode, userInfo.getUserId());
		if (custom != null) {
			result.setRetCode("2");
			// result.setRetContent("");
			result.setRetMessage("你已添加改支股票，请不要重复添加");
			return result;
		}

		try {
			customWeblogic.insertCustomInfo(sharecode, String.valueOf(userInfo.getUserId()));
			result.setRetCode("1");
			// result.setRetContent("");
			result.setRetMessage("添加成功");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setRetCode("0");
			result.setRetMessage("内部错误，发送失败");
			// result.setRetContent("");
		}

		return result;
	}

	@RequestMapping(value = "/cancelCustShare", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<String> cancelCustomShare(String sharecode, String token) {
		ResultEntity<String> result = new ResultEntity<String>();

		if (token == null || token.equals("")) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}

		TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
		if (tokenInfo == null) {
			result.setRetCode("3");
			result.setRetMessage("用户登录信息失效！");
			// result.setRetContent("");
			return result;
		}
		String str = tokenInfo.getUserInfo();
		UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

		Custom custom = customWeblogic.selectCustom(sharecode, userInfo.getUserId());
		if (custom == null) {
			result.setRetCode("4");
			result.setRetMessage("查无数据！");
			// result.setRetContent("");
			return result;
		}

		try {
			customWeblogic.deleteCustomShares(sharecode, userInfo.getUserId());
			result.setRetCode("1");
			// result.setRetContent("");
			result.setRetMessage("取消成功");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("内部错误，取消失败");
		}
		return result;
	}

	@RequestMapping(value = "/queryCustomList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity queryCustomShareList(String token) {
		ResultEntity result = new ResultEntity();

		if (token == null || token.equals("")) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}
		List<SharesModel> customs = new ArrayList<SharesModel>();
		TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
		if (tokenInfo == null) {
			result.setRetCode("3");
			// result.setRetContent("");
			result.setRetMessage("用户登录信息失效");
			return result;
		}
		try {

			String str = tokenInfo.getUserInfo();
			UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);
			customs = customWeblogic.selectCustomShares(String.valueOf(userInfo.getUserId()));
			result.setRetCode("1");
			result.setRetContent(customs);
			result.setRetMessage("查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("内部错误，查询失败");
		}
		return result;
	}
}
