package com.ht.clinic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ht.clinic.service.CommonService;

@Component
public class InitializationData {

	@Autowired
	private CommonService commonService;

	public static InitializationData initializationData;

	@PostConstruct
	public void init() {
		initializationData = this;
	}

	protected void InitializationSQL(String clinicIndex) {
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		/**
		 * 新建用户
		 */
		// 系统管理员
		addUser(clinicIndex, "1", "0", "2", "", "系统管理员", "systemAdmin", "123456", null, null, dateStr, null, null, null,
				null, "0", "2", dateStr, "2", dateStr, null, "1");
		// 超级管理员
		addUser(clinicIndex, "2", "0", "1", "", "超级管理员", "admin", "123456", null, null, dateStr, null, null, null, null,
				"0", "2", dateStr, "2", dateStr, null, "1");

		/**
		 * 新建角色
		 */
		// 系统管理员
		addRole(clinicIndex, "1", "系统管理员", "", "2", dateStr, "2", dateStr, "1");
		// 超级管理员
		addRole(clinicIndex, "2", "超级管理员", "", "2", dateStr, "2", dateStr, "1");

		/**
		 * 新建流程
		 */
		// 系统管理员流程
		addFlow(clinicIndex, "1001", "人员管理", "0", "1", "2", dateStr, "2", dateStr, "1");
		// 超级管理员流程
		addFlow(clinicIndex, "1002", "基础管理", "0", "1", "2", dateStr, "2", dateStr, "1");
		addFlow(clinicIndex, "1003", "流程管理", "0", "2", "2", dateStr, "2", dateStr, "1");
		// 系统管理员流程
		addFlow(clinicIndex, "1004", "患者管理", "0", "2", "2", dateStr, "2", dateStr, "1");

		/**
		 * 关联流程角色关系
		 */
		// 系统管理员关联
		addFlowRole(clinicIndex, "1001", "2", "1");
		// 超级管理员关联
		addFlowRole(clinicIndex, "1002", "1", "1");
		addFlowRole(clinicIndex, "1003", "1", "1");
		// 系统管理员关联
		addFlowRole(clinicIndex, "1004", "2", "1");

		/**
		 * 新建流程节点
		 */
		// 基础设置节点
		addFlowPoint(clinicIndex, "1002", "10201", "1", "角色管理", "B", null, null, "1", "1", "2", dateStr, "2", dateStr,
				"1");
		addFlowPoint(clinicIndex, "1002", "10202", "2", "部门管理", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");
		// 流程管理节点
		addFlowPoint(clinicIndex, "1003", "10301", "1", "流程设定", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");
		addFlowPoint(clinicIndex, "1003", "10302", "2", "流程点设定", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");
		addFlowPoint(clinicIndex, "1003", "10303", "3", "服务点设定", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");
		// 人员管理节点
		addFlowPoint(clinicIndex, "1001", "10101", "1", "人员管理", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");
		// 患者管理节点
		addFlowPoint(clinicIndex, "1004", "10401", "1", "患者管理", "B", null, null, "1", "0", "2", dateStr, "2", dateStr,
				"1");

		/**
		 * 新建流程节点权限
		 */
		// 角色管理权限
		addFlowPointRole(clinicIndex, "1002", "10201", "1", "1");
		// 部门管理权限
		addFlowPointRole(clinicIndex, "1002", "10202", "1", "1");
		// 流程设定
		addFlowPointRole(clinicIndex, "1003", "10301", "1", "1");
		// 流程点设定
		addFlowPointRole(clinicIndex, "1003", "10302", "1", "1");
		// 服务点设定
		addFlowPointRole(clinicIndex, "1003", "10303", "1", "1");
		// 人员管理权限
		addFlowPointRole(clinicIndex, "1001", "10101", "2", "1");
		// 患者管理权限
		addFlowPointRole(clinicIndex, "1004", "10401", "2", "1");

		/**
		 * 新建服务点
		 */
		// 新建流程设定服务点
		addServicePoint(clinicIndex, "1003", "10301", "10314", "新增", "4", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");
		addServicePoint(clinicIndex, "1003", "10301", "10311", "查看", "1", "", "查看", "1", "1", "0", "2", dateStr, "2",
				dateStr, "1", "1");
		addServicePoint(clinicIndex, "1003", "10301", "10312", "编辑", "2", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1003", "10301", "10313", "启/禁用", "3", "", "启/禁用", "1", "1", "0", "2", dateStr,
				"2", dateStr, "8", "1");
		addServicePoint(clinicIndex, "1003", "10304", "2", "", "3", "", "", "1", "1", "0", "2", dateStr, "2", dateStr,
				"4", "1");

		// 新建流程设定服务点
		addServicePoint(clinicIndex, "1003", "10302", "10321", "查看", "1", "", "查看", "1", "1", "0", "2", dateStr, "2",
				dateStr, "1", "1");
		addServicePoint(clinicIndex, "1003", "10302", "10322", "编辑", "2", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1003", "10302", "10323", "启/禁用", "3", "", "启/禁用", "1", "1", "0", "2", dateStr,
				"2", dateStr, "8", "1");
		addServicePoint(clinicIndex, "1003", "10302", "10324", "新增", "4", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");

		// 新建服务点设定服务点
		addServicePoint(clinicIndex, "1003", "10303", "10331", "查看", "1", "", "查看", "1", "1", "0", "2", dateStr, "2",
				dateStr, "1", "1");
		addServicePoint(clinicIndex, "1003", "10303", "10332", "编辑", "2", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1003", "10303", "10333", "启/禁用", "3", "", "启/禁用", "1", "1", "0", "2", dateStr,
				"2", dateStr, "8", "1");
		addServicePoint(clinicIndex, "1003", "10303", "10334", "新增", "4", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");

		//
		addServicePoint(clinicIndex, "1003", "10304", "2", "", "3", "1", "", "1", "1", "0", "2", dateStr, "2", dateStr,
				"2", "1");
		addServicePoint(clinicIndex, "1003", "10305", "2", "子表单", "3", "1", "子表单", "1", "0", "1", "2", dateStr, "2",
				dateStr, "2", "1");

		// 角色管理服务点
		addServicePoint(clinicIndex, "1002", "10201", "10211", "编辑", "1", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1002", "10201", "10212", "删除", "2", "", "删除", "1", "1", "0", "2", dateStr, "2",
				dateStr, "4", "1");
		addServicePoint(clinicIndex, "1002", "10201", "10213", "新增", "3", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");
		// 部门管理服务点
		addServicePoint(clinicIndex, "1002", "10202", "10221", "编辑", "1", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1002", "10202", "10222", "删除", "2", "", "删除", "1", "1", "0", "2", dateStr, "2",
				dateStr, "4", "1");
		addServicePoint(clinicIndex, "1002", "10202", "10223", "新增", "3", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");

		// 人员管理服务点
		addServicePoint(clinicIndex, "1001", "10101", "10111", "查看", "1", "", "查看", "1", "1", "0", "2", dateStr, "2",
				dateStr, "1", "1");
		addServicePoint(clinicIndex, "1001", "10101", "10112", "编辑", "2", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1001", "10101", "10113", "启/禁用", "3", "", "启/禁用", "1", "1", "0", "2", dateStr,
				"2", dateStr, "8", "1");
		addServicePoint(clinicIndex, "1001", "10101", "10114", "重置密码", "4", "", "重置密码", "1", "1", "0", "2", dateStr,
				"2", dateStr, "7", "1");
		addServicePoint(clinicIndex, "1001", "10101", "10115", "新增", "5", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");

		// 患者管理服务点
		addServicePoint(clinicIndex, "1004", "10401", "10411", "查看", "1", "", "查看", "1", "1", "0", "2", dateStr, "2",
				dateStr, "1", "1");
		addServicePoint(clinicIndex, "1004", "10401", "10412", "编辑", "2", "", "编辑", "1", "1", "0", "2", dateStr, "2",
				dateStr, "3", "1");
		addServicePoint(clinicIndex, "1004", "10401", "10413", "启/禁用", "3", "", "启/禁用", "1", "1", "0", "2", dateStr,
				"2", dateStr, "8", "1");
		addServicePoint(clinicIndex, "1004", "10401", "10415", "新增", "5", "", "新增", "1", "1", "0", "2", dateStr, "2",
				dateStr, "2", "1");

		/**
		 * 流程点字段配置
		 */
		// 流程设定字段配置
		addFlowPointFields(clinicIndex, "1003", "10301", "0", "id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "1", "flow_no", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "2", "flow_name", "1", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "3", "flag", "1", "0", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "4", "flow_seq", "0", "0", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "5", "modify_time", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10301", "6", "create_time", "0", "1", "1");

		// 流程设定点字段配置
		addFlowPointFields(clinicIndex, "1003", "10302", "0", "id", "0", "0", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "1", "flow_point_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "2", "flow_point_name", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "3", "flow_point_seq", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "4", "flag", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "5", "flow_point_type", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10302", "6", "flow_no", "1", "0", "1");

		// 服务点设定字段配置
		addFlowPointFields(clinicIndex, "1003", "10303", "1", "service_point_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "2", "service_point_name", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "3", "service_point_seq", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "4", "service_point_tips", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "5", "flag", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "0", "id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "6", "flow_no", "1", "0", "1");
		addFlowPointFields(clinicIndex, "1003", "10303", "7", "flow_point_id", "1", "0", "1");
		// 角色管理字段配置
		addFlowPointFields(clinicIndex, "1002", "10201", "1", "role_id", "0", "0", "1");
		addFlowPointFields(clinicIndex, "1002", "10201", "2", "role_index", "0", "0", "1");
		addFlowPointFields(clinicIndex, "1002", "10201", "3", "role_name", "1", "0", "1");
		addFlowPointFields(clinicIndex, "1002", "10201", "4", "note", "0", "0", "0");
		addFlowPointFields(clinicIndex, "1002", "10201", "5", "modify_time", "0", "1", "1");

		// 部门管理字段配置
		addFlowPointFields(clinicIndex, "1002", "10202", "1", "department_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1002", "10202", "2", "department_index", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1002", "10202", "2", "department_parent_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1002", "10202", "3", "department_name", "1", "1", "1");
		addFlowPointFields(clinicIndex, "1002", "10202", "4", "sort", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1002", "10202", "5", "status", "0", "1", "1");

		// 人员管理字段配置
		addFlowPointFields(clinicIndex, "1001", "10101", "0", "personnel_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1001", "10101", "1", "department_index", "1", "0", "1");
		addFlowPointFields(clinicIndex, "1001", "10101", "2", "personnel_name", "1", "1", "1");
		addFlowPointFields(clinicIndex, "1001", "10101", "3", "login_name", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1001", "10101", "4", "email", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1001", "10101", "5", "status", "0", "1", "1");

		// 患者管理字段配置
		addFlowPointFields(clinicIndex, "1004", "10401", "0", "user_id", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1004", "10401", "1", "user_name", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1004", "10401", "2", "user_mobile", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1004", "10401", "3", "user_address", "0", "1", "1");
		addFlowPointFields(clinicIndex, "1004", "10401", "4", "status", "0", "1", "1");

		/**
		 * 服务点字段配置
		 */
		// 流程设定服务点字段---新增
		addServiceFields(clinicIndex, "1003", "10301", "10314", "1", "flow_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10314", "2", "role_index", "0", "0", "0", "CB", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10314", "3", "flow_seq", "0", "0", "0", "", "1");

		// 流程设定服务点字段---查看
		addServiceFields(clinicIndex, "1003", "10301", "10311", "1", "clinic_index", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "2", "flow_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "3", "flow_no", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "4", "flag", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "4", "flow_seq", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "5", "modify_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "6", "modify_time", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "7", "create_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "8", "create_time", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10311", "8", "role_index", "1", "1", "0", "LL", "1");
		// 流程设定服务点字段---编辑
		addServiceFields(clinicIndex, "1003", "10301", "10312", "1", "flow_no", "1", "0", "1", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10312", "2", "flow_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10312", "3", "role_index", "0", "0", "0", "CB", "1");
		addServiceFields(clinicIndex, "1003", "10301", "10312", "4", "flow_seq", "0", "0", "0", "", "1");

		// 流程点设定服务点字段---新增
		addServiceFields(clinicIndex, "1003", "10302", "10324", "1", "flow_no", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "2", "flow_point_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "3", "flow_point_type", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "3", "flow_point_seq", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "4", "role_index", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "5", "interface_type", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "6", "interface_index", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "7", "is_flow_finish", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10324", "8", "flag", "0", "0", "0", "", "1");
		// 流程点设定服务点字段---查看
		addServiceFields(clinicIndex, "1003", "10302", "10321", "1", "clinic_index", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "2", "flow_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "3", "flow_no", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "4", "flow_point_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "5", "flow_point_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "6", "flow_point_seq", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "7", "flow_point_type", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "8", "is_flow_finish", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "9", "flag", "1", "0", "1", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "10", "modify_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "11", "modify_time", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "12", "create_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10321", "13", "create_time", "1", "1", "0", "LL", "1");
		// 流程点设定服务点字段---编辑
		addServiceFields(clinicIndex, "1003", "10302", "10322", "1", "flow_no", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "2", "flow_point_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "2", "flow_point_id", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "3", "flow_point_seq", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "3", "role_index", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "4", "flow_point_type", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "5", "interface_type", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "6", "interface_index", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10302", "10322", "7", "is_flow_finish", "0", "0", "0", "", "1");
		// 流程服务点服务字段---新增
		addServiceFields(clinicIndex, "1003", "10303", "10334", "1", "flow_no", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "2", "flow_point_id", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "3", "service_point_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "4", "service_point_tips", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "5", "service_point_seq", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "6", "enter_condition", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "7", "is_service_finish", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "8", "is_reject", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "9", "flag", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10334", "10", "service_point_type", "0", "0", "0", "", "1");
		// 流程服务点服务字段---查看
		addServiceFields(clinicIndex, "1003", "10303", "10331", "1", "id", "1", "1", "0", "LL", "0");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "1", "clinic_index", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "2", "flow_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "3", "flow_no", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "4", "flow_point_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "5", "service_point_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "6", "service_point_type", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "6", "service_point_name", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "7", "service_point_seq", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "8", "enter_condition", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "9", "service_point_tips", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "10", "is_service_finish", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "11", "is_reject", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "12", "flag", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "13", "service_point_type", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "14", "modify_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "15", "modify_time", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "16", "create_user_id", "1", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10331", "17", "create_time", "1", "1", "0", "LL", "1");
		// 流程服务点服务字段---编辑
		addServiceFields(clinicIndex, "1003", "10303", "10332", "1", "service_point_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "1", "flow_no", "0", "0", "1", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "2", "flow_point_id", "0", "0", "1", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "2", "service_point_tips", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "3", "service_point_seq", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "4", "enter_condition", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "5", "is_service_finish", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "6", "is_reject", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "7", "flag", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "8", "service_point_id", "0", "0", "1", "", "1");
		addServiceFields(clinicIndex, "1003", "10303", "10332", "8", "service_point_type", "0", "0", "1", "", "1");
		//
		addServiceFields(clinicIndex, "1003", "10304", "2", "1", "field_name", "0", "0", "0", "", "0");
		addServiceFields(clinicIndex, "1003", "10304", "2", "2", "is_search_field", "0", "0", "0", "", "0");
		addServiceFields(clinicIndex, "1003", "10304", "2", "3", "is_show", "0", "0", "0", "", "0");
		addServiceFields(clinicIndex, "1003", "10304", "2", "4", "seq", "0", "0", "0", "", "0");

		// 角色管理服务字段---新增
		addServiceFields(clinicIndex, "1002", "10201", "10213", "1", "role_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10201", "10213", "2", "note", "0", "1", "0", "", "1");
		// 角色管理服务字段---编辑
		addServiceFields(clinicIndex, "1002", "10201", "10211", "1", "role_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10201", "10211", "2", "note", "0", "1", "0", "", "1");
		// 部门管理服务字段---新增
		addServiceFields(clinicIndex, "1002", "10202", "10223", "1", "department_parent_id", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10223", "2", "department_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10223", "3", "sort", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10223", "4", "status", "0", "0", "1", "", "1");
		// 部门管理服务字段---编辑
		addServiceFields(clinicIndex, "1002", "10202", "10221", "0", "department_id", "1", "0", "1", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10221", "1", "department_index", "0", "0", "1", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10221", "1", "department_parent_id", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10221", "2", "department_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10221", "3", "sort", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1002", "10202", "10221", "4", "status", "0", "0", "0", "", "1");
		//  人员管理服务字段---新增
		addServiceFields(clinicIndex, "1001", "10101", "10115", "1", "personnel_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "2", "birth_date", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "3", "gender", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "4", "education_background_id", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "5", "graduation_school", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "6", "work_year", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "7", "login_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "9", "department_index", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "10", "email", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "11", "role_index", "0", "0", "0", "SB", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "12", "personnel_mobile", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "13", "superior_index", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10115", "14", "status", "0", "0", "0", "", "1");
		// 人员管理服务字段---查看
		addServiceFields(clinicIndex, "1001", "10101", "10111", "1", "id", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "1", "personnel_name", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "2", "birth_date", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "3", "gender", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "4", "education_background_id", "0", "1", "0", "LL",
				"1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "5", "graduation_school", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "6", "work_year", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "7", "login_name", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "8", "login_passwd", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "9", "department_index", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "10", "email", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "11", "role_index", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "12", "personnel_mobile", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "13", "superior_index", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10111", "14", "status", "0", "1", "0", "LL", "1");
		// 人员管理服务字段---编辑
		addServiceFields(clinicIndex, "1001", "10101", "10112", "1", "personnel_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "2", "birth_date", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "3", "gender", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "4", "education_background_id", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "5", "graduation_school", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "6", "work_year", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "7", "login_name", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "9", "department_index", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "10", "email", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "11", "role_index", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "12", "personnel_mobile", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "13", "superior_index", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10112", "14", "status", "0", "0", "0", "", "1");
		// 人员管理服务字段---密码重置
		addServiceFields(clinicIndex, "1001", "10101", "10114", "1", "login_passwd", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1001", "10101", "10114", "2", "repeat_passwd", "0", "0", "0", "", "1");
		// 用户管理服务字段---新增
		addServiceFields(clinicIndex, "1004", "10401", "10415", "1", "user_login", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "2", "user_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "3", "user_gender", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "4", "user_mobile", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "5", "user_id_type", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "6", "user_id_num", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "7", "user_country", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "8", "user_province", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "9", "user_city", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "10", "user_district", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "11", "user_address", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "12", "status", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10415", "13", "personnel_index", "0", "1", "0", "", "1");
		// 用户管理服务字段---查看
		addServiceFields(clinicIndex, "1004", "10401", "10411", "1", "user_login", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "2", "user_name", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "3", "user_gender", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "4", "user_mobile", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "5", "user_id_type", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "6", "user_id_num", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "7", "user_address", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "8", "is_vip", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "9", "vip_end", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "10", "energy_money", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "11", "user_type", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "12", "user_channel", "0", "1", "0", "LL", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10411", "12", "personnel_index", "0", "1", "0", "LL", "1");
		// 用户管理服务字段---编辑
		addServiceFields(clinicIndex, "1004", "10401", "10412", "1", "user_login", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "2", "user_name", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "3", "user_gender", "1", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "4", "user_mobile", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "5", "user_id_type", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "6", "user_id_num", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "7", "user_country", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "8", "user_province", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "9", "user_city", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "10", "user_district", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "11", "user_address", "0", "1", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "12", "status", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1004", "10401", "10412", "13", "personnel_index", "1", "1", "0", "", "1");
		// 用户管理服务字段---守护人设置
		addServiceFields(clinicIndex, "1004", "10401", "10414", "1", "personnel_index", "0", "0", "0", "", "1");
		//
		addServiceFields(clinicIndex, "1003", "10305", "2", "1", "field_name", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10305", "2", "2", "read_only", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10305", "2", "3", "can_empty", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10305", "2", "4", "is_show", "0", "0", "0", "", "1");
		addServiceFields(clinicIndex, "1003", "10305", "2", "5", "seq", "0", "0", "0", "", "1");
	}

	/**
	 * 新建用户
	 */
	private void addUser(String clinic_index, String personnel_index, String department_index, String role_index,
			String superior_index, String personnel_name, String login_name, String login_passwd, String email,
			String personnel_mobile, String birth_date, String gender, String education_background_id,
			String graduation_school, String work_year, String status, String modify_user_id, String modify_time,
			String create_user_id, String create_time, String note, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_personal` (`clinic_index`, `personnel_index`, `department_index`, `role_index`, `superior_index`, `personnel_name`, `login_name`, `login_passwd`, `email`, `personnel_mobile`, `birth_date`, `gender`, `education_background_id`, `graduation_school`, `work_year`, `status`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `note`,`version`) VALUES ('"
						+ clinic_index + "','" + personnel_index + "','" + department_index + "','" + role_index + "','"
						+ superior_index + "','" + personnel_name + "','" + login_name + "','" + login_passwd + "',"
						+ email + "," + personnel_mobile + ",'" + birth_date + "'," + gender + ","
						+ education_background_id + "," + graduation_school + "," + work_year + ",'" + status + "','"
						+ modify_user_id + "','" + modify_time + "','" + create_user_id + "','" + create_time + "',"
						+ note + ",'" + version + "');");
	}

	/**
	 * 新建角色
	 */
	private void addRole(String clinic_index, String role_index, String role_name, String note, String modify_user_id,
			String modify_time, String create_user_id, String create_time, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_role` (`clinic_index`, `role_index`, `role_name`, `note`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `version`) VALUES ('"
						+ clinic_index + "','" + role_index + "','" + role_name + "', '" + note + "', '"
						+ modify_user_id + "','" + modify_time + "', '" + create_user_id + "', '" + create_time + "', '"
						+ version + "');");
	}

	/**
	 * 新建流程
	 */
	private void addFlow(String clinic_index, String flow_no, String flow_name, String flag, String flow_seq,
			String modify_user_id, String modify_time, String create_user_id, String create_time, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_flow` (`clinic_index`, `flow_no`, `flow_name`, `flag`, `flow_seq`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "','" + flow_name + "', '" + flag + "', '" + flow_seq
						+ "', '" + modify_user_id + "', '" + modify_time + "', '" + create_user_id + "', '"
						+ create_time + "', '" + version + "');");
	}

	/**
	 * 关联流程角色关系
	 */
	private void addFlowRole(String clinic_index, String flow_no, String role_index, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_flow_role` (`clinic_index`, `flow_no`, `role_index`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "', '" + role_index + "', '" + version + "');");
	}

	/**
	 * 新建流程节点
	 */
	public void addFlowPoint(String clinic_index, String flow_no, String flow_point_id, String flow_point_seq,
			String flow_point_name, String flow_point_type, String interface_type, String interface_index,
			String is_flow_finish, String flag, String modify_user_id, String modify_time, String create_user_id,
			String create_time, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "', '" + flow_point_id + "', '" + flow_point_seq + "', '"
						+ flow_point_name + "', '" + flow_point_type + "'," + interface_type + ", " + interface_index
						+ ", '" + is_flow_finish + "', '" + flag + "','" + modify_user_id + "', '" + modify_time
						+ "', '" + create_user_id + "', '" + create_time + "', '" + version + "');");
	}

	/**
	 * 新建流程节点权限
	 */
	public void addFlowPointRole(String clinic_index, String flow_no, String flow_point_id, String role_index,
			String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_flow_point_role` (`clinic_index`, `flow_no`, `flow_point_id`, `role_index`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "', '" + flow_point_id + "', '" + role_index + "', '"
						+ version + "');");
	}

	/**
	 * 新建服务点
	 */
	public void addServicePoint(String clinic_index, String flow_no, String flow_point_id, String service_point_id,
			String service_point_name, String service_point_seq, String enter_condition, String service_point_tips,
			String is_service_finish, String is_reject, String flag, String modify_user_id, String modify_time,
			String create_user_id, String create_time, String service_point_type, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `service_point_type`, `version`) VALUES ('"
						+ clinic_index + "','" + flow_no + "', '" + flow_point_id + "', '" + service_point_id + "', '"
						+ service_point_name + "','" + service_point_seq + "', '" + enter_condition + "', '"
						+ service_point_tips + "', '" + is_service_finish + "', '" + is_reject + "', '" + flag + "', '"
						+ modify_user_id + "', '" + modify_time + "', '" + create_user_id + "','" + create_time + "', '"
						+ service_point_type + "', '" + version + "');");
	}

	/**
	 * 流程点字段配置
	 */
	public void addFlowPointFields(String clinic_index, String flow_no, String flow_point_id, String seq,
			String field_name, String is_search_field, String is_show, String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`, `is_show`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "', '" + flow_point_id + "', '" + seq + "', '" + field_name
						+ "', '" + is_search_field + "', '" + is_show + "', '" + version + "');");
	}

	/**
	 * 服务点字段配置
	 */
	public void addServiceFields(String clinic_index, String flow_no, String flow_point_id, String service_point_id,
			String seq, String field_name, String read_only, String can_empty, String is_show, String special_type,
			String version) {
		initializationData.commonService.executeAction(
				"INSERT INTO test.`b_service_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `seq`, `field_name`, `read_only`, `can_empty`,`is_show`,`special_type`, `version`) VALUES ('"
						+ clinic_index + "', '" + flow_no + "', '" + flow_point_id + "', '" + service_point_id + "', '"
						+ seq + "', '" + field_name + "', '" + read_only + "', '" + can_empty + "','" + is_show + "', '"
						+ special_type + "','" + version + "');");
	}

	public int randomId() {
		return (int) ((Math.random() * 9 + 1) * 10000);
	}
}
