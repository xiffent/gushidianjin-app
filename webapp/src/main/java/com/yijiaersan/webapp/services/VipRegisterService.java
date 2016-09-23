package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.VipRegister;

public interface VipRegisterService {
	
	int insert(VipRegister record);

    int insertSelective(VipRegister record);
}
