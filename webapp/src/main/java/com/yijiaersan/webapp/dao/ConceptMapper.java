package com.yijiaersan.webapp.dao;

import com.yijiaersan.webapp.model.Concept;

public interface ConceptMapper {
    int insert(Concept record);

    int insertSelective(Concept record);
}