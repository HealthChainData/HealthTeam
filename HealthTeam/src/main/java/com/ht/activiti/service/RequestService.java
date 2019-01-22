package com.ht.activiti.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ht.activiti.domain.RequestDO;



@Service
public interface RequestService {
	
    RequestDO get(String id);
	
	List<RequestDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RequestDO request);
	
	int update(RequestDO request);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
