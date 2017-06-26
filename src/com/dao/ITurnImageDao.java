package com.dao;

import java.util.List;

import com.pojo.TurnImage;

public interface ITurnImageDao {
	List<TurnImage> getTurnImage();

	Integer getCount();

	boolean inserTurnImage(TurnImage turnImage);
	
	boolean deleteTurnImage(Integer turnId);
}
