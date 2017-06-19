package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.GoodInfo;

public interface IGoodInfoDao {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Map<String, Integer> map);
	List<GoodInfo> findAll(Map<String, Integer> map);
}
