package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.Admin;
import java.util.List;

public abstract interface AdminMapper {
	int insert(Admin paramAdmin);

	int insertSelective(Admin paramAdmin);

	List<Admin> selectAdminInfo(Admin paramAdmin);
}