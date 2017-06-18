package com.dao;


import java.util.List;

import com.pojo.OrderInfo;

public interface IOrderInfoDAO {
	public boolean save(OrderInfo order);
	public OrderInfo findById(Integer orderid);
	public List<OrderInfo> findByStatus(OrderInfo order);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
	
}
