<<<<<<< HEAD
package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodServiceDao;
import com.dao.IGoodServiceRelaxDao;
import com.service.IGoodService;
import com.vo.ServiceType;
@Service
public class GoodServiceImpl implements IGoodService {

	private IGoodServiceDao goodServiceDaoImpl;
	private IGoodServiceRelaxDao goodServiceRelaxDaoImpl;
	@Override
	public List<String> getGoodServiceName(Integer goodId) {
		List<Integer> goodServiceId = goodServiceRelaxDaoImpl.getGoodServiceId(goodId);
		System.out.println(goodServiceId);
		return goodServiceDaoImpl.getGoodServiceName(goodServiceId);
	}
	@Override
	public ServiceType getAllService(Integer goodId) {
		
		return null;
	}
	@Override
	public List<ServiceType> getAllServiceAndChecked(Integer goodId) {
		List<ServiceType> list = goodServiceDaoImpl.getAllServiceAndChecked();
		if (goodId==null) {
			return list;
		}
		List<Integer> goodServiceId = goodServiceRelaxDaoImpl.getGoodServiceId(goodId);
		for (int i = 0; i < goodServiceId.size(); i++) {
			Integer integer = goodServiceId.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (integer==list.get(j).getServiceId()) {
					list.get(j).setCheckStatus(1);
					break;
				}
			}
		}
		return list;
	}
	public IGoodServiceDao getGoodServiceDaoImpl() {
		return goodServiceDaoImpl;
	}
	public void setGoodServiceDaoImpl(IGoodServiceDao goodServiceDaoImpl) {
		this.goodServiceDaoImpl = goodServiceDaoImpl;
	}
	public IGoodServiceRelaxDao getGoodServiceRelaxDaoImpl() {
		return goodServiceRelaxDaoImpl;
	}
	public void setGoodServiceRelaxDaoImpl(IGoodServiceRelaxDao goodServiceRelaxDaoImpl) {
		this.goodServiceRelaxDaoImpl = goodServiceRelaxDaoImpl;
	}
	
	
	
	
}
=======
package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodServiceDao;
import com.dao.IGoodServiceRelaxDao;
import com.service.IGoodService;
import com.vo.ServiceType;
@Service
public class GoodServiceImpl implements IGoodService {

	private IGoodServiceDao goodServiceDaoImpl;
	private IGoodServiceRelaxDao goodServiceRelaxDaoImpl;
	@Override
	public List<String> getGoodServiceName(Integer goodId) {
		List<Integer> goodServiceId = goodServiceRelaxDaoImpl.getGoodServiceId(goodId);
		return goodServiceDaoImpl.getGoodServiceName(goodServiceId);
	}
	@Override
	public ServiceType getAllService(Integer goodId) {
		
		return null;
	}
	@Override
	public List<ServiceType> getAllServiceAndChecked(Integer goodId) {
		List<ServiceType> list = goodServiceDaoImpl.getAllServiceAndChecked();
		if (goodId==null) {
			return list;
		}
		List<Integer> goodServiceId = goodServiceRelaxDaoImpl.getGoodServiceId(goodId);
		for (int i = 0; i < goodServiceId.size(); i++) {
			Integer integer = goodServiceId.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (integer==list.get(j).getServiceId()) {
					list.get(j).setCheckStatus(1);
					break;
				}
			}
		}
		return list;
	}
	@Override
	public boolean insertService(String serviceName) {
		return goodServiceDaoImpl.insertService(serviceName);
	}
	@Override
	public boolean updateService(Integer serviceId, String serviceName) {
		return goodServiceDaoImpl.updateService(serviceId, serviceName);
	}
	public IGoodServiceDao getGoodServiceDaoImpl() {
		return goodServiceDaoImpl;
	}
	public void setGoodServiceDaoImpl(IGoodServiceDao goodServiceDaoImpl) {
		this.goodServiceDaoImpl = goodServiceDaoImpl;
	}
	public IGoodServiceRelaxDao getGoodServiceRelaxDaoImpl() {
		return goodServiceRelaxDaoImpl;
	}
	public void setGoodServiceRelaxDaoImpl(IGoodServiceRelaxDao goodServiceRelaxDaoImpl) {
		this.goodServiceRelaxDaoImpl = goodServiceRelaxDaoImpl;
	}
	
	
	
}
>>>>>>> branch 'master' of https://github.com/HAHAGOGO/NewProject
