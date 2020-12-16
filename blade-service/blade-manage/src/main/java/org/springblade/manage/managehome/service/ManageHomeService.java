package org.springblade.manage.managehome.service;

import org.springblade.manage.managehome.entity.ManageHome;

import java.util.List;

public interface ManageHomeService {
	/**
	 * @Description: 根据单位id获取数据 首页数字数据
	 * @Param: [deptId]
	 * @return: org.springblade.manage.managehome.entity.ManageHome
	 */
	ManageHome selectHome(String deptId,String month);

	/**
	 * @Description: 根据单位id获取当月数据
	 * @Param: [deptId]
	 * @return: org.springblade.manage.managehome.entity.ManageHome
	 */
	List<ManageHome> selectyue(String deptId);
	/**
	 * @Description: 根据单位id获取本年数据
	 * @Param: [deptId]
	 * @return: org.springblade.manage.managehome.entity.ManageHome
	 */
	List<ManageHome> selectnian(String deptId);
	/**
	 * @Description: 根据单位id获取在运车辆信息
	 * @Param: [deptId]
	 * @return: java.util.List<org.springblade.manage.managehome.entity.ManageHome>
	 */
	List<ManageHome> selectzaiyun(String deptId);

	/**
	 * @Description: 根据单位id获取闲置车辆信息
	 * @Param: [deptId]
	 * @return: java.util.List<org.springblade.manage.managehome.entity.ManageHome>
	 */
	List<ManageHome> selectxianzhi(String deptId);
}
