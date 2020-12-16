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
package org.springblade.app.yingjichuzhi.controller;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.app.yingjichuzhi.entity.Yingjichuzhi;
import org.springblade.app.yingjichuzhi.page.YingjichuzhiPage;
import org.springblade.app.yingjichuzhi.service.IYingjichuzhiService;
import org.springblade.app.yingjichuzhi.vo.YingjichuzhiVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  应急处置 - 控制器
 *
 * @author jx
 * @since 2019-05-06
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/yingjichuzhi")
@Api(value = "应急处置", tags = "应急处置")
public class YingjichuzhiController extends BladeController {

	private IYingjichuzhiService yingjichuzhiService;


	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-应急处置")
	@ApiOperation(value = "详情-应急处置", notes = "传入yingjichuzhi", position = 1)
	public R<Yingjichuzhi> detail(Yingjichuzhi yingjichuzhi) {
		Yingjichuzhi detail = yingjichuzhiService.getOne(Condition.getQueryWrapper(yingjichuzhi));
		//YingjichuzhiWrapper yingjichuzhiWrapper = new YingjichuzhiWrapper(dictClient);
		return R.data(detail);
	}

	/**
	* 分页
	*/
/*	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入yingjichuzhi", position = 2)
	public R<IPage<YingjichuzhiVO>> list(Yingjichuzhi yingjichuzhi, Query query) {
		IPage<Yingjichuzhi> pages = yingjichuzhiService.page(Condition.getPage(query), Condition.getQueryWrapper(yingjichuzhi));

		return R.data(yingjichuzhiWrapper.pageVO(pages));
	}*/

	/**
	* 自定义分页
	*/
	@PostMapping("/list")
	@ApiLog("列表-应急处置")
	@ApiOperation(value = "列表-应急处置", notes = "传入yingjichuzhiPage", position = 2)
	public R<YingjichuzhiPage<YingjichuzhiVO>> list(@RequestBody YingjichuzhiPage yingjichuzhiPage) {
		YingjichuzhiPage<YingjichuzhiVO> pages = yingjichuzhiService.selectYingjichuzhiPage(yingjichuzhiPage);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/save")
	@ApiLog("新增-应急处置")
	@ApiOperation(value = "新增-应急处置", notes = "传入yingjichuzhi", position = 3)
	public R save(@Valid @RequestBody Yingjichuzhi yingjichuzhi, BladeUser user) {
		yingjichuzhi.setCaozuoren(user.getUserName());
		yingjichuzhi.setCaozuorenid(user.getUserId());
		yingjichuzhi.setCaozuoshijian(DateUtil.now());
		yingjichuzhi.setCreatetime(DateUtil.now());
		return R.status(yingjichuzhiService.save(yingjichuzhi));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-应急处置")
	@ApiOperation(value = "修改-应急处置", notes = "传入yingjichuzhi", position = 4)
	public R update(@Valid @RequestBody Yingjichuzhi yingjichuzhi) {
		return R.status(yingjichuzhiService.updateById(yingjichuzhi));
	}

	/**
	* 新增或修改
	*/
	@PostMapping("/submit")
	@ApiLog("新增或修改-应急处置")
	@ApiOperation(value = "新增或修改-应急处置", notes = "传入yingjichuzhi", position = 5)
	public R submit(@Valid @RequestBody Yingjichuzhi yingjichuzhi) {
		return R.status(yingjichuzhiService.saveOrUpdate(yingjichuzhi));
	}


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiLog("删除-应急处置")
	@ApiOperation(value = "删除-应急处置", notes = "传入ids", position = 6)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(yingjichuzhiService.removeByIds(Func.toStrList(ids)));
	}


}
