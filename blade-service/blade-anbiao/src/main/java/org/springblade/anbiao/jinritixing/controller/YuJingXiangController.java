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
package org.springblade.anbiao.jinritixing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.jinritixing.entity.Yujingxiang;
import org.springblade.anbiao.jinritixing.service.IYuJingXiangService;
import org.springblade.anbiao.qiyeshouye.page.YuJingXiangPage;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

/**
 *  预警项
 * @author hyp
 * @since 2020-11-12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yuJingXiang")
@Api(value = "预警项", tags = "预警项")
public class YuJingXiangController extends BladeController {

	private IYuJingXiangService iYuJingXiangService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-预警项")
	@ApiOperation(value = "详情-预警项", notes = "传入id", position = 1)
	public R detail(String id) {
		return R.data(iYuJingXiangService.selectGetQYByOne(id));
	}

	/**
	* 自定义分页
	*/
	@PostMapping("/getList")
	@ApiLog("分页-预警项")
	@ApiOperation(value = "分页-预警项", notes = "传入yuJingXiangPage", position = 2)
	public R<YuJingXiangPage<Yujingxiang>> getList(@RequestBody YuJingXiangPage yuJingXiangPage) {
		YuJingXiangPage<Yujingxiang> pages = iYuJingXiangService.selectGetYJListTJ(yuJingXiangPage);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-预警项")
	@ApiOperation(value = "新增-预警项", notes = "传入yujingxiang", position = 3)
	public R insert(@RequestBody Yujingxiang yujingxiang) {
		return R.status(iYuJingXiangService.insertSelective(yujingxiang));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-预警项")
	@ApiOperation(value = "修改-预警项", notes = "传入yujingxiang", position = 4)
	public R update(@RequestBody Yujingxiang yujingxiang) {
		return R.status(iYuJingXiangService.updateByPrimaryKeySelective(yujingxiang));
	}

	/**
	* 删除
	*/
//	@PostMapping("/del")
//	@ApiLog("删除-今日提醒")
//	@ApiOperation(value = "删除-今日提醒", notes = "传入id", position = 5)
//	public R del(@ApiParam(value = "id", required = true) @RequestParam String id) {
//		return R.status(jinritixingService.updateDel(id));
//	}

}
