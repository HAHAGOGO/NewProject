package com.dao;

import java.util.List;

import com.pojo.ReceiptPerson;

public interface IReceiptPersonDAO {
	public boolean addReceiptPerson(ReceiptPerson rp);

	public ReceiptPerson queryReceiptPerson(Integer rpid);

	public List<ReceiptPerson> queryByUserId(Integer userid);

	public boolean deleteReceiptPerson(Integer rpid);

	public boolean updateReceiptPerson(ReceiptPerson rp);
	public boolean updateDefault(Integer rpid);
}
