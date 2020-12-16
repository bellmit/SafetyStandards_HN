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
package org.springblade.manage.settlement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.manage.settlement.page.SettlementPage;
import org.springblade.manage.settlement.service.ISettlementService;
import org.springblade.manage.settlement.vo.SettlementVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/manage/settlement")
@Api(value = "报表管理", tags = "报表管理")
public class SettlementController extends BladeController {

	private ISettlementService settlementService;

	@PostMapping("/list")
	@ApiLog("报表管理-分页")
	@ApiOperation(value = "报表管理-分页", notes = "传入settlementPage", position = 1)
	public R<SettlementPage<SettlementVO>> list(@RequestBody SettlementPage settlementPage) {
//		if(!StrUtil.hasEmpty(settlementPage.getOutTimeStart())){
//			List<String> split=StrSpliter.split(settlementPage.getOutTimeStart(), ',', 0, true, true);
//			settlementPage.setOutTimeStart(split.get(0));
//			settlementPage.setOutTimeEnd(split.get(1));
//		}
		settlementPage.setOrderColumn("zhuanghuoshijian");
		SettlementPage<SettlementVO> pages = settlementService.selectPageList(settlementPage);
		return R.data(pages);
	}

	@PostMapping("/listLirun")
	@ApiLog("对内利润-分页")
	@ApiOperation(value = "对内利润-分页", notes = "传入settlementPage", position = 1)
	public R<SettlementPage<SettlementVO>> listLirun(@RequestBody SettlementPage settlementPage) {
//		if(!StrUtil.hasEmpty(settlementPage.getOutTimeStart())){
//			List<String> split=StrSpliter.split(settlementPage.getOutTimeStart(), ',', 0, true, true);
//			settlementPage.setOutTimeStart(split.get(0));
//			settlementPage.setOutTimeEnd(split.get(1));
//		}
		SettlementPage<SettlementVO> pages = settlementService.selectLirunList(settlementPage);
		return R.data(pages);
	}

	@PostMapping("/listZhiChu")
	@ApiLog("支出-分页")
	@ApiOperation(value = "支出-分页", notes = "传入settlementPage", position = 1)
	public R<SettlementPage<SettlementVO>> listZhiChu(@RequestBody SettlementPage settlementPage) {
//		if(!StrUtil.hasEmpty(settlementPage.getOutTimeStart())){
//			List<String> split=StrSpliter.split(settlementPage.getOutTimeStart(), ',', 0, true, true);
//			settlementPage.setOutTimeStart(split.get(0));
//			settlementPage.setOutTimeEnd(split.get(1));
//		}
		SettlementPage<SettlementVO> pages = settlementService.selectZhiChuList(settlementPage);
		return R.data(pages);
	}
}
