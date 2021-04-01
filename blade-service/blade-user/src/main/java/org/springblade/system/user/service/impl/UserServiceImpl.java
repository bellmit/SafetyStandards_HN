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
package org.springblade.system.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springblade.common.constant.CommonConstant;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.core.tool.utils.DigestUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.mapper.UserMapper;
import org.springblade.system.user.page.UserPage;
import org.springblade.system.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务实现类
 * @author hyp
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

	private UserMapper userMapper;

	@Override
	public IPage<User> selectUserPage(IPage<User> page, User user) {
		return page.setRecords(baseMapper.selectUserPage(page, user));
	}

	@Override
	public UserPage<User> selectUserByPage(UserPage userPage) {
		Integer total = userMapper.selectUsersTotal(userPage);
		if(userPage.getSize()==0){
			if(userPage.getTotal()==0){
				userPage.setTotal(total);
			}
			List<User> userlist = userMapper.selectUserByPage(userPage);
			userPage.setRecords(userlist);
			return userPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%userPage.getSize()==0){
				pagetotal = total / userPage.getSize();
			}else {
				pagetotal = total / userPage.getSize() + 1;
			}
			List<User> userlist = userMapper.selectUserByPage(userPage);
			userPage.setRecords(userlist);
		}
		if (pagetotal >= userPage.getCurrent()) {
			userPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (userPage.getCurrent() > 1) {
				offsetNo = userPage.getSize() * (userPage.getCurrent() - 1);
			}
			userPage.setTotal(total);
			userPage.setOffsetNo(offsetNo);
			List<User> userlist = userMapper.selectUserByPage(userPage);
			userPage.setRecords(userlist);
		}
		return userPage;
	}

	@Override
	public List<User> selectByDeptId(String deptId) {
		return userMapper.selectByDeptId(deptId);
	}

	@Override
	public UserInfo userInfo( String account, String password) {
		UserInfo userInfo = new UserInfo();
		User user = baseMapper.getUser(account, password);
		userInfo.setUser(user);
		return userInfo;
	}

	@Override
	public User login(String account, String password) {
		User user = baseMapper.getUser(account, password);
		return user;
	}

	@Override
	public boolean grant(String userIds, String roleIds) {
		User user = new User();
		user.setRoleId(roleIds);
		return this.update(user, Wrappers.<User>update().lambda().in(User::getId, Func.toIntList(userIds)));
	}

	@Override
	public boolean resetPassword(String userIds) {
		User user = new User();
		user.setPassword(DigestUtil.encrypt(CommonConstant.DEFAULT_PASSWORD));
		user.setUpdateTime(LocalDateTime.now());
		return this.update(user, Wrappers.<User>update().lambda().in(User::getId, Func.toIntList(userIds)));
	}

	@Override
	public boolean updatePassword(String userId, String passWord) {
		User user = new User();
		user.setPassword(DigestUtil.encrypt(passWord));
		user.setUpdateTime(LocalDateTime.now());
		return this.update(user, Wrappers.<User>update().lambda().in(User::getId, Func.toIntList(userId)));
	}

	@Override
	public List<String> getRoleName(String roleIds) {
		return baseMapper.getRoleName(Func.toStrArray(roleIds));
	}

	@Override
	public List<String> getDeptName(String deptIds) {
		return baseMapper.getDeptName(Func.toStrArray(deptIds));
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public int selectMaxId() {
		return userMapper.selectMaxId();
	}

	@Override
	public int selectByLoginName(String account) {
		return userMapper.selectByLoginName(account);
	}

	@Override
	public boolean insertPer(User user) {
		return userMapper.insertPer(user);
	}
	@Override
	public List<User> selectByPostId(String postId) {
		return userMapper.selectByPostId(postId);
	}

	@Override
	public boolean updatePer(User user) {
		return userMapper.updatePer(user);
	}

	@Override
	public boolean deletePer(String id) {
		return userMapper.deletePer(id);
	}

	@Override
	public User selectByopenId(String openid) {
		return userMapper.selectByopenId(openid);
	}

	@Override
	public void bindDriverOpenId(String account, String openid) {
		userMapper.bindDriverOpenId(account,openid);
	}

	/**
	 * 通过openid获取用户信息
	 * @param openid
	 * @return
	 */
	@Override
	public UserInfo getWeixinUser(String openid) {

		UserInfo userInfo = new UserInfo();
		User user = baseMapper.getWeixinUser(openid);
		userInfo.setUser(user);
		return userInfo;
	}

	@Override
	public User ZFlogin(String account, String password) {
		User user = baseMapper.getZFUser(account, password);
		return user;
	}

	@Override
	public User getZFUserInfo(String type,String userId) {
		User user = baseMapper.getZFUserInfo(type,userId);
		return user;
	}

	@Override
	public boolean updateLocked(Integer isLocked, Integer loginErrorCount, String lastLoginErrorTime, String id) {
		return baseMapper.updateLocked(isLocked, loginErrorCount, lastLoginErrorTime, id);
	}

	@Override
	public User selectByName(String account) {
		return baseMapper.selectByName(account);
	}

	@Override
	public boolean updateUserStatus(Integer updateUser, String updateTime, Integer isDeleted, String[] idss) {
		return baseMapper.updateUserStatus(updateUser, updateTime, isDeleted, idss);
	}

	@Override
	public List<User> selectNameById(String deptId) {
		return baseMapper.selectNameById(deptId);
	}

}
