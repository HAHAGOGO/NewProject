package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodServiceRelaxDao;
@Repository
public class GoodServiceRelaxDaoImpl extends SqlSessionDaoSupport implements IGoodServiceRelaxDao {

	@Override
	public List<Integer> getGoodServiceId(Integer goodId) {
		return super.getSqlSession().selectList("com.pojo.GoodServiceRelax.getServiceId",goodId);
	}

}
