
package com.dao;

import com.pojo.FrontUser;

public interface IFrontUserDAO {
public FrontUser queryFrontUser(String loginname,String loginpwd);
public boolean updateStatus(Integer userid);
public Integer checkPhone(String phone,String frontid);
public Integer checkOpenID(String openid);
public boolean addFrontUser(FrontUser user);
public boolean addCheckCode(Integer frontid,String code);
public boolean removeCheckCode(Integer frontid);
public boolean matchCheckCode(Integer frontid,String code);
}

