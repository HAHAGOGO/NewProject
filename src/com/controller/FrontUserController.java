package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloopen.message.SendMessage;
import com.pojo.FrontUser;
import com.service.IFrontUserService;

@Controller
@RequestMapping(value = "fuc")
public class FrontUserController {
	@Resource(name = "frontService")
	private IFrontUserService frontService;

	@RequestMapping(value = "islogin", method = RequestMethod.POST)
	private String isLogin(String loginname, String loginpwd,
			HttpSession session) {
		FrontUser user = frontService.queryFrontUser(loginname, loginpwd);
		if (user != null) {
			session.setAttribute("user", user);
			return "file/lingbowen/self";
		}

		return "file/lingbowen/login";
	}

	@RequestMapping(value = "sendMessage", method = RequestMethod.POST)
	private void code(String phone, HttpSession session,HttpServletResponse response) {
		PrintWriter writer=null;
		try {
			 writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer frontid = ((FrontUser)session.getAttribute("user")).getFrontid();
		Integer integer = frontService.checkPhone(phone, frontid.toString());
		if(integer>0){
		session.removeAttribute("code");
		String code = SendMessage.sendMessage(phone);
		session.setAttribute("code", code);
		writer.write("1");
		return;
		}
			
		writer.write("0");

	}

	@RequestMapping(value = "checkCode", method = RequestMethod.POST)
	private void checkCode(String code, HttpSession session,
			HttpServletResponse response) {
		String ocode = (String) session.getAttribute("code");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ocode.equals(code)) {
			Integer integer = ((FrontUser)session.getAttribute("user")).getFrontid();
			boolean b = frontService.updateStatus(integer);
			
			writer.write(b?"1":"2");

		} else {
			writer.write("0");
		}

	}

}
