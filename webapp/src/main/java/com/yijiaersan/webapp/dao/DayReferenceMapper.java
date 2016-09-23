package com.yijiaersan.webapp.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.DayReference;


public interface DayReferenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DayReference record);

    int insertSelective(DayReference record);

    DayReference selectDayReference(@Param("articleId")Long articleId);

    int updateByPrimaryKeySelective(DayReference record);

    int updateByPrimaryKey(DayReference record);
}