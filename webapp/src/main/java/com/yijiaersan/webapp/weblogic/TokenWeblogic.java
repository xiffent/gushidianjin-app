package com.yijiaersan.webapp.weblogic;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.services.TokenService;
import com.yijiaersan.webapp.utils.Sequence;

public class TokenWeblogic {

	@Resource
	private TokenService tokenService;
	
	/**
	 * 添加token信息
	 * @param tokenInfo
	 * @return
	 */
	public int insertTokenInfo(TokenInfo tokenInfo){
		tokenInfo.setMainId(Sequence.nextId());
		return tokenService.insert(tokenInfo);
	}
	
	/**
	 * 查询token信息
	 * @param token
	 * @return
	 */
	public TokenInfo selectTokenInfo(String token){
		
		return tokenService.selectTokenInfo(token);
	}
	
	/**
	 * 删除token信息
	 * @param token
	 * @return
	 */
	public int deleteTokenInfo(String token){
		return tokenService.deleteTokenInfo(token);
	}
	
	
	/**
	 * 查询token信息
	 * @param token
	 * @return
	 */
	public TokenInfo selectTokenInfoByPhoneNum(String phoneNum){
		
		return tokenService.selectTokenInfoByPhoneNum(phoneNum);
	}
}
