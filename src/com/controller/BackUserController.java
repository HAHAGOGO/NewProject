package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.BackUser;
import com.service.IBackUserService;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("buc")
public class BackUserController {
	private IBackUserService backUserServiceImpl;

	public IBackUserService getBackUserServiceImpl() {
		return backUserServiceImpl;
	}

	public void setBackUserServiceImpl(IBackUserService backUserServiceImpl) {
		this.backUserServiceImpl = backUserServiceImpl;
	}

	@RequestMapping(value = "backLogin", method = {RequestMethod.POST,RequestMethod.GET})
	private String backLogin(String loginname, String loginpwd,
			HttpSession session) {
		BackUser user = backUserServiceImpl.queryBackUser(loginname, loginpwd);
		if (user != null) {
			System.out.println(user.getAdminRealName());
			session.setAttribute("user", user);
			return "file/lingbowen/admin";

		}
		return "file/lingbowen/backlogin";
	}

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	private String reg(String loginname, String loginpwd, String realname,Model model) {
		boolean queryBackUserByLoginname = backUserServiceImpl.queryBackUserByLoginname(loginname);
		if(queryBackUserByLoginname){
			model.addAttribute("have", "ÒÑ¾­´æÔÚ");
			return "file/lingbowen/Reg";
		}
		boolean b = backUserServiceImpl.addBackUser(loginname, loginpwd,
				realname);
		if (b) {
			return "file/lingbowen/backlogin";
		}
		return "file/lingbowen/Reg";
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	private String logout(){
		
		return "file/lingbowen/backlogin";
	}

}
