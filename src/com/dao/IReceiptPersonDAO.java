package com.dao;

import java.util.List;

import com.pojo.ReceiptPerson;

public interface IReceiptPersonDAO {
public boolean addReceiptPerson(ReceiptPerson rp);
public ReceiptPerson queryReceiptPerson(Integer frontid);
}
