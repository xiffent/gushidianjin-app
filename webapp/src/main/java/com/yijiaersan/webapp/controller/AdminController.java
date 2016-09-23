package com.yijiaersan.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yijiaersan.webapp.model.Admin;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.utils.MD5;
import com.yijiaersan.webapp.utils.Sequence;
import com.yijiaersan.webapp.utils.UuidUtil;
import com.yijiaersan.webapp.weblogic.AdminWeblogic;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/admin"})
public class AdminController
{

  @Resource
  private AdminWeblogic adminWeblogic;

  @Resource
  private TokenWeblogic tokenWeblogic;

  @RequestMapping
  public String toLogicPage()
  {
    return "admin/login";
  }

  @RequestMapping({"/toIndexPage"})
  public ModelAndView toIndexPage(String token)
  {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin/index");
    mav.addObject("token", token);
    return mav;
  }

  @RequestMapping({"/toListArticlePage"})
  public ModelAndView toListArticlePage(String token)
  {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin/calendar");
    mav.addObject("token", token);
    return mav;
  }

  @RequestMapping({"/adminLogin"})
  public ModelAndView adminLogin(String username, String password) {
    ModelAndView mav = new ModelAndView();
    List admins = this.adminWeblogic.adminLogin(username, password);
    Admin admin = new Admin();
    if (admins == null) {
      mav.setViewName("admin/login");
      mav.addObject("result", "用户名不存在！");
    } else {
      boolean tmp = false;
      MD5 md5 = new MD5();
      int i = 0; if ((i < admins.size()) && 
        (((Admin)admins.get(i)).getPassword().equals(md5.getMD5ofStr(password)))) {
        tmp = true;
        admin = (Admin)admins.get(i);
      }

      if (tmp) {
        String token = UuidUtil.get32UUID();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setMainId(Sequence.nextId());
        tokenInfo.setToken(token);
        tokenInfo.setUserInfo(JSON.toJSONString(admin));
        tokenInfo.setPhoneNum(admin.getTel());
        this.tokenWeblogic.insertTokenInfo(tokenInfo);
        mav.setViewName("admin/calendar");
        mav.addObject("token", token);
      } else {
        mav.setViewName("admin/login");
        mav.addObject("result", "密码错误！");
      }

    }

    return mav;
  }
}