package org.springblade.manage.managehome.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.manage.managehome.entity.ManageHome;
import org.springblade.manage.managehome.mapper.ManageHomeMapper;
import org.springblade.manage.managehome.service.ManageHomeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SafetyStandards
 **/
@Service
@AllArgsConstructor
public class ManageHomeServiceImpl implements ManageHomeService {

	private ManageHomeMapper manageHomeMapper;
	@Override
	public ManageHome selectHome(String deptId,String month) {
		return manageHomeMapper.selectHome(deptId,month);
	}

	@Override
	public List<ManageHome> selectyue(String deptId) {
		return manageHomeMapper.selectyue(deptId);
	}

	@Override
	public List<ManageHome> selectnian(String deptId) {
		return manageHomeMapper.selectnian(deptId);
	}

	@Override
	public List<ManageHome> selectzaiyun(String deptId) {
		return manageHomeMapper.selectzaiyun(deptId);
	}

	@Override
	public List<ManageHome> selectxianzhi(String deptId) {
		return manageHomeMapper.selectxianzhi(deptId);
	}
}
