
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.Area;
import com.pojo.City;
import com.pojo.FrontUser;
import com.pojo.Province;
import com.pojo.ReceiptPerson;
import com.service.IAreaService;
import com.service.ICityService;
import com.service.IProvinceService;
import com.service.IReceiptPersonService;

@Controller
@RequestMapping("rpc")
public class ReceiptPersonController {
	@Resource(name = "irps")
	private IReceiptPersonService irps;
	private IAreaService areaServiceImpl;
	private ICityService cityServiceImpl;
	private IProvinceService provinceServiceImpl;

	public IAreaService getAreaServiceImpl() {
		return areaServiceImpl;
	}

	public void setAreaServiceImpl(IAreaService areaServiceImpl) {
		this.areaServiceImpl = areaServiceImpl;
	}

	public ICityService getCityServiceImpl() {
		return cityServiceImpl;
	}

	public void setCityServiceImpl(ICityService cityServiceImpl) {
		this.cityServiceImpl = cityServiceImpl;
	}

	public IProvinceService getProvinceServiceImpl() {
		return provinceServiceImpl;
	}

	public void setProvinceServiceImpl(IProvinceService provinceServiceImpl) {
		this.provinceServiceImpl = provinceServiceImpl;
	}

	@RequestMapping(value = "ap", method = RequestMethod.POST)
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
			response.setContentType("text/json;charset=utf-8");
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writer.print(obj.toString());
	}

	@RequestMapping(value = "qbuid", method = RequestMethod.GET)
	private void queryByUserId(Integer userid, HttpServletResponse response) {

		List<ReceiptPerson> list = irps.queryByUserId(userid);
		JSONArray array = JSONArray.fromObject(list);
		try {
			response.setContentType("text/json;charset=utf-8");
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

	@RequestMapping(value = "getAreaByFather", method = RequestMethod.GET)
	private void getAreaByFather(String father, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			response.setContentType("text/json;charset=utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Area> list = areaServiceImpl.getArea(father);
		JSONArray object = JSONArray.fromObject(list);
		writer.print(object.toString());

	}

	@RequestMapping(value = "getCityByFather", method = RequestMethod.GET)
	private void getCityByFather(String father, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			response.setContentType("text/json;charset=utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<City> list = cityServiceImpl.getCity(father);
		JSONArray object = JSONArray.fromObject(list);
		writer.print(object.toString());
	}

	@RequestMapping(value = "getProvince", method = RequestMethod.GET)
	private void getProvince(HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			response.setContentType("text/json;charset=utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Province> list = provinceServiceImpl.getProvince();
		JSONArray jsonArray = JSONArray.fromObject(list);
		writer.write(jsonArray.toString());
	}
}

