package com.dao.impl;

import java.util.HashMap;
import java.util.List;
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
		return super.getSqlSession().selectOne("com.dao.IOrderInfoDAO.findById", orderid);
	}

	@Override
	public List<OrderInfo> findByStatus(OrderInfo order) {
		 return super.getSqlSession().selectList("com.dao.IOrderInfoDAO.findByStatus", order);
	}

	@Override
	public boolean update(OrderInfo order) {
		return super.getSqlSession().update("com.dao.IOrderInfoDAO.findByStatus", order)>0;
	}

	@Override
	public boolean delete(Integer orderid) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("com.dao.IOrderInfoDAO.findByStatus", orderid)>0;
	}
	

}
