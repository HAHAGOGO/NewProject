package com.pojo;

import java.io.Serializable;
import java.util.List;

public class GoodService implements Serializable{
	private Integer goodId;
	private List<String> serviceType;
	
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public List<String> getServiceType() {
		return serviceType;
	}
	public void setServiceType(List<String> serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
