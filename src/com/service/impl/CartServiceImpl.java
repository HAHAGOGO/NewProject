package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.ICartDao;
import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;
import com.service.ICartService;
@Service
public class CartServiceImpl implements ICartService {
	private ICartDao cartDaoImpl;
	@Override
	public boolean insertCart(SimpleCart cart) {
	return	cartDaoImpl.insertCart(cart);
	}

	@Override
	public List<Cart> selectCartOfUser(FrontUser user) {
		return cartDaoImpl.selectCartOfUser(user);
	}

	@Override
	public List<Cart> selectRealCartOfUser(FrontUser user) {
		return cartDaoImpl.selectRealCartOfUser(user);
	}

	@Override
	public int isHaveGoodOfCart(SimpleCart cart) {
		return cartDaoImpl.isHaveGoodOfCart(cart);
	}

	@Override
	public boolean cartNumberAdd1(SimpleCart cart) {
		return cartDaoImpl.cartNumberAdd1(cart);
	}

	@Override
	public boolean setCartNumber(SimpleCart cart) {
	return	cartDaoImpl.setCartNumber(cart);
	}

	@Override
	public boolean removreGoodOfCart(SimpleCart cart) {
		return cartDaoImpl.removreGoodOfCart(cart);
	}

	@Override
	public boolean confirmGoodOfCart(SimpleCart cart) {
	return	cartDaoImpl.confirmGoodOfCart(cart);
	}

	@Override
	public boolean cancelGoodOfCart(SimpleCart cart) {
	return	cartDaoImpl.cancelGoodOfCart(cart);
	}

	@Override
	public boolean removreGoodOfCartAfterOrder(Cart cart) {
	return	cartDaoImpl.removreGoodOfCartAfterOrder(cart);
	}

	public ICartDao getCartDaoImpl() {
		return cartDaoImpl;
	}

	public void setCartDaoImpl(ICartDao cartDaoImpl) {
		this.cartDaoImpl = cartDaoImpl;
	}
	

}
