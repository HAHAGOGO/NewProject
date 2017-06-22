package com.service;

import java.util.List;

import com.pojo.GoodInfo;

public interface IGoodInfoService {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Integer styleId,Integer cp,Integer ps);
	List<GoodInfo> findAll(Integer styleId,Integer cp,Integer ps);
	
	boolean addGood(GoodInfo goodInfo,String[] serviceId);
	boolean updateGood(GoodInfo goodInfo,String[] serviceId);
	boolean deleteGood(Integer goodId);
}
