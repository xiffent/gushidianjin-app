package com.yijiaersan.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiaersan.webapp.model.Carousel;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.CarouselWeblogic;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Resource
	private CarouselWeblogic carouselWeblogic;

	@RequestMapping(value = "/queryCarousel", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity queryCarouselList() {
		ResultEntity result = new ResultEntity();
		List<Carousel> carousels = new ArrayList<Carousel>();
		try {
			carousels = carouselWeblogic.selectCarouselList();
			result.setRetCode("1");
			result.setRetContent(carousels);
			result.setRetMessage("查询成功");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setRetCode("0");
			// result.setRetContent("");
			result.setRetMessage("服务器内部错误");
		}
		return result;
	}
}
