package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.Trade;

public interface TradeMapper {
    int insert(Trade record);

    int insertSelective(Trade record);
}