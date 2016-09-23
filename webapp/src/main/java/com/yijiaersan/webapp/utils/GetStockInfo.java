package com.yijiaersan.webapp.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetStockInfo {
	public static String apikey = "57336a25126243c2e75e502591799658";

	public static JSONObject getStockInfoByStockId(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", apikey);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		JSONObject object = JSON.parseObject(result); 
		System.out.println(object);
		return object;
	}

	public static JSONObject getStockHistoryInfo(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", apikey);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject object = JSON.parseObject(result); 
		System.out.println(object);
		return object;
	}

	public static void main(String[] args) {
		String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
		String httpArg = "stockid=sz002230&list=1";
		JSONObject jsonResult = getStockInfoByStockId(httpUrl, httpArg);
		System.out.println(jsonResult);
	}
}
