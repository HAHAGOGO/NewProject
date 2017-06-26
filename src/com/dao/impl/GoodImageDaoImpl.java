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

	@Override
	public boolean addImage(GoodImage goodImage) {
		int flag = super.getSqlSession().insert("com.pojo.GoodImage.addImage", goodImage);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteImage(Integer goodId) {
		int flag = super.getSqlSession().delete("com.pojo.GoodImage.deleteImage", goodId);
		if (flag>0) {
			return true;
		}
		return false;
	}

}
