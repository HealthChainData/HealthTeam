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
import com.ht.clinic.service.BodyPartsService;
import com.ht.common.domain.Tree;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;
import com.ht.system.domain.DeptDO;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-21 17:19:59
 */
 
@Controller
@RequestMapping("/bodyParts")
public class BodyPartsController {
	@Autowired
	private BodyPartsService bodyPartsService;
	
	@GetMapping()
	String BodyParts(){
	    return "/bodyParts/bodyParts";
	}
	
	@GetMapping("/treeView")
	String treeView() {
		return  "clinic/symptomsDefine/bodyPartsTree";
	}
	
	@GetMapping("/tree")
	@ResponseBody
	public Tree<BodyPartsDO> tree() {
		Tree<BodyPartsDO> tree = new Tree<BodyPartsDO>();
		tree = bodyPartsService.getTreeByFlag();
		return tree;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BodyPartsDO> bodyPartsList = bodyPartsService.list(query);
		int total = bodyPartsService.count(query);
		PageUtils pageUtils = new PageUtils(bodyPartsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "bodyParts/add";
	}

	@GetMapping("/edit/{bodyPartsId}")
	String edit(@PathVariable("bodyPartsId") Integer bodyPartsId,Model model){
		BodyPartsDO bodyParts = bodyPartsService.get(bodyPartsId);
		model.addAttribute("bodyParts", bodyParts);
	    return "bodyParts/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( BodyPartsDO bodyParts){
		if(bodyPartsService.save(bodyParts)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( BodyPartsDO bodyParts){
		bodyPartsService.update(bodyParts);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer bodyPartsId){
		if(bodyPartsService.remove(bodyPartsId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] bodyPartsIds){
		bodyPartsService.batchRemove(bodyPartsIds);
		return R.ok();
	}
	
}
