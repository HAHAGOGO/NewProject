package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloopen.message.SendMessage;
import com.pojo.FrontUser;
import com.pojo.WeChatInfo;
import com.service.IFrontUserService;
import com.utils.HttpClientUtil;

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
	private void code(WeChatInfo we, String phone, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Integer integer = frontService.checkPhone(phone, frontid.toString()); */
		Integer frontid = frontService.checkOpenID(we.getOpenid());
	
		
		String code = SendMessage.sendMessage(phone);
	
		frontService.addCheckCode(frontid, code);

	}

	@RequestMapping(value = "checkCode", method = RequestMethod.POST)
	private void checkCode(String code,WeChatInfo we,
			HttpServletResponse response) {
		Integer frontid = frontService.checkOpenID(we.getOpenid());
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (frontService.matchCheckCode(frontid, code)) {
			frontService.removeCheckCode(frontid);
			boolean b = frontService.updateStatus(frontid);

			writer.write(b ? "1" : "2");

		} else {
			writer.write("0");
		}

	}


	private void getWeChantInfo(JSONObject we) {

		FrontUser user = new FrontUser();
		Integer count = frontService.checkOpenID(we.getString("openid"));
		if (count == null) {
			user.setNickName(we.getString("nickname"));
			user.setPicPath(we.getString("headimgurl"));
			user.setOpenid(we.getString("openid"));
			user.setUserStatus("0");

			frontService.addFrontUser(user);
		}

	
	}

	@RequestMapping(value = "queryWeChatInfo")
	private void queryWeChatInfo(String code, HttpServletResponse response) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		String appid = "wxaf77eef37e18c26b";
		String appsecrect = "5235e9308db4caadc2783e4e810bb76d";

		String string = url.replace("APPID", appid)
				.replace("SECRET", appsecrect).replace("CODE", code);

		JSONObject jsonObject = HttpClientUtil.httpRequest(string, "GET", null);
		String openid = jsonObject.getString("openid");
		jsonObject.getInt("expires_in");
		String token = jsonObject.getString("access_token");
		String url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		String string2 = url2.replace("ACCESS_TOKEN", token).replace("OPENID",
				openid);

		JSONObject jsonObject1 = HttpClientUtil.httpRequest(string2, "GET",
				null);
		String weChatInfo = jsonObject1.toString();
		getWeChantInfo(jsonObject1);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().print(weChatInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
