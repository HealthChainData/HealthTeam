package com.ht.activiti.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.domain.RequestStepDO;
import com.ht.activiti.service.RequestService;
import com.ht.activiti.service.RequestStepService;
import com.ht.common.annotation.Log;
import com.ht.common.config.Constant;
import com.ht.common.controller.BaseController;
import com.ht.common.domain.DictDO;
import com.ht.common.service.DictService;
import com.ht.common.utils.MD5Utils;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;
import com.ht.common.utils.R;
import com.ht.system.domain.UserDO;
import com.ht.system.service.UserService;

@RequestMapping("activiti")
@RestController
public class RequestController extends BaseController {

	@Autowired
	private DictService dictService;

	@Autowired
	private UserService userService;

	@Autowired
	private RequestService requestService;

	@Autowired
	private RequestStepService requestStepService;

	@GetMapping("request")
	public ModelAndView gotoTask() {
		return new ModelAndView("act/request/request");
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		if (query.get("ownerId") != null && query.get("ownerId").equals("1")) {
			query.put("ownerId", getUserId());
		}
		List<RequestDO> requestList = requestService.list(query);
		int total = requestService.count(query);
		PageUtils pageUtils = new PageUtils(requestList, total);
		return pageUtils;
	}

	@RequestMapping(value = "/details{id}")
	public ModelAndView toDetails(@PathVariable("id") String id) {
		this.id = id;
		return new ModelAndView("act/request/details");
	}

	@RequestMapping(value = "/push{id}")
	public ModelAndView toPush(@PathVariable("id") String id) {
		this.id = id;
		RequestDO request = requestService.get(id);
		if(!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return new ModelAndView("error/200");
		}
		return new ModelAndView("act/request/push");
	}
	@RequestMapping(value = "/turnover{id}")
	public ModelAndView toTurnnover(@PathVariable("id") String id) {
		this.id = id;
		RequestDO request = requestService.get(id);
		if(!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return new ModelAndView("error/200");
		}
		return new ModelAndView("act/request/turnover");
	}

	/*
	 * @GetMapping(value = "/details{id}") String Details(@PathVariable("id") String
	 * id, Model model) { this.id = id; Map<String, Object> param = new
	 * HashMap<String, Object>(); param.put("requestId", id); List<RequestStepDO>
	 * requestStepList = requestStepService.list(param); int total =
	 * requestStepService.count(param); PageUtils pageUtils = new
	 * PageUtils(requestStepList, total); model.addAttribute("pageUtils",
	 * pageUtils); return "act/request/details"; }
	 */

