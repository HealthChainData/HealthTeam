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
import com.ht.clinic.service.DrugDefineService;
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

	@GetMapping()
	String DrugDefine() {
		return "clinic/drugDefine/drugDefine";
	}

	@ResponseBody
	@GetMapping("/list")
	public List<DrugDefineDO> list() {
		// 查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<DrugDefineDO> drugDefineList = drugDefineService.list(query);
		int j = 1;
		for (int i = 0; i < drugDefineList.size(); i++) {
			if (drugDefineList.get(i).getDrugParentId() == null || drugDefineList.get(i).getDrugParentId().equals("")) {
				drugDefineList.get(i).setId(String.valueOf(j));
				j = j + 1;
			}
		}
		return drugDefineList;
	}

	@GetMapping("/add")
	String add() {
		return "clinic/drugDefine/add";
	}

	@GetMapping("/adds/{drugId}")
	ModelAndView adds(@PathVariable("drugId") Integer drugId, Model model) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugId", drugId);
		if (drugDefine != null) {
			model.addAttribute("drugName", drugDefine.getDrugName());
		}
		return new ModelAndView("clinic/drugDefine/adds");
	}

	@GetMapping("/edit/{drugId}")
	ModelAndView edit(@PathVariable("drugId") Integer drugId, Model model) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugDefine", drugDefine);
		String drugParentName = drugDefine.getDrugName();
		if (drugDefine.getDrugParentId() != null) {
			DrugDefineDO drugDefine1 = drugDefineService.get(drugDefine.getDrugParentId());
			if (drugDefine1 != null) {
				drugParentName = drugDefine1.getDrugName();
			}
		}
		model.addAttribute("drugParentName", drugParentName);
		return new ModelAndView("clinic/drugDefine/details");
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(DrugDefineDO drugDefine) {
		if (drugDefine.getDrugId() != null) {
			drugDefine.setDrugParentId(drugDefine.getDrugId());
		}
		if (drugDefineService.save(drugDefine) > 0) {
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drugParentId", drugId);
		if (drugDefineService.remove(drugId) > 0) {
			if(drugDefineService.count(map)>0) {
				if(drugDefineService.removes(drugId)>0) {
					return R.ok();
				}
			}
			return R.ok();
		}
		return R.error();
	}
	
	@GetMapping("/update/{drugId}")
	ModelAndView update(Model model,@PathVariable("drugId") Integer drugId) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugDefine", drugDefine);
		return new ModelAndView("clinic/drugDefine/update");
	}
	
	@GetMapping("/updates/{drugId}")
	ModelAndView updates(Model model,@PathVariable("drugId") Integer drugId) {
		DrugDefineDO drugDefine = drugDefineService.get(drugId);
		model.addAttribute("drugDefine", drugDefine);
		String drugParentName = drugDefine.getDrugName();
		if (drugDefine.getDrugParentId() != null) {
			DrugDefineDO drugDefine1 = drugDefineService.get(drugDefine.getDrugParentId());
			if (drugDefine1 != null) {
				drugParentName = drugDefine1.getDrugName();
			}
		}
		model.addAttribute("drugParentName", drugParentName);
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
