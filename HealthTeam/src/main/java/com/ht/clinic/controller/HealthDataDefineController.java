package com.ht.clinic.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ht.clinic.domain.HealthCodeDefineDO;
import com.ht.clinic.service.HealthCodeDefineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.clinic.domain.ClinicDO;
import com.ht.clinic.domain.HealthDataDefineDO;
import com.ht.clinic.service.HealthDataDefineService;
import com.ht.common.controller.BaseController;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 11:26:55
 */
 
@Controller
@RequestMapping("/healthDataDefine")
public class HealthDataDefineController extends BaseController{
	@Autowired
	private HealthDataDefineService healthDataDefineService;

	@Autowired
	private HealthCodeDefineService healthCodeDefineService;
	
	@GetMapping()
	String HealthDataDefine(){
	    return "clinic/healthDataDefine/healthDataDefine";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<HealthDataDefineDO> healthDataDefineList = healthDataDefineService.list(query);
		int total = healthDataDefineService.count(query);
		PageUtils pageUtils = new PageUtils(healthDataDefineList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/codeList")
	public PageUtils codeList(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<HealthCodeDefineDO> healthCodeDefineList = healthCodeDefineService.list(query);
		int total = healthCodeDefineService.count(query);
		PageUtils pageUtils = new PageUtils(healthCodeDefineList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "clinic/healthDataDefine/add";
	}

	@GetMapping("/addCode")
	String addCode(){
		return "clinic/healthDataDefine/addCode";
	}

	@GetMapping("/codeDefine")
	String codeDefine(){
		return "clinic/healthDataDefine/codeDefine";
	}

	@GetMapping("/edit/{defineId}")
	String edit(@PathVariable("defineId") Integer defineId,Model model){
		HealthDataDefineDO healthDataDefine = healthDataDefineService.get(defineId);
		if(healthDataDefine.getFieldType().equals("C")) {
			healthDataDefine.setFieldType("字符");
		}else if(healthDataDefine.getFieldType().equals("N")) {
			healthDataDefine.setFieldType("数字");
		}else if(healthDataDefine.getFieldType().equals("D")) {
			healthDataDefine.setFieldType("日期");
		}else if(healthDataDefine.getFieldType().equals("T")) {
			healthDataDefine.setFieldType("时间");
		}
		String flag = "启用";
		if(healthDataDefine.getFlag().equals(0)) {
			flag = "禁用";
		}
		if(healthDataDefine.getDataType().equals("1")) {
			healthDataDefine.setDataType("系统配置");
		}else if(healthDataDefine.getDataType().equals("2")) {
			healthDataDefine.setDataType("健康数据配置");
		}
		model.addAttribute("flag", flag);
		model.addAttribute("healthDataDefine", healthDataDefine);
	    return "clinic/healthDataDefine/details";
	}
	
	@GetMapping("/update/{defineId}")
	String update(@PathVariable("defineId") Integer defineId,Model model){
		HealthDataDefineDO healthDataDefine = healthDataDefineService.get(defineId);
		model.addAttribute("healthDataDefine", healthDataDefine);
	    return "clinic/healthDataDefine/edit";
	}
	
	/**
	 * 禁用
	 */
	@PostMapping("/ban")
	@ResponseBody
	public R ban(Integer defineId) {
		HealthDataDefineDO healthDataDefine = new HealthDataDefineDO();
		healthDataDefine.setDefineId(defineId);
		healthDataDefine.setFlag(0);
		if (healthDataDefineService.update(healthDataDefine) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 启用
	 */
	@PostMapping("/start")
	@ResponseBody
	public R start(Integer defineId) {
		HealthDataDefineDO healthDataDefine = new HealthDataDefineDO();
		healthDataDefine.setDefineId(defineId);
		healthDataDefine.setFlag(1);
		if (healthDataDefineService.update(healthDataDefine) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( HealthDataDefineDO healthDataDefine){
		healthDataDefine.setCreateUserId(getUserId().toString());
		healthDataDefine.setCreateTime(new Date());
		if(healthDataDefineService.save(healthDataDefine)>0){
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/saveCode")
	public R saveCode( HealthCodeDefineDO healthCodeDefine){
		healthCodeDefine.setCreateUserId(getUserId().toString());
		healthCodeDefine.setCreateTime(new Date());
		if(healthCodeDefineService.save(healthCodeDefine)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( HealthDataDefineDO healthDataDefine){
		healthDataDefine.setModifyUserId(getUserId().toString());
		healthDataDefine.setModifyTime(new Date());
		if(healthDataDefineService.update(healthDataDefine)>0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer defineId){
		if(healthDataDefineService.remove(defineId)>0){
		return R.ok();
		}
		return R.error();
	}

	@PostMapping( "/removeCode")
	@ResponseBody
	public R removeCode( Long id){
		if(healthCodeDefineService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] defineIds){
		healthDataDefineService.batchRemove(defineIds);
		return R.ok();
	}

	@PostMapping( "/batchRemoveCode")
	@ResponseBody
	public R removeCode(@RequestParam("ids[]") Long[] defineIds){
		healthCodeDefineService.batchRemove(defineIds);
		return R.ok();
	}

	@GetMapping("/editCode/{id}")
	String editCode(@PathVariable("id") Integer id,Model model){
		HealthCodeDefineDO healthCodeDefine = healthCodeDefineService.get(id);
		model.addAttribute("healthCodeDefine", healthCodeDefine);
		return "clinic/healthDataDefine/editCode";
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updateCode")
	public R updateCode( HealthCodeDefineDO healthCodeDefine){
		healthCodeDefine.setModifyUserId(getUserId().toString());
		healthCodeDefine.setModifyTime(new Date());
		if(healthCodeDefineService.update(healthCodeDefine)>0) {
			return R.ok();
		}
		return R.error();
	}
	
}
