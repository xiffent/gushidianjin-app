package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.Share;

public interface ShareService {

	
	int insert(Share record);

    int insertSelective(Share record);
    
    List<Share> selectShareList();
    
    /**
     * 查询版本号
     * @return
     */
    int selectVersion();
    /**
     * 更新版本号
     * @return
     */
    int updateVersion();
}
