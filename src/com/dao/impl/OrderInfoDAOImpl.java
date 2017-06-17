package com.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IOrderInfoDAO;
import com.pojo.OrderInfo;

@Repository
public class OrderInfoDAOImpl extends SqlSessionDaoSupport implements
		IOrderInfoDAO {

	@Override
	public boolean save(OrderInfo order) {
		try {
			int rows = super.getSqlSession().update("com.dao.IOrderInfoDAO.save",order);
			if(rows>0){
				Map<String, Object> map= new HashMap<>();
				map.put("orderid", order.getOrderid());
				map.put("list", order.getOrderItem());
				super.getSqlSession().update("com.pojo.IOrderDetailDAO.batchDeleteMap", map);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

		
	}

	@Override
	public OrderInfo findById(Integer orderid) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("com.dao.IOrderInfoDAO.findById", orderid);
	}

	@Override
	public OrderInfo findByStatus(OrderInfo order) {
		// TODO Auto-generated method stub
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
	

}
