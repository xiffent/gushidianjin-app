package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.Stock;

public interface StockMapper {
    int insert(Stock record);

    int insertSelective(Stock record);
}