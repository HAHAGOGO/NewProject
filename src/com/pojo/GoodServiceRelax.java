package com.pojo;

import java.io.Serializable;

public class GoodServiceRelax implements Serializable{
	private Integer goodId;
	private int[] serviceId;
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public int[] getServiceId() {
		return serviceId;
	}
	public void setServiceId(int[] serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
