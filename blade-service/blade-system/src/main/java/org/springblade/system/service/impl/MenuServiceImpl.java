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
package org.springblade.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.constant.BladeConstant;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springblade.core.tool.support.Kv;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.dto.MenuDTO;
import org.springblade.system.entity.Menu;
import org.springblade.system.entity.PostMenu;
import org.springblade.system.mapper.MenuMapper;
import org.springblade.system.service.IMenuService;
import org.springblade.system.service.IPostMenuService;
import org.springblade.system.service.IPostService;
import org.springblade.system.service.IRoleMenuService;
import org.springblade.system.vo.MenuVO;
import org.springblade.system.wrapper.MenuWrapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Service
@AllArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	IRoleMenuService roleMenuService;

	IPostService postService;

	IPostMenuService postMenuService;

	private MenuMapper menuMapper;


	@Override
	public IPage<MenuVO> selectMenuPage(IPage<MenuVO> page, MenuVO menu) {
		return page.setRecords(baseMapper.selectMenuPage(page, menu));
	}

	@Override
	public List<Menu> selectAllList(Menu menu) {
		return menuMapper.selectAllList(menu);
	}

	@Override
	public List<MenuVO> routes(String roleId) {
		List<Menu> allMenus = baseMapper.allMenu();
		List<Menu> roleMenus = baseMapper.roleMenu(Func.toIntList(roleId));
		List<Menu> routes = new LinkedList<>(roleMenus);
		roleMenus.forEach(roleMenu -> recursion(allMenus, routes, roleMenu));
		routes.sort(Comparator.comparing(Menu::getSort));
		MenuWrapper menuWrapper = new MenuWrapper();
		List<Menu> collect = routes.stream().filter(x -> Func.equals(x.getCategory(), 1)).collect(Collectors.toList());
		return menuWrapper.listNodeVO(collect);
	}

	public void recursion(List<Menu> allMenus, List<Menu> routes, Menu roleMenu) {
		Optional<Menu> menu = allMenus.stream().filter(x -> Func.equals(x.getId(), roleMenu.getParentId())).findFirst();
		if (menu.isPresent() && !routes.contains(menu.get())) {
			routes.add(menu.get());
			recursion(allMenus, routes, menu.get());
		}
	}

	@Override
	public List<MenuVO> buttons(String roleId) {
		List<Menu> buttons = baseMapper.buttons(Func.toIntList(roleId));
		MenuWrapper menuWrapper = new MenuWrapper();
		return menuWrapper.listNodeVO(buttons);
	}

	@Override
	public List<MenuVO> tree() {
		return ForestNodeMerger.merge(baseMapper.tree());
	}

	@Override
	public List<MenuVO> grantTree(BladeUser user) {
		String postId=user.getRoleName();
		return ForestNodeMerger.merge(user.getTenantCode().equals(BladeConstant.ADMIN_TENANT_CODE) ? baseMapper.grantTree() : baseMapper.grantTreeByPost(Func.toIntList(postId)));
	}

	@Override
	public List<String> postTreeKeys(String postId) {
		List<PostMenu> postMenus = postMenuService.selectListByPostId(Integer.parseInt(postId),0);
		return postMenus.stream().map(postMenu -> Func.toStr(postMenu.getMenuId())).collect(Collectors.toList());
	}

	@Override
	public List<Kv> authRoutes(BladeUser user) {
		if (Func.isEmpty(user)) {
			return null;
		}
		List<MenuDTO> routes = baseMapper.authRoutes(Func.toIntList(user.getRoleId()));
		List<Kv> list = new ArrayList<>();
		routes.forEach(route -> list.add(Kv.init().set(route.getPath(), Kv.init().set("authority", Func.toStrArray(route.getAlias())))));
		return list;
	}
	//***************安标*************************//

	@Override
	public IPage<MenuVO> selectABMenuPage(IPage<MenuVO> page, MenuVO menu) {
		return page.setRecords(baseMapper.selectABMenuPage(page, menu));
	}

	@Override
	public List<MenuVO> ABroutes(String roleId) {
		List<Menu> allMenus = baseMapper.ABallMenu();
		List<Menu> roleMenus = baseMapper.ABroleMenu(Func.toIntList(roleId));
		List<Menu> routes = new LinkedList<>(roleMenus);
		roleMenus.forEach(roleMenu -> recursion(allMenus, routes, roleMenu));
		routes.sort(Comparator.comparing(Menu::getSort));
		MenuWrapper menuWrapper = new MenuWrapper();
		List<Menu> collect = routes.stream().filter(x -> Func.equals(x.getCategory(), 1)).collect(Collectors.toList());
		return menuWrapper.listNodeVO(collect);
	}

	@Override
	public List<MenuVO> ABbuttons(String roleId) {
		List<Menu> buttons = baseMapper.ABbuttons(Func.toIntList(roleId));
		MenuWrapper menuWrapper = new MenuWrapper();
		return menuWrapper.listNodeVO(buttons);
	}

	@Override
	public List<MenuVO> ABtree() {
		return ForestNodeMerger.merge(baseMapper.ABtree());
	}

	@Override
	public List<MenuVO> ABgrantTree(BladeUser user) {
		String postId=user.getRoleName();
		return ForestNodeMerger.merge(user.getTenantCode().equals(BladeConstant.ADMIN_TENANT_CODE) ? baseMapper.ABgrantTree() : baseMapper.ABgrantTreeByPost(Func.toIntList(postId)));
	}

	@Override
	public List<String> ABpostTreeKeys(String postId) {
		List<PostMenu> postMenus = postMenuService.selectListByPostId(Integer.parseInt(postId),1);
		return postMenus.stream().map(postMenu -> Func.toStr(postMenu.getMenuId())).collect(Collectors.toList());
	}

	@Override
	public List<Kv> ABauthRoutes(BladeUser user) {
		if (Func.isEmpty(user)) {
			return null;
		}
		List<MenuDTO> routes = baseMapper.ABauthRoutes(Func.toIntList(user.getRoleId()));
		List<Kv> list = new ArrayList<>();
		routes.forEach(route -> list.add(Kv.init().set(route.getPath(), Kv.init().set("authority", Func.toStrArray(route.getAlias())))));
		return list;
	}
	//***********业务权限 展板控制//
	@Override
	public List<MenuVO> Businesstree(BladeUser user) {
		return ForestNodeMerger.merge(baseMapper.Businesstree());
	}

	@Override
	public List<String> BusinessgrantTreeByPost(String postId) {
		List<PostMenu> postMenus = postMenuService.selectListByPostIdBusiness(Integer.parseInt(postId),3);
		return postMenus.stream().map(postMenu -> Func.toStr(postMenu.getMenuId())).collect(Collectors.toList());
	}
	/**
	* @Description: 手机APP
	* @Param: [user]
	* @return: java.util.List<org.springblade.system.vo.MenuVO>
	*/
	@Override
	public List<MenuVO> Apptree(BladeUser user) { return ForestNodeMerger.merge(baseMapper.Apptree()); }

	@Override
	public List<String> AppgrantTreeByPost(String postId) {
		List<PostMenu> postMenus = postMenuService.selectListByPostIdApp(Integer.parseInt(postId),4);
		return postMenus.stream().map(postMenu -> Func.toStr(postMenu.getMenuId())).collect(Collectors.toList());
	}


}
