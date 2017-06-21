package com.service;

import java.util.List;

import com.pojo.ExpressSelect;

public interface IExpressSelectService {
	public List<ExpressSelect> findByID(Integer expressID);
	public List<ExpressSelect> findAll();
}
