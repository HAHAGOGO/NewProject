package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.FrontUser;
import com.pojo.ReceiptPerson;
import com.service.IReceiptPersonService;

@Controller
@RequestMapping("rpc")
public class ReceiptPersonController {
	@Resource(name = "irps")
	private IReceiptPersonService irps;

	@RequestMapping(value = "ap",method=RequestMethod.POST)
	private void addPerson(ReceiptPerson rp, HttpSession session,
			HttpServletResponse response) {
		System.out.println(rp);
		rp.setUserid(((FrontUser) session.getAttribute("user")).getFrontid());
		boolean b = irps.addReceiptPerson(rp);

		try {
			response.getWriter().write(b + "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "qrp", method = RequestMethod.POST)
	private void queryReceiptPerson(Integer receiptid,
			HttpServletResponse response) {
		ReceiptPerson person = irps.queryReceiptPerson(receiptid);
		JSONObject obj = JSONObject.fromObject(person);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writer.print(obj.toString());
	}

	@RequestMapping(value = "qbuid", method = RequestMethod.POST)
	private void queryByUserId(Integer userid, HttpServletResponse response) {

		List<ReceiptPerson> list = irps.queryByUserId(userid);
		JSONArray array = JSONArray.fromObject(list);
		try {
			response.getWriter().print(array.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "delete")
	private void deleteByReceiptPersonID(Integer rpid,
			HttpServletResponse response) {

		boolean person = irps.deleteReceiptPerson(rpid);
		try {
			response.getWriter().write(person + "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	private void updateReceiptUser(ReceiptPerson rp,
			HttpServletResponse response) {

		boolean person = irps.updateReceiptPerson(rp);
		try {
			response.getWriter().write(person + "");
			System.out.println(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "updateDefault")
	private void updateDefault(Integer rpid, HttpServletResponse response) {
		boolean b = irps.updateDefault(rpid);
		try {
			response.getWriter().print(b + "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
