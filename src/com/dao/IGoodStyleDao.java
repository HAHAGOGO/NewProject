package com.dao;

import java.util.List;

import com.pojo.GoodStyle;

public interface IGoodStyleDao {
	List<GoodStyle> getAllType();
	
	boolean insertGoodStyle(String styleName);
	
	boolean updateGoodStyleName(GoodStyle goodStyle);
}
