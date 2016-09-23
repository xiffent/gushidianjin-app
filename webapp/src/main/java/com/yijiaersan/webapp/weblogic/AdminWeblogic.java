package com.yijiaersan.webapp.weblogic;

import com.yijiaersan.webapp.model.Admin;
import com.yijiaersan.webapp.services.AdminService;
import java.util.List;
import javax.annotation.Resource;

public class AdminWeblogic
{

  @Resource
  private AdminService adminService;

  public List<Admin> adminLogin(String username, String password)
  {
    Admin admin = new Admin();
    admin.setUsername(username);
    List admins = this.adminService.selectAdminInfo(admin);

    return admins;
  }
}