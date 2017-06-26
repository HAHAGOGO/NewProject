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

	@Override
	public boolean insertGoodStyle(String styleName) {
		int flag = super.getSqlSession().insert("com.pojo.GoodStyle.insertGoodStyle", styleName);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateGoodStyleName(GoodStyle goodStyle) {
		int flag = super.getSqlSession().update("com.pojo.GoodStyle.updateGoodStyleName", goodStyle);
		if (flag>0) {
			return true;
		}
		return false;
	}

}
