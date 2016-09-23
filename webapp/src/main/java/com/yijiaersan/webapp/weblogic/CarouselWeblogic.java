package com.yijiaersan.webapp.weblogic;

import java.util.List;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.Carousel;
import com.yijiaersan.webapp.services.CarouselService;
import com.yijiaersan.webapp.utils.Sequence;

public class CarouselWeblogic {

	@Resource
	private CarouselService carouselService;
	
	public int insertCarousel(Carousel record){
		record.setCarouselId(Sequence.nextId());
		return carouselService.insert(record);
	}
	
	public List<Carousel> selectCarouselList(){
		return carouselService.selectCarouselList();
	}
}
