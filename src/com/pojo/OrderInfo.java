package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private Integer frontid;
	private ReceiptPerson receipt;
	private Integer orderstatus;
	private Double totalprice;
	private Integer totalnum;
	private ExpressSelect expressSelect;
	private Date ordertime;
	private Date deadline;
	private String message;
	
	private List<OrderDetail> orderItem;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getFrontid() {
		return frontid;
	}

	public void setFrontid(Integer frontid) {
		this.frontid = frontid;
	}

	public ReceiptPerson getReceipt() {
		return receipt;
	}

	public void setReceipt(ReceiptPerson receipt) {
		this.receipt = receipt;
	}

	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public ExpressSelect getExpressSelect() {
		return expressSelect;
	}

	public void setExpressSelect(ExpressSelect expressSelect) {
		this.expressSelect = expressSelect;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<OrderDetail> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderDetail> orderItem) {
		this.orderItem = orderItem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
