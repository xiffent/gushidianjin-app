package com.yijiaersan.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yijiaersan.webapp.model.VipPackage;

public interface VipPackageMapper {
    int insert(VipPackage record);
    
    int insertSelective(VipPackage record);
    
    VipPackage queryVipPackageInfo(@Param("pkgId")Long pkgId);
    
    
    List<VipPackage> queryVipPackageAllInfo();
}