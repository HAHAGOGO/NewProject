package com.service;

import com.pojo.BackUser;

public interface IBackUserService {
	public BackUser queryBackUser(String loginname,String loginpwd);
}
