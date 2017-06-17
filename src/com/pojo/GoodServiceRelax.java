package com.pojo;

import java.io.Serializable;

public class GoodServiceRelax implements Serializable{
	private Integer goodId;
	private Integer serviceId;
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
}
