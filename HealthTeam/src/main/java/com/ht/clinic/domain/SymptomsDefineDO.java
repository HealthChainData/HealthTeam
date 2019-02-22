package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 10:15:39
 */
public class SymptomsDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//症状id
	private Integer symptomsId;
	//症状编号
	private String symptomsIndex;
	//症状名称
	private String symptoms;
	//症状描述
	private String symptomsDescribe;
	//身体部位id
	private String bodyPartsId;
	//好发人群描述
	private String oftenPeople;
	//推荐科室
	private String departmentId;
	//备注
	private String note;
	

	/**
	 * 设置：症状id
	 */
	public void setSymptomsId(Integer symptomsId) {
		this.symptomsId = symptomsId;
	}
	/**
	 * 获取：症状id
	 */
	public Integer getSymptomsId() {
		return symptomsId;
	}
	/**
	 * 设置：症状编号
	 */
	public void setSymptomsIndex(String symptomsIndex) {
		this.symptomsIndex = symptomsIndex;
	}
	/**
	 * 获取：症状编号
	 */
	public String getSymptomsIndex() {
		return symptomsIndex;
	}
	/**
	 * 设置：症状名称
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	/**
	 * 获取：症状名称
	 */
	public String getSymptoms() {
		return symptoms;
	}
	/**
	 * 设置：症状描述
	 */
	public void setSymptomsDescribe(String symptomsDescribe) {
		this.symptomsDescribe = symptomsDescribe;
	}
	/**
	 * 获取：症状描述
	 */
	public String getSymptomsDescribe() {
		return symptomsDescribe;
	}
	/**
	 * 设置：身体部位id
	 */
	public void setBodyPartsId(String bodyPartsId) {
		this.bodyPartsId = bodyPartsId;
	}
	/**
	 * 获取：身体部位id
	 */
	public String getBodyPartsId() {
		return bodyPartsId;
	}
	/**
	 * 设置：好发人群描述
	 */
	public void setOftenPeople(String oftenPeople) {
		this.oftenPeople = oftenPeople;
	}
	/**
	 * 获取：好发人群描述
	 */
	public String getOftenPeople() {
		return oftenPeople;
	}
	/**
	 * 设置：推荐科室
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：推荐科室
	 */
	public String getDepartmentId() {
		return departmentId;
	}
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
}
