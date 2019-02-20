package com.ht.clinic.service;



import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.DrugDefineDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-19 15:20:41
 */
public interface DrugDefineService {
	
	DrugDefineDO get(Integer drugId);
	
	List<DrugDefineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DrugDefineDO drugDefine);
	
	int update(DrugDefineDO drugDefine);
	
	int remove(Integer drugId);

	int removes(Integer drugId);
	
	int batchRemove(Integer[] drugIds);
}
