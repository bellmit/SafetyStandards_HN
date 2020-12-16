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
package org.springblade.anbiao.yingjijiuyuan.controller;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.yingjijiuyuan.entity.YingjizhuangbeiWeihu;
import org.springblade.anbiao.yingjijiuyuan.page.YingjizhuangbeiWeihuPage;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjizhuangbeiWeihuService;
import org.springblade.anbiao.yingjijiuyuan.vo.YingjizhuangbeiWeihuVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yingjizhuangbeiweihu")
@Api(value = "应急装备维护", tags = "应急装备维护")
public class YingjizhuangbeiWeihuController extends BladeController {

	private IYingjizhuangbeiWeihuService yingjizhuangbeiWeihuService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-应急装备维护")
	@ApiOperation(value = "详情-应急装备维护", notes = "传入id", position = 1)
	public R detail(String id) {
		return R.data(yingjizhuangbeiWeihuService.getById(id));
	}

	/**
	* 分页
	*/
	@PostMapping("/list")
	@ApiLog("分页-应急装备维护")
	@ApiOperation(value = "分页-应急装备维护", notes = "传入yingjizhuangbeiWeihu", position = 2)
	public R<YingjizhuangbeiWeihuPage<YingjizhuangbeiWeihuVO>> list(@RequestBody YingjizhuangbeiWeihuPage Page) {
		YingjizhuangbeiWeihuPage<YingjizhuangbeiWeihuVO> pages = yingjizhuangbeiWeihuService.selectPageList(Page);
		return R.data(pages);
	}
	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-应急装备维护")
	@ApiOperation(value = "新增-应急装备维护", notes = "传入yingjizhuangbeiWeihu", position = 3)
	public R insert(@RequestBody YingjizhuangbeiWeihu yingjizhuangbeiWeihu,BladeUser user) {
		yingjizhuangbeiWeihu.setCaozuoren(user.getUserName());
		yingjizhuangbeiWeihu.setCaozuorenid(user.getUserId());
		yingjizhuangbeiWeihu.setCaozuoshijian(DateUtil.now());
		yingjizhuangbeiWeihu.setCreatetime(DateUtil.now());
		return R.status(yingjizhuangbeiWeihuService.save(yingjizhuangbeiWeihu));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-应急装备维护")
	@ApiOperation(value = "修改-应急装备维护", notes = "传入yingjizhuangbeiWeihu", position = 4)
	public R update(@RequestBody YingjizhuangbeiWeihu yingjizhuangbeiWeihu,BladeUser user) {
		yingjizhuangbeiWeihu.setCaozuoren(user.getUserName());
		yingjizhuangbeiWeihu.setCaozuorenid(user.getUserId());
		yingjizhuangbeiWeihu.setCaozuoshijian(DateUtil.now());
		return R.status(yingjizhuangbeiWeihuService.updateById(yingjizhuangbeiWeihu));
	}
	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-应急装备维护")
	@ApiOperation(value = "删除-应急装备维护", notes = "传入id", position = 5)
	public R del(@ApiParam(value = "id", required = true) @RequestParam String id) {
		return R.status(yingjizhuangbeiWeihuService.updateDel(id));
	}


}
