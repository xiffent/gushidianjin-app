package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.DayShare;

public interface DayShareMapper {
    int insert(DayShare record);

    int insertSelective(DayShare record);
}