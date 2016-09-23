package com.yijiaersan.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.Custom;

public interface CustomMapper {
    int insert(Custom record);

    int insertSelective(Custom record);
    
    /**
     * 查询自选股票列表
     * @param userId
     * @return
     */
    List<Custom> queryCustomsList(@Param("userId")Long userId);
    
    Custom queryCustom(@Param("sharesCode")String sharesCode,@Param("userId")Long userId);
    
    int deleteCustomShares(@Param("sharesCode")String sharesCode,@Param("userId")Long userId);
}