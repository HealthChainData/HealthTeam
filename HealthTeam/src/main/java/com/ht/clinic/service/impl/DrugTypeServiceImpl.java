package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.clinic.dao.DrugTypeDao;
import com.ht.clinic.domain.DrugTypeDO;
import com.ht.clinic.service.DrugTypeService;

import java.util.List;
import java.util.Map;





@Service
public class DrugTypeServiceImpl implements DrugTypeService {
	@Autowired
	private DrugTypeDao drugTypeDao;
	
	@Override
	public DrugTypeDO get(Integer id){
		return drugTypeDao.get(id);
	}
	
	@Override
	public List<DrugTypeDO> list(Map<String, Object> map){
		return drugTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return drugTypeDao.count(map);
	}
	
	@Override
	public int save(DrugTypeDO drugType){
		return drugTypeDao.save(drugType);
	}
	
	@Override
	public int update(DrugTypeDO drugType){
		return drugTypeDao.update(drugType);
	}
	
	@Override
	public int remove(Integer id){
		return drugTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return drugTypeDao.batchRemove(ids);
	}
	
}
