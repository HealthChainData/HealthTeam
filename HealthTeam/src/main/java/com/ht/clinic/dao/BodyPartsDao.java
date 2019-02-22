package com.ht.clinic.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.BodyPartsDO;
import com.ht.system.domain.DeptDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 17:19:59
 */
@Mapper
public interface BodyPartsDao {
	
	List<BodyPartsDO> getTreeByFlag(Map<String,Object> map);
	
	BodyPartsDO get(Integer bodyPartsId);
	
	List<BodyPartsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(BodyPartsDO bodyParts);
	
	int update(BodyPartsDO bodyParts);
	
	int remove(Integer body_parts_id);
	
	int batchRemove(Integer[] bodyPartsIds);
}
