package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.ReceiptPerson;
import com.service.IReceiptPersonService;

@Controller
@RequestMapping("rpc")
public class ReceiptPersonController {
	@Resource(name = "irps")
	private IReceiptPersonService irps;
	

	@RequestMapping(value = "ap")
	private String addPerson(ReceiptPerson rp) {
		System.out.println(rp);
		rp.setUserid(2);
		irps.addReceiptPerson(rp);
		
		
		
		return null;
		
		
	}
	@RequestMapping(value="qrp",method=RequestMethod.POST)
	private void queryReceiptPerson(Integer receiptid,HttpServletResponse response){
		ReceiptPerson person = irps.queryReceiptPerson(receiptid);
	    JSONObject obj = JSONObject.fromObject(person);
	    PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj.toString());
	    writer.print(obj.toString());
}
	@RequestMapping(value="drp")
	private void deleteReceiptPerson(Integer userid){
		
	}
	
}
