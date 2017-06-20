package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IAreaDAO;
import com.pojo.Area;
import com.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {

	private IAreaDAO areaDAOImpl;

	public IAreaDAO getAreaDAOImpl() {
		return areaDAOImpl;
	}

	public void setAreaDAOImpl(IAreaDAO areaDAOImpl) {
		this.areaDAOImpl = areaDAOImpl;
	}

	@Override
	public List<Area> getArea(String father) {
		// TODO Auto-generated method stub
		List<Area> area = areaDAOImpl.getArea(father);
		return area;
	}

}
