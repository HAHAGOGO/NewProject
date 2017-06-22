package com.service;

import java.util.List;

import com.pojo.GoodImage;

public interface IGoodImageService {
	List<GoodImage> getGoodImageByGoodId(Integer goodId);
}
