package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodServiceRelaxDao;
@Repository
public class GoodServiceRelaxDaoImpl extends SqlSessionDaoSupport implements IGoodServiceRelaxDao {

	@Override
	public List<Integer> getGoodServiceId(Integer goodId) {
		return super.getSqlSession().selectList("com.pojo.GoodServiceRelax.getServiceId",goodId);
	}

	@Override
	public boolean insertRelax(Integer goodId, Integer serviceId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("goodId", goodId);
		map.put("serviceId", serviceId);
		int flag = super.getSqlSession().insert("com.pojo.GoodServiceRelax.insertRelax", map);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRelax(Integer goodId) {
		int flag = super.getSqlSession().delete("com.pojo.GoodServiceRelax.deleteRelax", goodId);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAll(Integer[] delId) {
		int flag = super.getSqlSession().delete("com.pojo.GoodServiceRelax.deleteAll", delId);
		if (flag>0) {
			return true;
		}
		return false;
	}

}
