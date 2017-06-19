
package com.service;

import java.util.List;

import com.pojo.GoodInfo;
import java.util.Map;

public interface IGoodInfoService {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Map<String, Integer> map);
	List<GoodInfo> findAll(Map<String, Integer> map);
}

