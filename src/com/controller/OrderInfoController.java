package com.controller;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convert.JsonDateValueProcessor;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Controller
@RequestMapping("order")
public class OrderInfoController {
	@Resource(name="orderInfoServiceImpl")
	IOrderInfoService service;
	@RequestMapping(value="addorder")
	public String addOrder(OrderInfo order){	
		service.save(order);
		return null;
		
	}
	
	
	@RequestMapping(value="showorderinfo")
	@ResponseBody
	public String showOrderInfo(Integer orderid){
		OrderInfo order = service.findById(orderid);
		System.out.println(order.getOrderid());
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		JSONArray array = new JSONArray();
		array.add(order,jsonConfig);
		
		return array.toString();
	}
}
