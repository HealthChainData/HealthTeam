package com.ht.clinic.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.SymptomsDefineDao;
import com.ht.clinic.domain.SymptomsDefineDO;
import com.ht.clinic.service.SymptomsDefineService;

import java.util.List;
import java.util.Map;




@Service
public class SymptomsDefineServiceImpl implements SymptomsDefineService {
	@Autowired
	private SymptomsDefineDao symptomsDefineDao;
	
	@Override
	public SymptomsDefineDO get(Integer symptomsId){
		return symptomsDefineDao.get(symptomsId);
	}
	
	@Override
	public List<SymptomsDefineDO> list(Map<String, Object> map){
		return symptomsDefineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return symptomsDefineDao.count(map);
	}
	
	@Override
	public int save(SymptomsDefineDO symptomsDefine){
		return symptomsDefineDao.save(symptomsDefine);
	}
	
	@Override
	public int update(SymptomsDefineDO symptomsDefine){
		return symptomsDefineDao.update(symptomsDefine);
	}
	
	@Override
	public int remove(Integer symptomsId){
		return symptomsDefineDao.remove(symptomsId);
	}
	
	@Override
	public int batchRemove(Integer[] symptomsIds){
		return symptomsDefineDao.batchRemove(symptomsIds);
	}
	
}
