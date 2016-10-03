package com.yijiaersan.webapp.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.utils.MD5;
import com.yijiaersan.webapp.utils.UuidUtil;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;
import com.yijiaersan.webapp.weblogic.UserWeblogic;

@Controller
@RequestMapping("/user")
public class UserContorller {

	MD5 md5 = new MD5();

	@Resource
	private UserWeblogic userWeblogic;
	@Resource
	private TokenWeblogic tokenWeblogic;

	@RequestMapping("/toFileUploadpage")
	public String toFileUploadpage() {
		return "imgFileUpload";
	}

	@RequestMapping(value = "/registerUser", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<UserInfo> registerUser(String telphone, String password, String code) {
		ResultEntity<UserInfo> result = userWeblogic.insertUser(telphone, password, code);
		return result;
	}

	@RequestMapping(value = "/userLogin", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<UserInfo> userLogin(String telphone, String password) {
		ResultEntity<UserInfo> result = userWeblogic.queryUser(telphone, password);
		return result;
	}

	@RequestMapping(value = "/logout", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity logout(String token) {
		ResultEntity result = new ResultEntity();
		try {
			userWeblogic.deleteUserInfoToken(token);
			result.setRetCode("1");
			// result.setRetContent("");
			result.setRetMessage("退出成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("退出失败");
		}
		return result;
	}

	@RequestMapping(value = "/updateVip", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<UserInfo> updateVip(String phonenum, String pkgid) {
		/*
		 * TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token); String
		 * str = tokenInfo.getUserInfo(); UserInfo userInfo =
		 * JSONUtil.json2Bean(str, UserInfo.class);
		 */
		ResultEntity<UserInfo> result = userWeblogic.insertVip(phonenum, pkgid);
		// tokenWeblogic.deleteTokenInfo(token);
		return result;
	}

	/**
	 * 忘记密码,重置密码
	 * 
	 * @param telphone
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<String> updatePassword(String telphone, String password, String code) {
		ResultEntity<String> result = new ResultEntity<String>();
		result = userWeblogic.updatePassword(telphone, password, code);
		return result;
	}

	@RequestMapping(value = "/imgFileUpload", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject imgFileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, String token) {
		JSONObject jSONObject = new JSONObject();
		String projectName = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ projectName;

		String pathStr = "/static/pic/";
		String path = request.getSession().getServletContext().getRealPath(pathStr);

		if (file == null) {
			jSONObject.put("retCode", "6");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "上传的文件为空");
			return jSONObject;
		}
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+UuidUtil.get32UUID()+".jpg";
		System.out.println(fileName);
		if (fileName == null || fileName.equals("")) {
			jSONObject.put("retCode", "7");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "上传的文件为空");
			return jSONObject;
		}
		String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf("."), fileName.length())
				: null;
		System.out.println(type);
		if (type.equals(".jpg")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".jpg";
		} else if (type.equals(".png")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".png";
		} else if (type.equals(".jpeg")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".jpeg";
		} else if (type.equals(".bmp")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".bmp";
		} else if (type.equals(".gif")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".gif";
		} else {
			jSONObject.put("retCode", "5");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "图片格式不支持");
			return jSONObject;
		}

		if (token != null) {
			TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
			if (tokenInfo == null) {
				jSONObject.put("retCode", "3");
				// jSONObject.put("retContent","");
				jSONObject.put("retMessage", "用户登录信息失效");
				return jSONObject;
			}

			String str = tokenInfo.getUserInfo();
			UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
				userInfo.setHeadPic(basePath + pathStr + fileName);
				// 更新用户头像
				userWeblogic.updateUserInfo(userInfo);
			} catch (Exception e) {
				e.printStackTrace();
				jSONObject.put("retCode", "0");
				// jSONObject.put("retContent","");
				jSONObject.put("retMessage", "内部错误，更新头像失败");
				return jSONObject;
			}
			jSONObject.put("retCode", "1");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "更新头像成功");
			jSONObject.put("url", basePath + pathStr + fileName);
			return jSONObject;
		} else {
			jSONObject.put("retCode", "3");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "用户登录信息失效");
			return jSONObject;
		}

	}

	@RequestMapping(value = "/modifyNikeName", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject updateNikeName(String token, String nikename) {
		JSONObject jSONObject = new JSONObject();
		if (token != null) {
			TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
			if (tokenInfo == null) {
				jSONObject.put("retCode", "3");
				// jSONObject.put("retContent","");
				jSONObject.put("retMessage", "用户登录信息失效");
				return jSONObject;
			}

			String str = tokenInfo.getUserInfo();
			UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

			try {
				userInfo.setUserName(nikename);
				userWeblogic.updateUserInfo(userInfo);
			} catch (Exception e) {
				e.printStackTrace();
				jSONObject.put("retCode", "0");
				// jSONObject.put("retContent","");
				jSONObject.put("retMessage", "内部错误，更新头像失败");
				return jSONObject;
			}
			jSONObject.put("retCode", "1");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "修改成功");
			return jSONObject;
		} else {
			jSONObject.put("retCode", "3");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "用户登录信息失效");
			return jSONObject;
		}
	}
}
