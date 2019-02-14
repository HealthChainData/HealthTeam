package com.ht.clinic.service;

import com.ht.clinic.domain.ClinicDO;

import java.util.List;
import java.util.Map;

/**
 * @date 2019-02-12 16:10:19
 */
public interface ClinicService {
	
	ClinicDO get(String clinicId);
	
	List<ClinicDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ClinicDO clinic);
	
	int update(ClinicDO clinic);
	
	int remove(String clinicId);
	
	int batchRemove(String[] clinicIds);
}
