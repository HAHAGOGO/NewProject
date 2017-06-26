package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.convert.Page;
import com.dao.IOrderInfoDAO;
import com.pojo.OrderInfo;
import com.pojo.ReceiptPerson;

@Repository
public class OrderInfoDAOImpl extends SqlSessionDaoSupport implements
		IOrderInfoDAO {

	@Override
	
	public boolean save(OrderInfo order) {
		try {
			System.out.println(order.getFrontid());
			ReceiptPerson rp = super.getSqlSession().selectOne("com.pojo.ReceiptPerson.queryAddressByUserAndDefault",order.getFrontid());
			System.out.println("rp.getPid():"+rp.getPid());
			order.setReceipt(rp);//设置接收人地址
			order.setOrderstatus(1);//设置默认状态为未支付状态
			int rows = super.getSqlSession().update(
					"com.dao.IOrderInfoDAO.save", order);
			if (rows > 0) {
				Map<String, Object> map = new HashMap<>();
				map.put("orderid", order.getOrderid());
				map.put("list", order.getOrderItem());
				super.getSqlSession().update(
						"com.dao.IOrderDetailDAO.batchDeleteMap", map);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public OrderInfo findById(Integer orderid) {
		return super.getSqlSession().selectOne(
				"com.dao.IOrderInfoDAO.findById", orderid);
	}

	@Override
	public List<OrderInfo> findByStatus(OrderInfo order) {
		return super.getSqlSession().selectList(
				"com.dao.IOrderInfoDAO.findByStatus", order);
	}

	@Override
	public boolean update(OrderInfo order) {
		return super.getSqlSession().update(
				"com.dao.IOrderInfoDAO.update", order) > 0;
	}

	@Override
	public boolean delete(Integer orderid) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update(
				"com.dao.IOrderInfoDAO.delete", orderid) > 0;
	}

	@Override
	public boolean findPages(Page<OrderInfo> pages) {
		int total = this.count(null);
		if (total <= 0) {
			return false;
		}
		pages.setTotalsRecord(total);
		List<OrderInfo> list = super.getSqlSession().selectList(
				"com.dao.IOrderInfoDAO.findPages", pages);
		System.out.println(list);
		if (list == null) {
			return false;
		}
		
		pages.setList(list);
		return true;
	}

	@Override
	public int count(OrderInfo order) {
		int total = 0;
		if(order !=null){
			 total = (Integer) super.getSqlSession().selectOne(
					"com.dao.IOrderInfoDAO.count",order);
		}else{
			 total = (Integer) super.getSqlSession().selectOne(
					"com.dao.IOrderInfoDAO.countAll");
			
		}
		return total;
	}

}
