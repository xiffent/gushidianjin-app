package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.TokenInfo;

public interface TokenService {

	int insert(TokenInfo record);

    int insertSelective(TokenInfo record);
    
    TokenInfo selectTokenInfo( String token);
    
    int deleteTokenInfo( String token);
    
    TokenInfo selectTokenInfoByPhoneNum(String phoneNum);
}
