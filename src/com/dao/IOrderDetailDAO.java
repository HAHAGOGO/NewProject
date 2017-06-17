package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
public interface IOrderDetailDAO {
	public boolean save(OrderInfo order);
	public OrderDetail findById(Integer orderid);
	public boolean update(OrderInfo order);
	public boolean delete(Integer orderid);
	public boolean batchSave(List<OrderInfo> order);
	public boolean batchUpdate(List<OrderInfo> order);
	public boolean batchDelete(List<OrderInfo> order);
	public boolean batchDeleteMap(Map<String,Object> map);

}
