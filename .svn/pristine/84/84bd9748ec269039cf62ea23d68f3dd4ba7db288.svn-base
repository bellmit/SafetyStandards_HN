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
package org.springblade.anbiao.richenganpai.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.richenganpai.entity.Richenganpai;
import org.springblade.anbiao.richenganpai.service.IRichenganpaiService;
import org.springblade.anbiao.richenganpai.vo.RichengIndexVo;
import org.springblade.anbiao.richenganpai.vo.RichenganpaiVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.feign.IDictClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 *  控制器
 *
 * @author Blade
 * @since 2019-06-06
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/richenganpai")
@Api(value = "日程安排", tags = "日程安排接口")
public class RichenganpaiController extends BladeController {

	private IRichenganpaiService richenganpaiService;

	private IDictClient dictClient;




	@GetMapping("/richengIndex")
	@ApiLog("日程首页数据-日程安排")
	@ApiOperation(value = "日程首页数据-日程安排", notes = "传入单位id,日期", position = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true),
		@ApiImplicitParam(name = "date", value = "日期(yyyy-MM-dd)", required = true)
	})
	public R<List<RichengIndexVo>> richengIndex(Integer deptId,String date, BladeUser user) {
		List<RichengIndexVo> list= richenganpaiService.selectRichengIndex(deptId,user.getUserId(),date);
		return R.data(list);
	}


	@GetMapping("/getRichengList")
	@ApiLog("获取当天日程-日程安排")
	@ApiOperation(value = "获取当天日程-日程安排", notes = "传入单位id,日期", position = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true),
		@ApiImplicitParam(name = "date", value = "日期(yyyy-MM-dd)", required = true)
	})
	public R<List<RichenganpaiVO>> getRichengList(Integer deptId,String date, BladeUser user) {
		List<RichenganpaiVO> list= richenganpaiService.getByDate(deptId,date,user.getUserId());
		return R.data(list);
	}



	@GetMapping("/getRichengDetail")
	@ApiLog("获取日程详细-日程安排")
	@ApiOperation(value = "获取日程详细-日程安排", notes = "传入id", position = 3)
	@ApiImplicitParam(name = "id", value = "日程id", required = true)
	public R<Richenganpai> getRichengDetail(Integer id) {
		Richenganpai richeng= richenganpaiService.getById(id);
		return R.data(richeng);
	}

	@ApiLog("新增日程-日程安排")
	@PostMapping("/addRicheng")
	@ApiOperation(value = "新增日程-日程安排", notes = "传入日程", position = 3)
	public R<Richenganpai> addRicheng(@RequestBody Richenganpai richen,BladeUser user) {
		richen.setCaozuoren(user.getUserName());
		richen.setCaozuorenid(user.getUserId());
		richen.setCaozuoshijian(DateUtil.now());
	 	richenganpaiService.save(richen);
		return R.success("新增日程成功");
	}



	@PostMapping("/updateRicheng")
	@ApiLog("修改日程-日程安排")
	@ApiOperation(value = "修改日程-日程安排", notes = "传入日程", position = 3)
	public R<Richenganpai> updateRicheng(@RequestBody Richenganpai richen,BladeUser user) {
		richen.setCaozuoren(user.getUserName());
		richen.setCaozuorenid(user.getUserId());
		richen.setCaozuoshijian(DateUtil.now());
		richenganpaiService.updateById(richen);
		return R.success("修改日程成功");
	}




	@GetMapping("/getChaoqiRicheng")
	@ApiLog("获取超期日程-日程安排")
	@ApiOperation(value = "获取超期日程-日程安排", notes = "传入单位id", position = 3)
	@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
	public R<List<RichenganpaiVO>> getChaoqiRicheng(Integer deptId, BladeUser user) {
		List<RichenganpaiVO> list= richenganpaiService.getChaoqiByDate(deptId,user.getUserId());
		return R.data(list);
	}


	@GetMapping("/getAnpaiRicheng")
	@ApiLog("获取当前用户安排的日程-日程安排")
	@ApiOperation(value = "获取当前用户安排的日程-日程安排", notes = "传入单位id", position = 3)
	@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
	public R<List<RichenganpaiVO>> getAnpaiRicheng(Integer deptId, BladeUser user) {
		List<RichenganpaiVO> list= richenganpaiService.getAnpaiByUser(deptId,user.getUserId());
		return R.data(list);
	}








	/**
	* 自定义分页
	*/
	@GetMapping("/page")
	@ApiIgnore
	@ApiLog("分页-日程安排")
	@ApiOperation(value = "分页-日程安排", notes = "传入richenganpai", position = 3)
	public R<IPage<RichenganpaiVO>> page(RichenganpaiVO richenganpai, Query query) {
		IPage<RichenganpaiVO> pages = richenganpaiService.selectRichenganpaiPage(Condition.getPage(query), richenganpai);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/save")
	@ApiIgnore
	@ApiLog("新增-日程安排")
	@ApiOperation(value = "新增-日程安排", notes = "传入richenganpai", position = 4)
	public R save(@Valid @RequestBody Richenganpai richenganpai) {
		return R.status(richenganpaiService.save(richenganpai));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiIgnore
	@ApiLog("修改-日程安排")
	@ApiOperation(value = "修改-日程安排", notes = "传入richenganpai", position = 5)
	public R update(@Valid @RequestBody Richenganpai richenganpai) {
		return R.status(richenganpaiService.updateById(richenganpai));
	}

	/**
	* 新增或修改
	*/
	@PostMapping("/submit")
	@ApiIgnore
	@ApiLog("新增或修改-日程安排")
	@ApiOperation(value = "新增或修改-日程安排", notes = "传入richenganpai", position = 6)
	public R submit(@Valid @RequestBody Richenganpai richenganpai) {
		return R.status(richenganpaiService.saveOrUpdate(richenganpai));
	}


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiIgnore
	@ApiLog("删除-日程安排")
	@ApiOperation(value = "删除-日程安排", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(richenganpaiService.removeByIds(Func.toIntList(ids)));
	}


}
