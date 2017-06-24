package com.service;

import java.util.List;

import com.pojo.TurnImage;

public interface ITurnImageService {
	List<TurnImage> getTurnImage();

	Integer getCount();

	boolean inserTurnImage(TurnImage turnImage);

	boolean deleteTurnImage(Integer turnId);
}
