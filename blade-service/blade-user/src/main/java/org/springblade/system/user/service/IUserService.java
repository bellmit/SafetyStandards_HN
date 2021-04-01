/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.system.user.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.core.mp.base.BaseService;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.page.UserPage;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 服务类
 *
 * @author hyp
 */
public interface IUserService extends BaseService<User> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param user
	 * @return
	 */
	IPage<User> selectUserPage(IPage<User> page, User user);

	/**
	 * 自定义分页根据条件
	 *
	 * @param userPage
	 * @return
	 */
	UserPage<User> selectUserByPage(UserPage userPage);

	/**
	 * 根据单位id获取下级人员信息
	 * @param deptId
	 * @return
	 */
	List<User> selectByDeptId(String deptId);

	/**
	 * 用户信息
	 *
	 * @param account
	 * @param password
	 * @return
	 */
	UserInfo userInfo( String account, String password);

	/**
	 * 用户信息
	 *
	 * @param account
	 * @param password
	 * @return
	 */
	User login( String account, String password);

	/**
	 * 给用户设置角色
	 *
	 * @param userIds
	 * @param roleIds
	 * @return
	 */
	boolean grant(String userIds, String roleIds);

	/**
	 * 初始化密码
	 *
	 * @param userIds
	 * @return
	 */
	boolean resetPassword(String userIds);
	/**
	 * 初始化密码
	 *
	 * @param userId
	 * @return
	 */
	boolean updatePassword(String userId,String passWord);

	/**
	 * 获取角色名
	 *
	 * @param roleIds
	 * @return
	 */
	List<String> getRoleName(String roleIds);

	/**
	 * 获取部门名
	 *
	 * @param deptIds
	 * @return
	 */
	List<String> getDeptName(String deptIds);

	/**
	 * 根据用户id获取数据
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

	/**
	 * 获取当前最大的id
	 * @return
	 */
	int selectMaxId();

	int selectByLoginName(String account);

	/**
	 * 自定义新增
	 * @param user
	 * @return
	 */
	boolean insertPer(User user);

	/**
	 * 根据岗位id获取岗位下级人员信息
	 * @param postId
	 * @return
	 */
	List<User> selectByPostId(String postId);

	/**
	 * 自定义编辑
	 * @param user
	 * @return
	 */
	boolean updatePer(User user);

	/**
	 * 自定义删除
	 * @param id
	 * @return
	 */
	boolean deletePer(String id);

	/**
	 * 查询是否存在openid
	 */
	User selectByopenId(String openid);

	/**
	 * 绑定openid
	 * @param account
	 * @param openid
	 */
	void bindDriverOpenId(String account, String openid);

	/**
	 * 微信用户信息
	 * @param openid
	 * @return
	 */
	UserInfo getWeixinUser(String openid);

	/**
	 * 获取政府用户
	 * @param account
	 * @param password
	 * @return
	 */
	User ZFlogin(String account, String password);

	/**
	 * 根据用户id获取用户所属岗位、机构信息
	 * @param userId
	 * @return
	 */
	User getZFUserInfo(String type,String userId);

	/**
	 * 自定义锁定
	 * @return
	 */
	boolean updateLocked(@RequestParam("isLocked") Integer isLocked, @RequestParam("loginErrorCount") Integer loginErrorCount
		, @RequestParam("lastLoginErrorTime") String lastLoginErrorTime, @RequestParam("id") String id);

	/**
	 * 根据登录名称查询用户
	 * @param account
	 * @return
	 */
	User selectByName(String account);

	/**
	 * 禁用、启用、删除用户账号信息
	 * @param updateUser
	 * @param updateTime
	 * @param isDeleted
	 * @param idss
	 * @return
	 */
	boolean updateUserStatus(@RequestParam("updateUser") Integer updateUser,
							 @RequestParam("updateTime") String updateTime,
							 @RequestParam("isDeleted") Integer isDeleted,
							 @RequestParam("idss") String[] idss);

	/**
	 * 根据企业ID查询所属下级所有的账号
	 * @param deptId
	 * @return
	 */
	List<User> selectNameById(String deptId);

}

