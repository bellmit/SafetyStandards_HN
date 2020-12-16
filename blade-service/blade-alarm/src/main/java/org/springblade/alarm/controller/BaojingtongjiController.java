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
package org.springblade.alarm.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;


import org.springblade.alarm.page.BaojingTJPage;
import org.springblade.alarm.service.IBaojingtongjiService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import org.springblade.core.boot.ctrl.BladeController;

/**
 *  控制器
 * luo
 * @author Blade
 * @since 2019-07-25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/alarm/alarmTongji")
@Api(value = "报警统计接口", tags = "报警统计接口")
public class BaojingtongjiController extends BladeController {

		private IBaojingtongjiService iBaojingtongjiService;


		@PostMapping("ChosuList")
		@ApiLog("超速-统计")
		@ApiOperation(value = "超速-统计-分页", notes = "传入offlinePage", position = 5)
		public  R findAllChaosuPage(@RequestBody BaojingTJPage baojingTJPage){
			BaojingTJPage list=iBaojingtongjiService.selectAll(baojingTJPage);
			return  R.data(list);
		}
		@PostMapping("PilaoList")
		@ApiLog("疲劳-统计-分页")
		@ApiOperation(value = "疲劳-统计-分页", notes = "传入offlinePage", position = 5)
		public R findAllPilaoPage(@RequestBody BaojingTJPage baojingTJPage){
			BaojingTJPage list=iBaojingtongjiService.PilaoAll(baojingTJPage);
			return  R.data(list);

		}
		@PostMapping("alarmCountDay")
		@ApiLog("当日报警统计")
		@ApiOperation(value = "当日报警统计", notes = "传入company 企业名称", position = 5)
	   public R alarmCountDay(@ApiParam(value = "企业名称", required = true)  @RequestParam String company){

			return R.data(iBaojingtongjiService.alarmCount(company));

		}
	@PostMapping("BudingweiList")
	@ApiLog("不定位-统计")
	@ApiOperation(value = "不定位-统计-分页", notes = "BaojingTJPage", position = 5)
	public R budingwei(@RequestBody BaojingTJPage baojingTJPage){
		BaojingTJPage selectbudingwei = iBaojingtongjiService.selectbudingwei(baojingTJPage);
		return R.data(selectbudingwei);
	}
	@PostMapping("BuzaixianList")
	@ApiLog("不在线-统计")
	@ApiOperation(value = "不在线-统计-分页", notes = "BaojingTJPage", position = 5)
	public R buzaixian(@RequestBody BaojingTJPage baojingTJPage){
		BaojingTJPage selectbudingwei = iBaojingtongjiService.selectbuzaixian(baojingTJPage);

		return R.data(selectbudingwei);
	}

}
