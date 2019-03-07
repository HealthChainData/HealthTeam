package com.ht.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.system.domain.AreasDO;
import com.ht.system.domain.CitiesDO;
import com.ht.system.domain.ProvincesDO;
import com.ht.system.service.AreasService;
import com.ht.system.service.CitiesService;
import com.ht.system.service.ProvincesService;

@Controller
@RequestMapping("/provincesCityArea")
public class ProvinceCityAreaController {
	
	@Autowired
	private ProvincesService provincesService;
	
	@Autowired
	private CitiesService citiesService;
	
	@Autowired
	private AreasService areasService;
	
	@RequestMapping("/getProvinces")
	@ResponseBody
	public List<ProvincesDO> getProvinces() {
		Map<String, Object> query = new HashMap<>(16);
		return provincesService.list(query);
	}

	@RequestMapping("/getCityByProvinceId/{provinceid}")
	@ResponseBody
	public List<CitiesDO> getCityBuProvinces(@PathVariable("provinceid")Long provinceid) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("provinceid", provinceid);
		return citiesService.list(query);

	}

	@RequestMapping("/getCountyByCityId/{cityid}")
	@ResponseBody
	public List<AreasDO> getCountyByCityId(@PathVariable("cityid")Long cityid) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("cityid", cityid);
		return areasService.list(query);

	}
}
