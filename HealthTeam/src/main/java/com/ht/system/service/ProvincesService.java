package com.ht.system.service;

import com.ht.system.domain.ProvincesDO;

import java.util.List;
import java.util.Map;

/**
 * 省份信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 10:26:05
 */
public interface ProvincesService {
	
	ProvincesDO get(Integer id);
	
	List<ProvincesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProvincesDO provinces);
	
	int update(ProvincesDO provinces);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
