
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

	@Override
	public Integer checkOpenID(String openid) {
		// TODO Auto-generated method stub
		Integer count = getSqlSession().selectOne("com.pojo.FrontUser.checkOpenId", openid);
		return count;
	}

	@Override
	public boolean addFrontUser(FrontUser user) {
		// TODO Auto-generated method stub
		int i = getSqlSession().insert("com.pojo.FrontUser.addFrontUser", user);
		return i>0?true:false;
	}

	@Override
	public boolean addCheckCode(Integer frontid, String code) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("frontid", frontid.toString());
		map.put("checkcode",code);
		System.out.println(frontid+"----"+code);
		int i = getSqlSession().update("com.pojo.FrontUser.addCheckCode",map);
		return i>0?true:false;
	}

	@Override
	public boolean removeCheckCode(Integer frontid) {
		// TODO Auto-generated method stub
		int i = getSqlSession().delete("com.pojo.FrontUser.removeCheckCode", frontid);
		return i>0?true:false;
	}

	@Override
	public boolean matchCheckCode(Integer frontid, String code) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<>();
		map.put("frontid", frontid.toString());
		map.put("checkcode",code);
		Integer selectOne = getSqlSession().selectOne("com.pojo.FrontUser.matchCheckCode",map);
		return selectOne>0?true:false;
	}
	
	

}

