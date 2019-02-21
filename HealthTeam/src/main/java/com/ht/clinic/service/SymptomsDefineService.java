package com.ht.clinic.service;



import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.SymptomsDefineDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 10:15:39
 */
public interface SymptomsDefineService {
	
	SymptomsDefineDO get(Integer symptomsId);
	
	List<SymptomsDefineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SymptomsDefineDO symptomsDefine);
	
	int update(SymptomsDefineDO symptomsDefine);
	
	int remove(Integer symptomsId);
	
	int batchRemove(Integer[] symptomsIds);
}
