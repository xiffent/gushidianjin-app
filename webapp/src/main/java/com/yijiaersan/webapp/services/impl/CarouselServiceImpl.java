package com.yijiaersan.webapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yijiaersan.webapp.dao.CarouselMapper;
import com.yijiaersan.webapp.model.Carousel;
import com.yijiaersan.webapp.services.CarouselService;

@Service("carouselService")
public class CarouselServiceImpl implements CarouselService {

	@Resource
	private CarouselMapper carouselMapper;
	
	@Override
	public int insert(Carousel record) {
		// TODO Auto-generated method stub
		return carouselMapper.insert(record);
	}

	@Override
	public int insertSelective(Carousel record) {
		// TODO Auto-generated method stub
		return carouselMapper.insertSelective(record);
	}

	@Override
	public List<Carousel> selectCarouselList() {
		// TODO Auto-generated method stub
		return carouselMapper.selectCarouselList();
	}

}
