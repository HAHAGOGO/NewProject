package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodInfoDao;
import com.pojo.GoodInfo;
import java.util.Map;
import com.service.IGoodInfoService;
@Service
public class GoodInfoServiceImpl implements IGoodInfoService {
	
	private IGoodInfoDao goodInfoDaoImpl;
	@Override
	public GoodInfo findByGoodId(Integer goodId) {
		return goodInfoDaoImpl.findByGoodId(goodId);
	}

	@Override
	public List<GoodInfo> findByStyleId(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodInfo> findAll(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public IGoodInfoDao getGoodInfoDaoImpl() {
		return goodInfoDaoImpl;
	}

	public void setGoodInfoDaoImpl(IGoodInfoDao goodInfoDaoImpl) {
		this.goodInfoDaoImpl = goodInfoDaoImpl;
	}

}
