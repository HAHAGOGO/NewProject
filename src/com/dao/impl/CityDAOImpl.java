package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.ICityDAO;
import com.pojo.City;
@Repository
public class CityDAOImpl extends SqlSessionDaoSupport implements ICityDAO {

	@Override
	public List<City> getCity(String father) {
		// TODO Auto-generated method stub
		List<City> list = getSqlSession().selectList("com.pojo.City.queryCityByFather", father);
		return list;
	}

}
