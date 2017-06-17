package com.dao;

import com.pojo.FrontUser;

public interface IFrontUserDAO {
public FrontUser queryFrontUser(String loginname,String loginpwd);
}
