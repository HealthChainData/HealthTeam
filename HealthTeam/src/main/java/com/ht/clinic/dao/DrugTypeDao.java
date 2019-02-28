package com.ht.clinic.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ht.clinic.domain.DrugTypeDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-27 10:29:54
 */
@Mapper
public interface DrugTypeDao {

	DrugTypeDO get(Integer id);
	
	List<DrugTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DrugTypeDO drugType);
	
	int update(DrugTypeDO drugType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
