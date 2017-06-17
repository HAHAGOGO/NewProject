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
	private void code(String phone, HttpSession session) {
		session.removeAttribute("code");
		String code = SendMessage.sendMessage(phone);
		session.setAttribute("code", code);

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
			writer.write(1);

		} else {
			writer.write(0);
		}

	}

}
