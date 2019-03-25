package com.ht.clinic.dao;



import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.HealthCodeDefineDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 申请字典代码表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-22 14:22:33
 */
@Mapper
public interface HealthCodeDefineDao {

	HealthCodeDefineDO get(Long id);
	
	List<HealthCodeDefineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HealthCodeDefineDO healthCodeDefine);
	
	int update(HealthCodeDefineDO healthCodeDefine);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
