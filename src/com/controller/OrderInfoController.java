package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convert.JsonDateValueProcessor;
import com.convert.Page;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Controller
@RequestMapping("order")
public class OrderInfoController {
	@Resource(name = "orderInfoServiceImpl")
	IOrderInfoService service;

	@RequestMapping(value = "addorder")
	@ResponseBody
	public String addOrder(@RequestBody OrderInfo order) {
		System.out.println(order.getOrderItem().get(0).getGoodInfo());
		boolean save = false;
		try {
			save = service.save(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (save) {
			return "[{frontid:" + order.getFrontid() + ",orderid:"
					+ order.getOrderid() + "}]";
		} else {
			return "[{frontid:" + order.getFrontid() + "orderid:0}]";
		}

	}

	@RequestMapping(value = "showorderinfo")
	public void showOrderInfo(Integer orderid, HttpServletResponse response) {
		OrderInfo order =null; 

		PrintWriter out;
		try {
			service.findById(orderid);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());
			JSONArray array = new JSONArray();
			array.add(order, jsonConfig);
			out = response.getWriter();
			out.write(array.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping(value = "showall")
	// fron
	public void showOrderInfo(OrderInfo order, HttpServletResponse response) {
		List<OrderInfo> list =null;
		PrintWriter out;
		try {
			list = service.findByStatus(order);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());
			JSONArray array = new JSONArray();
			array.addAll(list, jsonConfig);
			out = response.getWriter();
			out.write(array.toString());
			out.flush();
		} catch (IOException e) {
		}
		return;
	}

	@RequestMapping(value = "payOrder")
	@ResponseBody
	public String payOrder(OrderInfo or) {
		OrderInfo order = new OrderInfo();
		order.setOrderid(or.getOrderid());
		order.setOrderstatus(2);
		
		boolean flag =false;
		 try {
			flag=service.update(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		if (flag) {
			return "[{frontid:" + order.getFrontid() + ",orderid:"
					+ order.getOrderid() + ",result:ok}]";
		}
		return "[{frontid:" + order.getFrontid() + ",orderid:"
				+ order.getOrderid() + "result:error}]";
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public String update(OrderInfo or) {
		OrderInfo order = new OrderInfo();
		order.setOrderid(or.getOrderid());
		order.setOrderstatus(or.getOrderstatus());
		boolean flag =false;
		 try {
			flag=service.update(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		if (flag) {
			return "{result:'ok'}";
		}
		return "{result:'error'}";
	}

	@RequestMapping(value = "showpages")
	public String showPages(Integer cp, Integer rows, Model model) {
		Page<OrderInfo> pages = null;
		try {
			pages = service.findPages(cp, rows);
			model.addAttribute("pages", pages);
		} catch (Exception e) {
		}

		return "file/chen/orderlist";
	}
}
