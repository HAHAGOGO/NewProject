package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IReceiptPersonDAO;
import com.pojo.ReceiptPerson;
import com.service.IReceiptPersonService;

@Service("irps")
public class IReceiptPersonServiceImpl implements IReceiptPersonService {
	@Resource(name = "rpdao")
	private IReceiptPersonDAO rpdao;

	@Override
	public boolean addReceiptPerson(ReceiptPerson rp) {
		// TODO Auto-generated method stub
		
		return rpdao.addReceiptPerson(rp);
	}

	@Override
	public ReceiptPerson queryReceiptPerson(Integer frontid) {
		// TODO Auto-generated method stub
		ReceiptPerson person = rpdao.queryReceiptPerson(frontid);
		return person;
	}

}
