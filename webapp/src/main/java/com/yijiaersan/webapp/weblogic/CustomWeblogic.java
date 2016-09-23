package com.yijiaersan.webapp.weblogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.Custom;
import com.yijiaersan.webapp.model.SharesModel;
import com.yijiaersan.webapp.services.CustomService;
import com.yijiaersan.webapp.utils.Sequence;

public class CustomWeblogic {

	@Resource
	private CustomService customService;
	
	/**
	 * 添加自选股
	 * @param sharesCode
	 * @param token
	 * @return
	 */
	public int insertCustomInfo(String sharesCode,String userId){
		Custom custom = new Custom();
		//UserInfo userInfo = UserSession.get(token, UserInfo.class);
		custom.setAddDate(new Date());
		custom.setSharesCode(sharesCode);
		custom.setCustomId(Sequence.nextId());
		custom.setUserId(Long.parseLong(userId));
		return customService.insert(custom);
	}
	
	/**
	 * 查询我的自选股
	 * @param token
	 * @return
	 */
	public List<SharesModel> selectCustomShares(String userId){
		StockWeblogic sw = new StockWeblogic();
		//UserInfo userInfo = UserSession.get(token, UserInfo.class);
		List<SharesModel> sharesModels = new ArrayList<SharesModel>();
		List<Custom> customs = customService.queryCustomsList(Long.parseLong(userId));
		for(int i=0;i<customs.size();i++){
			SharesModel sharesModel = new SharesModel();
			 String sharesCode = customs.get(i).getSharesCode();
			 JSONObject jsonObject = sw.getStockInfoByStockId(sharesCode);
			 JSONArray stockinfo = jsonObject.getJSONObject("retData").getJSONArray("stockinfo");
			 JSONObject info = stockinfo.getJSONObject(0);
			 
			 String currentPrice = info.getString("currentPrice");
			 String increase = info.getString("increase");
			 String name = info.getString("name");
			 String share = info.getString("code");
			 
			 BigDecimal bd=new BigDecimal(increase); 
			 bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			 
			 sharesModel.setCurrentPrice(currentPrice);
			 sharesModel.setIncrease(bd.toString());
			 sharesModel.setSharesCode(share);
			 sharesModel.setSharesName(name);
			 sharesModels.add(sharesModel);
		}
		return sharesModels;
	}
	
	
	public Custom selectCustom(String sharesCode,Long userId){
		
		return customService.queryCustom(sharesCode,userId);
	}
	
	public int deleteCustomShares(String sharesCode, Long userId){
		return customService.deleteCustomShares(sharesCode, userId);
	}
}
