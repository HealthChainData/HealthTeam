package com.ht.clinic.domain;


import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 17:19:59
 */
public class BodyPartsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//身体部位id
	private Integer bodyPartsId;
	//身体部位名称
	private String bodyPartsName;
	//父身体部位id
	private String bodyPartsParentId;

	/**
	 * 设置：身体部位id
	 */
	public void setBodyPartsId(Integer bodyPartsId) {
		this.bodyPartsId = bodyPartsId;
	}
	/**
	 * 获取：身体部位id
	 */
	public Integer getBodyPartsId() {
		return bodyPartsId;
	}
	/**
	 * 设置：身体部位名称
	 */
	public void setBodyPartsName(String bodyPartsName) {
		this.bodyPartsName = bodyPartsName;
	}
	/**
	 * 获取：身体部位名称
	 */
	public String getBodyPartsName() {
		return bodyPartsName;
	}
	/**
	 * 设置：父身体部位id
	 */
	public void setBodyPartsParentId(String bodyPartsParentId) {
		this.bodyPartsParentId = bodyPartsParentId;
	}
	/**
	 * 获取：父身体部位id
	 */
	public String getBodyPartsParentId() {
		return bodyPartsParentId;
	}
}
