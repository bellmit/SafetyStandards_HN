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
package org.springblade.anbiao.cankaofangan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cankaofangan.entity.Cankaofangan;
import org.springblade.anbiao.cankaofangan.service.ICankaofanganService;
import org.springblade.anbiao.cankaofangan.vo.CankaofanganVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.doc.biaozhunhuamuban.entity.FileParse;
import org.springblade.system.feign.IDictClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 *  控制器
 *
 * @author Blade
 * @since 2019-06-14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cankaofangan")
@Api(value = "参考方案", tags = "参考方案接口")
public class CankaofanganController extends BladeController {

	private ICankaofanganService cankaofanganService;

	private IDictClient dictClient;

	private FileParse fileParse;



	@GetMapping("/getCankaofangan")
	@ApiIgnore
	@ApiLog("参考方案-获取")
	@ApiOperation(value = "获取-参考方案", notes = "传入renwuleixing", position = 3)
	@ApiImplicitParam(name = "renwuleixing", value = "任务类型", required = true)
	public R<List<Cankaofangan>> getCankaofangan(String renwuleixing) {
		List<Cankaofangan> fangan = cankaofanganService.getByRenwuleixing(renwuleixing);

		fangan.forEach(item->{
			item.setPath(fileParse.insertPathToUrl(item.getPath()));
		});
		return R.data(fangan);
	}

	/**
	* 自定义分页
	*/
	@GetMapping("/page")
	@ApiIgnore
	@ApiLog("参考方案-分页")
	@ApiOperation(value = "分页-参考方案", notes = "传入cankaofangan", position = 3)
	public R<IPage<CankaofanganVO>> page(CankaofanganVO cankaofangan, Query query) {
		IPage<CankaofanganVO> pages = cankaofanganService.selectCankaofanganPage(Condition.getPage(query), cankaofangan);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/save")
	@ApiIgnore
	@ApiLog("参考方案-新增")
	@ApiOperation(value = "新增-参考方案", notes = "传入cankaofangan", position = 4)
	public R save(@Valid @RequestBody Cankaofangan cankaofangan) {
		return R.status(cankaofanganService.save(cankaofangan));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiIgnore
	@ApiLog("参考方案-修改")
	@ApiOperation(value = "修改-参考方案", notes = "传入cankaofangan", position = 5)
	public R update(@Valid @RequestBody Cankaofangan cankaofangan) {
		return R.status(cankaofanganService.updateById(cankaofangan));
	}

	/**
	* 新增或修改
	*/
	@PostMapping("/submit")
	@ApiIgnore
	@ApiLog("参考方案-新增或修改")
	@ApiOperation(value = "新增或修改-参考方案", notes = "传入cankaofangan", position = 6)
	public R submit(@Valid @RequestBody Cankaofangan cankaofangan) {
		return R.status(cankaofanganService.saveOrUpdate(cankaofangan));
	}


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiIgnore
	@ApiLog("参考方案-删除")
	@ApiOperation(value = "删除-参考方案", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(cankaofanganService.removeByIds(Func.toIntList(ids)));
	}


}
