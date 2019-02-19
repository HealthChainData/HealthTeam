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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ht.clinic.domain.ClinicDO;
import com.ht.clinic.domain.DiseaseDefineDO;
import com.ht.clinic.service.DiseaseDefineService;

import com.ht.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-18 09:39:56
 */

@Controller
@RequestMapping("/diseaseDefine")
public class DiseaseDefineController {
	@Autowired
	private DiseaseDefineService diseaseDefineService;

	@GetMapping("diseaseDefine")
	String DiseaseDefine() {
		return "clinic/diseaseDefine/diseaseDefine";
	}

	@ResponseBody
	@GetMapping("/list")
	public List<DiseaseDefineDO> list() {
		// 查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<DiseaseDefineDO> diseaseDefineList = diseaseDefineService.list(query);
		int j = 1;
		for (int i = 0; i < diseaseDefineList.size(); i++) {
			if (diseaseDefineList.get(i).getDiseaseParentId() == null
					|| diseaseDefineList.get(i).getDiseaseParentId().equals("")) {
				diseaseDefineList.get(i).setId(String.valueOf(j));
				j = j + 1;
			}

		}
		return diseaseDefineList;
	}

	@GetMapping("/add")
	ModelAndView add() {
		return new ModelAndView("clinic/diseaseDefine/add");
	}

	@GetMapping("/adds/{diseaseId}")
	ModelAndView adds(@PathVariable("diseaseId") Integer diseaseId, Model model) {
		DiseaseDefineDO diseaseDefine = diseaseDefineService.get(diseaseId);
		model.addAttribute("diseaseId", diseaseId);
		if (diseaseDefine != null) {
			model.addAttribute("diseaseName", diseaseDefine.getDiseaseName());
		}
		return new ModelAndView("clinic/diseaseDefine/adds");
	}

	@GetMapping("/edit/{diseaseId}")
	ModelAndView edit(@PathVariable("diseaseId") Integer diseaseId, Model model) {
		DiseaseDefineDO diseaseDefine = diseaseDefineService.get(diseaseId);
		model.addAttribute("diseaseDefine", diseaseDefine);
		String tenderLimit = "";
		if (diseaseDefine.getTenderLimit() != null && diseaseDefine.getTenderLimit().equals(0)) {
			tenderLimit = "无限制";
		} else if (diseaseDefine.getTenderLimit() != null && diseaseDefine.getTenderLimit().equals(1)) {
			tenderLimit = "女";
		} else if (diseaseDefine.getTenderLimit() != null && diseaseDefine.getTenderLimit().equals(2)) {
			tenderLimit = "男";
		}
		model.addAttribute("tenderLimit", tenderLimit);
		String curativeLimit = "";
		if (diseaseDefine.getCurativeLimit() != null && diseaseDefine.getCurativeLimit().equals(0)) {
			curativeLimit = "治愈";
		} else if (diseaseDefine.getCurativeLimit() != null && diseaseDefine.getCurativeLimit().equals(1)) {
			curativeLimit = "好转";
		} else if (diseaseDefine.getCurativeLimit() != null && diseaseDefine.getCurativeLimit().equals(2)) {
			curativeLimit = "无定义";
		}
		String diseaseParentName = diseaseDefine.getDiseaseName();
		if (diseaseDefine.getDiseaseParentId() != null) {
			DiseaseDefineDO diseaseDefine1 = diseaseDefineService.get(diseaseDefine.getDiseaseParentId());
			if (diseaseDefine1 != null) {
				diseaseParentName = diseaseDefine1.getDiseaseName();
			}
		}
		model.addAttribute("diseaseParentName", diseaseParentName);
		model.addAttribute("curativeLimit", curativeLimit);
		return new ModelAndView("clinic/diseaseDefine/details");
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(DiseaseDefineDO diseaseDefine) {
		if (diseaseDefine.getDiseaseId() != null) {
			diseaseDefine.setDiseaseParentId(diseaseDefine.getDiseaseId());
		}
		if (diseaseDefineService.save(diseaseDefine) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	@GetMapping("/update/{diseaseId}")
	ModelAndView update(Model model,@PathVariable("diseaseId") Integer diseaseId) {
		DiseaseDefineDO diseaseDefine = diseaseDefineService.get(diseaseId);
		model.addAttribute("diseaseDefine", diseaseDefine);
		return new ModelAndView("clinic/diseaseDefine/update");
	}
	
	@GetMapping("/updates/{diseaseId}")
	ModelAndView updates(Model model,@PathVariable("diseaseId") Integer diseaseId) {
		DiseaseDefineDO diseaseDefine = diseaseDefineService.get(diseaseId);
		model.addAttribute("diseaseDefine", diseaseDefine);
		String diseaseParentName = diseaseDefine.getDiseaseName();
		if (diseaseDefine.getDiseaseParentId() != null) {
			DiseaseDefineDO diseaseDefine1 = diseaseDefineService.get(diseaseDefine.getDiseaseParentId());
			if (diseaseDefine1 != null) {
				diseaseParentName = diseaseDefine1.getDiseaseName();
			}
		}
		model.addAttribute("diseaseParentName", diseaseParentName);
		return new ModelAndView("clinic/diseaseDefine/updates");
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(DiseaseDefineDO diseaseDefine) {
		diseaseDefineService.update(diseaseDefine);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public R remove(Integer diseaseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("diseaseParentId", diseaseId);
		if (diseaseDefineService.remove(diseaseId) > 0) {
			if (diseaseDefineService.count(map) > 0) {
				if (diseaseDefineService.removes(diseaseId) > 0) {
					return R.ok();
				}
			} else {
				return R.ok();
			}
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:diseaseDefine:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] diseaseIds) {
		diseaseDefineService.batchRemove(diseaseIds);
		return R.ok();
	}

}
