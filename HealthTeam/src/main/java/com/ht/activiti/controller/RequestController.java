package com.ht.activiti.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.service.RequestService;
import com.ht.common.annotation.Log;
import com.ht.common.config.Constant;
import com.ht.common.controller.BaseController;
import com.ht.common.service.DictService;
import com.ht.common.utils.MD5Utils;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;
import com.ht.system.domain.UserDO;
import com.ht.system.service.UserService;

@RequestMapping("activiti")
@RestController
public class RequestController extends BaseController{

	@Autowired
	private DictService dictService;

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
		List<RequestDO> requestList = requestService.list(query);
		int total = requestService.count(query);
		PageUtils pageUtils = new PageUtils(requestList, total);
		return pageUtils;
	}

	@RequestMapping(value = "/add")
	public ModelAndView toAdd() {
		return new ModelAndView("act/request/add");
	}

	@ResponseBody
	@RequestMapping(value = "/queryTypeList/{type}")
	public List<Map<String, Object>> queryTypeList(@PathVariable String type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("requestType", type);
		return dictService.queryDictByType(param);
	}

	@ResponseBody
	@RequestMapping(value = "/isExistsUser/{userName}")
	public Map<String, Object> isExistsUser(@PathVariable String user) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", user);
		int count = userService.count(param);
		result.put("isExists", false);
		if (count > 0) {
			result.put("isExists", true);
		}
		return result;
	}
	
	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return userService.exit(params);
	}
	
	@Log("保存请求")
	@PostMapping("/save")
	@ResponseBody
	R save(RequestDO request) {
		request.setCreateUserId(getUserId().toString());
		request.setCreateUserName(getUsername());
		request.setRequestProgress("0");
		request.setRequestStatus("进行中");
		request.setUpdateTime(new Date());
		if (requestService.save(request) > 0) {
			return R.ok();
		}
		return R.error();
	}

}
