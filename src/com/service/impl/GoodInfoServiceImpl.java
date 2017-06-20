package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dao.IGoodInfoDao;
import com.pojo.GoodInfo;

import com.service.IGoodInfoService;
@Service
public class GoodInfoServiceImpl implements IGoodInfoService {
	
	private IGoodInfoDao goodInfoDaoImpl;
	@Override
	public GoodInfo findByGoodId(Integer goodId) {
		return goodInfoDaoImpl.findByGoodId(goodId);
	}

	@Override
	public List<GoodInfo> findByStyleId(Integer styleId,Integer cp,Integer ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodInfo> findAll(Integer styleId,Integer cp,Integer ps) {
		if (cp==null||cp<1) {
			cp=1;
		}
		if (ps==null||ps<1) {
			ps=1;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("styleId", styleId);
		map.put("start", (cp-1)*ps);
		map.put("ps", ps);
		return goodInfoDaoImpl.findAll(map);
	}

	public IGoodInfoDao getGoodInfoDaoImpl() {
		return goodInfoDaoImpl;
	}

	public void setGoodInfoDaoImpl(IGoodInfoDao goodInfoDaoImpl) {
		this.goodInfoDaoImpl = goodInfoDaoImpl;
	}

}
