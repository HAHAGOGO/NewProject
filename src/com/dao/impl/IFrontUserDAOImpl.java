package com.dao.impl;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IFrontUserDAO;
import com.pojo.FrontUser;

@Repository("frontDAO")
public class IFrontUserDAOImpl extends SqlSessionDaoSupport implements
		IFrontUserDAO {

	@Override
	public FrontUser queryFrontUser(String loginname, String loginpwd) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("loginname", loginname);
		map.put("loginpwd", loginpwd);
		FrontUser one = getSqlSession().selectOne(
				"com.pojo.FrontUser.getFrontUser", map);
		return one;
	}

	@Override
	public boolean updateStatus(Integer userid) {
		// TODO Auto-generated method stub
		int update = getSqlSession().update("com.pojo.FrontUser.updateStatus",
				userid);
		return update > 0 ? true : false;
	}

	@Override
	public Integer checkPhone(String phone, String frontid) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("frontid",frontid);
		Integer one = getSqlSession().selectOne("com.pojo.FrontUser.checkPhone",map);
		return one;
	}
	

}
