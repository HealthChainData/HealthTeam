package com.ht.activiti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.domain.RequestStepDO;
import com.ht.activiti.service.RequestService;
import com.ht.activiti.service.RequestStepService;
import com.ht.common.annotation.Log;
import com.ht.common.config.BootdoConfig;
import com.ht.common.config.Constant;
import com.ht.common.controller.BaseController;
import com.ht.common.domain.DictDO;
import com.ht.common.domain.FileDO;
import com.ht.common.service.DictService;
import com.ht.common.service.FileService;
import com.ht.common.utils.FileType;
import com.ht.common.utils.FileUtil;
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
	private BootdoConfig bootdoConfig;

	@Autowired
	private FileService sysFileService;

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
		List<RequestDO> requestList = requestService.lists(query);
		int total = requestService.count(query);
		PageUtils pageUtils = new PageUtils(requestList, total);
		return pageUtils;
	}

	@RequestMapping(value = "/details{id}")
	public ModelAndView toDetails(Model model, @PathVariable("id") String id) {
		this.id = id;
		RequestDO request = requestService.get(id);
		UserDO user = userService.getUserById(request.getOwnerId());
		request.setUsername(user.getName());
		String format = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		request.setCreateTimes(sdf.format(request.getCreateTime()));
		if (request.getExpectTime() != null) {
			request.setExpectTimes(sdf.format(request.getExpectTime()));
		}
		if (request.getUpdateTime() != null) {
			request.setUpdateTimes(sdf.format(request.getUpdateTime()));
		}
		model.addAttribute("request", request);
		return new ModelAndView("act/request/details");
	}

	@RequestMapping(value = "/push{id}")
	public ModelAndView toPush(Model model, @PathVariable("id") String id) {
		this.id = id;
		RequestDO request = requestService.get(id);
		if (!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return new ModelAndView("error/200");
		}
		if (request.getRequestStatus().equals("已完成")) {
			return new ModelAndView("error/201");
		}
		String format = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (request.getUpdateTime() != null) {
			request.setUpdateTimes(sdf.format(request.getUpdateTime()));
		}
		model.addAttribute("request", request);
		return new ModelAndView("act/request/push");
	}

	@RequestMapping(value = "/turnover{id}")
	public ModelAndView toTurnnover(Model model, @PathVariable("id") String id) {
		this.id = id;
		RequestDO request = requestService.get(id);
		if (!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return new ModelAndView("error/200");
		}
		if (request.getRequestStatus().equals("已完成")) {
			return new ModelAndView("error/201");
		}
		UserDO user = userService.getUserById(request.getOwnerId());
		request.setUsername(user.getName());
		model.addAttribute("request", request);
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
	R save(RequestDO request, RequestStepDO requestStep,@RequestParam("file")MultipartFile file) {
		if (request.getOwnerId() == null || request.getOwnerId() == "") {
			return R.userIsNull();
		}
		if (request.getRequestType() == null || request.getRequestType() == "") {
			return R.typeIsNull();
		}
		if (request.getRequestSrc() == null || request.getRequestSrc() == "") {
			return R.srcIsNull();
		}
		int requestId = 1;
		if (requestService.getRequestId() != null) {
			requestId = Integer.parseInt(requestService.getRequestId().getId())+1;
		}
		request.setId(String.valueOf(requestId));
		if(!file.getOriginalFilename().equals("")) {
			String fileName = file.getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
			try {
				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
			} catch (Exception e) {
				return R.error();
			}
			if (sysFileService.save(sysFile) > 0) {
				fileUrl = sysFile.getUrl();
			}
			if(fileUrl!=null) {
				request.setRequestPic(fileUrl);
			}
		}
		UserDO user = userService.getUserById(request.getOwnerId());
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
	String fileUrl = null;
	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			fileUrl = sysFile.getUrl();
			return R.ok().put("fileName",sysFile.getUrl());
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
		request.setRequestProgress(String.valueOf(progressInt) + "%");
		request.setUpdateUserId(getUserId().toString());
		request.setExpectTime(new Date());
		request.setUpdateTime(new Date());
		int r = requestService.update(request);
		if (r > 0) {
			RequestStepDO requestStep = new RequestStepDO();
			requestStep.setRequestId(id);
			requestStep.setStepName(stepName);
			requestStep.setStepDesc(stepDesc);
			requestStep.setProgressAdd(String.valueOf(progressAdd) + "%");
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
	R turnoverSave(String ownerId, String stepDesc) {
		if (ownerId == null || ownerId == "") {
			return R.userIsNull();
		}
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
			requestStep.setStepDesc(stepDesc);
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
		if (!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return R.no();
		}
		if (request.getRequestStatus().equals("已搁置")) {
			return R.repeat();
		}
		if (request.getRequestStatus().equals("已完成")) {
			return R.done();
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
		if (!request.getOwnerId().equals(getUser().getUserId().toString())) {
			return R.no();
		}
		if (!request.getRequestStatus().equals("已搁置")) {
			return R.repeat();
		}
		if (request.getRequestStatus().equals("已完成")) {
			return R.done();
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
