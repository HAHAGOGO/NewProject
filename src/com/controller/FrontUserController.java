package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.FrontUser;
import com.service.IFrontUserService;

@Controller
@RequestMapping(value="fuc")
public class FrontUserController {
@Resource(name="frontService")	
private IFrontUserService frontService;
@RequestMapping(value="islogin",method=RequestMethod.POST)	
public String isLogin(String loginname,String loginpwd,HttpSession session){
	System.out.println("ssss");
	System.out.println(loginname+"---"+loginpwd);
	FrontUser user = frontService.queryFrontUser(loginname, loginpwd);
	if(user!=null){
		session.setAttribute("user", user);
		return "file/lingbowen/self";
	}
	
	return "file/lingbowen/login";
}
}
