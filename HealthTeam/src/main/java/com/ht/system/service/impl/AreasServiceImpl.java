package com.ht.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ht.system.dao.AreasDao;
import com.ht.system.domain.AreasDO;
import com.ht.system.service.AreasService;



@Service
public class AreasServiceImpl implements AreasService {
	@Autowired
	private AreasDao areasDao;
	
	@Override
	public AreasDO get(Integer id){
		return areasDao.get(id);
	}
	
	@Override
	public List<AreasDO> list(Map<String, Object> map){
		return areasDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return areasDao.count(map);
	}
	
	@Override
	public int save(AreasDO areas){
		return areasDao.save(areas);
	}
	
	@Override
	public int update(AreasDO areas){
		return areasDao.update(areas);
	}
	
	@Override
	public int remove(Integer id){
		return areasDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return areasDao.batchRemove(ids);
	}
	
}
