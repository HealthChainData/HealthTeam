package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @date 2019-02-12 16:10:19
 */
public class ClinicDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	// 机构id
	private String clinicId;
	// 机构名称
	private String clinicName;
	//机构号
	private String clinicIndex;
	// 机构地址
	private String clinicAddress;
	// 状态 0:可用 1:不可用
	private Integer status;
	// 机构电话
	private String clinicTel;
	// 机构负责人
	private String clinicHead;
	// 机构负责人电话
	private String clinicHeadMobile;
	// 联系人
	private String clinicContact;
	// 联系人电话
	private String clinicContactMobile;
	// 父机构ID
	private String clinicParentId;
	// 能量币
	private Integer energyMoney;
	// 超级管理员ID
	private String superAdminId;
	// 修改人ID
	private String modifyUserId;
	// 修改时间
	private Date modifyTime;
	// 新建人ID
	private String createUserId;
	// 新建时间
	private Date createTime;
	// 备注
	private String note;

	
	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：机构id
	 */
	public String getClinicId() {
		return clinicId;
	}

	/**
	 * 设置：机构名称
	 */
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	
	public String getClinicIndex() {
		return clinicIndex;
	}

	public void setClinicIndex(String clinicIndex) {
		this.clinicIndex = clinicIndex;
	}

	/**
	 * 获取：机构名称
	 */
	public String getClinicName() {
		return clinicName;
	}

	/**
	 * 设置：机构地址
	 */
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	/**
	 * 获取：机构地址
	 */
	public String getClinicAddress() {
		return clinicAddress;
	}

	/**
	 * 设置：0：可用 1：不可用
	 * 
	 * 状态 0:可用 1:不可用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：0：可用 1：不可用
	 * 
	 * 状态 0:可用 1:不可用
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：机构电话
	 */
	public void setClinicTel(String clinicTel) {
		this.clinicTel = clinicTel;
	}

	/**
	 * 获取：机构电话
	 */
	public String getClinicTel() {
		return clinicTel;
	}

	/**
	 * 设置：机构负责人
	 */
	public void setClinicHead(String clinicHead) {
		this.clinicHead = clinicHead;
	}

	/**
	 * 获取：机构负责人
	 */
	public String getClinicHead() {
		return clinicHead;
	}

	/**
	 * 设置：机构负责人电话
	 */
	public void setClinicHeadMobile(String clinicHeadMobile) {
		this.clinicHeadMobile = clinicHeadMobile;
	}

	/**
	 * 获取：机构负责人电话
	 */
	public String getClinicHeadMobile() {
		return clinicHeadMobile;
	}

	/**
	 * 设置：联系人
	 */
	public void setClinicContact(String clinicContact) {
		this.clinicContact = clinicContact;
	}

	/**
	 * 获取：联系人
	 */
	public String getClinicContact() {
		return clinicContact;
	}

	/**
	 * 设置：联系人电话
	 */
	public void setClinicContactMobile(String clinicContactMobile) {
		this.clinicContactMobile = clinicContactMobile;
	}

	/**
	 * 获取：联系人电话
	 */
	public String getClinicContactMobile() {
		return clinicContactMobile;
	}

	/**
	 * 设置：父机构ID
	 */
	public void setClinicParentId(String clinicParentId) {
		this.clinicParentId = clinicParentId;
	}

	/**
	 * 获取：父机构ID
	 */
	public String getClinicParentId() {
		return clinicParentId;
	}

	/**
	 * 设置：能量币
	 */
	public void setEnergyMoney(Integer energyMoney) {
		this.energyMoney = energyMoney;
	}

	/**
	 * 获取：能量币
	 */
	public Integer getEnergyMoney() {
		return energyMoney;
	}

	/**
	 * 设置：超级管理员ID
	 */
	public void setSuperAdminId(String superAdminId) {
		this.superAdminId = superAdminId;
	}

	/**
	 * 获取：超级管理员ID
	 */
	public String getSuperAdminId() {
		return superAdminId;
	}

	/**
	 * 设置：修改人ID
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	/**
	 * 获取：修改人ID
	 */
	public String getModifyUserId() {
		return modifyUserId;
	}

	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置：新建人ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 获取：新建人ID
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * 设置：新建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：新建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
