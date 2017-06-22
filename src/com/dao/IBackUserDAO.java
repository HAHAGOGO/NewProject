package com.dao;

import com.pojo.BackUser;

public interface IBackUserDAO {
	public BackUser queryBackUser(String loginname,String loginpwd);

}
