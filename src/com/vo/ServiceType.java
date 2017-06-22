package com.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 这个类是用于后台页面
 *
 */
public class ServiceType implements Serializable{
	private Integer serviceId;
	private String serviceName;
	private Integer checkStatus;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	@Override
	public String toString() {
		return "ServiceType [serviceId=" + serviceId + ", serviceName=" + serviceName + ", checkStatus=" + checkStatus
				+ "]";
	}
}
