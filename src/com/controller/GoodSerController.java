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





@Controller
@RequestMapping("gsc")
public class GoodSerController {
	
	private IGoodInfoService goodInfoServiceImpl;
	private IGoodService goodServiceImpl;
	private IGoodStyleService goodStyleServiceImpl;
	
	
	@RequestMapping("cag")
	public String checkAllGoods(Integer styleId,Integer cp,Integer ps,Model model,HttpServletRequest req){
		if (cp==null||cp<1) {
			cp=1;
		}
		if (ps==null||ps<1) {
			ps=5;
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
	 * 解决乱码问题
	 * @param goodInfo
	 * @return
	 * @throws UnsupportedEncodingException
	 */
//	private GoodInfo encodeGoodInfo(GoodInfo goodInfo) throws UnsupportedEncodingException{
//		goodInfo.setGoodName(new String(goodInfo.getGoodName().getBytes("iso-8859-1"),"utf-8"));
//		goodInfo.setGoodDesc(new String(goodInfo.getGoodDesc().getBytes("iso-8859-1"),"utf-8"));
//		goodInfo.setSpecification(new String(goodInfo.getSpecification().getBytes("iso-8859-1"),"utf-8"));
//		return goodInfo;
//	}
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
	
}
