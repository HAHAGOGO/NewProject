
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convert.JsonDateValueProcessor;
import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Controller
@RequestMapping("order")
public class OrderInfoController {
	@Resource(name="orderInfoServiceImpl")
	IOrderInfoService service;
	@RequestMapping(value="addorder")
	@ResponseBody
	public String addOrder(OrderInfo order){	
		System.out.println(order.getOrderItem().size());
		boolean save = service.save(order);
		if(save){
			return "[{frontid:"+order.getFrontid()+",orderid:"+order.getOrderid()+",}]";
		}else{
			return "[{frontid:"+order.getFrontid()+",}]";
		}
		
		
	}
	
	
	@RequestMapping(value="showorderinfo")
	public void showOrderInfo(Integer orderid,HttpServletResponse response){
		OrderInfo order = service.findById(orderid);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		JSONArray array = new JSONArray();
		array.add(order,jsonConfig);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(array.toString());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	
	@RequestMapping(value="showall")//fron
	public void showOrderInfo(OrderInfo order,HttpServletResponse response){
		System.out.println(order.getFrontid());
		  List<OrderInfo> list = service.findByStatus(order);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		JSONArray array = new JSONArray();
		array.addAll(list, jsonConfig);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(array.toString());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	
	@RequestMapping(value="payOrder")
	@ResponseBody
	public String payOrder(OrderInfo or){
		OrderInfo order = new OrderInfo();
		order.setOrderid(or.getOrderid());
		order.setOrderstatus(or.getOrderstatus());
		boolean flag = service.update(order);
		if(flag){
			return "[{result:ok}]";
		}
		return "[{result:error}]";
	}
}
