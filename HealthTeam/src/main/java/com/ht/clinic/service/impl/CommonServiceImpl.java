package com.ht.clinic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.CommonDao;
import com.ht.clinic.service.CommonService;
@Service
public class CommonServiceImpl  implements CommonService{
	
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public long executeAction(String sql) {
		// TODO Auto-generated method stub
		return commonDao.executeAction(sql);
	}

	@Override
	public Map<String, Object> findOneData(String sql) {
		// TODO Auto-generated method stub
		return commonDao.findOneData(sql);
	}

	@Override
	public List<Map<String, Object>> findManyData(String sql) {
		// TODO Auto-generated method stub
		return commonDao.findManyData(sql);
	}

	@Override
	public long findCount(String sql) {
		// TODO Auto-generated method stub
		return commonDao.findCount(sql);
	}

}
