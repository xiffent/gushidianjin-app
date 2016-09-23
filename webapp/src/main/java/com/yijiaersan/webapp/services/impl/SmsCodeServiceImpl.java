package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.SmsCodeMapper;
import com.yijiaersan.webapp.model.SmsCode;
import com.yijiaersan.webapp.services.SmsCodeService;

@Service("smsCodeService")
public class SmsCodeServiceImpl implements SmsCodeService {
	
	@Resource
	private SmsCodeMapper smsCodeMapper;
	
	@Override
	public int insert(SmsCode record) {
		// TODO Auto-generated method stub
		return smsCodeMapper.insert(record);
	}

	@Override
	public int insertSelective(SmsCode record) {
		// TODO Auto-generated method stub
		return smsCodeMapper.insertSelective(record);
	}

	@Override
	public SmsCode selectSmsCode(SmsCode record) {
		// TODO Auto-generated method stub
		return smsCodeMapper.selectSmsCode(record);
	}

	@Override
	public int updateSmsCode(SmsCode record) {
		// TODO Auto-generated method stub
		return smsCodeMapper.updateSmsCode(record);
	}

	@Override
	public int deleteSmsCodeByMainId(Long mainId) {
		// TODO Auto-generated method stub
		return smsCodeMapper.deleteSmsCodeByMainId(mainId);
	}

}
