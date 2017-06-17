package com.service.impl;

import java.util.List;

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

	@Override
	public List<ReceiptPerson> queryByUserId(Integer userid) {
		// TODO Auto-generated method stub
		List<ReceiptPerson> list = rpdao.queryByUserId(userid);
		return list;
	}

	@Override
	public boolean deleteReceiptPerson(Integer rpid) {
		// TODO Auto-generated method stub

		return rpdao.deleteReceiptPerson(rpid);
	}

	@Override
	public boolean updateReceiptPerson(ReceiptPerson rp) {
		// TODO Auto-generated method stub
		return rpdao.updateReceiptPerson(rp);
	}

	@Override
	public boolean updateDefault(Integer rpid) {
		// TODO Auto-generated method stub
		return rpdao.updateDefault(rpid);
	}

}
