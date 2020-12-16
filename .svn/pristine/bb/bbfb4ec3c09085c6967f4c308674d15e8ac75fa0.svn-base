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
package org.springblade.system.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springblade.system.entity.Dept;
import org.springblade.system.entity.Post;
import org.springblade.system.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Feign接口类
 *
 * @author Chill
 */
@FeignClient(
	value = AppConstant.APPLICATION_SYSTEM_NAME,
	fallback = ISysClientFallback.class
)
public interface ISysClient {

	String API_PREFIX = "/sys";

	/**
	 * 获取部门名
	 *
	 * @param id 主键
	 * @return 部门名
	 */
	@GetMapping(API_PREFIX + "/getDeptName")
	String getDeptName(@RequestParam("id") Integer id);

	/**
	 * 获取部门
	 *
	 * @param id 主键
	 * @return Dept
	 */
	@GetMapping(API_PREFIX + "/getDept")
	Dept getDept(@RequestParam("id") Integer id);

	/**
	 * 获取角色名
	 *
	 * @param id 主键
	 * @return 角色名
	 */
	@GetMapping(API_PREFIX + "/getRoleName")
	String getRoleName(@RequestParam("id") Integer id);

	/**
	 * 获取角色别名
	 *
	 * @param id 主键
	 * @return 角色别名
	 */
	@GetMapping(API_PREFIX + "/getRoleAlias")
	String getRoleAlias(@RequestParam("id") Integer id);

	/**
	 * 获取角色
	 *
	 * @param id 主键
	 * @return Role
	 */
	@GetMapping(API_PREFIX + "/getRole")
	Role getRole(@RequestParam("id") Integer id);

	/**
	 * 根据传值岗位id 类型 获取直属上级信息
	 * @param type
	 * @param deptId
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByJGBM")
	Dept selectByJGBM(@RequestParam("type") String type,@RequestParam("deptId") String deptId);

	/**
	 * 赋权
	 * @param postId
	 * @param menuIds
	 * @return
	 */
	@PostMapping(API_PREFIX + "/grant")
	Boolean grant(@RequestParam("postId")  String postId,@RequestParam("menuIds")  String menuIds);
	/**
	 * 赋权
	 * @param postId
	 * @param menuIds
	 * @return
	 */
	@PostMapping(API_PREFIX + "/ABgrant")
	Boolean ABgrant(@RequestParam("postId")  String postId,@RequestParam("menuIds")  String menuIds);
	/**
	 * 安标16项权限设置
	 * @param postId
	 * @param menuIds
	 * @return
	 */
	@PostMapping(API_PREFIX + "/ABJurisdiction")
	Boolean ABJurisdiction(@RequestParam("postId")  String postId,@RequestParam("menuIds")  String menuIds);
	/**
	 * 设置默认岗位
	 * @param post
	 * @return
	 */
	@PostMapping(API_PREFIX + "/savePost")
	Boolean insertPost(@Valid @RequestBody Post post);

	/**
	 * 自定义新增 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param dept
	 * @return
	 */
	@PostMapping(API_PREFIX + "/insertDept")
	Boolean insertDept(@Valid @RequestBody Dept dept);

	/**
	 * 自定义编辑 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param dept
	 * @return
	 */
	@PostMapping(API_PREFIX + "/updateDept")
	Boolean updateDept(@Valid @RequestBody Dept dept);

	/**
	 * 根据上级id查询treecode
	 * @param id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByTreeCode")
	Dept selectByTreeCode(@RequestParam("id") String id);

	/**
	 * 根据单位id获取数据
	 * @param id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectById")
	Dept selectById(@RequestParam("id") String id);

	/**
	 * 获取当前最大单位id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectMaxId")
	int selectMaxId();

	/**
	 * 获取当前最大单位id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectCountByparentId")
	int selectCountByparentId(@RequestParam("id") String id);

	/**
	 * 根据名称查询是否已存在
	 * @param name
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByName")
	int selectByName(@RequestParam("name") String name);

	/**
	 * 根据名称查询是否已存在
	 * @param id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/removeById")
	Boolean removeById(@RequestParam("id") String id);

	/**
	 *获取下级deptid
	 * @author: th
	 * @date: 2019/10/28 13:51
	 * @param deptId
	 * @return: java.util.List<java.lang.Integer>
	 */
	@GetMapping(API_PREFIX + "/getDetpIds")
    List<Integer> getDetpIds(@RequestParam("deptId")Integer deptId);

	/**
	 * 根据机构名称获取机构信息
	 * @param name
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getDeptByName")
	Dept getDeptByName(@RequestParam("name") String name);

	@GetMapping(API_PREFIX + "/getByName")
	List<Dept> getByName(@RequestParam("deptname") String deptname);
}
