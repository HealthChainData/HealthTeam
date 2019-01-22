package com.ht.activiti.domain;

import java.util.Date;

public class RequestDO {
	 /** 主键ID */
	 private String id;
	 /** 请求名称 */
	 private String requestName; 
	 /** 请求类型 */
	 private String requestType;
	 /** 请求描述 */
	 private String requestDesc; 
	 /** 相关截图 */
	 private String requestPic; 
	 /** 请求来源 */
	 private String requestSrc;
	 /** 创建者ID */
	 private String createUserId;
	 /** 创建者姓名 */
	 private String createUserName;
	 /** 创建时间 */
	 private Date createTime;  
	 /** 期待完成时间 */
	 private Date expectTime; 
	 /** 责任人ID */
	 private String ownerId; 
	 /** 请求进度 */
	 private String requestProgress; 
	 /** 请求状态 */
	 private String requestStatus; 
	 /** 更新者Id */
	 private String updateUserId;
	 /** 更新时间 */
	 private Date updateTime;  				
	 
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestDesc() {
		return requestDesc;
	}
	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}
	public String getRequestPic() {
		return requestPic;
	}
	public void setRequestPic(String requestPic) {
		this.requestPic = requestPic;
	}
	public String getRequestSrc() {
		return requestSrc;
	}
	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpectTime() {
		return expectTime;
	}
	public void setExpectTime(Date expectTime) {
		this.expectTime = expectTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getRequestProgress() {
		return requestProgress;
	}
	public void setRequestProgress(String requestProgress) {
		this.requestProgress = requestProgress;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	 
}