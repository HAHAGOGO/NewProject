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

}
