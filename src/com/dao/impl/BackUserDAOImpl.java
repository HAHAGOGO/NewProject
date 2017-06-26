package com.dao.impl;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IBackUserDAO;
import com.pojo.BackUser;
@Repository
public class BackUserDAOImpl extends SqlSessionDaoSupport implements IBackUserDAO{

	@Override
	public BackUser queryBackUser(String loginname, String loginpwd) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("adminName", loginname);
		map.put("adminPwd", loginpwd);
		BackUser one = getSqlSession().selectOne("com.pojo.BackUser.queryBackUser",map );
		return one;
	}

	@Override
	public boolean addBackUser(String loginname, String loginpwd,
			String realname) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("loginname", loginname);
		map.put("loginpwd",loginpwd );
		map.put("realname", realname);
		int i = getSqlSession().insert("com.pojo.BackUser.addBackUser", map);
		return i>0?true:false;
	}

	@Override
	public boolean queryBackUserByLoginname(String loginname) {
		// TODO Auto-generated method stub
		Integer one = getSqlSession().selectOne("com.pojo.BackUser.queryBackUserByLoginname",loginname);
		return one>0?true:false;
	}

}
