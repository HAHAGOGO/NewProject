
package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IFrontUserDAO;
import com.pojo.FrontUser;
import com.service.IFrontUserService;

@Service("frontService")
public class IFrontUserServiceImpl implements IFrontUserService {
	@Resource(name = "frontDAO")
	private IFrontUserDAO frontDAO;

	@Override
	public FrontUser queryFrontUser(String loginname, String loginpwd) {
		// TODO Auto-generated method stub
		FrontUser user = frontDAO.queryFrontUser(loginname, loginpwd);
		return user;
	}

	@Override
	public boolean updateStatus(Integer userid) {
		// TODO Auto-generated method stub
		boolean b = frontDAO.updateStatus(userid);
		return b;
	}

	@Override
	public Integer checkPhone(String phone, String frontid) {
		// TODO Auto-generated method stub
		Integer integer = frontDAO.checkPhone(phone, frontid);
		return integer;
	}

	@Override
	public Integer checkOpenID(String openid) {
		// TODO Auto-generated method stub
		
		return frontDAO.checkOpenID(openid);
	}

	@Override
	public boolean addFrontUser(FrontUser user) {
		// TODO Auto-generated method stub
		return frontDAO.addFrontUser(user);
	}

	@Override
	public boolean addCheckCode(Integer frontid, String code) {
		// TODO Auto-generated method stub
		return frontDAO.addCheckCode(frontid, code);
	}

	@Override
	public boolean removeCheckCode(Integer frontid) {
		// TODO Auto-generated method stub
		return frontDAO.removeCheckCode(frontid);
	}

	@Override
	public boolean matchCheckCode(Integer frontid, String code) {
		// TODO Auto-generated method stub
		return frontDAO.matchCheckCode(frontid, code);
	}
	

}

