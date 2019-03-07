package com.ht.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 省份信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 10:26:05
 */
public class ProvincesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String provinceid;
	//
	private String province;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	/**
	 * 获取：
	 */
	public String getProvinceid() {
		return provinceid;
	}
	/**
	 * 设置：
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：
	 */
	public String getProvince() {
		return province;
	}
}
