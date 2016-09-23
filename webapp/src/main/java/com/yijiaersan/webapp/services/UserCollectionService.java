package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.UserCollection;

public interface UserCollectionService {

	int insert(UserCollection record);

	int insertSelective(UserCollection record);
	
	List<UserCollection> selectUserCollectionList(UserCollection record);
	
	int deleteUserCollection(UserCollection record);
	
	UserCollection selectUserCollection(UserCollection record);
}
