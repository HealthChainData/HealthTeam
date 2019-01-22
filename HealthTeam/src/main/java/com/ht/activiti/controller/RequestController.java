package com.ht.activiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.service.RequestService;
import com.ht.common.service.DictService;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.system.service.UserService;

@RequestMapping("activiti")
@RestController
public class RequestController {

	@Autowired
	private DictService  dictService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;

	@GetMapping("request")
	public ModelAndView gotoTask() {
		return new ModelAndView("act/request/request");
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<RequestDO> salaryList = requestService.list(query);
		int total = requestService.count(query);
		PageUtils pageUtils = new PageUtils(salaryList, total);
		return pageUtils;
	}

	@RequestMapping(value="/add")
	public ModelAndView toAdd() {
		return new ModelAndView("act/request/add");
	}
	
	@ResponseBody
	@RequestMapping(value="/queryTypeList/{type}")
	public List<Map<String,Object>> queryTypeList(@PathVariable String type){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("requestType", type);
		return dictService.queryDictByType(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/isExistsUser/{userName}")
	public Map<String,Object> isExistsUser(@PathVariable String userName){
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("username", userName);
		int count = userService.count(param);
		result.put("isExists", false);
		if (count > 0) {
			result.put("isExists", true);
		}
		return result;
	}
}
