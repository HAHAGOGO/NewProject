package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.GoodImage;
import com.pojo.GoodInfo;
import com.pojo.GoodStyle;
import com.service.IGoodImageService;
import com.service.IGoodInfoService;
import com.service.IGoodService;
import com.service.IGoodStyleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("gc")
public class GoodController {
	
	private IGoodInfoService goodInfoServiceImpl;
	private IGoodStyleService goodStyleServiceImpl;
	private IGoodImageService goodImageServiceImpl;
	private IGoodService goodServiceImpl;
	/**
	 * ������ƷID��ȡ��Ʒ����
	 * @param goodId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="getgood")
	public void getGoodById(@RequestParam Integer goodId,HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		GoodInfo goodInfo = goodInfoServiceImpl.findByGoodId(goodId);
		PrintWriter writer = response.getWriter();
		if (goodInfo!=null) {
			List<String> goodService = getGoodService(goodId);
			goodInfo.setServiceType(goodService);
			JSONObject jsonObject = JSONObject.fromObject(goodInfo);
			writer.print(jsonObject.toString());
		}else{
			writer.print("û�и�������");
		}
		writer.flush();
		writer.close();
	}
	/**
	 * ��ȡ������Ʒ����
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="getgoodtype")
	public void getGoodStyle(HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<GoodStyle> types = goodStyleServiceImpl.getAllType();
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(types);
		writer.println(jsonArray.toString());
	}
	/**
	 * ������Ʒ���ID��ȡ��Ʒ
	 * @param styleId
	 * @param cp
	 * @param ps
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getallgood")
	public void getGoodByStyleId(Integer styleId,Integer cp,Integer ps,HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<GoodInfo> goods = goodInfoServiceImpl.findAll(styleId, cp, ps);
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(goods);
		writer.println(jsonArray.toString());
	}
	/**
	 * ������Ʒid��ȡͼƬ
	 * @param goodId
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="goodimage")
	public void getGoodImage(Integer goodId,HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<GoodImage> list = goodImageServiceImpl.getGoodImageByGoodId(goodId);
		JSONArray jsonArray = JSONArray.fromObject(list);
		PrintWriter writer = response.getWriter();
		writer.print(jsonArray.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * ������ƷId��ȡ��Ʒ����
	 * @param goodId
	 */
	private List<String> getGoodService(Integer goodId) {
		List<String> goodServiceName = goodServiceImpl.getGoodServiceName(goodId);
		return goodServiceName;
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
	public IGoodImageService getGoodImageServiceImpl() {
		return goodImageServiceImpl;
	}
	public void setGoodImageServiceImpl(IGoodImageService goodImageServiceImpl) {
		this.goodImageServiceImpl = goodImageServiceImpl;
	}
	public IGoodService getGoodServiceImpl() {
		return goodServiceImpl;
	}
	public void setGoodServiceImpl(IGoodService goodServiceImpl) {
		this.goodServiceImpl = goodServiceImpl;
	}
	
}
