package com.service;

import com.pojo.ReceiptPerson;

public interface IReceiptPersonService {
	public boolean addReceiptPerson(ReceiptPerson rp);
	public ReceiptPerson queryReceiptPerson(Integer frontid);
}
