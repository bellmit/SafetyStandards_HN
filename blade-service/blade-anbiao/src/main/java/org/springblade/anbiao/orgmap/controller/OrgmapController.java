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
package org.springblade.anbiao.orgmap.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.orgmap.entity.Orgmap;
import org.springblade.anbiao.orgmap.service.IOrgmapService;
import org.springblade.anbiao.orgmap.vo.OrgmapVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.StringUtil;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  控制器
 * @author 呵呵哒
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/orgmap")
@Api(value = "组织机构配置", tags = "组织机构配置")
public class OrgmapController extends BladeController {

	private IOrgmapService orgmapService;

	private IFileUploadClient fileUploadClient;

	/**
	 * 获取组织机构树形结构
	 *
	 * @return
	 */
	@GetMapping("/tree")
	@ApiLog("树形结构-组织机构配置")
	@ApiOperation(value = "树形结构-组织机构配置", notes = "树形结构", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
	})
	public R<List<OrgmapVO>> tree(String deptId) {
		//根据所选择树形加载下级数据
		List<OrgmapVO> tree = orgmapService.tree(deptId);
		for (int i = 0; i <tree.size() ; i++) {
			//照片
			if(StrUtil.isNotEmpty(tree.get(i).getPhoto())){
				tree.get(i).setPhoto(fileUploadClient.getUrl(tree.get(i).getPhoto()));
			}
		}
		return R.data(tree);
	}

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-组织机构配置")
	@ApiOperation(value = "详情-组织机构配置", notes = "传入orgmap", position = 2)
	public R<Orgmap> detail(Orgmap orgmap) {
		Orgmap detail = orgmapService.getOne(Condition.getQueryWrapper(orgmap));
		//照片
		if(StrUtil.isNotEmpty(detail.getPhoto())){
			detail.setPhoto(fileUploadClient.getUrl(detail.getPhoto()));
		}
		return R.data(detail);
	}


	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-组织机构配置")
	@ApiOperation(value = "新增-组织机构配置", notes = "传入orgmap", position = 3)
	public R<Orgmap> save(@Valid @RequestBody Orgmap orgmap, BladeUser user) {
		String str="1";
		Orgmap org=new Orgmap();
		String msg;
		//照片
		if(StringUtil.isNotBlank(orgmap.getPhoto())){
			fileUploadClient.updateCorrelation(orgmap.getPhoto(),str);
		}
		orgmap.setUpdateuser(user.getUserName());
		orgmap.setUpdatetime(DateUtil.now());
		orgmap.setCreatetime(DateUtil.now());
		boolean flag=orgmapService.saveOrUpdate(orgmap);
		if(flag==true){
			org=orgmapService.selectByCretaTime(orgmap.getCreatetime(),orgmap.getDeptName());
			msg="操作成功";
		}else{
			msg="操作失败";
		}
		return R.data(org,msg);
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-组织机构配置")
	@ApiOperation(value = "修改-组织机构配置", notes = "传入orgmap", position = 4)
	public R update(@Valid @RequestBody Orgmap orgmap, BladeUser user) {
		String str="1";
		Orgmap org=new Orgmap();
		String msg;
		//照片
		if(StringUtil.isNotBlank(orgmap.getPhoto())){
			fileUploadClient.updateCorrelation(orgmap.getPhoto(),str);
		}
		orgmap.setUpdateuser(user.getUserName());
		orgmap.setUpdatetime(DateUtil.now());
		boolean flag=orgmapService.saveOrUpdate(orgmap);
		if(flag==true){
			org=orgmapService.selectByCretaTime(orgmap.getCreatetime(),orgmap.getDeptName());
			msg="操作成功";
		}else{
			msg="操作失败";
		}
		return R.data(org,msg);
	}
	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiLog("删除-组织机构配置")
	@ApiOperation(value = "删除-组织机构配置", notes = "传入id", position = 5)
	public R remove(@ApiParam(value = "主键id", required = true) @RequestParam Integer id) {
		int i=	orgmapService.Countorg(id);
		int code=201;
		Object obj=new Object();
		String msg;
		if(i>0){
			msg="还存在下级，不能删除";
		}else{
			orgmapService.removeById(id);
			msg="操作成功";
		}
		return R.data(code,obj,msg);
	}

}
