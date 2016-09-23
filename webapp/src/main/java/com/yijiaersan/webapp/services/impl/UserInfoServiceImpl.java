package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.UserInfoMapper;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.services.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Resource
	private UserInfoMapper userInfoMapper;
	@Override
	public int insert(UserInfo userInfo) {
		return userInfoMapper.insert(userInfo);
	}
	@Override
	public UserInfo findUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.findUser(userInfo);
	}
	@Override
	public int insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return userInfoMapper.insertSelective(record);
	}
	@Override
	public int updateUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateUser(userInfo);
	}
	@Override
	public int updatePassword(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updatePassword(userInfo);
	}
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateUserInfo(userInfo);
	}

}
