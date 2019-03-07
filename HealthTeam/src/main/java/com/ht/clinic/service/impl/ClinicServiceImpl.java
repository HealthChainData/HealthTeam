package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ht.clinic.dao.ClinicDao;
import com.ht.clinic.domain.ClinicDO;
import com.ht.clinic.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService {
	@Autowired
	private ClinicDao clinicDao;

	@Override
	public ClinicDO get(String clinicId) {
		return clinicDao.get(clinicId);
	}

	@Override
	public List<ClinicDO> list(Map<String, Object> map) {
		return clinicDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return clinicDao.count(map);
	}

	@Override
	public int save(ClinicDO clinic) {
		return clinicDao.save(clinic);
	}

	@Override
	public int update(ClinicDO clinic) {
		return clinicDao.update(clinic);
	}

	@Override
	public int remove(String clinicId) {
		return clinicDao.remove(clinicId);
	}

	@Override
	public int batchRemove(String[] clinicIds) {
		return clinicDao.batchRemove(clinicIds);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = clinicDao.list(params).size() > 0;
		return exit;
	}

}
