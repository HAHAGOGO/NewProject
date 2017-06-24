package com.service;

import com.pojo.BackUser;

public interface IBackUserService {
	public BackUser queryBackUser(String loginname,String loginpwd);
	public boolean addBackUser(String loginname,String loginpwd,String realname);
	public boolean queryBackUserByLoginname(String loginname);

}
