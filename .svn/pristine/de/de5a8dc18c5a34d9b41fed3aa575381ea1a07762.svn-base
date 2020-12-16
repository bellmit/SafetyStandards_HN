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
import lombok.AllArgsConstructor;

import org.springblade.anbiao.ranyoubutie.page.GpsfuelvehPage;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import org.springblade.anbiao.ranyoubutie.service.IGpsfuelvehService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.Map;

/**
 *  控制器
 *
 * @author jx
 * @since 2019-10-20
 */
@RestController
@RequestMapping("/anbiao/ranyoubutiexiangqing")
@AllArgsConstructor
@Api(value = "燃油补贴详情", tags = "燃油补贴详情")
public class GpsfuelvehController extends BladeController {

	private IGpsfuelvehService gpsfuelvehService;

	//private IDictClient dictClient;



	/**
	* 分页 
	*/
	/*@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入gpsfuelveh", position = 2)
	public R<IPage<GpsfuelvehVO>> list(Gpsfuelveh gpsfuelveh, Query query) {
		IPage<Gpsfuelveh> pages = gpsfuelvehService.page(Condition.getPage(query), Condition.getQueryWrapper(gpsfuelveh));
		GpsfuelvehWrapper gpsfuelvehWrapper = new GpsfuelvehWrapper(dictClient);
		return R.data(gpsfuelvehWrapper.pageVO(pages));
	}*/

	/**
	 * 存储过程分页
	 * @param page
	 * @return
	 */
	@PostMapping("/list")
	@ApiLog("分页-燃油补贴详情")
	@ApiOperation(value = "存储过程分页", notes = "传入GpsfuelvehPage", position = 1)
	public R<GpsfuelvehPage<Map<String, Object>>> list(@RequestBody GpsfuelvehPage page){
		gpsfuelvehService.selectPageList(page);
		return R.data(page);
	}

	@PostMapping("/page")
	@ApiLog("分页-燃油补贴详情")
	@ApiOperation(value = "自定义分页", notes = "传入GpsfuelvehPage", position = 2)
	public R<GpsfuelvehPage<Map<String, Object>>> page(@RequestBody GpsfuelvehPage page){
		GpsfuelvehPage  list = gpsfuelvehService.selectAllList(page);
		list.setSql(null);
		return R.data(list);
	}








	
}
