package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodImageDao;
import com.pojo.GoodImage;
@Repository
public class GoodImageDaoImpl extends SqlSessionDaoSupport implements IGoodImageDao {

	@Override
	public List<GoodImage> getGoodImageByGoodId(Integer goodId) {
		return super.getSqlSession().selectList("com.pojo.GoodImage.getGoodImageByGoodId",goodId);
	}

}
