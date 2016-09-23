package com.yijiaersan.webapp.services.impl;

import com.yijiaersan.webapp.dao.AdminMapper;
import com.yijiaersan.webapp.model.Admin;
import com.yijiaersan.webapp.services.AdminService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper adminMapper;

	public int insert(Admin record) {
		return this.adminMapper.insert(record);
	}

	public int insertSelective(Admin record) {
		return this.adminMapper.insertSelective(record);
	}

	public List<Admin> selectAdminInfo(Admin record) {
		return this.adminMapper.selectAdminInfo(record);
	}
}