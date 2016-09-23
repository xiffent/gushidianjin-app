package com.yijiaersan.webapp.weblogic;

import java.util.Date;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.yijiaersan.webapp.model.SmsCode;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.model.VipPackage;
import com.yijiaersan.webapp.model.VipRegister;
import com.yijiaersan.webapp.services.SmsCodeService;
import com.yijiaersan.webapp.services.TokenService;
import com.yijiaersan.webapp.services.UserInfoService;
import com.yijiaersan.webapp.services.VipPackageService;
import com.yijiaersan.webapp.services.VipRegisterService;
import com.yijiaersan.webapp.utils.DateUtil;
import com.yijiaersan.webapp.utils.MD5;
import com.yijiaersan.webapp.utils.Sequence;
import com.yijiaersan.webapp.utils.UuidUtil;
import com.yijiaersan.webapp.utils.common.Content;
import com.yijiaersan.webapp.utils.result.ResultEntity;

public class UserWeblogic {

	@Resource
	private UserInfoService userInfoService;
	@Resource
	private SmsCodeService smsCodeService;
	@Resource
	private VipRegisterService vipRegisterService;
	@Resource
	private VipPackageService vipPackageService;
	@Resource
	private TokenService tokenService;
	
	MD5 md5 = new MD5();
	
	
	public int deleteUserInfoToken(String token){
		return tokenService.deleteTokenInfo(token);
	}
	
