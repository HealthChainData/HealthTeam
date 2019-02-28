package com.ht.clinic.service;


import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.DrugTypeDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-27 10:29:54
 */
public interface DrugTypeService {
	
	DrugTypeDO get(Integer id);
	
	List<DrugTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DrugTypeDO drugType);
	
	int update(DrugTypeDO drugType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
