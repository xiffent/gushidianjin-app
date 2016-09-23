package com.yijiaersan.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiaersan.webapp.model.VipPackage;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.VipPackageWeblogic;

@Controller
@RequestMapping("/vipPackage")
public class VIpPackageController {

	@Resource
	private VipPackageWeblogic vipPackageWeblogic;
	
	@RequestMapping(value="/addVipPackage", produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<String> addVipPackageInfo(VipPackage record){
		ResultEntity<String> rsult = new ResultEntity<String>();
		try {
			vipPackageWeblogic.insertVipPackageInfo(record);
			rsult.setRetCode("1");
			//rsult.setRetContent("");
			rsult.setRetMessage("添加成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rsult.setRetCode("0");
			//rsult.setRetContent("");
			rsult.setRetMessage("内部错误，添加失败");
		}
		return  rsult;
	}
	
	@RequestMapping(value = "/queryPackageList", produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity queryAllPackageInfo(){
		List<VipPackage> vipPackages = new ArrayList<VipPackage>();
		ResultEntity result = new ResultEntity();
		
		try {
			vipPackages = vipPackageWeblogic.selectVipPackagesList();
			result.setRetCode("1");
			result.setRetMessage("查询成功！");
			result.setRetContent(vipPackages);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setRetCode("0");
			//result.setRetContent("");
			result.setRetMessage("内部错误，查询失败");
		}
		
		return result;
	}
}
