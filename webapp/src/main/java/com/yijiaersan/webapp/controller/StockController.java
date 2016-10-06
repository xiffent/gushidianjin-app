package com.yijiaersan.webapp.controller;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.Custom;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.DateUtil;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.weblogic.CustomWeblogic;
import com.yijiaersan.webapp.weblogic.StockWeblogic;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Resource
	private StockWeblogic stockWeblogic;

	@Resource
	private CustomWeblogic customWeblogic;

	@Resource
	private TokenWeblogic tokenWeblogic;

	/**
	 * 查询股票详情
	 * 
	 * @param stockid
	 * @return
	 */
	@RequestMapping(value = "/getStockInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject getStockInfoByStockId(String stockid, String token) {

		JSONObject jSONObject = null;

		Date date = new Date();

		String time = DateUtil.getTime(date);

		String day = DateUtil.getDay(date);

		boolean tmp = DateUtil.compareDate(time, day + " 09:30:00");

		if (tmp) {
			tmp = DateUtil.compareDate(day + " 15:00:00", time);
		}

		boolean isWeekDay = false;

		try {
			isWeekDay = DateUtil.isWeekDay(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jSONObject = stockWeblogic.getStockInfoByStockId(stockid);

		JSONObject retData = (JSONObject) jSONObject.get("retData");
		JSONArray stockinfo = (JSONArray) retData.get("stockinfo");
		// System.out.println(stockinfo.get(0));
		JSONObject sk = (JSONObject) stockinfo.get(0);

		if (tmp && !isWeekDay) {
			sk.put("isBusiness", "0"); // 交易中
		} else {
			sk.put("isBusiness", "1");// 交易关闭
		}

		if (token != null) {
			TokenInfo tokenInfo = tokenWeblogic.selectTokenInfo(token);
			if (tokenInfo == null) {
				jSONObject = new JSONObject();
				jSONObject.put("retCode", "3");
				// jSONObject.put("retContent","用户登录信息失效");
				jSONObject.put("retMessage", "用户登录信息失效");
				return jSONObject;
			}
			String str = tokenInfo.getUserInfo();
			UserInfo userInfo = JSONUtil.json2Bean(str, UserInfo.class);

			Custom custom = customWeblogic.selectCustom(stockid, userInfo.getUserId());
			if (custom != null) {
				sk.put("isCustom", "0"); // 已收藏

			} else {
				sk.put("isCustom", "1");// 未收藏

			}
		} else {
			sk.put("isCustom", "1");// 未收藏

		}
		stockinfo.remove(0);
		stockinfo.add(0, sk);
		retData.put("stockinfo", stockinfo);
		jSONObject.put("retData", retData);
		jSONObject.put("retCode", "1");
		// jSONObject.put("retContent","");
		jSONObject.put("retMessage", "查询股票详情成功");
		return jSONObject;
	}

	/**
	 * 查询股票历史数据
	 * 
	 * @param stockid
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	@RequestMapping(value = "/getStockHistoryInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject getStockHistoryInfo(String stockid, String startdate, String enddate) {
		JSONObject jSONObject = stockWeblogic.getStockHistoryInfo(stockid, startdate, enddate);
		return jSONObject;
	}
}
