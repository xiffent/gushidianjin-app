package com.yijiaersan.webapp.dao;

import java.util.List;

import com.yijiaersan.webapp.model.UserCollection;

public interface UserCollectionMapper {
    int insert(UserCollection record);

    int insertSelective(UserCollection record);
    
    
    List<UserCollection> selectUserCollectionList(UserCollection record);
    
    
    int deleteUserCollection(UserCollection record);
    
    UserCollection selectUserCollection(UserCollection record);
}