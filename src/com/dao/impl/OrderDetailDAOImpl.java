package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IOrderDetailDAO;
import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
@Repository
public class OrderDetailDAOImpl extends SqlSessionDaoSupport implements IOrderDetailDAO{

	@Override
	public boolean save(OrderInfo order) {
		try {
			int rows = super.getSqlSession().insert("com.dao.IOrderDetailDAO.save",order);
			if(rows>0){
				Map<String, Object> map= new HashMap<>();
				map.put("orderid", order.getOrderid());
				map.put("list", order.getOrderItem());
				super.getSqlSession().insert("com.dao.IOrderDetailDAO.batchDeleteMap", map);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

		
	}

	@Override
	public OrderDetail findById(Integer orderid) {
		super.getSqlSession().selectOne("com.dao.IOrderDetailDAO.", orderid);
		return null;
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

	@Override
	public boolean batchSave(List<OrderInfo> order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean batchUpdate(List<OrderInfo> order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean batchDelete(List<OrderInfo> order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean batchDeleteMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

}
