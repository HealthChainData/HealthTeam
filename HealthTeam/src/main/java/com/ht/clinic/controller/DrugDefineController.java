package com.ht.clinic.controller;

import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.ht.clinic.domain.DiseaseDefineDO;
import com.ht.clinic.domain.DrugDefineDO;
import com.ht.clinic.domain.DrugTypeDO;
import com.ht.clinic.domain.HealthDataDefineDO;
import com.ht.clinic.service.DrugDefineService;
import com.ht.clinic.service.DrugTypeService;
import com.ht.common.domain.DictDO;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-19 15:20:41
 */

@Controller
@RequestMapping("/drugDefine")
public class DrugDefineController {
	@Autowired
	private DrugDefineService drugDefineService;

	@Autowired
	private DrugTypeService drugTypeService;

	@GetMapping()
	String DrugDefine() {
		return "clinic/drugDefine/drugDefine";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<DrugDefineDO> drugDefineList = drugDefineService.list(query);
		int j = 1;
		for (int i = 0; i < drugDefineList.size(); i++) {
			if(drugDefineList.get(i).getDrugTypeId()!=null) {
				DrugTypeDO drugTypeDO = drugTypeService.get(drugDefineList.get(i).getDrugTypeId());
				drugDefineList.get(i).setDrugTypeName(drugTypeDO.getDrugTypeName());
			}
			drugDefineList.get(i).setId(String.valueOf(j));
			j = j + 1;
		}
		int total = drugDefineService.count(query);
		PageUtils pageUtils = new PageUtils(drugDefineList, total);
		return pageUtils;
	}
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/list") public PageUtils list(@RequestParam Map<String, Object>
	 * params){ //查询列表数据 Query query = new Query(params); List<DrugDefineDO>
	 * drugDefineList = drugDefineService.list(query); int total =
	 * drugDefineService.count(query); PageUtils pageUtils = new
	 * PageUtils(drugDefineList, total); return pageUtils; }
	 */

	@GetMapping("/add")
	String add() {
		return "clinic/drugDefine/add";
	}

	@GetMapping("/adds")
	ModelAndView adds() {
		return new ModelAndView("clinic/drugDefine/adds");
	}

	@GetMapping("/edit/{drugId}")
	ModelAndView edit(@PathVariable("drugId") Integer drugId, Model model) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		if(drugDefine.getDrugTypeId()!=null) {
			DrugTypeDO drugTypeDO = drugTypeService.get(drugDefine.getDrugTypeId());
			model.addAttribute("drugTypeName", drugTypeDO.getDrugTypeName());
		}
		model.addAttribute("drugDefine", drugDefine);
		return new ModelAndView("clinic/drugDefine/details");
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(DrugDefineDO drugDefine) {
		if (drugDefine.getDrugTypeId() == null || drugDefine.getDrugTypeId().equals("")) {
			return R.drugTypeIsNull();
		}
		if (drugDefineService.save(drugDefine) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@GetMapping("/drugTypeList/{drugTypeId}")
	public List<DrugTypeDO> drugTypeList(@PathVariable("drugTypeId") Integer drugTypeId) {
		Map<String, Object> map = new HashMap<>(16);
		List<DrugTypeDO> drugTypeList = drugTypeService.list(map);
		if(drugTypeId!=null) {
			for (int i = 0; i < drugTypeList.size(); i++) {
				if(drugTypeList.get(i).getId().equals(drugTypeId)) {
					drugTypeList.remove(i);
				}
			}
		}
		return drugTypeList;
	}
	
	@ResponseBody
	@GetMapping("/drugTypeList")
	public List<DrugTypeDO> drugTypeList() {
		Map<String, Object> map = new HashMap<>(16);
		List<DrugTypeDO> drugTypeList = drugTypeService.list(map);
		return drugTypeList;
	}

	/**
	 * 保存药品类型
	 */
	@ResponseBody
	@PostMapping("/saveType")
	public R saveType(DrugTypeDO drugTypeDO) {
		if (drugTypeService.save(drugTypeDO) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(DrugDefineDO drugDefine) {
		drugDefineService.update(drugDefine);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public R remove(Integer drugId) {
		if (drugDefineService.remove(drugId) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@GetMapping("/update/{drugId}")
	ModelAndView update(Model model, @PathVariable("drugId") Integer drugId) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugDefine", drugDefine);
		return new ModelAndView("clinic/drugDefine/update");
	}

	@GetMapping("/updates/{drugId}")
	ModelAndView updates(Model model, @PathVariable("drugId") Integer drugId) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugDefine", drugDefine);
		DrugTypeDO drugTypeDO = null;
		if(drugDefine.getDrugTypeId()!=null) {
			drugTypeDO = drugTypeService.get(drugDefine.getDrugTypeId());	
		}
		model.addAttribute("drugTypeDO", drugTypeDO);
		return new ModelAndView("clinic/drugDefine/updates");
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] drugIds) {
		drugDefineService.batchRemove(drugIds);
		return R.ok();
	}

}
