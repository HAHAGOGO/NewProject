
package com.dao;

import java.util.List;

import com.vo.ServiceType;

public interface IGoodServiceDao {
	List<String> getGoodServiceName(List<Integer> goodServiceId);

	List<String> getAllService();

	List<ServiceType> getAllServiceAndChecked();

	boolean insertService(String serviceName);
	
	boolean updateService(Integer serviceId,String serviceName);
}
