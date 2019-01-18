package com.ht.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ht.common.domain.LogDO;
import com.ht.common.domain.PageDO;
import com.ht.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
