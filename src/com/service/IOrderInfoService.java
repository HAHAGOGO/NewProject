
package com.service;

import java.util.List;

import com.convert.Page;
import com.pojo.OrderInfo;

public interface IOrderInfoService {
	public boolean save(OrderInfo order);
	public OrderInfo findById(Integer orderid);
	public List<OrderInfo> findByStatus(OrderInfo order);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
	public Page<OrderInfo>  findPages(Integer cp,Integer rows);
}

