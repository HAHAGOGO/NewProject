package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TurnImage;
import com.service.ITurnImageService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("tic")
public class TurnImageController {

	private ITurnImageService turnImageServiceImpl;
	/**
	 * Ê×Ò³ÂÖ²¥Í¼
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="turnimage")
	public void getTurnImage(HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<TurnImage> turnImage = turnImageServiceImpl.getTurnImage();
		JSONArray fromObject = JSONArray.fromObject(turnImage);
		PrintWriter writer = response.getWriter();
		writer.println(fromObject.toString());
		writer.flush();
		writer.close();
	}
	public ITurnImageService getTurnImageServiceImpl() {
		return turnImageServiceImpl;
	}
	public void setTurnImageServiceImpl(ITurnImageService turnImageServiceImpl) {
		this.turnImageServiceImpl = turnImageServiceImpl;
	}
}
