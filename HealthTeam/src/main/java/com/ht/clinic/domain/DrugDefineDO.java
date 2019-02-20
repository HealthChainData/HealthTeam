package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-19 15:20:41
 */
public class DrugDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	//药品id
	private Integer drugId;
	//药品编号
	private String drugIndex;
	//药品名称
	private String drugName;
	//药品父ID
	private Integer drugParentId;
	//药品规格
	private String drugSpecification;
	//生产厂家
	private String manufacturer;
	//批准文号
	private String approvalNumber;
	//功能主治
	private String majorFunction;
	//用法用量
	private String usage;
	//备注
	private String note;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 设置：药品id
	 */
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	/**
	 * 获取：药品id
	 */
	public Integer getDrugId() {
		return drugId;
	}
	/**
	 * 设置：药品编号
	 */
	public void setDrugIndex(String drugIndex) {
		this.drugIndex = drugIndex;
	}
	/**
	 * 获取：药品编号
	 */
	public String getDrugIndex() {
		return drugIndex;
	}
	/**
	 * 设置：药品名称
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	/**
	 * 获取：药品名称
	 */
	public String getDrugName() {
		return drugName;
	}
	/**
	 * 设置：药品父ID
	 */
	public void setDrugParentId(Integer drugParentId) {
		this.drugParentId = drugParentId;
	}
	/**
	 * 获取：药品父ID
	 */
	public Integer getDrugParentId() {
		return drugParentId;
	}
	/**
	 * 设置：药品规格
	 */
	public void setDrugSpecification(String drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
	/**
	 * 获取：药品规格
	 */
	public String getDrugSpecification() {
		return drugSpecification;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * 设置：批准文号
	 */
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	/**
	 * 获取：批准文号
	 */
	public String getApprovalNumber() {
		return approvalNumber;
	}
	/**
	 * 设置：功能主治
	 */
	public void setMajorFunction(String majorFunction) {
		this.majorFunction = majorFunction;
	}
	/**
	 * 获取：功能主治
	 */
	public String getMajorFunction() {
		return majorFunction;
	}
	/**
	 * 设置：用法用量
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	/**
	 * 获取：用法用量
	 */
	public String getUsage() {
		return usage;
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
