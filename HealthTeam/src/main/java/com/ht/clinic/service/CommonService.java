package com.ht.clinic.service;

import java.util.List;
import java.util.Map;

public interface CommonService {
	/**
	 * 执行增删改sql语句
	 * 
	 * @author dy
	 * @param sql sql语句
	 * @return
	 */
	public long executeAction(String sql);

	/**
	 * 根据sql语句查询单调数据
	 * 
	 * @author dy
	 * @param sql sql语句
	 * @return
	 */
	public Map<String, Object> findOneData(String sql);

	/**
	 * 根据sql语句查询多调数据
	 * 
	 * @author dy
	 * @param sql sql语句
	 * @return
	 */
	public List<Map<String, Object>> findManyData(String sql);

	/**
	 * 根据sql语句查询条数
	 * 
	 * @author dy
	 * @param sql sql语句
	 * @return
	 */
	public long findCount(String sql);
}
