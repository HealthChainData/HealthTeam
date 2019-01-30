package com.ht.activiti.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ht.activiti.domain.RequestStepDO;


@Service
public interface RequestStepService {
	
	RequestStepDO get(String id);
	
	List<RequestStepDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RequestStepDO requestStep);
	
	int update(RequestStepDO requestStep);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
