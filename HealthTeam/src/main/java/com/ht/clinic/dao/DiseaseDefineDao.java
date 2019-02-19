package com.ht.clinic.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.DiseaseDefineDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-18 09:39:56
 */
@Mapper
public interface DiseaseDefineDao {

	DiseaseDefineDO get(Integer diseaseId);
	
	List<DiseaseDefineDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DiseaseDefineDO diseaseDefine);
	
	int update(DiseaseDefineDO diseaseDefine);
	
	int remove(Integer disease_id);
	
	int removes(Integer disease_id);
	
	int batchRemove(Integer[] diseaseIds);
}
