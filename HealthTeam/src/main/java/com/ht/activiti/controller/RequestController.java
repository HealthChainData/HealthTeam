package com.ht.activiti.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ht.activiti.vo.ProcessVO;
import com.ht.common.utils.PageUtils;

@RequestMapping("activiti")
@RestController
public class RequestController {
	
	 @GetMapping("request")
	    public ModelAndView gotoTask(){
	        return new ModelAndView("act/request/request");
	    }
	 
	 @GetMapping("/requestlist")
	    PageUtils list(int offset, int limit) {
	       
	        
	        return null;
	    }

}
