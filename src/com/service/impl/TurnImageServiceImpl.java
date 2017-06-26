package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.ITurnImageDao;
import com.pojo.TurnImage;
import com.service.ITurnImageService;
@Service
public class TurnImageServiceImpl implements ITurnImageService {
	
	private ITurnImageDao turnImageDaoImpl;
	@Override
	public List<TurnImage> getTurnImage() {
		return turnImageDaoImpl.getTurnImage();
	}
	
	@Override
	public Integer getCount() {
		return turnImageDaoImpl.getCount();
	}
	@Override
	public boolean inserTurnImage(TurnImage turnImage) {
		return turnImageDaoImpl.inserTurnImage(turnImage);
	}
	@Override
	public boolean deleteTurnImage(Integer turnId) {
		return turnImageDaoImpl.deleteTurnImage(turnId);
	}
	public ITurnImageDao getTurnImageDaoImpl() {
		return turnImageDaoImpl;
	}
	public void setTurnImageDaoImpl(ITurnImageDao turnImageDaoImpl) {
		this.turnImageDaoImpl = turnImageDaoImpl;
	}
	

}
