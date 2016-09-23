package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.VipPackage;

public interface VipPackageService {

	int insert(VipPackage record);

	int insertSelective(VipPackage record);

	VipPackage queryVipPackageInfo(Long pkgId);
	
	List<VipPackage> queryVipPackageAllInfo();
}
