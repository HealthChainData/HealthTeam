package com.ht.clinic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户健康字段定义表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-08 09:44:29
 */
public class HealthDataDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer defineId;
	//字段在筛选或显示时的顺序
	private Integer fieldSeq;
	//字段排列顺序(字段在筛选或显示时的顺序)
	private String fieldName;
	//
	private String classfyId;
	//字段描述
	private String fieldDesc;
	//C:字符  N:数字  D:日期  T:时间 (必须填）
	private String fieldType;
	//疾病 症状 药品 食物
	private String specialType;
	//字段长度
	private Integer fieldLenth;
	//字段小数
	private Integer fieldDec;
	//预设值
	private String defultValue;
	//对应代码集 不为空者需从代码集中去lookup值
	private String codeType;
	//关联字段
	private String relatedField;
	//父字段的字段类型必须是“G"
	private String parentField;
	//1-已启用 -1禁用
	private Integer flag;
	//来自于后台管理系统的工作人员ID
	private String modifyUserId;
	//是否显示字段 0-否 1-是
	private Date modifyTime;
	//来自于后台管理系统的工作人员ID
	private String createUserId;
	//
	private Date createTime;
	//数据类型,1：系统配置 2：健康数据配置
	private String dataType;
	//
	private Integer version;

	/**
	 * 设置：
	 */
	public void setDefineId(Integer defineId) {
		this.defineId = defineId;
	}
	/**
	 * 获取：
	 */
	public Integer getDefineId() {
		return defineId;
	}
	/**
	 * 设置：字段在筛选或显示时的顺序
	 */
	public void setFieldSeq(Integer fieldSeq) {
		this.fieldSeq = fieldSeq;
	}
	/**
	 * 获取：字段在筛选或显示时的顺序
	 */
	public Integer getFieldSeq() {
		return fieldSeq;
	}
	/**
	 * 设置：字段排列顺序(字段在筛选或显示时的顺序)
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段排列顺序(字段在筛选或显示时的顺序)
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：
	 */
	public void setClassfyId(String classfyId) {
		this.classfyId = classfyId;
	}
	/**
	 * 获取：
	 */
	public String getClassfyId() {
		return classfyId;
	}
	/**
	 * 设置：字段描述
	 */
	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}
	/**
	 * 获取：字段描述
	 */
	public String getFieldDesc() {
		return fieldDesc;
	}
	/**
	 * 设置：C:字符  N:数字  D:日期  T:时间 (必须填）
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	/**
	 * 获取：C:字符  N:数字  D:日期  T:时间 (必须填）
	 */
	public String getFieldType() {
		return fieldType;
	}
	/**
	 * 设置：疾病 症状 药品 食物
	 */
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	/**
	 * 获取：疾病 症状 药品 食物
	 */
	public String getSpecialType() {
		return specialType;
	}
	/**
	 * 设置：字段长度
	 */
	public void setFieldLenth(Integer fieldLenth) {
		this.fieldLenth = fieldLenth;
	}
	/**
	 * 获取：字段长度
	 */
	public Integer getFieldLenth() {
		return fieldLenth;
	}
	/**
	 * 设置：字段小数
	 */
	public void setFieldDec(Integer fieldDec) {
		this.fieldDec = fieldDec;
	}
	/**
	 * 获取：字段小数
	 */
	public Integer getFieldDec() {
		return fieldDec;
	}
	/**
	 * 设置：预设值
	 */
	public void setDefultValue(String defultValue) {
		this.defultValue = defultValue;
	}
	/**
	 * 获取：预设值
	 */
	public String getDefultValue() {
		return defultValue;
	}
	/**
	 * 设置：对应代码集 不为空者需从代码集中去lookup值
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * 获取：对应代码集 不为空者需从代码集中去lookup值
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 设置：关联字段
	 */
	public void setRelatedField(String relatedField) {
		this.relatedField = relatedField;
	}
	/**
	 * 获取：关联字段
	 */
	public String getRelatedField() {
		return relatedField;
	}
	/**
	 * 设置：父字段的字段类型必须是“G"
	 */
	public void setParentField(String parentField) {
		this.parentField = parentField;
	}
	/**
	 * 获取：父字段的字段类型必须是“G"
	 */
	public String getParentField() {
		return parentField;
	}
	/**
	 * 设置：1-已启用 -1禁用
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：1-已启用 -1禁用
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
	 * 设置：数据类型,1：系统配置 2：健康数据配置
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：数据类型,1：系统配置 2：健康数据配置
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}
