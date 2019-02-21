package com.ht.clinic.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.SymptomsDefineDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 10:15:39
 */
@Mapper
public interface SymptomsDefineDao {

	SymptomsDefineDO get(Integer symptomsId);
	
	List<SymptomsDefineDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SymptomsDefineDO symptomsDefine);
	
	int update(SymptomsDefineDO symptomsDefine);
	
	int remove(Integer symptoms_id);
	
	int batchRemove(Integer[] symptomsIds);
}
