package com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ReceiptPerson queryReceiptPerson(Integer rpid) {
		// TODO Auto-generated method stub
		ReceiptPerson one = getSqlSession().selectOne(
				"com.pojo.ReceiptPerson.queryByID", rpid);
		return one;
	}

	@Override
	public List<ReceiptPerson> queryByUserId(Integer userid) {
		// TODO Auto-generated method stub
		List<ReceiptPerson> list = getSqlSession().selectList(
				"com.pojo.ReceiptPerson.queryByUserID", userid);
		return list;
	}

	@Override
	public boolean deleteReceiptPerson(Integer rpid) {
		// TODO Auto-generated method stub
		int i = getSqlSession().delete("com.pojo.ReceiptPerson.deleteByRPID", rpid);
		return i>0?true:false;
	}

	@Override
	public boolean updateReceiptPerson(ReceiptPerson rp) {
		// TODO Auto-generated method stub
		int i = getSqlSession().update("com.pojo.ReceiptPerson.update",rp);
		return 1>0?true:false;
	}

	@Override
	public boolean updateDefault(Integer rpid) {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		session.update("com.pojo.ReceiptPerson.updateInit");
		int i = session.update("com.pojo.ReceiptPerson.updateStatus",rpid);
		return i>0?true:false;
	}

}
