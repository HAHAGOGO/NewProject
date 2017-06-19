package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IProvince;
import com.pojo.Province;
@Repository
public class ProvinceDAOImpl extends SqlSessionDaoSupport implements IProvince {

	@Override
	public List<Province> getProvince() {
		// TODO Auto-generated method stub
		List<Province> list = getSqlSession().selectList("com.pojo.Province.queryProvince");
		
		return list;
	}

}
