package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.GoodInfo;
import com.pojo.GoodStyle;
import com.service.IGoodInfoService;
import com.service.IGoodStyleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("gc")
public class GoodController {
	
	private IGoodInfoService goodInfoServiceImpl;
	private IGoodStyleService goodStyleServiceImpl;
	/**
	 * 根据商品ID获取商品详情
	 * @param goodId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="getGood",method=RequestMethod.GET)
	public void getGoodById(Integer goodId,HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		GoodInfo goodInfo = goodInfoServiceImpl.findByGoodId(goodId);
		PrintWriter writer = response.getWriter();
		if (goodInfo!=null) {
			JSONObject jsonObject = JSONObject.fromObject(goodInfo);
//			String json = new String(jsonObject.toString().getBytes("iso-8859-1"), "utf-8");
			writer.print(jsonObject.toString());
		}else{
			writer.print("没有更多数据");
		}
		writer.flush();
		writer.close();
	}
	/**
	 * 获取所有商品分类
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="getGoodtype")
	public void getGoodStyle(HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<GoodStyle> types = goodStyleServiceImpl.getAllType();
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(types);
		writer.println(jsonArray.toString());
	}
	
	public IGoodStyleService getGoodStyleServiceImpl() {
		return goodStyleServiceImpl;
	}
	public void setGoodStyleServiceImpl(IGoodStyleService goodStyleServiceImpl) {
		this.goodStyleServiceImpl = goodStyleServiceImpl;
	}
	public IGoodInfoService getGoodInfoServiceImpl() {
		return goodInfoServiceImpl;
	}
	public void setGoodInfoServiceImpl(IGoodInfoService goodInfoServiceImpl) {
		this.goodInfoServiceImpl = goodInfoServiceImpl;
	}
	
}
