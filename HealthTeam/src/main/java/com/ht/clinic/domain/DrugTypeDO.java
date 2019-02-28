package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-27 10:29:54
 */
public class DrugTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主鍵id
	private Integer id;
	//药品分类名称
	private String drugTypeName;

	/**
	 * 设置：主鍵id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主鍵id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：药品分类名称
	 */
	public void setDrugTypeName(String drugTypeName) {
		this.drugTypeName = drugTypeName;
	}
	/**
	 * 获取：药品分类名称
	 */
	public String getDrugTypeName() {
		return drugTypeName;
	}
}
