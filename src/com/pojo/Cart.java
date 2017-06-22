package com.pojo;

import java.util.List;
/**
 * 
  *@ClassName:  Cart   
 * @Description:���ﳵ��   
 * @author: NICK
 * @date:   2017��6��17�� ����2:06:12   
 *
 */
public class Cart {
	private Integer cartId;
	private FrontUser user;//һ�����ﳵ��Ӧһ���û�
	private List<GoodInfo> goodList;//һ�����ﳵ���ж����Ʒ
	private double total;//�ܼ�Ǯ
	private double realTotal;//�����û��Ƿ�ѡ��������
	private int orderId;//�������
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
	//��ʼ���������ܼ�Ǯ
		public void init(){
			for(int i=0;i<goodList.size();++i){
				GoodInfo good = goodList.get(i);
				double tempPrice = good.getGoodDiscountedPrice()*good.getCartNumber();
				total+=tempPrice;
				//ֻ�е�ѡ��ʱ���żӵ�realToal��
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
