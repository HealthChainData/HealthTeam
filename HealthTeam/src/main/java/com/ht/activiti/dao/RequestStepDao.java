package com.ht.activiti.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.activiti.domain.RequestStepDO;

@Mapper
public interface RequestStepDao {
	RequestStepDO get(String id);

	List<RequestStepDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(RequestStepDO requestStep);

	int update(RequestStepDO requestStep);

	int remove(String id);

	int batchRemove(String[] ids);
}
