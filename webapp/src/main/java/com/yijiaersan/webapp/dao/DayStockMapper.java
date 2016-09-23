package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.DayStock;

public interface DayStockMapper {
    int insert(DayStock record);

    int insertSelective(DayStock record);
}