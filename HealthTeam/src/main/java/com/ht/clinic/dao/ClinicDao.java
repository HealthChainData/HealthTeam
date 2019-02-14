package com.ht.clinic.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.ClinicDO;

/**
 * @date 2019-02-12 16:10:19
 */
@Mapper
public interface ClinicDao {

	ClinicDO get(String clinicId);
	
	List<ClinicDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ClinicDO clinic);
	
	int update(ClinicDO clinic);
	
	int remove(String clinic_id);
	
	int batchRemove(String[] clinicIds);
}
