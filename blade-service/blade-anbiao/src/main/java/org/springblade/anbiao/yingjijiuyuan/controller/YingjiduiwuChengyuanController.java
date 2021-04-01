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
import org.springblade.anbiao.yingjijiuyuan.entity.YingjiduiwuChengyuan;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjiduiwuChengyuanService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应急救援-应急队伍-队伍成员 控制器
 *
 * @author hyp
 * @since 2019-04-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yingjiduiwuchengyuan")
@Api(value = "应急救援-应急队伍-队伍成员", tags = "应急救援-应急队伍-队伍成员")
public class YingjiduiwuChengyuanController {

    private IYingjiduiwuChengyuanService yingjiduiwuChengyuanService;

    @PostMapping("/list")
	@ApiLog("根据应急队伍id获取队伍成员-队伍成员")
    @ApiOperation(value = "根据应急队伍id获取队伍成员", notes = "传入队伍id", position = 1)
    public R<List<YingjiduiwuChengyuan>> list(@RequestParam String id) {
        return R.data(yingjiduiwuChengyuanService.selectByDuiwuId(id));
    }

    @GetMapping("/detail")
	@ApiLog("查看详情-队伍成员")
    @ApiOperation(value = "查看详情-队伍成员", notes = "传入id", position = 2)
    public R<YingjiduiwuChengyuan> detail(String id) {
        YingjiduiwuChengyuan detail = yingjiduiwuChengyuanService.getById(id);
        return R.data(detail);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
	@ApiLog("新增-队伍成员")
    @ApiOperation(value = "新增-队伍成员", notes = "传入yingjiduiwuChengyuan", position = 3)
    public R insert(@RequestBody YingjiduiwuChengyuan yingjiduiwuChengyuan, BladeUser user) {
		yingjiduiwuChengyuan.setCaozuoren(user.getUserName());
		yingjiduiwuChengyuan.setCaozuorenid(user.getUserId());
		yingjiduiwuChengyuan.setCaozuoshijian(DateUtil.now());
		yingjiduiwuChengyuan.setCreatetime(DateUtil.now());
        return R.status(yingjiduiwuChengyuanService.save(yingjiduiwuChengyuan));
    }

    @PostMapping("/update")
	@ApiLog("修改-队伍成员")
    @ApiOperation(value = "修改-队伍成员", notes = "传入yingjiduiwuChengyuan", position = 4)
    public R update(@RequestBody YingjiduiwuChengyuan yingjiduiwuChengyuan, BladeUser user) {
		yingjiduiwuChengyuan.setCaozuoren(user.getUserName());
		yingjiduiwuChengyuan.setCaozuorenid(user.getUserId());
		yingjiduiwuChengyuan.setCaozuoshijian(DateUtil.now());
        return R.status(yingjiduiwuChengyuanService.updateById(yingjiduiwuChengyuan));
    }

    @PostMapping("/del")
	@ApiLog("删除-队伍成员")
    @ApiOperation(value = "删除-队伍成员", notes = "传入id", position = 5)
    public R del(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(yingjiduiwuChengyuanService.deleleChengyuan(id));
    }

}
