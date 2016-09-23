package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.Admin;
import java.util.List;

public abstract interface AdminService {
	int insert(Admin paramAdmin);

	int insertSelective(Admin paramAdmin);

	List<Admin> selectAdminInfo(Admin paramAdmin);
}