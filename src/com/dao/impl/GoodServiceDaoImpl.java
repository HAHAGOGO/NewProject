package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodServiceDao;
@Repository
public class GoodServiceDaoImpl extends SqlSessionDaoSupport implements IGoodServiceDao{

	@Override
	public List<String> getGoodServiceName(List<Integer> goodServiceId) {
		return super.getSqlSession().selectList("com.pojo.GoodService.getGoodServiceName", goodServiceId);
	}

}
