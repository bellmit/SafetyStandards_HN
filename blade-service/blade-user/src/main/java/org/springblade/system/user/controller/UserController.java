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


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.common.tool.HttpUtils;
import org.springblade.common.tool.TESTOKHttp;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author hyp
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
		R r = new R();
		String msg;
		System.out.println(DigestUtil.encrypt(oldpassWord));
		UserInfo userInfo = userService.userInfo(userId,DigestUtil.encrypt(oldpassWord));
		if(userInfo.getUser()==null){
			r.setSuccess(false);
			r.setMsg("原密码不正确");
			r.setCode(500);
			return r;
		}else{
			boolean temp = userService.updatePassword(userId,passWord);
			if(temp == true){
				r.setSuccess(true);
				r.setMsg("修改成功");
				r.setCode(200);
			}else{
				r.setSuccess(false);
				r.setMsg("修改失败");
				r.setCode(500);
			}
			// 云南
			String ss = TESTOKHttp.interfaceUtil("http://www.zhwlt.cn/api/userInfo/modifyThreePassword",
				"username="+userInfo.getUser().getAccount()+"&oldUserPwd="+oldpassWord+"&newUserPwd="+passWord);
			if(ss == "true"){
				r.setSuccess(true);
				r.setMsg("修改成功");
				r.setCode(200);
			}else{
				r.setSuccess(false);
				r.setMsg("修改失败");
				r.setCode(500);
			}
			return r;
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

	@PostMapping("/updateUserStatus")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "status", value = "账号状态（启用：0，禁用：1，启用：2，删除：1）",required = true),
		@ApiImplicitParam(name = "ids", value = "账号ID串，多个ID以英文逗号隔开", paramType = "query", required = true),
		@ApiImplicitParam(name = "user", value = "当前登录用户对象", required = true)
	})
	@ApiLog("禁用、启用、删除用户账号信息")
	@ApiOperation(value = "禁用、启用、删除用户账号信息", notes = "传入相关参数", position = 10)
	public R updateUserStatus(String status, String ids,BladeUser user) {
		String[] idsss = ids.split(",");
		//去除素组中重复的数组
		List<String> listid = new ArrayList<String>();
		for (int i=0; i<idsss.length; i++) {
			if(!listid.contains(idsss[i])) {
				listid.add(idsss[i]);
			}
		}
		//返回一个包含所有对象的指定类型的数组
		String[] idss= listid.toArray(new String[1]);

		//获取当前日期
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		System.out.println(dateFormat.format(calendar.getTime()));
		String date = dateFormat.format(calendar.getTime());
		Integer updateUser = null;
		if(user == null){
			updateUser = 1;
		}else{
			updateUser = user.getUserId();
		}
		Integer isDeleted = null;
		if("禁用".equals(status)){
			isDeleted = 2;
		}else if("启用".equals(status)){
			isDeleted = 0;
		}else if("删除".equals(status)){
			isDeleted = 1;
		}else{
			isDeleted = 0;
		}
		boolean pages = userService.updateUserStatus(updateUser,date,isDeleted,idss);
		return R.data(pages);
	}

	@PostMapping("/getUserNameById")
	@ApiLog("根据企业ID查询所属下级所有的账号")
	@ApiOperation(value = "根据企业ID查询所属下级所有的账号", notes = "传入deptId", position = 9)
	public R<User> getUserNameById(@ApiParam(value = "deptId", required = true) @RequestParam String deptId) {
		R r = new R();
		List<User> pages = userService.selectNameById(deptId);
		if (pages == null){
			r.setData("暂无数据");
			r.setCode(200);
			r.setData(null);
		}else{
			r.setMsg("获取成功");
			r.setCode(200);
			r.setData(pages);
		}
		return r;
	}

}
