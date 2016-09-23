package com.yijiaersan.webapp.weblogic;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.UserCollection;
import com.yijiaersan.webapp.services.UserCollectionService;
import com.yijiaersan.webapp.utils.Sequence;

public class UserCollectionWeblogic {

	@Resource
	private UserCollectionService userCollectionService;
	
	
	public int insertUserCollection(Long articleId,Long userId){
		
		UserCollection record = new UserCollection();
		record.setArticleId(articleId);
		record.setCollectionId(Sequence.nextId());
		record.setCollectionTime(new Date());
		record.setUserId(userId);
		int i = userCollectionService.insert(record);
		return i;
	}
	
	
	public List<UserCollection> selectUserCollectionList(Long userId){
		UserCollection record = new UserCollection();
		record.setUserId(userId);
		return userCollectionService.selectUserCollectionList(record);
	}
	
	
	public int deleteUserCollection(Long articleId,Long userId){
		UserCollection record = new UserCollection();
		record.setUserId(userId);
		record.setArticleId(articleId);
		return userCollectionService.deleteUserCollection(record);
	}
	
	public UserCollection selectUserCollection(Long articleId,Long userId){
		UserCollection record = new UserCollection();
		record.setUserId(userId);
		record.setArticleId(articleId);
		return userCollectionService.selectUserCollection(record);
	}
}
