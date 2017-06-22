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

}
