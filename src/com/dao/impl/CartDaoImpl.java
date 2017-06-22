package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.ICartDao;
import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;
@Repository
public class CartDaoImpl extends SqlSessionDaoSupport implements ICartDao {

	@Override
	public boolean insertCart(SimpleCart cart) {
		int i = super.getSqlSession().insert("com.pojo.Cart.insertCart", cart); 
		return i>0?true:false;
	}

	@Override
	public List<Cart> selectCartOfUser(FrontUser user) {
	return super.getSqlSession().selectList("com.pojo.Cart.selectCartOfUser",user);
	}

	@Override
	public List<Cart> selectRealCartOfUser(FrontUser user) {
		return super.getSqlSession().selectList("com.pojo.Cart.selectRealCartOfUser",user);
	}

	@Override
	public int isHaveGoodOfCart(SimpleCart cart) {
		return super.getSqlSession().selectOne("com.pojo.Cart.isHaveGoodOfCart",cart);
	}

	@Override
	public boolean cartNumberAdd1(SimpleCart cart) {
		int i = super.getSqlSession().update("com.pojo.Cart.cartNumberAdd1",cart);
		 return i>0?true:false;
	}

	@Override
	public boolean setCartNumber(SimpleCart cart) {
		int i = super.getSqlSession().update("com.pojo.Cart.setCartNumber",cart);
		 return i>0?true:false;
	}

	@Override
	public boolean removreGoodOfCart(SimpleCart cart) {
	int i = super.getSqlSession().delete("com.pojo.Cart.removreGoodOfCart", cart);
	 return i>0?true:false;
	}

	@Override
	public boolean confirmGoodOfCart(SimpleCart cart) {
		int i = super.getSqlSession().delete("com.pojo.Cart.confirmGoodOfCart", cart);
		 return i>0?true:false;
	}

	@Override
	public boolean cancelGoodOfCart(SimpleCart cart) {
	 int i = super.getSqlSession().update("com.pojo.Cart.cancelGoodOfCart", cart);
	 return i>0?true:false;
	}

	@Override
	public boolean removreGoodOfCartAfterOrder(Cart cart) {
		int i = super.getSqlSession().update("com.pojo.Cart.removreGoodOfCartAfterOrder",cart);
		 return i>0?true:false;
	}

}
