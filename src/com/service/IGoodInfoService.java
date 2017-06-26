package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pojo.GoodInfo;

public interface IGoodInfoService {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Integer styleId,Integer cp,Integer ps);
	List<GoodInfo> findAll(Integer styleId,Integer cp,Integer ps);
	Integer getCount(Integer styleId);
	
	Integer addGood(GoodInfo goodInfo,String[] serviceId,HttpServletRequest req);
	boolean updateGood(GoodInfo goodInfo,String[] serviceId,HttpServletRequest req);
	boolean deleteGood(Integer goodId,HttpServletRequest req);
	boolean deleteAll(Integer[] delId,HttpServletRequest req);
}
