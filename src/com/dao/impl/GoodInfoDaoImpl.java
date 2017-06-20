package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodInfoDao;
import com.pojo.GoodInfo;

@Repository
public class GoodInfoDaoImpl extends SqlSessionDaoSupport implements IGoodInfoDao {

	@Override
	public GoodInfo findByGoodId(Integer goodId) {
		return super.getSqlSession().selectOne("com.pojo.GoodInfo.findByGoodId",goodId);
	}

	@Override
	public List<GoodInfo> findByStyleId(Map<String, Integer> map) {
		
		return null;
	}

	@Override
	public List<GoodInfo> findAll(Map<String, Integer> map) {
		return super.getSqlSession().selectList("com.pojo.GoodInfo.findAll",map);
	}

}
