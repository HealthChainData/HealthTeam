package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-18 09:39:56
 */
public class DiseaseDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	//疾病id
	private Integer diseaseId;
	//名称
	private String diseaseName;
	//引用国际ICD编号内容，国际统一标准，不会重复
	private String icdNumber;
	//父疾病分类id
	private Integer diseaseParentId;
	//助记码
	private String mnemonicCode;
	//性别限制 0:无限制 1:女 2:男
	private Integer tenderLimit;
	//疗效限制 0:治愈 1:好转 2:无定义
	private Integer curativeLimit;
	//备注
	private String note;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 设置：疾病id
	 */
	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}
	/**
	 * 获取：疾病id
	 */
	public Integer getDiseaseId() {
		return diseaseId;
	}
	/**
	 * 设置：疾病名称
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	/**
	 * 获取：疾病名称
	 */
	public String getDiseaseName() {
		return diseaseName;
	}
	/**
	 * 设置：引用国际ICD编号内容，国际统一标准，不会重复
	 */
	public void setIcdNumber(String icdNumber) {
		this.icdNumber = icdNumber;
	}
	/**
	 * 获取：引用国际ICD编号内容，国际统一标准，不会重复
	 */
	public String getIcdNumber() {
		return icdNumber;
	}
	/**
	 * 设置：父疾病分类id
	 */
	public void setDiseaseParentId(Integer diseaseParentId) {
		this.diseaseParentId = diseaseParentId;
	}
	/**
	 * 获取：父疾病分类id
	 */
	public Integer getDiseaseParentId() {
		return diseaseParentId;
	}
	/**
	 * 设置：助记码
	 */
	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}
	/**
	 * 获取：助记码
	 */
	public String getMnemonicCode() {
		return mnemonicCode;
	}
	/**
	 * 设置：性别限制 0:无限制 1:女 2:男
	 */
	public void setTenderLimit(Integer tenderLimit) {
		this.tenderLimit = tenderLimit;
	}
	/**
	 * 获取：性别限制 0:无限制 1:女 2:男
	 */
	public Integer getTenderLimit() {
		return tenderLimit;
	}
	/**
	 * 设置：疗效限制 0:治愈 1:好转 2:无定义
	 */
	public void setCurativeLimit(Integer curativeLimit) {
		this.curativeLimit = curativeLimit;
	}
	/**
	 * 获取：疗效限制 0:治愈 1:好转 2:无定义
	 */
	public Integer getCurativeLimit() {
		return curativeLimit;
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
