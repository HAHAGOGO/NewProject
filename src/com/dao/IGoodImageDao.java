package com.dao;

import java.util.List;

import com.pojo.GoodImage;

public interface IGoodImageDao {
	List<GoodImage> getGoodImageByGoodId(Integer goodId);
	
	boolean addImage(GoodImage goodImage);
	boolean deleteImage(Integer goodId);
}
