package com.ht.clinic.service;

import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.BodyPartsDO;
import com.ht.common.domain.Tree;
import com.ht.system.domain.DeptDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 17:19:59
 */
public interface BodyPartsService {
	
	BodyPartsDO get(Integer bodyPartsId);
	
	List<BodyPartsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BodyPartsDO bodyParts);
	
	int update(BodyPartsDO bodyParts);
	
	int remove(Integer bodyPartsId);
	
	int batchRemove(Integer[] bodyPartsIds);
	
	Tree<BodyPartsDO> getTreeByFlag();
}
