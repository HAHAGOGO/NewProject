package com.dao;

import java.util.List;

import com.pojo.ExpressSelect;

public interface IExpressSelectDao {
	public List<ExpressSelect> findByID(Integer expressID);
	public boolean save(ExpressSelect exps);
	public boolean update(ExpressSelect exps);
	public boolean delete(Integer goodid);
}
