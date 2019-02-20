package com.ht.clinic.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.DrugDefineDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-19 15:20:41
 */
@Mapper
public interface DrugDefineDao {

	DrugDefineDO get(Integer drugId);
	
	List<DrugDefineDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DrugDefineDO drugDefine);
	
	int update(DrugDefineDO drugDefine);
	
	int remove(Integer drug_id);
	
	int removes(Integer drug_id);
	
	int batchRemove(Integer[] drugIds);
}
