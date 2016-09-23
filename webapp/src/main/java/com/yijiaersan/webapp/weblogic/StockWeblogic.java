package com.yijiaersan.webapp.weblogic;

import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.utils.GetStockInfo;

public class StockWeblogic {
	
	String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
	String httpHistoryUrl = "http://apis.baidu.com/showapi_open_bus/stock_his/sh_stock_his";
	/**
	 * 根据股票代码查询股票信息
	 * @param stockId
	 * @return
	 */
	public JSONObject getStockInfoByStockId(String stockId){
		String httpArg = "stockid="+stockId+"&list=1";
		
		JSONObject jSONObject = GetStockInfo.getStockInfoByStockId(httpUrl, httpArg);
		JSONObject retData = (JSONObject) jSONObject.get("retData");
		JSONObject market = (JSONObject) retData.get("market");
		//retData.remove(market);
		if(market.get("HSI") != null){
			market.remove("HSI");
		}
		if(market.get("IXIC") != null){
			market.remove("IXIC");
		}
		if(market.get("INX") != null){
			market.remove("INX");
		}
		if(market.get("DJI") != null){
			market.remove("DJI");
		}
		
		retData.put("market", market);
		jSONObject.put("retData", retData);
		
		return jSONObject;
	}
	
	
	public JSONObject getStockHistoryInfo(String stockId,String startDate,String endDate){
		String httpArg = "begin="+startDate+"&end="+endDate+"&code="+stockId;
		JSONObject jSONObject = GetStockInfo.getStockHistoryInfo(httpHistoryUrl, httpArg);
		return jSONObject;
	}
}
