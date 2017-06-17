package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodStyleDao;
import com.pojo.GoodStyle;
import com.service.IGoodStyleService;
@Service
public class GoodStyleServiceImpl implements IGoodStyleService {
	private IGoodStyleDao goodStyleDaoImpl;
	@Override
	public List<GoodStyle> getAllType() {
		return goodStyleDaoImpl.getAllType();
	}
	public IGoodStyleDao getGoodStyleDaoImpl() {
		return goodStyleDaoImpl;
	}
	public void setGoodStyleDaoImpl(IGoodStyleDao goodStyleDaoImpl) {
		this.goodStyleDaoImpl = goodStyleDaoImpl;
	}

}
