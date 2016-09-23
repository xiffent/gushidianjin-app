package com.yijiaersan.webapp.dao;

import java.util.List;

import com.yijiaersan.webapp.model.Carousel;

public interface CarouselMapper {
    int insert(Carousel record);

    int insertSelective(Carousel record);
    
    List<Carousel> selectCarouselList();
}