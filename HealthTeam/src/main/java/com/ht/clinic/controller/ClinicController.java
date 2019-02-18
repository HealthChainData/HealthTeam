package com.ht.clinic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import com.ht.activiti.domain.RequestDO;
import com.ht.clinic.domain.ClinicDO;
import com.ht.clinic.service.ClinicService;
import com.ht.common.controller.BaseController;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;
import com.ht.system.domain.UserDO;
import com.ht.system.service.UserService;

/**
 * @date 2019-02-12 16:10:19
 */

@Controller
@RequestMapping("/clinic")
public class ClinicController extends BaseController {
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private UserService userService;


	@GetMapping("clinic")
	public ModelAndView gotoTask() {
		return new ModelAndView("clinic/clinic/clinic");
	}

	@ResponseBody
	@GetMapping("/list")
	public List<ClinicDO> list() {
		// 查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<ClinicDO> clinicList = clinicService.list(query);
		int j = 1;
		for (int i = 0; i < clinicList.size(); i++) {
			if (clinicList.get(i).getClinicParentId() == null || clinicList.get(i).getClinicParentId().equals("")) {
				clinicList.get(i).setId(String.valueOf(j));
				j=j+1;
			}
		}
		for (ClinicDO clinicDO : clinicList) {
			if(clinicDO.getSuperAdminId()!=null || clinicDO.getSuperAdminId() != "") {
				UserDO user = userService.getUserById(clinicDO.getSuperAdminId());
				if(user != null) {
					clinicDO.setSuperAdminId(user.getName());
				}
			}
		}
		return clinicList;
	}
	
	/**@ResponseBody
	@GetMapping("/list")
	public PageUtils list() {
		// 查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<ClinicDO> clinicList = clinicService.list(query);
		int j = 1;
		for (int i = 0; i < clinicList.size(); i++) {
			if (clinicList.get(i).getClinicParentId() == null || clinicList.get(i).getClinicParentId().equals("")) {
				clinicList.get(i).setId(String.valueOf(j));
				j=j+1;
			}
		}
		int total = clinicService.count(query);
		PageUtils pageUtils = new PageUtils(clinicList, total);
		return pageUtils;
	}*/

	@GetMapping("/add")
	ModelAndView add() {
		return new ModelAndView("clinic/clinic/add");
	}

	@GetMapping("/adds{clinicId}")
	ModelAndView adds(@PathVariable("clinicId") String clinicId,Model model) {
		if (clinicId != null) {
			ClinicDO clinic = clinicService.get(clinicId);
			if (clinic.getClinicParentId() == null || clinic.getClinicParentId().equals("")) {
				model.addAttribute("clinicId", clinicId);
			} else {
				return new ModelAndView("error/202");
			}
		}
		return new ModelAndView("clinic/clinic/add");
	}
	
	@GetMapping("/set{clinicId}")
	ModelAndView set(@PathVariable("clinicId") String clinicId,Model model) {
		model.addAttribute("clinicId", clinicId);
		return new ModelAndView("clinic/clinic/set");
	}

	@GetMapping("/edit/{clinicId}")
	ModelAndView edit(@PathVariable("clinicId") String clinicId, Model model) {
		ClinicDO clinic = clinicService.get(clinicId);
		model.addAttribute("clinic", clinic);
		return new ModelAndView("clinic/clinic/details");
	}
	
	@GetMapping("/update/{clinicId}")
	ModelAndView update(Model model,@PathVariable("clinicId") String clinicId) {
		ClinicDO clinic = clinicService.get(clinicId);
		model.addAttribute("clinic", clinic);
		return new ModelAndView("clinic/clinic/update");
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(ClinicDO clinic) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		if (clinic.getClinicId()!=null) {
			clinic.setClinicParentId(clinic.getClinicId());
		}
		clinic.setClinicId(sb.toString());
		clinic.setStatus(0);
		clinic.setCreateUserId(getUserId().toString());
		clinic.setCreateTime(new Date());
		if (clinicService.save(clinic) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(ClinicDO clinic) {
		clinicService.update(clinic);
		return R.ok();
	}

	/**
	 * 禁用
	 */
	@PostMapping("/ban{clinicId}")
	@ResponseBody
	public R ban(String clinicId) {
		ClinicDO clinic = new ClinicDO();
		clinic.setClinicId(clinicId);
		clinic.setStatus(1);
		if (clinicService.update(clinic) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 启用
	 */
	@PostMapping("/start{clinicId}")
	@ResponseBody
	public R start(String clinicId) {
		ClinicDO clinic = new ClinicDO();
		clinic.setClinicId(clinicId);
		clinic.setStatus(0);
		if (clinicService.update(clinic) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 设置超级管理员
	 */
	@PostMapping("/setAdmin/{clinicId}")
	@ResponseBody
	public R setAdmin(@RequestParam("ids[]") String[] userIds,@PathVariable("clinicId")String clinicId) {
		ClinicDO clinic = new ClinicDO();
		clinic.setClinicId(clinicId);
		clinic.setSuperAdminId(userIds[0]);
		if (clinicService.update(clinic) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] clinicIds) {
		clinicService.batchRemove(clinicIds);
		return R.ok();
	}

}
