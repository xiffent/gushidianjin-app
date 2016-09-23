package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.TokenInfoMapper;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.services.TokenService;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {
	
	@Resource
	private TokenInfoMapper tokenInfoMapper;
	@Override
	public int insert(TokenInfo record) {
		// TODO Auto-generated method stub
		return tokenInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(TokenInfo record) {
		// TODO Auto-generated method stub
		return tokenInfoMapper.insertSelective(record);
	}

	@Override
	public TokenInfo selectTokenInfo(String token) {
		// TODO Auto-generated method stub
		return tokenInfoMapper.selectTokenInfo(token);
	}

	@Override
	public int deleteTokenInfo(String token) {
		// TODO Auto-generated method stub
		return tokenInfoMapper.deleteTokenInfo(token);
	}

	@Override
	public TokenInfo selectTokenInfoByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return tokenInfoMapper.selectTokenInfoByPhoneNum(phoneNum);
	}

}
