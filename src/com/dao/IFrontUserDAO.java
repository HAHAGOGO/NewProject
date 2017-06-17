package com.dao;

import com.pojo.FrontUser;

public interface IFrontUserDAO {
public FrontUser queryFrontUser(String loginname,String loginpwd);
public boolean updateStatus(Integer userid);
public Integer checkPhone(String phone,String frontid);
}
