package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.Custom;

public interface CustomService {

	int insert(Custom record);

    int insertSelective(Custom record);
    
    /**
     * 查询自选股票列表
     * @param userId
     * @return
     */
    List<Custom> queryCustomsList(Long userId);
    
    
    Custom queryCustom(String sharesCode,Long userId);
    
    int deleteCustomShares(String sharesCode,Long userId);
}
