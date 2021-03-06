package com.service;

import java.util.List;

import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;

public interface ICartService {
	public boolean insertCart(SimpleCart cart);// 加入购物车

	public List<Cart> selectCartOfUser(FrontUser user);// 查询

	public List<Cart> selectRealCartOfUser(FrontUser user);// 查询选中的商品

	public int isHaveGoodOfCart(SimpleCart cart);// 判断商品是否已在购物车

	public boolean cartNumberAdd1(SimpleCart cart);// +1

	public boolean setCartNumber(SimpleCart cart);// 设置商品数量

	public boolean removreGoodOfCart(SimpleCart cart);// 删除对应购物车商品

	public boolean confirmGoodOfCart(SimpleCart cart);// 选中对应的商品

	public boolean cancelGoodOfCart(SimpleCart cart);// 取消选中对应的商品

	public boolean removreGoodOfCartAfterOrder(Cart cart);// 确认订单后，删除购物车中对应商品
}
