package org.springblade.anbiao.configure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.configure.mapper.ConfigureMapper;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.configure.entity.Configure;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SafetyStandards
 * @description: IMapService实现类
 **/
@Service
@AllArgsConstructor
public class ConfigureServiceImpl extends ServiceImpl<ConfigureMapper, Configure> implements IConfigureService  {

	private ConfigureMapper mapMapper;

	@Override
	public List<Configure> selectMapList(String tableName, Integer deptId) {
		return mapMapper.selectMapList(tableName,deptId);
	}


	@Override
	public boolean delMap(String tableName, String id) {
		return mapMapper.delMap(tableName,id);
	}

	@Override
	public boolean delMapByDeptId(String tableName, String deptId) {
		return mapMapper.delMapByDeptId(tableName,deptId);
	}

	@Override
	public boolean delMapByDeptIdDel(String tableName, String deptId,String shujubiaoziduan) {
		return mapMapper.delMapByDeptIdDel(tableName,deptId,shujubiaoziduan);
	}

	@Override
	public Configure selectByIds(String tableName, String id) {
		return mapMapper.selectByIds(tableName,id);
	}

	@Override
	public boolean insertMap(Configure Configure) {
		return mapMapper.insertMap(Configure);
	}

	@Override
	public boolean updateMap(Configure Configure) {
		return mapMapper.updateMap(Configure);
	}

	@Override
	public List<Configure> selectByName() {
		return mapMapper.selectByName();
	}
}
