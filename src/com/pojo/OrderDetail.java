package com.pojo;
import java.io.Serializable;
public class OrderDetail implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer detailid;
	 private Integer orderid;
	 private Good_Info goodInfo;
	 private double  price;
	 private Integer status;
	 private Integer quantity;
	public Integer getDetailid() {
		return detailid;
	}
	public void setDetailid(Integer detailid) {
		this.detailid = detailid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	public Good_Info getGoodInfo() {
		return goodInfo;
	}
	public void setGoodInfo(Good_Info goodInfo) {
		this.goodInfo = goodInfo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 
	 
	
}
