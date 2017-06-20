package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.ITurnImageDao;
import com.pojo.TurnImage;
@Repository
public class TurnImageDaoImpl extends SqlSessionDaoSupport implements ITurnImageDao {

	@Override
	public List<TurnImage> getTurnImage() {
		return super.getSqlSession().selectList("com.pojo.TurnImage.getTurnImage");
	}

}
