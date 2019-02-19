package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.DiseaseDefineDao;
import com.ht.clinic.domain.DiseaseDefineDO;
import com.ht.clinic.service.DiseaseDefineService;

import java.util.List;
import java.util.Map;




@Service
public class DiseaseDefineServiceImpl implements DiseaseDefineService {
	@Autowired
	private DiseaseDefineDao diseaseDefineDao;
	
	@Override
	public DiseaseDefineDO get(Integer diseaseId){
		return diseaseDefineDao.get(diseaseId);
	}
	
	@Override
	public List<DiseaseDefineDO> list(Map<String, Object> map){
		return diseaseDefineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return diseaseDefineDao.count(map);
	}
	
	@Override
	public int save(DiseaseDefineDO diseaseDefine){
		return diseaseDefineDao.save(diseaseDefine);
	}
	
	@Override
	public int update(DiseaseDefineDO diseaseDefine){
		return diseaseDefineDao.update(diseaseDefine);
	}
	
	@Override
	public int remove(Integer diseaseId){
		return diseaseDefineDao.remove(diseaseId);
	}
	
	@Override
	public int removes(Integer diseaseId){
		return diseaseDefineDao.removes(diseaseId);
	}
	
	@Override
	public int batchRemove(Integer[] diseaseIds){
		return diseaseDefineDao.batchRemove(diseaseIds);
	}
	
}
