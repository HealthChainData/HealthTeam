package com.ht.clinic.domain;
import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 11:26:55
 */
public class HealthDataDefineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字段id
	private Integer defineId;
	//字段排列顺序
	private Integer fieldSeq;
	//字段名
	private String fieldName;
	//字段分类
	private String classfyId;
	//字段描述
	private String fieldDesc;
	//字段类型,C:字符  N:数字  D:日期  T:时间 (必须填）
	private String fieldType;
	//特殊类型,疾病 症状 药品 食物
	private String specialType;
	//字段长度
	private Integer fieldLenth;
	//字段小数
	private Integer fieldDec;
	//预设值
	private String defultValue;
	//对应代码集,不为空者需从代码集中去lookup值
	private String codeType;
	//相关字段名
	private String relatedField;
	//父字段名,父字段的字段类型必须是“G"
	private String parentField;
	//启用标志,1-已启用 -1禁用
	private Integer flag;
	//修改人ID,来自于后台管理系统的工作人员ID
	private String modifyUserId;
	//修改时间
	private Date modifyTime;
	//新建人ID,来自于后台管理系统的工作人员ID
	private String createUserId;
	//新建时间
	private Date createTime;
	
	private String version;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 设置：字段id
	 */
	public void setDefineId(Integer defineId) {
		this.defineId = defineId;
	}
	/**
	 * 获取：字段id
	 */
	public Integer getDefineId() {
		return defineId;
	}
	/**
	 * 设置：字段排列顺序
	 */
	public void setFieldSeq(Integer fieldSeq) {
		this.fieldSeq = fieldSeq;
	}
	/**
	 * 获取：字段排列顺序
	 */
	public Integer getFieldSeq() {
		return fieldSeq;
	}
	/**
	 * 设置：字段名
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段名
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：字段分类
	 */
	public void setClassfyId(String classfyId) {
		this.classfyId = classfyId;
	}
	/**
	 * 获取：字段分类
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
	 * 设置：字段类型,C:字符  N:数字  D:日期  T:时间 (必须填）
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	/**
	 * 获取：字段类型,C:字符  N:数字  D:日期  T:时间 (必须填）
	 */
	public String getFieldType() {
		return fieldType;
	}
	/**
	 * 设置：特殊类型,疾病 症状 药品 食物
	 */
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	/**
	 * 获取：特殊类型,疾病 症状 药品 食物
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
	 * 设置：对应代码集,不为空者需从代码集中去lookup值
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * 获取：对应代码集,不为空者需从代码集中去lookup值
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 设置：相关字段名
	 */
	public void setRelatedField(String relatedField) {
		this.relatedField = relatedField;
	}
	/**
	 * 获取：相关字段名
	 */
	public String getRelatedField() {
		return relatedField;
	}
	/**
	 * 设置：父字段名,父字段的字段类型必须是“G"
	 */
	public void setParentField(String parentField) {
		this.parentField = parentField;
	}
	/**
	 * 获取：父字段名,父字段的字段类型必须是“G"
	 */
	public String getParentField() {
		return parentField;
	}
	/**
	 * 设置：启用标志,1-已启用 -1禁用
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：启用标志,1-已启用 -1禁用
	 */
	public Integer getFlag() {
		return flag;
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
	 * 设置：新建人ID,来自于后台管理系统的工作人员ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：新建人ID,来自于后台管理系统的工作人员ID
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
}
