package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IGoodServiceDao;
import com.vo.ServiceType;
@Repository
public class GoodServiceDaoImpl extends SqlSessionDaoSupport implements IGoodServiceDao{

	@Override
	public List<String> getGoodServiceName(List<Integer> goodServiceId) {
		if (goodServiceId==null||goodServiceId.size()==0) {
			return null;
		}
		return super.getSqlSession().selectList("com.pojo.GoodService.getGoodServiceName", goodServiceId);
	}

	@Override
	public List<String> getAllService() {
		return super.getSqlSession().selectList("com.pojo.GoodService.getAllService");
	}

	@Override
	public List<ServiceType> getAllServiceAndChecked() {
		return super.getSqlSession().selectList("com.pojo.GoodService.getAllServiceAndChecked");
	}

	@Override
	public boolean insertService(String serviceName) {
		int flag = super.getSqlSession().insert("com.pojo.GoodService.insertService", serviceName);
		if (flag>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateService(Integer serviceId, String serviceName) {
		Map<String, Object> map = new HashMap<>();
		map.put("serviceId",serviceId);
		map.put("serviceName",serviceName);
		int flag = super.getSqlSession().update("com.pojo.GoodService.updateService", map);
		if (flag>0) {
			return true;
		}
		return false;
	}

}
