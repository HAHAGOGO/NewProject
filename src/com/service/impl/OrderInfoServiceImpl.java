package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convert.Page;
import com.dao.ICartDao;
import com.dao.IOrderInfoDAO;
import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.GoodInfo;
import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
import com.service.IOrderInfoService;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

	@Resource(name = "orderInfoDAOImpl")
	private IOrderInfoDAO dao;

	@Resource(name = "cartDaoImpl")
	private ICartDao cartDao;

	@Override
	public boolean save(OrderInfo order) {
		if (order == null || order.getOrderItem() == null) {
			return false;
		}

		// 查询用户默认地址
		Integer totalnum = order.getTotalnum();

		if (totalnum == null || totalnum == 0) {
			int total_num = 0;
			double total_price = 0;
			List<OrderDetail> orderItem = order.getOrderItem();
			for (OrderDetail orderDetail : orderItem) {
				total_num += orderDetail.getQuantity();
				total_price += orderDetail.getPrice();
			}
			order.setTotalnum(total_num);
			order.setTotalprice(total_price);
		}

		boolean save = dao.save(order);
		if (save) {
			Cart cart = new Cart();
			FrontUser user = new FrontUser();
			user.setFrontid(order.getFrontid());
			cart.setUser(user);
			List<GoodInfo> gList = new ArrayList<>();
			for (OrderDetail orderd : order.getOrderItem()) {
				GoodInfo goods = new GoodInfo();
				goods.setGoodId(orderd.getGoodInfo().getGoodId());
				gList.add(goods);
			}
			//cart.setGoodList(gList);
			 List<Cart> o = cartDao.selectRealCartOfUser(user);
			 for (Cart cart2 : o) {
				 cartDao.removreGoodOfCartAfterOrder(cart2);
			}
			
		}
		return save;
	}

	@Override
	public OrderInfo findById(Integer orderid) {
		return dao.findById(orderid);
	}

	@Override
	public List<OrderInfo> findByStatus(OrderInfo order) {
		return dao.findByStatus(order);
	}

	@Override
	public boolean update(OrderInfo order) {
		return dao.update(order);
	}

	@Override
	public boolean delete(Integer orderid) {
		return dao.delete(orderid);
	}

	@Override
	public Page<OrderInfo> findPages(Integer cp, Integer rows) {

		System.out.println(cp);
		Page<OrderInfo> pages = new Page<OrderInfo>();

		if (cp == null) {
			cp = 1;
		}
		if (rows == null) {
			rows = 5;
		}
		pages.setPagesize(rows);
		pages.setCurrentPage(cp);
		boolean flag = dao.findPages(pages);
		if (!flag) {
			return null;
		}
		return pages;
	}

}
