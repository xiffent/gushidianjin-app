package com.yijiaersan.webapp.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GetTradeStockInfo {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	public static final String access_key = "7e58607ceddf180e190b0a38d1d869b1";
	public static final String secret_key = "BqKwDmnf+36jewG/2aOszhfgJ54=";

	public static String commonGetTrade(String url, Map params)
			throws InvalidKeyException, NoSuchAlgorithmException {
		String result = null;
		try {
			result = net(url, params, "GET");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException {
		String url = "http://api.ichinascope.com/api/market/index/capital/flows/realtime";

		Map paramsRealtime = new HashMap();
		String strRealtime = commonGetTrade(url, paramsRealtime);
		JSONObject jsRealtime = JSON.parseObject(strRealtime);
		if (!jsRealtime.get("code").toString().equals("200")) {
			System.out.println("error");
		} else {
			JSONArray jsonArrayResp = new JSONArray();
			JSONArray jsonArray = jsRealtime.getJSONArray("message");
			for (int i = 0; i < jsonArray.size(); ++i) {
				JSONObject jobjectResp = new JSONObject();
				JSONObject jobject = (JSONObject) jsonArray.get(i);

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
			System.out.println(JSON.toJSONString(jsonArrayResp));
		}
	}

	public static String net(String strUrl, Map params, String method)
			throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if ((method == null) || (method.equals("GET"))) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();

			Long t = Long.valueOf(new Date().getTime());

			String data = "7e58607ceddf180e190b0a38d1d869b1," + t + ","
					+ "BqKwDmnf+36jewG/2aOszhfgJ54=";
			SecretKeySpec keySpec = new SecretKeySpec(data.getBytes(),
					"HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(keySpec);
			byte[] res = mac.doFinal();
			String token = new BASE64Encoder().encode(res);

			conn.addRequestProperty("access_key",
					"7e58607ceddf180e190b0a38d1d869b1");
			conn.addRequestProperty("t", t+"");
			conn.addRequestProperty("token", token);

			if ((method == null) || (method.equals("GET"))) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if ((params != null) && (method.equals("POST")))
				try {
					DataOutputStream out = new DataOutputStream(
							conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception localException) {
				}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=")
						.append(URLEncoder.encode(i.getValue()+"", "UTF-8"))
						.append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}