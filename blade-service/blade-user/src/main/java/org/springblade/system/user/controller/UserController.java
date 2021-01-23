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
package org.springblade.system.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.BladeConstant;
import org.springblade.core.tool.utils.DigestUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.feign.IDictClient;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.page.UserPage;
import org.springblade.system.user.service.IUserService;
import org.springblade.system.user.vo.UserVO;
import org.springblade.system.user.wrapper.UserWrapper;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "人员", tags = "人员")
public class UserController  {

	private IUserService userService;

	private IDictClient dictClient;

	/**
	 * 查询单条
	 */
	@ApiOperation(value = "查看详情", notes = "传入id", position = 1)
	@GetMapping("/detail")
	public R<UserVO> detail(User user) {
		User detail = userService.getOne(Condition.getQueryWrapper(user));
		UserWrapper userWrapper = new UserWrapper(userService, dictClient);
		return R.data(userWrapper.entityVO(detail));
	}

	/**
	 * 根据单位id获取人员数据
	 */
	@ApiOperation(value = "根据单位id获取人员数据", notes = "传入deptId", position = 1)
	@GetMapping("/selectByDeptId")
	public R<List<User>> selectByDeptId(String deptId) {
		List<User> list = userService.selectByDeptId(deptId);
		return R.data(list);
	}

	/**
	 * 用户列表
	 */
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "account", value = "账号名", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "realName", value = "姓名", paramType = "query", dataType = "string")
	})
	@ApiOperation(value = "列表", notes = "传入account和realName", position = 2)
	public R<IPage<UserVO>> list(@ApiIgnore @RequestParam Map<String, Object> user, Query query, BladeUser bladeUser) {
		QueryWrapper<User> queryWrapper = Condition.getQueryWrapper(user, User.class);
		IPage<User> pages = userService.page(Condition.getPage(query), (!bladeUser.getTenantCode().equals(BladeConstant.ADMIN_TENANT_CODE)) ? queryWrapper.lambda().eq(User::getTenantCode, bladeUser.getTenantCode()) : queryWrapper);
		UserWrapper userWrapper = new UserWrapper(userService, dictClient);
		return R.data(userWrapper.pageVO(pages));
	}

	/**
	 * 新增
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增", notes = "传入User", position = 3)
	public R submit(@Valid @RequestBody User user) {
		if (Func.isNotEmpty(user.getPassword())) {
			user.setPassword(DigestUtil.encrypt(user.getPassword()));
		}
		return R.status(userService.saveOrUpdate(user));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入User", position = 3)
	public R update(@Valid @RequestBody User user) {
		return R.status(userService.updateById(user));
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入userId集合", position = 4)
	public R remove(@RequestParam String ids) {
		return R.status(userService.deleteLogic(Func.toIntList(ids)));
	}

	@PostMapping("/reset-password")
	@ApiLog("初始化密码")
	@ApiOperation(value = "初始化密码", notes = "传入userId集合", position = 5)
	public R resetPassword(@ApiParam(value = "userId集合", required = true) @RequestParam String userIds) {
		boolean temp = userService.resetPassword(userIds);
		return R.status(temp);
	}

	@PostMapping("/update-password")
	@ApiLog("密码修改")
	@ApiOperation(value = "密码修改", notes = "传入userId与新就密码值", position = 6)
	public R updatePassword(BladeUser bladeUser,@ApiParam(value = "userId", required = true) @RequestParam String userId,
							@ApiParam(value = "passWord", required = true) @RequestParam String passWord,
							@ApiParam(value = "oldpassWord", required = true) @RequestParam String oldpassWord) {
		String msg;
		System.out.println(DigestUtil.encrypt(oldpassWord));
		UserInfo userInfo = userService.userInfo(userId,DigestUtil.encrypt(oldpassWord));
		if(userInfo.getUser()==null){
			msg="原密码不正确";
			return R.fail(msg);
		}else{
			boolean temp = userService.updatePassword(userId,passWord);
			return R.status(temp);
		}
	}

	@PostMapping("/userlist")
	@ApiLog("分页-人员资料管理")
	@ApiOperation(value = "分页-人员资料管理", notes = "传入userPage", position = 7)
	public R<UserPage<User>> userlist(@RequestBody UserPage userPage) {
		UserPage<User> pages = userService.selectUserByPage(userPage);
		return R.data(pages);
	}

	@PostMapping("/getUserByName")
	@ApiLog("根据用户名查询账号信息")
	@ApiOperation(value = "根据用户名查询账号信息", notes = "传入name", position = 8)
	public R<User> getUserByName(@ApiParam(value = "name", required = true) @RequestParam String name) {
		User pages = userService.selectByName(name);
		return R.data(pages);
	}

	@PostMapping("/updateLocked")
	@ApiLog("登录失败更新锁定机制")
	@ApiOperation(value = "登录失败更新锁定机制", notes = "传入相关参数", position = 9)
	public R updateLocked(String id, Integer isLocked, Integer loginErrorcount, String lastLoginErrorTime) {
		boolean pages = userService.updateLocked(isLocked,loginErrorcount,lastLoginErrorTime,id);
		return R.data(pages);
	}

}
