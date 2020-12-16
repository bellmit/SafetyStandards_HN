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
package org.springblade.system.controller;

import io.swagger.annotations.*;
import io.undertow.server.session.Session;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.support.Kv;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.entity.Menu;
import org.springblade.system.entity.Post;
import org.springblade.system.feign.IDictClient;
import org.springblade.system.service.IMenuService;
import org.springblade.system.service.IPostService;
import org.springblade.system.vo.MenuVO;
import org.springblade.system.wrapper.MenuWrapper;
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
@RequestMapping("/menu")
@Api(value = "菜单", tags = "菜单")
public class MenuController extends BladeController {

	private IMenuService menuService;

	private IDictClient dictClient;

	private IPostService postService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入menu", position = 1)
	public R<MenuVO> detail(Menu menu) {
		Menu detail = menuService.getOne(Condition.getQueryWrapper(menu));
		MenuWrapper menuWrapper = new MenuWrapper(menuService, dictClient);
		return R.data(menuWrapper.entityVO(detail));
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "菜单编号", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "name", value = "菜单名称", paramType = "query", dataType = "string")
	})
	@ApiOperation(value = "列表", notes = "传入menu", position = 2)
	public R<List<MenuVO>> list(String code,String name) {
		Menu menu=new Menu();
		menu.setCode(code);
		menu.setName(name);
		menu.setType("0");
		List<Menu> list = menuService.selectAllList(menu);
		MenuWrapper menuWrapper = new MenuWrapper(menuService, dictClient);
		return R.data(menuWrapper.listNodeVO(list));
	}

	/**
	 * 前端菜单数据
	 */
	@GetMapping("/routes")
	@ApiOperation(value = "前端菜单数据", notes = "前端菜单数据", position = 3)
	@ApiImplicitParams({ @ApiImplicitParam(name = "postId", value = "岗位id") })
	public R<List<MenuVO>> routes(BladeUser user,String postId) {
		List<MenuVO> list;
		if(postId!=null){
			list = menuService.routes(postId);
		}else{
			list = menuService.routes(user.getRoleName());
		}
		return R.data(list);
	}

	/**
	 * 前端按钮数据
	 */
	@GetMapping("/buttons")
	@ApiOperation(value = "前端按钮数据", notes = "前端按钮数据", position = 4)
	@ApiImplicitParams({ @ApiImplicitParam(name = "postId", value = "岗位id") })
	public R<List<MenuVO>> buttons(BladeUser user,String postId) {
		List<MenuVO> list;
		if(postId!=null){
			list = menuService.buttons(postId);
		}else{
			list = menuService.buttons(user.getRoleName());
		}
		return R.data(list);
	}

	/**
	 * 获取菜单树形结构
	 */
	@GetMapping("/tree")
	@ApiOperation(value = "树形结构", notes = "树形结构", position = 5)
	public R<List<MenuVO>> tree() {
		List<MenuVO> tree = menuService.tree();
		return R.data(tree);
	}

	/**
	 * 获取权限分配树形结构
	 */
	@GetMapping("/grant-tree")
	@ApiOperation(value = "权限分配树形结构", notes = "权限分配树形结构", position = 6)
	public R<List<MenuVO>> grantTree(BladeUser user) {
		return R.data(menuService.grantTree(user));
	}

	/**
	 * 获取权限分配树形结构
	 */
	@GetMapping("/role-tree-keys")
	@ApiOperation(value = "角色所分配的树", notes = "角色所分配的树", position = 7)
	public R<List<String>> roleTreeKeys(String postId) {
		return R.data(menuService.postTreeKeys(postId));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入menu", position = 8)
	public R submit(@Valid @RequestBody Menu menu) {
		menu.setType("0");
		return R.status(menuService.saveOrUpdate(menu));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 9)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(menuService.removeByIds(Func.toIntList(ids)));
	}

	/**
	 * 获取配置的角色权限
	 */
	@GetMapping("auth-routes")
	@ApiOperation(value = "菜单的角色权限", position = 8)
	public R<List<Kv>> authRoutes(BladeUser user) {
		return R.data(menuService.authRoutes(user));
	}



	//***********************安标************************************


	/**
	 * 列表
	 */
	@GetMapping("/listAB")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "菜单编号", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "name", value = "菜单名称", paramType = "query", dataType = "string")
	})
	@ApiOperation(value = "安标列表", notes = "传入menu", position = 9)
	public R<List<MenuVO>> listAB(@ApiIgnore @RequestParam Map<String, Object> menu) {
		menu.put("type",1);
		//删除不需要的参数
		menu.remove("deptId");
		List<Menu> list = menuService.list(Condition.getQueryWrapper(menu, Menu.class).lambda().orderByAsc(Menu::getSort));
		MenuWrapper menuWrapper = new MenuWrapper(menuService, dictClient);
		return R.data(menuWrapper.listNodeVO(list));
	}

	/**
	 * 前端菜单数据
	 */
	@GetMapping("/ABroutes")
	@ApiOperation(value = "前端菜单数据(安标)", notes = "前端菜单数据", position = 10)
	@ApiImplicitParams({ @ApiImplicitParam(name = "postId", value = "岗位id") })
	public R<List<MenuVO>> ABroutes(BladeUser user,String postId) {
		List<MenuVO> list;
		if(postId!=null){
			list = menuService.ABroutes(postId);
		}else{
			list = menuService.ABroutes(user.getRoleName());
		}
		return R.data(list);
	}

	/**
	 * 前端按钮数据
	 */
	@GetMapping("/ABbuttons")
	@ApiOperation(value = "前端按钮数据(安标)", notes = "前端按钮数据", position = 11)
	@ApiImplicitParams({ @ApiImplicitParam(name = "postId", value = "岗位id") })
	public R<List<MenuVO>> ABbuttons(BladeUser user,String postId) {
		List<MenuVO> list;
		if(postId!=null){
			list = menuService.ABbuttons(postId);
		}else{
			list = menuService.ABbuttons(user.getRoleName());
		}
		return R.data(list);
	}

	/**
	 * 获取菜单树形结构
	 */
	@GetMapping("/ABtree")
	@ApiOperation(value = "树形结构(安标)", notes = "树形结构", position = 12)
	public R<List<MenuVO>> ABtree() {
		List<MenuVO> tree = menuService.ABtree();
		return R.data(tree);
	}



	/**
	 * 新增或修改
	 */
	@PostMapping("/submitAB")
	@ApiOperation(value = "新增或修改(安标)", notes = "传入menu", position = 15)
	public R submitAB(@Valid @RequestBody Menu menu) {
		menu.setType("1");
		return R.status(menuService.saveOrUpdate(menu));
	}

	/**
	 * 获取配置的角色权限
	 */
	@GetMapping("ABauthRoutes")
	@ApiOperation(value = "菜单的角色权限(安标)", position = 16)
	public R<List<Kv>> ABauthRoutes(BladeUser user) {
		return R.data(menuService.ABauthRoutes(user));
	}

}
