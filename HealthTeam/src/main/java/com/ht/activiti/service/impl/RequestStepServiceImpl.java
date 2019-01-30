package com.ht.activiti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.activiti.dao.RequestStepDao;
import com.ht.activiti.domain.RequestStepDO;
import com.ht.activiti.service.RequestStepService;

@Service
public class RequestStepServiceImpl implements RequestStepService{
	
	@Autowired
	private RequestStepDao requestStepDao;

	@Override
	public RequestStepDO get(String id) {
		// TODO Auto-generated method stub
		return requestStepDao.get(id);
	}

	@Override
	public List<RequestStepDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return requestStepDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return requestStepDao.count(map);
	}

	@Override
	public int save(RequestStepDO requestStep) {
		// TODO Auto-generated method stub
		return requestStepDao.save(requestStep);
	}

	@Override
	public int update(RequestStepDO requestStep) {
		// TODO Auto-generated method stub
		return requestStepDao.update(requestStep);
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return requestStepDao.remove(id);
	}

	@Override
	public int batchRemove(String[] ids) {
		// TODO Auto-generated method stub
		return requestStepDao.batchRemove(ids);
	}

}
