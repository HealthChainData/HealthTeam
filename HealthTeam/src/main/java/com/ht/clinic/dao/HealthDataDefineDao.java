package com.ht.clinic.dao;




import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.HealthDataDefineDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 11:26:55
 */
@Mapper
public interface HealthDataDefineDao {

	HealthDataDefineDO get(Integer defineId);
	
	List<HealthDataDefineDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(HealthDataDefineDO healthDataDefine);
	
	int update(HealthDataDefineDO healthDataDefine);
	
	int remove(Integer define_id);
	
	int batchRemove(Integer[] defineIds);
}
