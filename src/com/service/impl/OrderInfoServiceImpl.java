package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IOrderInfoDAO;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
	
	@Resource(name="orderInfoDAOImpl")
	private  IOrderInfoDAO dao ;
	
	@Override
	public boolean save(OrderInfo order) {
		return dao.save(order);
	}

	@Override
	public OrderInfo findById(Integer orderid) {
		return dao.findById(orderid);
	}

	@Override
	public OrderInfo findByStatus(OrderInfo order) {
		return dao.findByStatus(order);
	}

	@Override
	public boolean update(OrderInfo order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer orderid) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
