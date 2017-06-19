package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.IProvince;
import com.pojo.Province;
import com.service.IProvinceService;
@Service
public class ProvinceServiceImpl implements IProvinceService {
private IProvince provinceDAOImpl;
	@Override
	public List<Province> getProvince() {
		// TODO Auto-generated method stub
		List<Province> list = provinceDAOImpl.getProvince();
		return list;
	}
	public IProvince getProvinceDAOImpl() {
		return provinceDAOImpl;
	}
	public void setProvinceDAOImpl(IProvince provinceDAOImpl) {
		this.provinceDAOImpl = provinceDAOImpl;
	}

}
