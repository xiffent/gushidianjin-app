package com.yijiaersan.webapp.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.SmsCode;


public interface SmsCodeMapper {
    int insert(SmsCode record);

    int insertSelective(SmsCode record);
    
    SmsCode selectSmsCode(SmsCode record);
    
    int updateSmsCode(SmsCode record);
    
    int deleteSmsCodeByMainId(@Param("mainId") Long mainId);
}