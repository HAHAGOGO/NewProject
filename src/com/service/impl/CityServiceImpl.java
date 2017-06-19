package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.ICityDAO;
import com.pojo.City;
import com.service.ICityService;

@Service
public class CityServiceImpl implements ICityService {

	private ICityDAO cityDAOImpl;

	@Override
	public List<City> getCity(String father) {
		// TODO Auto-generated method stub
		List<City> list = cityDAOImpl.getCity(father);
		return list;
	}

	public ICityDAO getCityDAOImpl() {
		return cityDAOImpl;
	}

	public void setCityDAOImpl(ICityDAO cityDAOImpl) {
		this.cityDAOImpl = cityDAOImpl;
	}

}
