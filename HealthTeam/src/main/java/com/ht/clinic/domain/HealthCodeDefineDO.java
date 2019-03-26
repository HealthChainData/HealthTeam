package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 申请字典代码表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-22 14:22:33
 */
public class HealthCodeDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//代码类型
	private String codeType;
	//代码代号
	private String codeNo;
	//父代码代号
	private String parentCodeNo;
	//代码值
	private String codeVal;
	//
	private String css;
	//启用标志 0-系统 1-已启用 -1禁用
	private Integer flag;
	//来自于后台管理系统的工作人员ID
	private String modifyUserId;
	//是否显示字段 0-否 1-是
	private Date modifyTime;
	//来自于后台管理系统的工作人员ID
	private String createUserId;
	//
	private Date createTime;
	//版本
	private Integer version;

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
	 * 设置：代码类型
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * 获取：代码类型
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 设置：代码代号
	 */
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	/**
	 * 获取：代码代号
	 */
	public String getCodeNo() {
		return codeNo;
	}
	/**
	 * 设置：父代码代号
	 */
	public void setParentCodeNo(String parentCodeNo) {
		this.parentCodeNo = parentCodeNo;
	}
	/**
	 * 获取：父代码代号
	 */
	public String getParentCodeNo() {
		return parentCodeNo;
	}
	/**
	 * 设置：代码值
	 */
	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}
	/**
	 * 获取：代码值
	 */
	public String getCodeVal() {
		return codeVal;
	}
	/**
	 * 设置：
	 */
	public void setCss(String css) {
		this.css = css;
	}
	/**
	 * 获取：
	 */
	public String getCss() {
		return css;
	}
	/**
	 * 设置：启用标志 0-系统 1-已启用 -1禁用
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：启用标志 0-系统 1-已启用 -1禁用
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * 设置：来自于后台管理系统的工作人员ID
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	/**
	 * 获取：来自于后台管理系统的工作人员ID
	 */
	public String getModifyUserId() {
		return modifyUserId;
	}
	/**
	 * 设置：是否显示字段 0-否 1-是
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：是否显示字段 0-否 1-是
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
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	public Integer getVersion() {
		return version;
	}
}
