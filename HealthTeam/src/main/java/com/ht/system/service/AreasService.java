package com.ht.system.service;

import com.ht.system.domain.AreasDO;

import java.util.List;
import java.util.Map;

/**
 * 行政区域县区信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 10:27:38
 */
public interface AreasService {
	
	AreasDO get(Integer id);
	
	List<AreasDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AreasDO areas);
	
	int update(AreasDO areas);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
