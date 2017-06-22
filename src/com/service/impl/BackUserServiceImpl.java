package com.service.impl;

import org.springframework.stereotype.Service;

import com.dao.IBackUserDAO;
import com.pojo.BackUser;
import com.service.IBackUserService;

@Service
public class BackUserServiceImpl implements IBackUserService {
	private IBackUserDAO backUserDAOImpl;

	public IBackUserDAO getBackUserDAOImpl() {
		return backUserDAOImpl;
	}

	public void setBackUserDAOImpl(IBackUserDAO backUserDAOImpl) {
		this.backUserDAOImpl = backUserDAOImpl;
	}

	@Override
	public BackUser queryBackUser(String loginname, String loginpwd) {
		// TODO Auto-generated method stub

		return backUserDAOImpl.queryBackUser(loginname, loginpwd);
	}

}
