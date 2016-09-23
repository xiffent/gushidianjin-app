package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.VipRegisterMapper;
import com.yijiaersan.webapp.model.VipRegister;
import com.yijiaersan.webapp.services.VipRegisterService;

@Service("vipRegisterService")
public class VipRegisterServiceImpl implements VipRegisterService {

	@Resource
	private VipRegisterMapper vipRegisterMapper;
	@Override
	public int insert(VipRegister record) {
		// TODO Auto-generated method stub
		return vipRegisterMapper.insert(record);
	}

	@Override
	public int insertSelective(VipRegister record) {
		// TODO Auto-generated method stub
		return vipRegisterMapper.insertSelective(record);
	}

}
