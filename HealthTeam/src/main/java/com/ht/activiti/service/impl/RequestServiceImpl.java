package com.ht.activiti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.activiti.dao.RequestDao;
import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestDao  requestDao;
	
	@Override
	public RequestDO get(String id) {
		// TODO Auto-generated method stub
		return requestDao.get(id);
	}

	@Override
	public List<RequestDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return requestDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return requestDao.count(map);
	}

	@Override
	public int save(RequestDO request) {
		// TODO Auto-generated method stub
		return requestDao.save(request);
	}

	@Override
	public int update(RequestDO request) {
		// TODO Auto-generated method stub
		return requestDao.update(request);
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return requestDao.remove(id);
	}

	@Override
	public int batchRemove(String[] ids) {
		// TODO Auto-generated method stub
		return requestDao.batchRemove(ids);
	}

}
