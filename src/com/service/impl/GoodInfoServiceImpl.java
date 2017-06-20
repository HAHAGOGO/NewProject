package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dao.IGoodInfoDao;
import com.dao.IGoodServiceRelaxDao;
import com.pojo.GoodInfo;
import com.service.IGoodInfoService;
@Service
public class GoodInfoServiceImpl implements IGoodInfoService {
	
	private IGoodInfoDao goodInfoDaoImpl;
	private IGoodServiceRelaxDao goodServiceRelaxDaoImpl;
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
	@Override
	public boolean addGood(GoodInfo goodInfo) {
		return false;
	}

	@Override
	public boolean updateGood(GoodInfo goodInfo, String[] serviceId) {
		Integer goodId = goodInfo.getGoodId();
		boolean deleteFlag = goodServiceRelaxDaoImpl.deleteRelax(goodId);
		if (!deleteFlag) {
			return false;
		}
		for (int i = 0; i < serviceId.length; i++) {
			boolean flag = goodServiceRelaxDaoImpl.insertRelax(goodId, Integer.valueOf(serviceId[i]));
			if (!flag) {
				return false;
			}
		}
		boolean addGood = goodInfoDaoImpl.addGood(goodInfo);
		if (addGood) {
			return true;
		}
		return false;
	}
	
	public IGoodInfoDao getGoodInfoDaoImpl() {
		return goodInfoDaoImpl;
	}

	public void setGoodInfoDaoImpl(IGoodInfoDao goodInfoDaoImpl) {
		this.goodInfoDaoImpl = goodInfoDaoImpl;
	}

	public IGoodServiceRelaxDao getGoodServiceRelaxDaoImpl() {
		return goodServiceRelaxDaoImpl;
	}

	public void setGoodServiceRelaxDaoImpl(IGoodServiceRelaxDao goodServiceRelaxDaoImpl) {
		this.goodServiceRelaxDaoImpl = goodServiceRelaxDaoImpl;
	}

	
	
	

}
