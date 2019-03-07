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

		// *******************新建用户
		// 系统管理员
		int personnelId = randomId();
		initializationData.commonService.executeAction(
				"INSERT INTO `b_personal` (`personnel_id`, `clinic_index`, `personnel_index`, `department_index`, `role_index`, `superior_index`, `personnel_name`, `login_name`, `login_passwd`, `email`, `personnel_mobile`, `birth_date`, `gender`, `education_background_id`, `graduation_school`, `work_year`, `status`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `note`) VALUES ('"
						+ personnelId + "', '" + clinicIndex + "', '" + personnelId
						+ "', '1', '2', '0', '系统管理员', 'systemAdmin', '123456', '', '', NULL, '', '', '', NULL, '1', '', '"
						+ dateStr + "', '', '" + dateStr + "', NULL);");
		// 超级管理员
		personnelId = randomId();
		initializationData.commonService.executeAction(
				"INSERT INTO `b_personal` (`personnel_id`, `clinic_index`, `personnel_index`, `department_index`, `role_index`, `superior_index`, `personnel_name`, `login_name`, `login_passwd`, `email`, `personnel_mobile`, `birth_date`, `gender`, `education_background_id`, `graduation_school`, `work_year`, `status`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`, `note`) VALUES ('"
						+ personnelId + "', '" + clinicIndex + "', '" + personnelId
						+ "', '2', '1', '0', '系统管理员', 'admin', '123456', '', '', NULL, '', '', '', NULL, '1', '', '"
						+ dateStr + "', '', '" + dateStr + "', NULL);");

		// *******************新建角色
		// 系统管理员
		initializationData.commonService.executeAction(
				"INSERT INTO `b_role` (`clinic_index`, `role_index`, `role_name`, `note`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '2', '系统管理员', NULL, '2', '" + dateStr + "', '2', '" + dateStr + "');");
		// 超级管理员
		initializationData.commonService.executeAction(
				"INSERT INTO `b_role` (`clinic_index`, `role_index`, `role_name`, `note`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1', '超级管理员', NULL, '2', '" + dateStr + "', '2', '" + dateStr + "');");

		// *******************新建流程
		// 系统管理员流程
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow` ( `clinic_index`, `flow_no`, `flow_name`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1001', '人员管理', '1', '1', '" + dateStr + "', '1', '" + dateStr + "');");
		// 超级管理员流程
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow` ( `clinic_index`, `flow_no`, `flow_name`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1002', '基础管理', '1', '1', '" + dateStr + "', '1', '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow` ( `clinic_index`, `flow_no`, `flow_name`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '流程管理', '1', '1', '" + dateStr + "', '1', '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow` ( `clinic_index`, `flow_no`, `flow_name`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1004', '用户管理', '1', '1', '" + dateStr + "', '1', '" + dateStr + "');");

		// *******************新建关联流程角色关系
		// 超级管理员关联
		initializationData.commonService
				.executeAction("INSERT INTO `b_flow_role` ( `clinic_index`, `flow_no`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1001', '2');");
		// 系统管理员关联
		initializationData.commonService
				.executeAction("INSERT INTO `b_flow_role` ( `clinic_index`, `flow_no`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1002', '1');");
		initializationData.commonService
				.executeAction("INSERT INTO `b_flow_role` ( `clinic_index`, `flow_no`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '1');");
		initializationData.commonService
				.executeAction("INSERT INTO `b_flow_role` ( `clinic_index`, `flow_no`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1004', '1');");

		// *******************新建流程节点
		// 基础设置节点
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '1', '角色管理', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '2', '部门管理', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		// 流程管理节点
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '1', '流程设定', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '2', '流程点设定', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '3', '服务点设定', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		// 人员管理节点
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '1', '人员管理', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");
		// 用户管理节点
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point` (`clinic_index`, `flow_no`, `flow_point_id`, `flow_point_seq`, `flow_point_name`, `flow_point_type`, `interface_type`, `interface_index`, `is_flow_finish`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '1', '用户管理', 'B', NULL, NULL, '1', '1', '2', '" + dateStr
						+ "', '2','" + dateStr + "');");

		// *******************新建流程节点权限
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '10304', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1003', '10305', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_role` ( `clinic_index`, `flow_no`, `flow_point_id`, `role_index`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '1');");

		// *******************新建服务点
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '1', '角色管理', '1', NULL, '角色管理','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '1', '部门管理', '1', NULL, '部门管理','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '1', '流程设定', '1', NULL, '流程设定','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '1', '流程点设定', '1', NULL, '流程点设定','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '1', '服务点设定', '1', NULL, '服务点设定','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex
						+ "', '1003', '10304', '1', '流程点字段设置', '1', NULL, '流程点字段设置','1', '1', '1', '2',  '" + dateStr
						+ "', '2',  '" + dateStr + "');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_service_point` (`clinic_index`, `flow_no`, `flow_point_id`, `service_point_id`, `service_point_name`, `service_point_seq`, `enter_condition`, `service_point_tips`, `is_service_finish`, `is_reject`, `flag`, `modify_user_id`, `modify_time`, `create_user_id`, `create_time`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '1', '用户管理', '1', NULL, '用户管理','1', '1', '1', '2',  '"
						+ dateStr + "', '2',  '" + dateStr + "');");

		// *******************流程点字段配置
		// 流程设定字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '1', 'flow_no', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '2', 'flow_name', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '3', 'flag', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '4', 'modify_time', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10301', '5', 'create_time', '0');");
		// 流程设定点字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '1', 'flow_point_id', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '2', 'flow_point_name', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '3', 'flow_point_seq', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '4', 'flag', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10302', '5', 'flow_point_type', '0');");
		// 服务点设定字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '1', 'service_point_id', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '2', 'service_point_name', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '3', 'service_point_seq', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '4', 'service_point_tips', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10303', '5', 'flag', '0');");
		// 流程点字段设定配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10304', '1', 'seq', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10304', '2', 'field_name', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10304', '3', 'is_search_field', '0');");
		// 服务点字段设定配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10305', '1', 'seq', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10305', '2', 'field_name', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10305', '3', 'read_only', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1003', '10305', '4', 'can_empty', '0');");
		// 角色管理配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '1', 'role_index', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '2', 'role_name', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10201', '3', 'note', '1');");
		// 部门管理字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '1', 'department_id', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '2', 'department_name', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '3', 'sort', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1002', '10202', '4', 'status', '0');");
		// 人员管理字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '1', 'personnel_index', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '2', 'personnel_name', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '3', 'login_name', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '4', 'email', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1001', '10101', '5', 'status', '0');");
		// 用户管理字段配置
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '1', 'user_name', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '2', 'personnel_mobile', '1');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '3', 'user_address', '0');");
		initializationData.commonService.executeAction(
				"INSERT INTO `b_flow_point_fields` (`clinic_index`, `flow_no`, `flow_point_id`, `seq`, `field_name`, `is_search_field`) VALUES ('"
						+ clinicIndex + "', '1004', '10401', '4', 'status', '0');");
	}

	public int randomId() {
		return (int) ((Math.random() * 9 + 1) * 10000);
	}
}
