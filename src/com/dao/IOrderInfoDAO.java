package com.dao;


import com.pojo.OrderInfo;

public interface IOrderInfoDAO {
	public boolean save(OrderInfo order);
	public OrderInfo findById(Integer orderid);
	public OrderInfo findByStatus(OrderInfo order);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
	
}
