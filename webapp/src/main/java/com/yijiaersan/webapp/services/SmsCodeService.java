package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.SmsCode;

public interface SmsCodeService {
	
	int insert(SmsCode record);

    int insertSelective(SmsCode record);
    
    SmsCode selectSmsCode(SmsCode record);
    
    int updateSmsCode(SmsCode record);
    
    int deleteSmsCodeByMainId(Long mainId);
}
