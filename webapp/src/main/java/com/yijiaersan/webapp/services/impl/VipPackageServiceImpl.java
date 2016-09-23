package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.VipPackageMapper;
import com.yijiaersan.webapp.model.VipPackage;
import com.yijiaersan.webapp.services.VipPackageService;

@Service("vipPackageService")
public class VipPackageServiceImpl implements VipPackageService {

	@Resource
	private VipPackageMapper vipPackageMapper;
	@Override
	public int insert(VipPackage record) {
		// TODO Auto-generated method stub
		return vipPackageMapper.insert(record);
	}

	@Override
	public int insertSelective(VipPackage record) {
		// TODO Auto-generated method stub
		return vipPackageMapper.insertSelective(record);
	}

	@Override
	public VipPackage queryVipPackageInfo(Long pkgId) {
		// TODO Auto-generated method stub
		return vipPackageMapper.queryVipPackageInfo(pkgId);
	}

	@Override
	public List<VipPackage> queryVipPackageAllInfo() {
		// TODO Auto-generated method stub
		return vipPackageMapper.queryVipPackageAllInfo();
	}

}
