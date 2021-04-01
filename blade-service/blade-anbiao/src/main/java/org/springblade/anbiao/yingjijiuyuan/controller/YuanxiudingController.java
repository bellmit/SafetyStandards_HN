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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import org.springblade.anbiao.yingjijiuyuan.entity.Yuanxiuding;
import org.springblade.anbiao.yingjijiuyuan.service.IYuanxiudingService;

import java.util.List;

/**
 * 应急预案-修订完善记录 控制器
 *
 * @author hyp
 * @since 2019-04-25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yuanxiuding")
@Api(value = "应急救援-应急预案-修订完善记录", tags = "应急救援-应急预案-修订完善记录")
public class YuanxiudingController {

    private IYuanxiudingService yuanxiudingService;

    @PostMapping("/list")
	@ApiLog("id获取-评审记录")
    @ApiOperation(value = "id获取-评审记录", notes = "传入预案id", position = 1)
    public R<List<Yuanxiuding>> list(@RequestParam String id) {
        return R.data(yuanxiudingService.selectByYuanId(id));
    }

    @GetMapping("/detail")
	@ApiLog("详情-修订完善记录")
    @ApiOperation(value = "详情-修订完善记录", notes = "传入id", position = 2)
    public R<Yuanxiuding> detail(String id) {
        Yuanxiuding detail = yuanxiudingService.getById(id);
        return R.data(detail);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
	@ApiLog("新增-修订完善记录")
    @ApiOperation(value = "新增-修订完善记录", notes = "传入yuanpingshen", position = 3)
    public R insert(@RequestBody Yuanxiuding yuanxiuding) {
        return R.status(yuanxiudingService.save(yuanxiuding));
    }

    @PostMapping("/update")
	@ApiLog("修改-修订完善记录")
    @ApiOperation(value = "修改-修订完善记录", notes = "传入yuanpingshen", position = 4)
    public R update(@RequestBody Yuanxiuding yuanxiuding) {
        return R.status(yuanxiudingService.updateById(yuanxiuding));
    }

    @PostMapping("/del")
	@ApiLog("删除-修订完善记录")
    @ApiOperation(value = "删除-修订完善记录", notes = "传入id", position = 5)
    public R del(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(yuanxiudingService.deleleYuanxiuding(id));
    }


}
