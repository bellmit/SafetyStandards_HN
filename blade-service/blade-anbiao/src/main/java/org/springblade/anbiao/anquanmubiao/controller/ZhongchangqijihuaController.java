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
package org.springblade.anbiao.anquanmubiao.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.anquanmubiao.entity.Zhongchangqijihua;
import org.springblade.anbiao.anquanmubiao.page.ZhongchangqijihuaPage;
import org.springblade.anbiao.anquanmubiao.service.IZhongchangqijihuaService;
import org.springblade.anbiao.anquanmubiao.vo.ZhongchangqijihuaVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/zhongchangqijihua")
@Api(value = "中长期规划", tags = "中长期规划")
public class ZhongchangqijihuaController extends BladeController {

	private IZhongchangqijihuaService zhongchangqijihuaService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-中长期规划")
	@ApiOperation(value = "详情-中长期规划", notes = "传入id", position = 1)
	public R detail(String id) {
		return R.data(zhongchangqijihuaService.selectByIds(id));
	}

	/**
	 * 分页
	 */
	@PostMapping("/list")
	@ApiLog("分页-中长期规划")
	@ApiOperation(value = "分页-中长期规划", notes = "传入ZhongchangqijihuaPage", position = 2)
	public R<ZhongchangqijihuaPage<ZhongchangqijihuaVO>> list(@RequestBody ZhongchangqijihuaPage Page) {
		ZhongchangqijihuaPage<ZhongchangqijihuaVO> pages = zhongchangqijihuaService.selectPageList(Page);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-中长期规划")
	@ApiOperation(value = "新增-中长期规划", notes = "传入zhongchangqijihua", position = 3)
	public R insert(@RequestBody Zhongchangqijihua zhongchangqijihua,BladeUser user) {
		zhongchangqijihua.setCaozuoren(user.getUserName());
		zhongchangqijihua.setCaozuorenid(user.getUserId());
		zhongchangqijihua.setCaozuoshijian(DateUtil.now());
		zhongchangqijihua.setCreatetime(DateUtil.now());
		return R.status(zhongchangqijihuaService.save(zhongchangqijihua));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-中长期规划")
	@ApiOperation(value = "修改-中长期规划", notes = "传入zhongchangqijihua", position = 4)
	public R update(@RequestBody Zhongchangqijihua zhongchangqijihua,BladeUser user) {
		zhongchangqijihua.setCaozuoren(user.getUserName());
		zhongchangqijihua.setCaozuorenid(user.getUserId());
		zhongchangqijihua.setCaozuoshijian(DateUtil.now());
		if("".equals(zhongchangqijihua.getCreatetime())){
			zhongchangqijihua.setCreatetime(DateUtil.now());
		}
		return R.status(zhongchangqijihuaService.updateById(zhongchangqijihua));
	}

	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-中长期规划")
	@ApiOperation(value = "删除-中长期规划", notes = "传入id", position = 5)
	public R del(@ApiParam(value = "id", required = true) @RequestParam String id) {
		return R.status(zhongchangqijihuaService.updateDel(id));
	}


}
