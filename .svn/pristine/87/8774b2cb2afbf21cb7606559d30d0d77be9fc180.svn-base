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
package org.springblade.anbiao.ranyoubutie.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.anbiao.ranyoubutie.page.FueltotalreportPage;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.system.feign.IDictClient;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.anbiao.ranyoubutie.entity.Fueltotalreport;
import org.springblade.anbiao.ranyoubutie.vo.FueltotalreportVO;
import org.springblade.anbiao.ranyoubutie.service.IFueltotalreportService;
import org.springblade.core.boot.ctrl.BladeController;


/**
 *  控制器
 *
 * @author jx
 * @since 2019-10-16
 */
@RestController
@RequestMapping("/anbiao/ranyoubutie")
@AllArgsConstructor
@Api(value = "燃油补贴", tags = "燃油补贴")
public class FueltotalreportController extends BladeController {

	private IFueltotalreportService fueltotalreportService;

	@PostMapping("/list")
	@ApiLog("分页-燃油补贴")
	@ApiOperation(value = "分页-燃油补贴", notes = "传入FueltotalreportPage", position = 1)
	public R<FueltotalreportPage<FueltotalreportVO>> list(@RequestBody FueltotalreportPage page) {

		FueltotalreportPage<FueltotalreportVO> fueltotal = fueltotalreportService.selectAllList(page);

		return R.data(fueltotal);
	}

	/**
	* 新增 
	*/
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入fueltotalreport", position = 4)
	public R save(@Valid @RequestBody Fueltotalreport fueltotalreport) {
		return R.status(fueltotalreportService.save(fueltotalreport));
	}

	/**
	* 修改 
	*/
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入fueltotalreport", position = 5)
	public R update(@Valid @RequestBody Fueltotalreport fueltotalreport) {
		return R.status(fueltotalreportService.updateById(fueltotalreport));
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入fueltotalreport", position = 6)
	public R submit(@Valid @RequestBody Fueltotalreport fueltotalreport) {
		return R.status(fueltotalreportService.saveOrUpdate(fueltotalreport));
	}

	
	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(fueltotalreportService.removeByIds(Func.toIntList(ids)));
	}

	
}
