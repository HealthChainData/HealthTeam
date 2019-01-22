package com.ht.activiti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.domain.RequestDO;
import com.ht.activiti.service.RequestService;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.Query;

@RequestMapping("activiti")
@RestController
public class RequestController {
	
		@Autowired
		private RequestService requestService;
	
	 	@GetMapping("request")
	    public ModelAndView gotoTask(){
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

}
