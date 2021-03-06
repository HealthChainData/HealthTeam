package com.ht.activiti.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestStepDO {
	/** 主键ID */
	private Integer id;
	/** 对应请求id */
	private String requestId;
	/** 步骤名称 */
	private String stepName;
	/** 步骤描述 */
	private String stepDesc;
	/** 状态推进 */
	private String progressAdd;
	/** 原责任人ID */
	private String beforeOwnerId;
	/** 现责任人ID */
	private String afterOwnerId;
	/** 处理时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recoTime;
	/** 处理人ID */
	private String recoUserId;

	/** 原责任人姓名 */
	private String beforeOwnerName;
	/** 现责任人姓名 */
	private String afterOwnerName;
	/** 处理人姓名 */
	private String recoUserName;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepDesc() {
		return stepDesc;
	}

	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}

	public String getProgressAdd() {
		return progressAdd;
	}

	public void setProgressAdd(String progressAdd) {
		this.progressAdd = progressAdd;
	}

	public String getBeforeOwnerId() {
		return beforeOwnerId;
	}

	public void setBeforeOwnerId(String beforeOwnerId) {
		this.beforeOwnerId = beforeOwnerId;
	}

	public String getAfterOwnerId() {
		return afterOwnerId;
	}

	public void setAfterOwnerId(String afterOwnerId) {
		this.afterOwnerId = afterOwnerId;
	}

	public Date getRecoTime() {
		return recoTime;
	}

	public void setRecoTime(Date recoTime) {
		this.recoTime = recoTime;
	}

	public String getRecoUserId() {
		return recoUserId;
	}

	public void setRecoUserId(String recoUserId) {
		this.recoUserId = recoUserId;
	}

}
