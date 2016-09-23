package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.ShareMapper;
import com.yijiaersan.webapp.model.Share;
import com.yijiaersan.webapp.services.ShareService;

@Service("shareService")
public class ShareServiceImpl implements ShareService {
	
	@Resource
	private ShareMapper shareMapper;
	@Override
	public int insert(Share record) {
		// TODO Auto-generated method stub
		return shareMapper.insert(record);
	}

	@Override
	public int insertSelective(Share record) {
		// TODO Auto-generated method stub
		return shareMapper.insertSelective(record);
	}

	@Override
	public List<Share> selectShareList() {
		// TODO Auto-generated method stub
		return shareMapper.selectShareList();
	}

	@Override
	public int selectVersion() {
		// TODO Auto-generated method stub
		return shareMapper.selectVersion();
	}

	@Override
	public int updateVersion() {
		// TODO Auto-generated method stub
		return shareMapper.updateVersion();
	}

}
