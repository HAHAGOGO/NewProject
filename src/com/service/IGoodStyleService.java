package com.service;

import java.util.List;

import com.pojo.GoodStyle;

public interface IGoodStyleService {
	List<GoodStyle> getAllType();

	boolean insertGoodStyle(String styleName);

	boolean updateGoodStyleName(GoodStyle goodStyle);
}
