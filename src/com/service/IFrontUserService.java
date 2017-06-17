package com.service;

import com.pojo.FrontUser;

public interface IFrontUserService {
	public FrontUser queryFrontUser(String loginname,String loginpwd);
}
