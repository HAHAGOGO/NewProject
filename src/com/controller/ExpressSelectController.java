package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.ExpressSelect;
import com.service.IExpressSelectService;
@Controller
@RequestMapping("express")
public class ExpressSelectController {
	@Resource(name = "expressSelectServiceImpl")
	IExpressSelectService eService;

	@RequestMapping(value = "showall")
	public void showAll(HttpServletResponse response) {
		List<ExpressSelect> findAll = eService.findAll();
		JSONArray array = new JSONArray();
		array.addAll(findAll);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(array.toString());
			writer.flush();
		} catch (IOException e) {

		}

	}

}