	private String id;

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
	R save(RequestDO request, RequestStepDO requestStep) {
		int requestId = requestService.getRequestId() + 1;
		request.setId(String.valueOf(requestId));
		UserDO user = userService.getUserById(request.getOwnerId());
		/*
		 * if (user != null) { request.setOwnerId(user.getName()); }
		 */
		request.setCreateTime(new Date());
		request.setCreateUserId(getUserId().toString());
		request.setCreateUserName(getUsername());
		request.setRequestProgress("0%");
		request.setRequestStatus("进行中");
		request.setUpdateTime(new Date());
		if (requestService.save(request) > 0) {
			requestStep.setRequestId(String.valueOf(requestId));
			requestStep.setStepName("新增事务请求");
			requestStep.setStepDesc(getUsername() + "指定给" + user.getName() + "的一个新任务");
			requestStep.setProgressAdd("0%");
			requestStep.setBeforeOwnerId(user.getUserId().toString());
			requestStep.setAfterOwnerId(user.getUserId().toString());
			requestStep.setRecoTime(new Date());
			requestStep.setRecoUserId(getUserId().toString());
			if (requestStepService.save(requestStep) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}

	@ResponseBody
	@RequestMapping("/requestStepList")
	public PageUtils RequestStepList() {
		// RequestStepDO requestStepDO = new RequestStepDO();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("requestId", id);
		List<RequestStepDO> requestStepList = requestStepService.list(param);
		for (RequestStepDO requestStepDO : requestStepList) {
			String beforeOwnerId = requestStepDO.getBeforeOwnerId();
			UserDO beforeOwnerUser = userService.getUserById(beforeOwnerId);
			requestStepDO.setBeforeOwnerId(beforeOwnerUser.getName());

			String afterOwnerId = requestStepDO.getAfterOwnerId();
			UserDO afterOwnerUser = userService.getUserById(afterOwnerId);
			requestStepDO.setAfterOwnerId(afterOwnerUser.getName());

			String recoUserId = requestStepDO.getRecoUserId();
			UserDO recoUser = userService.getUserById(recoUserId);
			requestStepDO.setRecoUserId(recoUser.getName());
		}
		int total = requestStepService.count(param);
		return new PageUtils(requestStepList, total);
	}
	
	@ResponseBody
	@RequestMapping("/listById")
	public PageUtils ListById(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		query.put("id", id);
		List<RequestDO> requestList = requestService.list(query);
		int total = requestService.count(query);
		PageUtils pageUtils = new PageUtils(requestList, total);
		return pageUtils;
	}
	
	
	/*
	 * @PostMapping("/push")
	 * 
	 * @ResponseBody
	 */
	/*
	 * R batchRemove(String id) { RequestDO request = requestService.get(id); String
	 * progress = request.getRequestProgress(); int progressInt =
	 * Integer.parseInt(progress); progressInt = progressInt + 10;
	 * request.setRequestProgress(String.valueOf(progressInt));
	 * request.setUpdateUserId(getUserId().toString()); request.setExpectTime(new
	 * Date()); int r = requestService.update(request); if (r > 0) { RequestStepDO
	 * requestStep = new RequestStepDO(); requestStep.setRequestId(id);
	 * requestStep.setStepName("更新进度"); requestStep.setStepDesc("进度更新10%");
	 * requestStep.setProgressAdd(String.valueOf(progressInt)); List<RequestStepDO>
	 * list = requestStepService.list(null); RequestStepDO requestStep1 = null; if
	 * (list != null) { requestStep1 = list.get(0); }
	 * requestStep.setBeforeOwnerId(request.getOwnerId());
	 * requestStep.setAfterOwnerId(request.getOwnerId());
	 * requestStep.setRecoTime(new Date());
	 * requestStep.setRecoUserId(getUserId().toString()); if
	 * (requestStepService.save(requestStep) > 0) { return R.ok(); } } return
	 * R.error(); }
	 */

	@PostMapping("/pushSave")
	@ResponseBody
	R pushSave(String stepName, String stepDesc, String progressAdd) {
		RequestDO request = requestService.get(id);
		String progress = request.getRequestProgress();
		progress = progress.substring(0, progress.indexOf("%"));
		progressAdd = progressAdd.substring(0, progressAdd.indexOf("%"));
		int progressInt = Integer.parseInt(progress);
		progressInt = progressInt + Integer.parseInt(progressAdd);
		if (progressInt >= 100) {
			progressInt = 100;
			request.setRequestStatus("已完成");
		}
		request.setRequestProgress(String.valueOf(progressInt)+"%");
		request.setUpdateUserId(getUserId().toString());
		request.setExpectTime(new Date());
		request.setUpdateTime(new Date());
		int r = requestService.update(request);
		if (r > 0) {
			RequestStepDO requestStep = new RequestStepDO();
			requestStep.setRequestId(id);
			requestStep.setStepName(stepName);
			requestStep.setStepDesc(stepDesc);
			requestStep.setProgressAdd(String.valueOf(progressAdd)+"%");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("requestId", id);
			List<RequestStepDO> list = requestStepService.list(param);
			RequestStepDO requestStep1 = null;
			if (list != null) {
				requestStep1 = list.get(0);
			}
			requestStep.setBeforeOwnerId(requestStep1.getAfterOwnerId());
			requestStep.setAfterOwnerId(request.getOwnerId());
			requestStep.setRecoTime(new Date());
			requestStep.setRecoUserId(getUserId().toString());
			if (requestStepService.save(requestStep) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}

	@ResponseBody
	@GetMapping("/userList")
	public List<UserDO> userList() {
		List<UserDO> userList = userService.userList();
		return userList;
	}

	@PostMapping("/turnoverSave")
	@ResponseBody
	R turnoverSave(String ownerId) {
		RequestDO request = requestService.get(id);
		UserDO user = userService.getUserById(ownerId);
		String beforeOwnerId = request.getOwnerId();
		request.setOwnerId(ownerId);
		request.setUpdateUserId(getUserId().toString());
		request.setUpdateTime(new Date());
		int r = requestService.update(request);
		if (r > 0) {
			RequestStepDO requestStep = new RequestStepDO();
			requestStep.setRequestId(id);
			requestStep.setStepName("事务移交");
			requestStep.setStepDesc(getUser().getName() + "将事务移交给" + user.getName());
			requestStep.setProgressAdd("0");
			requestStep.setBeforeOwnerId(beforeOwnerId);
			requestStep.setAfterOwnerId(request.getOwnerId());
			requestStep.setRecoTime(new Date());
			requestStep.setRecoUserId(getUserId().toString());
			if (requestStepService.save(requestStep) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}

	@PostMapping("/shelve")
	@ResponseBody
	R sheleve(String id) {
		RequestDO request = requestService.get(id);
		if(!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return R.no();
		}
		String beforeOwnerId = request.getOwnerId();
		request.setRequestStatus("已搁置");
		request.setUpdateUserId(getUserId().toString());
		request.setUpdateTime(new Date());
		int r = requestService.update(request);
		if (r > 0) {
			RequestStepDO requestStep = new RequestStepDO();
			requestStep.setRequestId(id);
			requestStep.setStepName("事务搁置");
			requestStep.setStepDesc(getUser().getName() + "将事务搁置");
			requestStep.setProgressAdd("0");
			requestStep.setBeforeOwnerId(beforeOwnerId);
			requestStep.setAfterOwnerId(request.getOwnerId());
			requestStep.setRecoTime(new Date());
			requestStep.setRecoUserId(getUserId().toString());
			if (requestStepService.save(requestStep) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}
	

	@PostMapping("/activate")
	@ResponseBody
	R activate(String id) {
		RequestDO request = requestService.get(id);
		if(!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return R.no();
		}
		String beforeOwnerId = request.getOwnerId();
		request.setRequestStatus("进行中");
		request.setUpdateUserId(getUserId().toString());
		request.setUpdateTime(new Date());
		int r = requestService.update(request);
		if (r > 0) {
			RequestStepDO requestStep = new RequestStepDO();
			requestStep.setRequestId(id);
			requestStep.setStepName("事务激活");
			requestStep.setStepDesc(getUser().getName() + "将事务激活");
			requestStep.setProgressAdd("0");
			requestStep.setBeforeOwnerId(beforeOwnerId);
			requestStep.setAfterOwnerId(request.getOwnerId());
			requestStep.setRecoTime(new Date());
			requestStep.setRecoUserId(getUserId().toString());
			if (requestStepService.save(requestStep) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}
}
