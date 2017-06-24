package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pojo.GoodInfo;
import com.pojo.GoodStyle;
import com.service.IGoodInfoService;
import com.service.IGoodService;
import com.service.IGoodStyleService;
import com.vo.ServiceType;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.GoodImage;
import com.pojo.GoodInfo;
import com.pojo.GoodStyle;
import com.pojo.TurnImage;
import com.service.IGoodImageService;
import com.service.IGoodInfoService;
import com.service.IGoodService;
import com.service.IGoodStyleService;
import com.service.ITurnImageService;
import com.vo.ServiceType;


@Controller
@RequestMapping("gsc")
public class GoodSerController {
	
	private IGoodInfoService goodInfoServiceImpl;
	private IGoodService goodServiceImpl;
	private IGoodStyleService goodStyleServiceImpl;
	private ITurnImageService turnImageServiceImpl;
	private IGoodImageService goodImageServiceImpl;
	
	@RequestMapping("cag")
	public String checkAllGoods(Integer styleId,Integer cp,Integer ps,Model model,HttpServletRequest req){
		if (cp==null||cp<1) {
			cp=1;
		}
		if (ps==null||ps<1) {
			ps=15;
		}
		if (styleId==null||styleId==0) {
			styleId=null;
		}
		try {
			List<GoodInfo> goods = goodInfoServiceImpl.findAll(styleId, cp, ps);
			int count = goodInfoServiceImpl.getCount(styleId);
			List<GoodStyle> goodStyles = goodStyleServiceImpl.getAllType();
			int sumpage=(count-1)/ps+1;
			model.addAttribute("styleId", styleId);
			model.addAttribute("cp", cp);
			model.addAttribute("ps", ps);
			model.addAttribute("goods", goods);
			model.addAttribute("sumpage", sumpage);
			model.addAttribute("count", count);
			model.addAttribute("goodStyles", goodStyles);
		} catch (Exception e) {
			
		}
		return "file/zwj/ser/files/list_goods";
	}
	/**
	 * 进入到商品详情或者添加商品页面
	 * @param goodId
	 * @param option
	 * @param model
	 * @return
	 */
	@RequestMapping("sgd")
	public String skipGoodDetail(Integer goodId,String option,Model model){
		try {
			List<GoodStyle> goodStyle = goodStyleServiceImpl.getAllType();
			List<ServiceType> serviceTypes = goodServiceImpl.getAllServiceAndChecked(goodId);
			if ("update".equals(option)) {
				model.addAttribute("type", "编辑");
				GoodInfo goodInfo = goodInfoServiceImpl.findByGoodId(goodId);
				Integer styleId = goodInfo.getStyleId();
				List<String> goodservice = goodServiceImpl.getGoodServiceName(goodId);
				goodInfo.setServiceType(goodservice);
				model.addAttribute("good", goodInfo);
				model.addAttribute("sId", styleId);
			}else {
				model.addAttribute("type", "添加");
			}
			model.addAttribute("allService", serviceTypes);
			model.addAttribute("goodStyle", goodStyle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return "file/zwj/ser/goods/gooddetail";
	}
	/**
	 * 修改商品
	 * @param goodInfo
	 * @param req
	 * @return
	 */
	@RequestMapping(value="updategood",method=RequestMethod.POST)
	public String updateGood(GoodInfo goodInfo,HttpServletRequest req){
		String[] parameter = req.getParameterValues("goodService");
		boolean flag = goodInfoServiceImpl.updateGood(goodInfo, parameter,req);
		if (flag) {
			System.out.println("修改数据成功");
		}
		return "redirect:cag";
	}
	/**
	 * 添加商品
	 * @param goodInfo
	 * @param req
	 * @return
	 */
	@RequestMapping(value="addgood",method=RequestMethod.POST)
	public String addGood(GoodInfo goodInfo,HttpServletRequest req){
		String[] parameter = req.getParameterValues("goodService");
		Integer goodId = goodInfoServiceImpl.addGood(goodInfo, parameter,req);
		if (goodId>0) {
			System.out.println("添加数据成功");
		}
		return "redirect:cag";
	}
	
	/**
	 * 删除单个商品
	 * @param goodId
	 * @return
	 */
	@RequestMapping(value="deletegood")
	public String deleteGood(Integer goodId,HttpServletRequest req){
		boolean flag = goodInfoServiceImpl.deleteGood(goodId,req);
		if (flag) {
			System.out.println("删除商品成功");
		}
		
		return "redirect:cag";
	}
	/**
	 * 批量删除商品
	 * @param delId
	 * @return
	 */
	@RequestMapping(value="deleteall")
	public String deleteAllGood(Integer[] delId,HttpServletRequest req){
		
		boolean flag = goodInfoServiceImpl.deleteAll(delId,req);
		if (flag) {
			System.out.println("批量删除成功");
		}
		return "redirect:cag";
	}
	/**
	 * 查询首页轮播图
	 * @param model
	 * @return
	 */
	@RequestMapping("gai")
	public String getAllTurnImage(Model model,HttpServletRequest req){
		List<TurnImage> turnImage = turnImageServiceImpl.getTurnImage();
		StringBuffer url = req.getRequestURL();
		String[] split = url.toString().split("gsc");
		model.addAttribute("base", split[0]);
		model.addAttribute("images", turnImage);
		return "file/zwj/ser/turn-image/turn-page";
	}
	
	/**
	 * 设置商品首页轮播图
	 * @param goodId
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("sti")
	public void setTurnImage(Integer goodId,HttpServletResponse res) throws IOException{
		PrintWriter writer = res.getWriter();
		GoodInfo goodInfo = goodInfoServiceImpl.findByGoodId(goodId);
		TurnImage turnImage = new TurnImage();
		turnImage.setImageLink("gc/getgood?goodId="+goodId);
		turnImage.setImagePath(goodInfo.getGoodPicPath());
		turnImage.setTurnTitle(goodInfo.getGoodName());
		turnImage.setGoodId(goodId);
		turnImage.setImageStatus("1");
		boolean flag = turnImageServiceImpl.inserTurnImage(turnImage);
		if (flag) {
			writer.print("ok");
		}else {
			writer.print("no");
		}
		writer.flush();
		writer.close();
	}
	
	/**
	 * 删除首页轮播图
	 * @param turnId
	 * @return
	 */
	@RequestMapping("dti")
	public String deleteTurnImage(Integer turnId){
		boolean flag = turnImageServiceImpl.deleteTurnImage(turnId);
		if (flag) {
			System.out.println("删除图片成功");
		}
		return "redirect:gai";
	}
	/**
	 * 查看商品轮播图详情
	 * @return
	 */
	@RequestMapping("cgi")
	public String checkGoodImage(Integer goodId,Model model,HttpServletRequest req){
		List<GoodImage> imgs = goodImageServiceImpl.getGoodImageByGoodId(goodId);
		model.addAttribute("imgs", imgs);
		StringBuffer url = req.getRequestURL();
		String[] split = url.toString().split("gsc");
		System.out.println("url:"+split[0]);
		model.addAttribute("base", split[0]);
		return "file/zwj/ser/goods/goodImage";
	}
	/**
	 * 后台查看商品服务
	 * @param model
	 * @return
	 */
	@RequestMapping("cgs")
	public String checkGoodService(Model model){
		List<ServiceType> serviceTypes = goodServiceImpl.getAllServiceAndChecked(null);
		model.addAttribute("serviceType", serviceTypes);
		
		return "file/zwj/ser/goods/goodservice";
	}
	/**
	 * 添加商品服务名
	 * @param serviceName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("ags")
	public String addGoodService(String serviceName) throws UnsupportedEncodingException{
		serviceName = new String(serviceName.getBytes("iso-8859-1"),"utf-8");
		goodServiceImpl.insertService(serviceName);
		return "redirect:cgs";
	}
	/**
	 * 修改商品服务名
	 * @param serviceId
	 * @param serviceName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("ugs")
	public String updateGoodService(Integer serviceId,String serviceName) throws UnsupportedEncodingException{
		serviceName=new String(serviceName.getBytes("iso-8859-1"),"utf-8");
		goodServiceImpl.updateService(serviceId, serviceName);
		return "redirect:cgs";
	}
	/**
	 * 跳转到商品分类页面
	 * @param model
	 * @return
	 */
	@RequestMapping("gags")
	public String getAllGoodStyle(Model model){
		List<GoodStyle> allType = goodStyleServiceImpl.getAllType();
		model.addAttribute("allType", allType);
		
		return "file/zwj/ser/goods/goodstyle";
	}
	@RequestMapping("addgs")
	public String addGoodStyle(String styleName) throws UnsupportedEncodingException{
		styleName=new String(styleName.getBytes("iso-8859-1"),"utf-8");
		boolean insertGoodStyle = goodStyleServiceImpl.insertGoodStyle(styleName);
		if (insertGoodStyle) {
			System.out.println("添加商品分类成功");
		}else {
			System.out.println("添加商品分类失败");
		}
		return "redirect:gags";
	}
	@RequestMapping("updategs")
	public String updateGoodStyle(GoodStyle goodStyle) throws UnsupportedEncodingException{
		goodStyle.setStyleName(new String(goodStyle.getStyleName().getBytes("iso-8859-1"),"utf-8"));
		boolean updateGoodStyleName = goodStyleServiceImpl.updateGoodStyleName(goodStyle);
		if (updateGoodStyleName) {
			System.out.println("修改商品分类成功");
		}else {
			System.out.println("修改商品分类失败");
		}
		return "redirect:gags";
	}
	
	public IGoodInfoService getGoodInfoServiceImpl() {
		return goodInfoServiceImpl;
	}

	public void setGoodInfoServiceImpl(IGoodInfoService goodInfoServiceImpl) {
		this.goodInfoServiceImpl = goodInfoServiceImpl;
	}

	public IGoodService getGoodServiceImpl() {
		return goodServiceImpl;
	}

	public void setGoodServiceImpl(IGoodService goodServiceImpl) {
		this.goodServiceImpl = goodServiceImpl;
	}

	public IGoodStyleService getGoodStyleServiceImpl() {
		return goodStyleServiceImpl;
	}

	public void setGoodStyleServiceImpl(IGoodStyleService goodStyleServiceImpl) {
		this.goodStyleServiceImpl = goodStyleServiceImpl;
	}
	public ITurnImageService getTurnImageServiceImpl() {
		return turnImageServiceImpl;
	}
	public void setTurnImageServiceImpl(ITurnImageService turnImageServiceImpl) {
		this.turnImageServiceImpl = turnImageServiceImpl;
	}
	public IGoodImageService getGoodImageServiceImpl() {
		return goodImageServiceImpl;
	}
	public void setGoodImageServiceImpl(IGoodImageService goodImageServiceImpl) {
		this.goodImageServiceImpl = goodImageServiceImpl;
	}
	
}
