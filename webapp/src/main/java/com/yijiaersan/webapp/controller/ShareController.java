package com.yijiaersan.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.ShareModel;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.ShareWeblogic;

@Controller
@RequestMapping("/share")
public class ShareController {

	@Resource
	private ShareWeblogic shareWeblogic;

	/**
	 * 查询所有股票基础信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryShares", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity selectShareList() {
		ResultEntity result = new ResultEntity();
		List<ShareModel> shareModels = new ArrayList<ShareModel>();
		try {
			shareModels = shareWeblogic.selectShareList();
			result.setRetCode("1");
			result.setRetContent(shareModels);
			result.setRetMessage("查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setRetCode("0");
			//result.setRetContent("");
			result.setRetMessage("内部错误，查询失败");
		}
		return result;
	}

	/**
	 * 查询股票基础信息的版本号
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectVersion", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity selectVersion(String version) {
		ResultEntity result = new ResultEntity();
		List<ShareModel> shareModels = new ArrayList<ShareModel>();
		int ver = shareWeblogic.selectVersion();
		JSONObject jSONObject = new JSONObject();
		try {
			if (version == null || version.equals("")) {
				shareModels = shareWeblogic.selectShareList();
				jSONObject.put("shareModels", shareModels);
				jSONObject.put("version", ver);
			} else {
				if (!version.equals(String.valueOf(ver))) {
					shareModels = shareWeblogic.selectShareList();
					jSONObject.put("shareModels", shareModels);
					jSONObject.put("version", ver);
				}
			}
			// int version = shareWeblogic.selectVersion();
			result.setRetCode("1");
			result.setRetContent(jSONObject);
			result.setRetMessage("查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			result.setRetCode("0");
			//result.setRetContent("");
			result.setRetMessage("内部错误，查询失败");
		}

		return result;
	}
}
