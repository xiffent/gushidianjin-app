package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.UserInfo;

public interface UserInfoService {

	 int insert(UserInfo record);
	 
	 int insertSelective(UserInfo record);
	 
	 UserInfo findUser(UserInfo userInfo);
	 
	 int updateUser(UserInfo userInfo);
	 
	 int updatePassword(UserInfo userInfo);
	 
	 int updateUserInfo(UserInfo userInfo);
}
