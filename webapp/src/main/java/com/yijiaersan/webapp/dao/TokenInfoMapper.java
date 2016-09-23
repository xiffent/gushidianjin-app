package com.yijiaersan.webapp.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.TokenInfo;

public interface TokenInfoMapper {
    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);
    
    TokenInfo selectTokenInfo(@Param("token") String token);
    
    int deleteTokenInfo(@Param("token") String token);
    
    TokenInfo selectTokenInfoByPhoneNum(@Param("phoneNum") String phoneNum);
}