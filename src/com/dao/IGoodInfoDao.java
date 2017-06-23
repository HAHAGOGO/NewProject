package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.GoodInfo;



public interface IGoodInfoDao {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Map<String, Integer> map);
	List<GoodInfo> findAll(Map<String, Integer> map);
	Integer getCount(Integer styleId);
	
	Integer addGood(GoodInfo goodInfo);
	boolean updateGood(GoodInfo goodInfo);
	boolean deleteGood(Integer goodId);
	boolean deleteAll(Integer[] delId);
}
