package com.ht.system.dao;

import com.ht.system.domain.CitiesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区域地州市信息表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 10:26:35
 */
@Mapper
public interface CitiesDao {

	CitiesDO get(Integer id);
	
	List<CitiesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CitiesDO cities);
	
	int update(CitiesDO cities);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
