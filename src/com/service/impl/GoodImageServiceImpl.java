package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IGoodImageDao;
import com.pojo.GoodImage;
import com.service.IGoodImageService;
@Service
public class GoodImageServiceImpl implements IGoodImageService {
	private IGoodImageDao goodImageDaoImpl;
	@Override
	public List<GoodImage> getGoodImageByGoodId(Integer goodId) {
		if (goodId==null) {
			return null;
		}
		return goodImageDaoImpl.getGoodImageByGoodId(goodId);
	}
	public IGoodImageDao getGoodImageDaoImpl() {
		return goodImageDaoImpl;
	}
	public void setGoodImageDaoImpl(IGoodImageDao goodImageDaoImpl) {
		this.goodImageDaoImpl = goodImageDaoImpl;
	}
	
}
