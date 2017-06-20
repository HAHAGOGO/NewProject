package com.pojo;
/**
 * 
  *@ClassName:  SimpleCart   
 * @Description:购物车类，简化增删改
 * @author: NICK
 * @date:   2017年6月17日 下午2:19:36   
 *
 */
public class SimpleCart {
	private int id;
	private int userId;
	private int goodId;
	private int cartNumber;
	private int flag;
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	
}
