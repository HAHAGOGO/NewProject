package com.service;

import com.pojo.OrderInfo;

public interface IOrderInfoService {
	public boolean save(OrderInfo order);
	public OrderInfo findById(Integer orderid);
	public OrderInfo findByStatus(OrderInfo order);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
}
