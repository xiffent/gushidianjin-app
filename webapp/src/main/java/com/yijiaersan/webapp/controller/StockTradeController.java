package com.yijiaersan.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.utils.GetTradeStockInfo;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({ "/stockTrade" })
@Controller
public class StockTradeController {
	@RequestMapping({ "/queryStockTrade" })
	@ResponseBody
	public JSONObject queryStockTrade() {
		JSONObject result = new JSONObject();
		JSONObject jSONObject = new JSONObject();
		String urlRealtime = "http://api.ichinascope.com/api/market/index/capital/flows/realtime";
		String urlRanking = "http://api.ichinascope.com/api/csf/index/capital/flows/ranking";
		String gaiNianUrl = "http://api.ichinascope.com/api/csf/index/ratio/ranking";
		String urlStockRanking = "http://api.ichinascope.com/api/stock/ratio/ranking";
		try {
			Map paramsRealtime = new HashMap();
			String strRealtime = GetTradeStockInfo.commonGetTrade(urlRealtime, paramsRealtime);
			JSONObject jsRealtime = JSON.parseObject(strRealtime);
			if (!jsRealtime.get("code").toString().equals("200")) {
				jSONObject.put("strRealtime", null);
			} else {
				JSONArray jsonArrayResp = new JSONArray();
				JSONArray jsonArray = jsRealtime.getJSONArray("message");
				for (int i = 0; i < jsonArray.size(); ++i) {
					JSONObject jobjectResp = new JSONObject();
					JSONObject jobject = (JSONObject) jsonArray.get(i);

					String code = jobject.get("code").toString();

					if (!code.equals("000300")) {
						String ratio = jobject.get("ratio").toString();
						BigDecimal ratiobd = new BigDecimal(ratio);
						String price = jobject.get("price").toString();
						BigDecimal pricebd = new BigDecimal(price);
						BigDecimal b = ratiobd.divide(new BigDecimal("100"));
						BigDecimal a = new BigDecimal("1").add(b);
						BigDecimal yesDayPrice = pricebd.divide(a, 3);
						jobjectResp.put("sratio", pricebd.subtract(yesDayPrice));
						jobjectResp.put("name", jobject.get("name"));
						jobjectResp.put("ratio", jobject.get("ratio"));
						jobjectResp.put("price", jobject.get("price"));
						jobjectResp.put("code", jobject.get("code"));
						jsonArrayResp.add(jobjectResp);
					}

				}

				jSONObject.put("strRealtime", jsonArrayResp);
			}

			Map paramsRanking = new HashMap();
			paramsRanking.put("sort", "-1");
			paramsRanking.put("type", "1");
			paramsRanking.put("limit", "6");
			String strTradeRealtime = GetTradeStockInfo.commonGetTrade(urlRanking, paramsRanking);
			JSONObject jsTradeRealtime = JSON.parseObject(strTradeRealtime);
			if (!jsTradeRealtime.get("code").toString().equals("200")) {
				jSONObject.put("strTradeRealtime", null);
			} else {
				JSONArray jsonArrayResp = new JSONArray();
				JSONArray jsonArray = jsTradeRealtime.getJSONArray("message");
				for (int i = 0; i < jsonArray.size(); ++i) {
					JSONObject jobjectResp = new JSONObject();
					JSONObject jobject = (JSONObject) jsonArray.get(i);
					jobjectResp.put("name", jobject.get("name"));
					jobjectResp.put("ratio", jobject.get("ratio"));
					jsonArrayResp.add(jobjectResp);
				}
				jSONObject.put("strTradeRealtime", jsonArrayResp);
			}

			Map gaiNianParams = new HashMap();
			gaiNianParams.put("sort", "-1");
			gaiNianParams.put("limit", "6");
			String strIdeaRealtime = GetTradeStockInfo.commonGetTrade(gaiNianUrl, gaiNianParams);
			JSONObject jsIdeaRealtime = JSON.parseObject(strIdeaRealtime);
			if (!jsIdeaRealtime.get("code").toString().equals("200")) {
				jSONObject.put("strIdeaRealtime", null);
			} else {
				JSONArray jsonArrayResp = new JSONArray();
				JSONArray jsonArray = jsIdeaRealtime.getJSONArray("message");
				for (int i = 0; i < jsonArray.size(); ++i) {
					JSONObject jobjectResp = new JSONObject();
					JSONObject jobject = (JSONObject) jsonArray.get(i);
					String strCode = jobject.getString("scode");
					String code = strCode.split("_")[0];
					String str = strCode.split("_")[1];
					jobjectResp.put("name", jobject.get("name"));
					jobjectResp.put("ratio", jobject.get("ratio"));
					jobjectResp.put("sname", jobject.get("sname"));
					jobjectResp.put("sratio", jobject.get("sratio"));
					jobjectResp.put("sprice", jobject.get("sprice"));
					jobjectResp.put("code", str + code);
					jsonArrayResp.add(jobjectResp);
				}
				jSONObject.put("strIdeaRealtime", jsonArrayResp);
			}

			Map paramsStockRanking = new HashMap();
			paramsStockRanking.put("sort", "2");
			paramsStockRanking.put("limit", "10");
			String strStockRanking = GetTradeStockInfo.commonGetTrade(urlStockRanking, paramsStockRanking);
			JSONObject jsStockRanking = JSON.parseObject(strStockRanking);
			if (!jsStockRanking.get("code").toString().equals("200")) {
				jSONObject.put("strStockRanking", null);
			} else {
				JSONArray jsonArrayRes = new JSONArray();
				JSONArray jsonArray = jsStockRanking.getJSONArray("message");
				for (int i = 0; i < jsonArray.size(); ++i) {
					JSONObject jobjectResp = new JSONObject();
					JSONObject jobject = (JSONObject) jsonArray.get(i);
					String strCode = jobject.getString("code");
					String code = strCode.split("_")[0];
					String str = strCode.split("_")[1];
					jobjectResp.put("name", jobject.get("name"));
					jobjectResp.put("price", jobject.get("price"));
					jobjectResp.put("ratio", jobject.get("ratio"));
					jobjectResp.put("code", str + code);
					jsonArrayRes.add(jobjectResp);
				}

				jSONObject.put("strStockRanking", jsonArrayRes);
			}

			paramsStockRanking.put("sort", "1");
			String strStockDownRanking = GetTradeStockInfo.commonGetTrade(urlStockRanking, paramsStockRanking);
			JSONObject jsStockDownRanking = JSON.parseObject(strStockDownRanking);
			if (!jsStockDownRanking.get("code").toString().equals("200")) {
				jSONObject.put("jsStockDownRanking", null);
			} else {
				JSONArray jsonArrayRes = new JSONArray();
				JSONArray jsonArray = jsStockDownRanking.getJSONArray("message");
				for (int i = 0; i < jsonArray.size(); ++i) {
					JSONObject jobjectResp = new JSONObject();
					JSONObject jobject = (JSONObject) jsonArray.get(i);
					String strCode = jobject.getString("code");
					String code = strCode.split("_")[0];
					String str = strCode.split("_")[1];
					jobjectResp.put("name", jobject.get("name"));
					jobjectResp.put("price", jobject.get("price"));
					jobjectResp.put("ratio", jobject.get("ratio"));
					jobjectResp.put("code", str + code);
					jsonArrayRes.add(jobjectResp);
				}

				jSONObject.put("strStockDownRanking", jsonArrayRes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("retCode", "0");
			result.put("retContent", null);
			result.put("retMessage", "查询失败");
			return result;
		}
		result.put("retCode", "1");
		result.put("retContent", jSONObject);
		result.put("retMessage", "查询成功");
		return result;
	}
}