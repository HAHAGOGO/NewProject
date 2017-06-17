package com.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IReceiptPersonDAO;
import com.pojo.ReceiptPerson;

@Repository("rpdao")
public class IReceiptPersonDAOImpl extends SqlSessionDaoSupport implements
		IReceiptPersonDAO {

	@Override
	public boolean addReceiptPerson(ReceiptPerson rp) {
	
		// TODO Auto-generated method stub
		int i = getSqlSession().update(
				"com.pojo.ReceiptPerson.addReceiptPerson", rp);
		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public ReceiptPerson queryReceiptPerson(Integer frontid) {
		// TODO Auto-generated method stub
		ReceiptPerson one = getSqlSession().selectOne(
				"com.pojo.ReceiptPerson.queryByID", frontid);
		return one;
	}

}
