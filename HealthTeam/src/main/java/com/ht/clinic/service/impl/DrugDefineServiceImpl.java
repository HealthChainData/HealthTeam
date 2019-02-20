package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.DrugDefineDao;
import com.ht.clinic.domain.DrugDefineDO;
import com.ht.clinic.service.DrugDefineService;

import java.util.List;
import java.util.Map;




@Service
public class DrugDefineServiceImpl implements DrugDefineService {
	@Autowired
	private DrugDefineDao drugDefineDao;
	
	@Override
	public DrugDefineDO get(Integer drugId){
		return drugDefineDao.get(drugId);
	}
	
	@Override
	public List<DrugDefineDO> list(Map<String, Object> map){
		return drugDefineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return drugDefineDao.count(map);
	}
	
	@Override
	public int save(DrugDefineDO drugDefine){
		return drugDefineDao.save(drugDefine);
	}
	
	@Override
	public int update(DrugDefineDO drugDefine){
		return drugDefineDao.update(drugDefine);
	}
	
	@Override
	public int remove(Integer drugId){
		return drugDefineDao.remove(drugId);
	}
	
	@Override
	public int removes(Integer drugId){
		return drugDefineDao.removes(drugId);
	}
	
	@Override
	public int batchRemove(Integer[] drugIds){
		return drugDefineDao.batchRemove(drugIds);
	}
	
}
