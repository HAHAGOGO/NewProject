package com.pojo;

import java.util.List;
/**
 * 
  *@ClassName:  Cart   
 * @Description:购物车类   
 * @author: NICK
 * @date:   2017年6月17日 下午2:06:12   
 *
 */
public class Cart {
	private Integer cartId;
	private FrontUser user;//一个购物车对应一个用户
	private List<GoodInfo> goodList;//一个购物车中有多个商品
	private double total;//总价钱
	private double realTotal;//根据用户是否选中来计算
	private int orderId;//订单编号
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public FrontUser getUser() {
		return user;
	}
	public void setUser(FrontUser user) {
		this.user = user;
	}
	public List<GoodInfo> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<GoodInfo> goodList) {
		this.goodList = goodList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getRealTotal() {
		return realTotal;
	}
	public void setRealTotal(double realTotal) {
		this.realTotal = realTotal;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	//初始化，计算总价钱
		public void init(){
			for(int i=0;i<goodList.size();++i){
				GoodInfo good = goodList.get(i);
				double tempPrice = good.getGoodDiscountedPrice()*good.getCartNumber();
				total+=tempPrice;
				//只有当选中时，才加到realToal中
				if(good.getCartFlag()==1){
					realTotal+=tempPrice;
				}
			}
		}
		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", user=" + user + ", goodList="
					+ goodList + ", total=" + total + ", realTotal="
					+ realTotal + ", orderId=" + orderId + "]";
		}
	

}
