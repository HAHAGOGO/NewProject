package com.dao.impl;

import java.util.HashMap;
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

	@Override
	public Integer addGood(GoodInfo goodInfo) {
		int flag = super.getSqlSession().insert("com.pojo.GoodInfo.addGood", goodInfo);
		if (flag<0) {
			return -1;
		}
		return goodInfo.getGoodId();
	}

	@Override
	public boolean updateGood(GoodInfo goodInfo) {
		int flag = super.getSqlSession().update("com.pojo.GoodInfo.updateGood", goodInfo);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteGood(Integer goodId) {
		int flag = super.getSqlSession().delete("com.pojo.GoodInfo.deleteGood", goodId);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAll(Integer[] delId) {
		int flag = super.getSqlSession().delete("com.pojo.GoodInfo.deleteAll", delId);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public Integer getCount(Integer styleId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("styleId", styleId);
		return super.getSqlSession().selectOne("com.pojo.GoodInfo.getCount", map);
		
	}

}
