package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodStyleDao;
import com.pojo.GoodStyle;
@Repository
public class GoodStyleDaoImpl extends SqlSessionDaoSupport implements IGoodStyleDao {

	@Override
	public List<GoodStyle> getAllType() {
		return super.getSqlSession().selectList("com.pojo.GoodStyle.getAllType");
	}

}
