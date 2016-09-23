package com.yijiaersan.webapp.services;

import com.yijiaersan.webapp.model.DayReference;

public interface DayReferenceService {
	int deleteByPrimaryKey(Long id);

    int insert(DayReference record);

    int insertSelective(DayReference record);

    DayReference selectDayReference(Long articleId);

    int updateByPrimaryKeySelective(DayReference record);

    int updateByPrimaryKey(DayReference record);
}
