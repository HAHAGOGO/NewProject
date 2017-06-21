package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.IExpressSelectDao;
import com.pojo.ExpressSelect;
import com.service.IExpressSelectService;

@Service
public class ExpressSelectServiceImpl implements IExpressSelectService {
	
	@Resource(name="expressSelectDAOImpl")
	IExpressSelectDao eDao;
	@Override
	public List<ExpressSelect> findByID(Integer expressID) {
		return eDao.findByID(expressID);
	}

	@Override
	public List<ExpressSelect> findAll() {
		return eDao.findAll();
	}

}
