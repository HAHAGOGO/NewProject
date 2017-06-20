package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodServiceDao;
import com.dao.IGoodServiceRelaxDao;
import com.service.IGoodService;
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
