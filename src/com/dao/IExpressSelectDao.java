package com.dao;

import java.util.List;

import com.pojo.ExpressSelect;

public interface IExpressSelectDao {
	public List<ExpressSelect> findByID(Integer expressID);
	public List<ExpressSelect> findAll();
}
