package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.UserCollectionMapper;
import com.yijiaersan.webapp.model.UserCollection;
import com.yijiaersan.webapp.services.UserCollectionService;

@Service("userCollectionService")
public class UserCollectionServiceImpl implements UserCollectionService {

	@Resource
	private UserCollectionMapper userCollectionMapper;
	@Override
	public int insert(UserCollection record) {
		// TODO Auto-generated method stub
		return userCollectionMapper.insert(record);
	}

	@Override
	public int insertSelective(UserCollection record) {
		// TODO Auto-generated method stub
		return userCollectionMapper.insertSelective(record);
	}

	@Override
	public List<UserCollection> selectUserCollectionList(UserCollection record) {
		// TODO Auto-generated method stub
		return userCollectionMapper.selectUserCollectionList(record);
	}

	@Override
	public int deleteUserCollection(UserCollection record) {
		// TODO Auto-generated method stub
		return userCollectionMapper.deleteUserCollection(record);
	}

	@Override
	public UserCollection selectUserCollection(UserCollection record) {
		// TODO Auto-generated method stub
		return userCollectionMapper.selectUserCollection(record);
	}

}
