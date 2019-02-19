package com.ht.clinic.service;


import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.DiseaseDefineDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-18 09:39:56
 */
public interface DiseaseDefineService {
	
	DiseaseDefineDO get(Integer diseaseId);
	
	List<DiseaseDefineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DiseaseDefineDO diseaseDefine);
	
	int update(DiseaseDefineDO diseaseDefine);
	
	int remove(Integer diseaseId);
	
	int removes(Integer diseaseId);
	
	int batchRemove(Integer[] diseaseIds);
}
