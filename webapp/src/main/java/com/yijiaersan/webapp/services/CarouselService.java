package com.yijiaersan.webapp.services;

import java.util.List;

import com.yijiaersan.webapp.model.Carousel;

public interface CarouselService {

	
	int insert(Carousel record);

    int insertSelective(Carousel record);
    
    List<Carousel> selectCarouselList();
}
