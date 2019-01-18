package com.ht.common.controller;

import org.springframework.stereotype.Controller;

import com.ht.common.utils.ShiroUtils;
import com.ht.system.domain.UserDO;
import com.ht.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}