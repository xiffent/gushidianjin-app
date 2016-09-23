package com.yijiaersan.webapp.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.DayReferenceMapper;
import com.yijiaersan.webapp.model.DayReference;
import com.yijiaersan.webapp.services.DayReferenceService;

@Service("dayReferenceService")
public class DayReferenceServiceImpl implements DayReferenceService {

	@Resource
	private DayReferenceMapper dayReferenceMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DayReference record) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.insert(record);
	}

	@Override
	public int insertSelective(DayReference record) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.insertSelective(record);
	}

	@Override
	public DayReference selectDayReference(Long articleId) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.selectDayReference(articleId);
	}

	@Override
	public int updateByPrimaryKeySelective(DayReference record) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DayReference record) {
		// TODO Auto-generated method stub
		return dayReferenceMapper.updateByPrimaryKey(record);
	}

}
