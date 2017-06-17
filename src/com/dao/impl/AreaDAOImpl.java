package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IAreaDAO;
import com.pojo.Area;
@Repository
public class AreaDAOImpl extends SqlSessionDaoSupport implements IAreaDAO {

	@Override
	public List<Area> getArea(String father) {
		// TODO Auto-generated method stub
		List<Area> list = getSqlSession().selectList("com.pojo.Area.queryAreaByFather", father);
		return list;
	}

}
