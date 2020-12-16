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
import org.springblade.anbiao.yingjijiuyuan.entity.Yuanpingshen;
import org.springblade.anbiao.yingjijiuyuan.service.IYuanpingshenService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 应急救援-应急预案-评审记录 控制器
 *
 * @author elvis.he
 * @since 2019-04-25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yuanpingshen")
@Api(value = "应急救援-应急预案-评审记录", tags = "应急救援-应急预案-评审记录")
public class YuanpingshenController {

    private IYuanpingshenService yuanpingshenService;

    @PostMapping("/list")
	@ApiLog("id获取-评审记录")
    @ApiOperation(value = "id获取-评审记录", notes = "传入预案id", position = 1)
    public R<List<Yuanpingshen>> list(@RequestParam String id) {
        return R.data(yuanpingshenService.selectByYuanId(id));
    }

    @GetMapping("/detail")
	@ApiLog("详情-评审记录")
    @ApiOperation(value = "详情-评审记录", notes = "传入id", position = 2)
    public R<Yuanpingshen> detail(String id) {
        Yuanpingshen detail = yuanpingshenService.getById(id);
        return R.data(detail);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
	@ApiLog("新增-评审记录")
    @ApiOperation(value = "新增-评审记录", notes = "传入yuanpingshen", position = 3)
    public R insert(@RequestBody Yuanpingshen yuanpingshen) {
        return R.status(yuanpingshenService.save(yuanpingshen));
    }

    @PostMapping("/update")
	@ApiLog("修改-评审记录")
    @ApiOperation(value = "修改-评审记录", notes = "传入yuanpingshen", position = 4)
    public R update(@RequestBody Yuanpingshen yuanpingshen) {
        return R.status(yuanpingshenService.updateById(yuanpingshen));
    }

    @PostMapping("/del")
	@ApiLog("删除-评审记录")
    @ApiOperation(value = "删除-评审记录", notes = "传入id", position = 5)
    public R del(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(yuanpingshenService.deleleYuanpingshen(id));
    }

}
