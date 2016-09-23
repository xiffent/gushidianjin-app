package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.PayInfo;

public interface PayInfoMapper {
    int insert(PayInfo record);

    int insertSelective(PayInfo record);
}