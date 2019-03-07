package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-05 09:21:18
 */
public class ClinicDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	// 机构id,自动产生
	private String clinicId;
	// 机构编号,系统内唯一
	private String clinicIndex;
	// 机构名称
	private String clinicName;
	// 系统名称,用于显示B端页面上的名称
	private String systemName;
	// 所在国家,预设”CHINA“
	private String country;
	// 所在省份,从t_province中去look-up
	private String province;
	// 所在城市,从t_city中去look-up
	private String city;
	// 所在区县,从t_district中去look-up
	private String district;
	// 机构地址
	private String clinicAddress;
	// 状态,
	private Integer status;
	//机构电话
	private String clinicTel;
	// 机构负责人
	private String clinicHead;
	// 机构负责人电话
	private String clinicHeadMobile;
	// 联系人
	private String clinicContact;
	// 联系人电话
	private String clinicContactMobile;
	// 父机构ID,如果本身是父机构，则不填写
	private String clinicParentId;
	// 能量币,初始是0
	private Integer energyMoney;
	// 超级管理员ID，来自于后台管理系统的工作人员ID
	private String superAdminId;
	// 修改人ID,来自于后台管理系统的工作人员ID
	private String modifyUserId;
	// 修改时间
	private Date modifyTime;
	// 来自于后台管理系统的工作人员ID
	private String createUserId;
	// 新建时间
	private Date createTime;
	// 备注
	private String note;
	// 预设值
	private Integer version;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 设置：机构id,自动产生
	 */
	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	/**
	 * 获取：机构id,自动产生
	 */
	public String getClinicId() {
		return clinicId;
	}

	/**
	 * 设置：机构编号,系统内唯一
	 */
	public void setClinicIndex(String clinicIndex) {
		this.clinicIndex = clinicIndex;
	}

	/**
	 * 获取：机构编号,系统内唯一
	 */
	public String getClinicIndex() {
		return clinicIndex;
	}

	/**
	 * 设置：机构名称
	 */
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	/**
	 * 获取：机构名称
	 */
	public String getClinicName() {
		return clinicName;
	}

	/**
	 * 设置：系统名称,用于显示B端页面上的名称
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * 获取：系统名称,用于显示B端页面上的名称
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 设置：所在国家,预设”CHINA“
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 获取：所在国家,预设”CHINA“
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置：所在省份,从t_province中去look-up
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获取：所在省份,从t_province中去look-up
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置：所在城市,从t_city中去look-up
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取：所在城市,从t_city中去look-up
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置：所在区县,从t_district中去look-up
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * 获取：所在区县,从t_district中去look-up
	 */
	public String getDistrict() {
		return district;
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
	 * 设置：状态, 0：可用 1：不可用
	 * 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态, 0：可用 1：不可用
	 * 
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置： 机构电话
	 */
	public void setClinicTel(String clinicTel) {
		this.clinicTel = clinicTel;
	}

	/**
	 * 获取： 机构电话
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
	 * 设置：父机构ID,如果本身是父机构，则不填写
	 */
	public void setClinicParentId(String clinicParentId) {
		this.clinicParentId = clinicParentId;
	}

	/**
	 * 获取：父机构ID,如果本身是父机构，则不填写
	 */
	public String getClinicParentId() {
		return clinicParentId;
	}

	/**
	 * 设置：能量币,初始是0
	 */
	public void setEnergyMoney(Integer energyMoney) {
		this.energyMoney = energyMoney;
	}

	/**
	 * 获取：能量币,初始是0
	 */
	public Integer getEnergyMoney() {
		return energyMoney;
	}

	/**
	 * 设置：超级管理员ID，来自于后台管理系统的工作人员ID
	 */
	public void setSuperAdminId(String superAdminId) {
		this.superAdminId = superAdminId;
	}

	/**
	 * 获取：超级管理员ID，来自于后台管理系统的工作人员ID
	 */
	public String getSuperAdminId() {
		return superAdminId;
	}

	/**
	 * 设置：修改人ID,来自于后台管理系统的工作人员ID
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	/**
	 * 获取：修改人ID,来自于后台管理系统的工作人员ID
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
	 * 设置：来自于后台管理系统的工作人员ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 获取：来自于后台管理系统的工作人员ID
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

	/**
	 * 设置：预设值
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 获取：预设值
	 */
	public Integer getVersion() {
		return version;
	}
}
