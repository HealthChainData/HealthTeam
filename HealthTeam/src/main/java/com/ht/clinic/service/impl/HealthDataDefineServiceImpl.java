package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.HealthDataDefineDao;
import com.ht.clinic.domain.HealthDataDefineDO;
import com.ht.clinic.service.HealthDataDefineService;

import java.util.List;
import java.util.Map;





@Service
public class HealthDataDefineServiceImpl implements HealthDataDefineService {
	@Autowired
	private HealthDataDefineDao healthDataDefineDao;
	
	@Override
	public HealthDataDefineDO get(Integer defineId){
		return healthDataDefineDao.get(defineId);
	}
	
	@Override
	public List<HealthDataDefineDO> list(Map<String, Object> map){
		return healthDataDefineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return healthDataDefineDao.count(map);
	}
	
	@Override
	public int save(HealthDataDefineDO healthDataDefine){
		return healthDataDefineDao.save(healthDataDefine);
	}
	
	@Override
	public int update(HealthDataDefineDO healthDataDefine){
		return healthDataDefineDao.update(healthDataDefine);
	}
	
	@Override
	public int remove(Integer defineId){
		return healthDataDefineDao.remove(defineId);
	}
	
	@Override
	public int batchRemove(Integer[] defineIds){
		return healthDataDefineDao.batchRemove(defineIds);
	}
	
}
