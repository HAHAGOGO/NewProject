package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.GoodInfo;
import com.service.IGoodInfoService;
import com.service.impl.GoodInfoServiceImpl;

@Controller
@RequestMapping("gsc")
public class GoodSerController {
	
	private IGoodInfoService goodInfoServiceImpl;
	
	@RequestMapping("cag")
	public String checkAllGoods(Model model){
		List<GoodInfo> goods = goodInfoServiceImpl.findAll(null, 1, 10);
		model.addAttribute("goods", goods);
		return "file/zwj/ser/files/list_goods";
	}

	public IGoodInfoService getGoodInfoServiceImpl() {
		return goodInfoServiceImpl;
	}

	public void setGoodInfoServiceImpl(IGoodInfoService goodInfoServiceImpl) {
		this.goodInfoServiceImpl = goodInfoServiceImpl;
	}
	
}
