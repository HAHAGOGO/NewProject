package com.service;

import java.util.List;

import com.vo.ServiceType;

public interface IGoodService {
	List<String> getGoodServiceName(Integer goodId);
	ServiceType getAllService(Integer goodId);
	List<ServiceType> getAllServiceAndChecked(Integer goodId);
}
