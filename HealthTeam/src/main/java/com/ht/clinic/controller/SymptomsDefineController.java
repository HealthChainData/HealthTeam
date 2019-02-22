package com.ht.clinic.controller;

import java.util.List;
import java.util.Map;

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

import com.ht.clinic.domain.BodyPartsDO;
import com.ht.clinic.domain.SymptomsDefineDO;
import com.ht.clinic.service.BodyPartsService;
import com.ht.clinic.service.SymptomsDefineService;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 10:15:39
 */
 
@Controller
@RequestMapping("/symptomsDefine")
public class SymptomsDefineController {
	@Autowired
	private SymptomsDefineService symptomsDefineService;
	
	@Autowired
	private BodyPartsService bodyPartsService;
	
	@GetMapping()
	String SymptomsDefine(){
	    return "clinic/symptomsDefine/symptomsDefine";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SymptomsDefineDO> symptomsDefineList = symptomsDefineService.list(query);
		for (SymptomsDefineDO symptomsDefineDO : symptomsDefineList) {
			if(symptomsDefineDO.getBodyPartsId() != null && !symptomsDefineDO.getBodyPartsId().equals("")) {
				BodyPartsDO bodyParts = bodyPartsService.get(Integer.valueOf(symptomsDefineDO.getBodyPartsId()));
				if(bodyParts!=null) {
					symptomsDefineDO.setBodyPartsId(bodyParts.getBodyPartsName());
				}
			}
		}
		int total = symptomsDefineService.count(query);
		PageUtils pageUtils = new PageUtils(symptomsDefineList, total);
		return pageUtils;
	}
	
	
	@GetMapping("/add")
	String add(){
	    return "clinic/symptomsDefine/add";
	}

	@GetMapping("/edit/{symptomsId}")
	String edit(@PathVariable("symptomsId") Integer symptomsId,Model model){
		SymptomsDefineDO symptomsDefine = symptomsDefineService.get(symptomsId);
		if(symptomsDefine.getBodyPartsId() != null && !symptomsDefine.getBodyPartsId().equals("")) {
			BodyPartsDO bodyParts = bodyPartsService.get(Integer.valueOf(symptomsDefine.getBodyPartsId()));
			if(bodyParts!=null) {
				symptomsDefine.setBodyPartsId(bodyParts.getBodyPartsName());
			}
		}
		model.addAttribute("symptomsDefine", symptomsDefine);
	    return "clinic/symptomsDefine/details";
	}
	
	@GetMapping("/update/{symptomsId}")
	String update(@PathVariable("symptomsId") Integer symptomsId,Model model){
		SymptomsDefineDO symptomsDefine = symptomsDefineService.get(symptomsId);
		if(symptomsDefine.getBodyPartsId() != null && !symptomsDefine.getBodyPartsId().equals("")) {
			BodyPartsDO bodyParts = bodyPartsService.get(Integer.valueOf(symptomsDefine.getBodyPartsId()));
			if(bodyParts!=null) {
				symptomsDefine.setBodyPartsId(bodyParts.getBodyPartsName());
			}
		}
		model.addAttribute("symptomsDefine", symptomsDefine);
	    return "clinic/symptomsDefine/update";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( SymptomsDefineDO symptomsDefine){
		if(symptomsDefineService.save(symptomsDefine)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( SymptomsDefineDO symptomsDefine){
		symptomsDefineService.update(symptomsDefine);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer symptomsId){
		if(symptomsDefineService.remove(symptomsId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] symptomsIds){
		symptomsDefineService.batchRemove(symptomsIds);
		return R.ok();
	}
	
}
