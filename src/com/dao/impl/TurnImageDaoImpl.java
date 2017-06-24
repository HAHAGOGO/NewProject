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

	@Override
	public Integer getCount() {
		return super.getSqlSession().selectOne("com.pojo.TurnImage.getCount");
	}

	@Override
	public boolean inserTurnImage(TurnImage turnImage) {
		int flag = super.getSqlSession().insert("com.pojo.TurnImage.inserTurnImage", turnImage);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTurnImage(Integer turnId) {
		int flag = super.getSqlSession().delete("com.pojo.TurnImage.deleteTurnImage", turnId);
		if (flag>0) {
			return true;
		}
		return false;
	}

}
