package com.dao;

import java.util.List;

public interface IGoodServiceDao {
	List<String> getGoodServiceName(List<Integer> goodServiceId);
}
