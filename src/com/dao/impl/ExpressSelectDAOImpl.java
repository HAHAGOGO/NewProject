package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IExpressSelectDao;
import com.pojo.ExpressSelect;

@Repository
public class ExpressSelectDAOImpl extends SqlSessionDaoSupport implements
		IExpressSelectDao {

	@Override
	public List<ExpressSelect> findByID(Integer expressID) {
		
		return super.getSqlSession().selectOne("com.dao.IExpressSelectDao.findByID",expressID);
	}

	@Override
	public List<ExpressSelect> findAll() {
		return super.getSqlSession().selectList("com.dao.IExpressSelectDao.findByAll");
	}

}
