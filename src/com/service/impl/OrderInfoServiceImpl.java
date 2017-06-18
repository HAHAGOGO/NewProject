package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IOrderInfoDAO;
import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
	
	@Resource(name="orderInfoDAOImpl")
	private  IOrderInfoDAO dao ;
	
	@Override
	public boolean save(OrderInfo order) {
		if(order==null||order.getOrderItem()==null){
			return false;
		}
		Integer totalnum = order.getTotalnum();
		
		if(totalnum==null||totalnum==0){
			int total_num=0;
			double total_price=0;
			List<OrderDetail> orderItem = order.getOrderItem();
			for (OrderDetail orderDetail : orderItem) {
				total_num+=orderDetail.getQuantity();
				total_price+=orderDetail.getPrice();
			}
			order.setTotalnum(total_num);
			order.setTotalprice(total_price);
		}
		
		return dao.save(order);
	}

	@Override
	public OrderInfo findById(Integer orderid) {
		return dao.findById(orderid);
	}

	@Override
	public List<OrderInfo> findByStatus(OrderInfo order) {
		return dao.findByStatus(order);
	}

	@Override
	public boolean update(OrderInfo order) {
		return dao.update(order);
	}

	@Override
	public boolean delete(Integer orderid) {
		return dao.delete(orderid);
	}
	

}
