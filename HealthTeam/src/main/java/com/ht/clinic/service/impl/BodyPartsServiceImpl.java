package com.ht.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ht.clinic.dao.BodyPartsDao;
import com.ht.clinic.domain.BodyPartsDO;
import com.ht.clinic.service.BodyPartsService;
import com.ht.common.domain.Tree;
import com.ht.common.utils.BuildTree;
import com.ht.system.domain.DeptDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BodyPartsServiceImpl implements BodyPartsService {
	@Autowired
	private BodyPartsDao bodyPartsDao;

	@Override
	public Tree<BodyPartsDO> getTreeByFlag() {
		List<Tree<BodyPartsDO>> trees = new ArrayList<Tree<BodyPartsDO>>();
		List<BodyPartsDO> bodyParts = bodyPartsDao.getTreeByFlag(new HashMap<String, Object>(16));
		for (BodyPartsDO bodyPartsDO : bodyParts) {
			Tree<BodyPartsDO> tree = new Tree<BodyPartsDO>();
			tree.setId(bodyPartsDO.getBodyPartsId().toString());
			tree.setParentId(bodyPartsDO.getBodyPartsParentId().toString());
			tree.setText(bodyPartsDO.getBodyPartsName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<BodyPartsDO> t = BuildTree.build(trees);
		return t;
	}


	@Override
	public BodyPartsDO get(Integer bodyPartsId) {
		return bodyPartsDao.get(bodyPartsId);
	}

	@Override
	public List<BodyPartsDO> list(Map<String, Object> map) {
		return bodyPartsDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return bodyPartsDao.count(map);
	}

	@Override
	public int save(BodyPartsDO bodyParts) {
		return bodyPartsDao.save(bodyParts);
	}

	@Override
	public int update(BodyPartsDO bodyParts) {
		return bodyPartsDao.update(bodyParts);
	}

	@Override
	public int remove(Integer bodyPartsId) {
		return bodyPartsDao.remove(bodyPartsId);
	}

	@Override
	public int batchRemove(Integer[] bodyPartsIds) {
		return bodyPartsDao.batchRemove(bodyPartsIds);
	}

}
