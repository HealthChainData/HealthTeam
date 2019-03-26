package com.ht.clinic.service.impl;

import com.ht.clinic.dao.HealthCodeDefineDao;
import com.ht.clinic.domain.HealthCodeDefineDO;
import com.ht.clinic.service.HealthCodeDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class HealthCodeDefineServiceImpl implements HealthCodeDefineService {
	@Autowired
	private HealthCodeDefineDao healthCodeDefineDao;
	
	@Override
	public HealthCodeDefineDO get(Integer id){
		return healthCodeDefineDao.get(id);
	}
	
	@Override
	public List<HealthCodeDefineDO> list(Map<String, Object> map){
		return healthCodeDefineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return healthCodeDefineDao.count(map);
	}
	
	@Override
	public int save(HealthCodeDefineDO healthCodeDefine){
		return healthCodeDefineDao.save(healthCodeDefine);
	}
	
	@Override
	public int update(HealthCodeDefineDO healthCodeDefine){
		return healthCodeDefineDao.update(healthCodeDefine);
	}
	
	@Override
	public int remove(Long id){
		return healthCodeDefineDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return healthCodeDefineDao.batchRemove(ids);
	}
	
}
