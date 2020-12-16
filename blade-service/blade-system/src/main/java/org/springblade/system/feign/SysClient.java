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

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springblade.system.entity.Dept;
import org.springblade.system.entity.Post;
import org.springblade.system.entity.Role;
import org.springblade.system.service.IDeptService;
import org.springblade.system.service.IPostService;
import org.springblade.system.service.IRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统服务Feign实现类
 *
 * @author Chill
 */
@ApiIgnore
@RestController
@AllArgsConstructor
public class SysClient implements ISysClient {

	IDeptService deptService;

	IRoleService roleService;

	IPostService postService;


	@Override
	@GetMapping(API_PREFIX + "/getDeptName")
	public String getDeptName(Integer id) {
		return deptService.getById(id).getDeptName();
	}

	@Override
	@GetMapping(API_PREFIX + "/getDept")
	public Dept getDept(Integer id) {
		return deptService.getById(id);
	}

	@Override
	@GetMapping(API_PREFIX + "/getRoleName")
	public String getRoleName(Integer id) {
		return roleService.getById(id).getRoleName();
	}

	@Override
	@GetMapping(API_PREFIX + "/getRoleAlias")
	public String getRoleAlias(Integer id) {
		return roleService.getById(id).getRoleAlias();
	}

	@Override
	@GetMapping(API_PREFIX + "/getRole")
	public Role getRole(Integer id) {
		return roleService.getById(id);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByJGBM")
	public Dept selectByJGBM(String type, String deptId) {
		return deptService.selectByJGBM(type,deptId);
	}

	@Override
	@PostMapping(API_PREFIX + "/grant")
	public Boolean grant( String postId,  String menuIds) {
		List<String> list1=StrUtil.split(postId,',');
		List<String> list2=StrUtil.split(menuIds,',');
		return postService.grant(list1,list2);
	}

	@Override
	public Boolean ABgrant(String postId, String menuIds) {
		List<String> list1=StrUtil.split(postId,',');
		List<String> list2=StrUtil.split(menuIds,',');
		return postService.ABgrant(list1,list2);
	}

	@Override
	@PostMapping(API_PREFIX + "/ABJurisdiction")
	public Boolean ABJurisdiction(String postId, String menuIds) {
		List<String> list1=StrUtil.split(postId,',');
		List<String> list2=StrUtil.split(menuIds,',');
		return postService.ABJurisdiction(list1,list2);
	}

	@Override
	public Boolean insertPost(@RequestBody Post post) {
		return postService.insertPost(post);
	}

	@Override
	@PostMapping(API_PREFIX + "/insertDept")
	public Boolean insertDept(@RequestBody Dept dept) {
		return deptService.insertDept(dept);
	}

	@Override
	@PostMapping(API_PREFIX + "/updateDept")
	public Boolean updateDept(@RequestBody Dept dept) {
		return deptService.saveOrUpdate(dept);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByTreeCode")
	public Dept selectByTreeCode(String id) {
		return deptService.selectByTreeCode(Integer.parseInt(id));
	}

	@Override
	@GetMapping(API_PREFIX + "/selectById")
	public Dept selectById(String id) {
		return deptService.selectByDeptId(Integer.parseInt(id));
	}

	@Override
	@GetMapping(API_PREFIX + "/selectMaxId")
	public int selectMaxId() {
		return deptService.selectMaxId();
	}

	@Override
	@GetMapping(API_PREFIX + "/selectCountByparentId")
	public int selectCountByparentId(String id) {
		return deptService.selectCountByparentId(Integer.parseInt(id));
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByName")
	public int selectByName(String name) {
		return deptService.selectByName(name);
	}

	@Override
	@GetMapping(API_PREFIX + "/removeById")
	public Boolean removeById(String id) {
		return deptService.removeById(id);
	}

    @Override
	@GetMapping(API_PREFIX + "/getDetpIds")
    public List<Integer> getDetpIds(Integer deptId) {
        return deptService.getDetpIds(deptId);
    }

	@Override
	@GetMapping(API_PREFIX + "/getDeptByName")
	public Dept getDeptByName(String name) {
		return deptService.getDeptByName(name);
	}

	@Override
	@GetMapping(API_PREFIX + "/getByName")
	public List<Dept> getByName(String deptname) {
		return deptService.getByName(deptname);
	}

}
