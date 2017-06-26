
package com.dao;


import java.util.List;

import org.apache.logging.log4j.core.config.Order;

import com.convert.Page;
import com.pojo.OrderInfo;

public interface IOrderInfoDAO {
	public boolean save(OrderInfo order);
	public OrderInfo findById(Integer orderid);
	public List<OrderInfo> findByStatus(OrderInfo order);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
	public boolean findPages(Page<OrderInfo> pages);
	public int count(OrderInfo order);
	}

