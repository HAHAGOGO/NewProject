package com.service;

import java.util.List;

import com.pojo.ReceiptPerson;

public interface IReceiptPersonService {
	public boolean addReceiptPerson(ReceiptPerson rp);

	public ReceiptPerson queryReceiptPerson(Integer frontid);

	public List<ReceiptPerson> queryByUserId(Integer userid);

	public boolean deleteReceiptPerson(Integer rpid);

	public boolean updateReceiptPerson(ReceiptPerson rp);

	public boolean updateDefault(Integer rpid);
}
