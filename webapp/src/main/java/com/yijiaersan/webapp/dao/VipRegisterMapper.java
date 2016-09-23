package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.VipRegister;

public interface VipRegisterMapper {
    int insert(VipRegister record);

    int insertSelective(VipRegister record);
}