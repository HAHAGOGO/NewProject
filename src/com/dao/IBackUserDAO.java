package com.dao;

import com.pojo.BackUser;

public interface IBackUserDAO {
	public BackUser queryBackUser(String loginname,String loginpwd);
public boolean addBackUser(String loginname,String loginpwd,String realname);
public boolean queryBackUserByLoginname(String loginname);
}
