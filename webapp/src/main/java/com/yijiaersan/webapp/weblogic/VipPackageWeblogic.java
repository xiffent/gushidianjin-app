package com.yijiaersan.webapp.weblogic;

import java.util.List;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.VipPackage;
import com.yijiaersan.webapp.services.VipPackageService;
import com.yijiaersan.webapp.utils.Sequence;

public class VipPackageWeblogic {

	@Resource
	private VipPackageService vipPackageService;
	
	public int insertVipPackageInfo(VipPackage record){
		record.setPkgId(Sequence.nextId());
		return vipPackageService.insert(record);
	}
	
	public VipPackage selectVipPackage(String pkgId){
		
		return vipPackageService.queryVipPackageInfo(Long.parseLong(pkgId));
	}
	
	
	public List<VipPackage> selectVipPackagesList(){
		return vipPackageService.queryVipPackageAllInfo();
	}
}