	public ResultEntity insertUser(String telPhone,String password,String code) {
		ResultEntity resultEntity = new ResultEntity();
		UserInfo userInfo = new UserInfo();
		
		if(telPhone==null || telPhone.equals("")){
			resultEntity.setRetCode("8");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("手机号码不能为空");
			return resultEntity;
		}else if(password==null || password.equals("")){
			resultEntity.setRetCode("9");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("密码不能为空");
			return resultEntity;
		}
		else if(code==null || code.equals("")){
			resultEntity.setRetCode("10");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("验证码不能为空");
			return resultEntity;
		}
		
		
		userInfo.setUserTel(telPhone);
		userInfo.setPassword(password);
		UserInfo userInfoOld = userInfoService.findUser(userInfo);
		if(userInfoOld != null){
			resultEntity.setRetCode("11");
			resultEntity.setRetMessage("该手机号码已注册");
			return resultEntity;
		}
		SmsCode smsCode = new SmsCode();
		smsCode.setTelphone(userInfo.getUserTel());
		smsCode = smsCodeService.selectSmsCode(smsCode);
		if(smsCode == null){
			resultEntity.setRetCode("12");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("验证码已过期");
			return resultEntity;
		}else{
			if(!smsCode.getCode().equals(code)){
				resultEntity.setRetCode("13");
				//resultEntity.setRetContent("");
				resultEntity.setRetMessage("验证码不正确！");
				return resultEntity;
			}
		}
		
		userInfo.setCreatDate(new Date());
		userInfo.setUserId(Sequence.nextId());//UuidUtil.get32UUID()
		userInfo.setUserType(Content.USER_TYPE_1);
		userInfo.setPassword(md5.getMD5ofStr(userInfo.getPassword()));
		userInfo.setUserName(telPhone+"_p");
		try {
			TokenInfo tokenInfo = tokenService.selectTokenInfoByPhoneNum(telPhone);
			if(tokenInfo != null){
				tokenService.deleteTokenInfo(tokenInfo.getToken()); // 插入token之前先清理一次token
			}
			userInfoService.insertSelective(userInfo);
			String token = UuidUtil.get32UUID();
			userInfo.setToken(token);
			TokenInfo record = new TokenInfo();
			record.setMainId(Sequence.nextId());
			record.setToken(token);
			String userInfoStr = JSON.toJSONString(userInfo);
			record.setUserInfo(userInfoStr);
			record.setPhoneNum(telPhone);
			tokenService.insert(record);
			
			//UserSession.set(token, userInfo);
			resultEntity.setRetCode("1");
			resultEntity.setRetContent(userInfo);
			resultEntity.setRetMessage("注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			resultEntity.setRetCode("0");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("内部错误，注册失败！");
		}
		return resultEntity;
	}
	
	public ResultEntity queryUser(String telPhone,String password){
		ResultEntity resultEntity = new ResultEntity();
		UserInfo userInfo = new UserInfo();
		
		if(telPhone==null ||telPhone.equals("")){
			resultEntity.setRetCode("8");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("手机号码不能为空");
			return resultEntity;
		}else if(password==null || password.equals("")){
			resultEntity.setRetCode("9");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("密码不能为空");
			return resultEntity;
		}
		
		
		userInfo.setUserTel(telPhone);
		userInfo.setPassword(password);
		UserInfo userInfoOld = userInfoService.findUser(userInfo);
		if(userInfoOld == null){
			resultEntity.setRetCode("14");
			//resultEntity.setRetContent();
			resultEntity.setRetMessage("该手机号码 "+userInfo.getUserTel()+"未注册，请先注册！");
		}else{
			String pasword = md5.getMD5ofStr(userInfo.getPassword());
			
			if(pasword.equals(userInfoOld.getPassword())){
				
				TokenInfo tokenInfo = tokenService.selectTokenInfoByPhoneNum(telPhone);
				
				if(tokenInfo != null){
					tokenService.deleteTokenInfo(tokenInfo.getToken());// 插入token之前先清理一次token
				}
				
				
				String token = UuidUtil.get32UUID();
				userInfoOld.setToken(token);
				resultEntity.setRetCode("1");
				resultEntity.setRetContent(userInfoOld);
				resultEntity.setRetMessage("ok");
				//UserSession.set(token, userInfoOld);
				TokenInfo record = new TokenInfo();
				record.setMainId(Sequence.nextId());
				record.setToken(token);
				record.setUserInfo(JSON.toJSONString(userInfoOld));
				record.setPhoneNum(telPhone);
				tokenService.insert(record);
				//System.out.println(UserSession.get(token,UserInfo.class));
			}else{
				resultEntity.setRetCode("15");
				//resultEntity.setRetContent("");
				resultEntity.setRetMessage("手机号码和密码不匹配!");
			}
		}
		return resultEntity;
	}
	
	public ResultEntity insertVip(String phonenum,String pkgId){
		ResultEntity resultEntity = new ResultEntity();
		VipRegister vipRegister = new VipRegister();
		if(phonenum == null){
			resultEntity.setRetCode("8");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("手机号码不能为空!");
			return resultEntity;
		}
		if( pkgId == null){
			resultEntity.setRetCode("16");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("套餐ID不能为空!");
			return resultEntity;
		}
		UserInfo user = new UserInfo();
		user.setUserTel(phonenum);
		user = userInfoService.findUser(user);
		
		TokenInfo tokenInfo = tokenService.selectTokenInfoByPhoneNum(phonenum);
		
		if(tokenInfo != null){
			tokenService.deleteTokenInfo(tokenInfo.getToken());//直接删掉token
		}
		
		VipPackage vipPackage = vipPackageService.queryVipPackageInfo(Long.parseLong(pkgId));
		if(vipPackage == null){
			resultEntity.setRetCode("17");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("获取套餐信息失败!");
			return resultEntity;
		}
		String afterDate = DateUtil.getDate(vipPackage.getPkgDate());
		vipRegister.setVipId(Sequence.nextId());
		vipRegister.setCteatDate(new Date());
		vipRegister.setPkgId(Long.parseLong(pkgId));
		vipRegister.setUserId(user.getUserId());
		vipRegister.setFailureDate(DateUtil.fomatDateTime(afterDate));
		vipRegister.setStatus("1");//0-无效，1-有效
		vipRegisterService.insertSelective(vipRegister);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(user.getUserId());
		userInfo.setUserType(Content.USER_TYPE_2);
		userInfoService.updateUser(userInfo);
		UserInfo userInfoOld = userInfoService.findUser(userInfo);
		resultEntity.setRetCode("1");
		resultEntity.setRetContent(userInfoOld);
		resultEntity.setRetMessage("注册vip成功");
		return resultEntity;
	}
	
	
	
	public ResultEntity<String> updatePassword(String telPhone,String password,String code){
		ResultEntity<String> resultEntity = new ResultEntity<String>();
		UserInfo userInfo = new UserInfo();
		if(telPhone==null || telPhone.equals("")){
			resultEntity.setRetCode("8");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("手机号码不能为空");
			return resultEntity;
		}else if(password==null || password.equals("")){
			resultEntity.setRetCode("9");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("密码不能为空");
			return resultEntity;
		}
		else if(code==null || code.equals("")){
			resultEntity.setRetCode("10");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("验证码不能为空");
			return resultEntity;
		}
		
		userInfo.setUserTel(telPhone);
		userInfo.setPassword(md5.getMD5ofStr(password));
		
		SmsCode smsCode = new SmsCode();
		smsCode.setTelphone(telPhone);
		smsCode = smsCodeService.selectSmsCode(smsCode);
		if(smsCode == null){
			resultEntity.setRetCode("12");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("手机号码和验证码不匹配！");
			return resultEntity;
		}else{
			if(!smsCode.getCode().equals(code)){
				resultEntity.setRetCode("13");
				//resultEntity.setRetContent("");
				resultEntity.setRetMessage("验证码不正确!");
				return resultEntity;
			}
		}
		
		try {
			TokenInfo tokenInfo = tokenService.selectTokenInfoByPhoneNum(telPhone);
			
			if(tokenInfo != null){
				tokenService.deleteTokenInfo(tokenInfo.getToken());// 删除token信息
			}
			userInfoService.updatePassword(userInfo);
			resultEntity.setRetCode("1");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("重置密码成功！");
		} catch (Exception e) {
			// TODO: handle exception
			resultEntity.setRetCode("0");
			//resultEntity.setRetContent("");
			resultEntity.setRetMessage("内部错误，重置密码失败！");
		}
		return resultEntity;
	}
	
	
	public int updateUserInfo(UserInfo userInfo){
		return userInfoService.updateUserInfo(userInfo);
	}
}
