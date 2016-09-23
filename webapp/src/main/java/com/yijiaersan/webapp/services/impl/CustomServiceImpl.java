package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.CustomMapper;
import com.yijiaersan.webapp.model.Custom;
import com.yijiaersan.webapp.services.CustomService;

@Service("customService")
public class CustomServiceImpl implements CustomService {
	
	@Resource
	private CustomMapper customMapper;
	@Override
	public int insert(Custom record) {
		// TODO Auto-generated method stub
		return customMapper.insert(record);
	}

	@Override
	public int insertSelective(Custom record) {
		// TODO Auto-generated method stub
		return customMapper.insertSelective(record);
	}

	@Override
	public List<Custom> queryCustomsList(Long userId) {
		// TODO Auto-generated method stub
		return customMapper.queryCustomsList(userId);
	}

	@Override
	public Custom queryCustom(String sharesCode,Long userId) {
		// TODO Auto-generated method stub
		return customMapper.queryCustom(sharesCode,userId);
	}

	@Override
	public int deleteCustomShares(String sharesCode, Long userId) {
		// TODO Auto-generated method stub
		return customMapper.deleteCustomShares(sharesCode, userId);
	}

}
