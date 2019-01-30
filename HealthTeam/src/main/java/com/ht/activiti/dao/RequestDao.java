package com.ht.activiti.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.activiti.domain.RequestDO;


@Mapper
public interface RequestDao {
	
	RequestDO get(String id);
	
	List<RequestDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RequestDO request);
	
	int update(RequestDO request);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	int getRequestId();

}
