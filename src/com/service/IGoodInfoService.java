package com.service;

import java.util.List;

import com.pojo.GoodInfo;
import com.sun.javafx.collections.MappingChange.Map;

public interface IGoodInfoService {
	GoodInfo findByGoodId(Integer goodId);
	List<GoodInfo> findByStyleId(Integer styleId,Integer cp,Integer ps);
	List<GoodInfo> findAll(Integer styleId,Integer cp,Integer ps);
}
