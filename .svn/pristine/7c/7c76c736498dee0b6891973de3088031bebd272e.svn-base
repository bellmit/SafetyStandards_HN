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
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.yingjijiuyuan.entity.Yingjiyuan;
import org.springblade.anbiao.yingjijiuyuan.page.YingjiyuanPage;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjiyuanService;
import org.springblade.anbiao.yingjijiuyuan.vo.YingjiyuanVO;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 应急救援-应急预案 控制器
 *
 * @author elvis.he
 * @since 2019-04-24
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yingjiyuan")
@Api(value = "应急救援-应急预案", tags = "应急救援-应急预案")
public class YingjiyuanController {

    private IYingjiyuanService yingjiyuanService;
    private IConfigureService mapService;

    @PostMapping("/list")
	@ApiLog("分页-应急预案")
    @ApiOperation(value = "分页-应急预案", notes = "传入VehiclePage", position = 1)
    public R<YingjiyuanPage<YingjiyuanVO>> list(@RequestBody YingjiyuanPage yingjiyuanpage) {
        YingjiyuanPage<YingjiyuanVO> pages = yingjiyuanService.selectYingjiyuanPage(yingjiyuanpage);
        return R.data(pages);
    }


    @GetMapping("/detail")
	@ApiLog("详情-应急预案")
    @ApiOperation(value = "详情-应急预案", notes = "传入id", position = 2)
    public R<YingjiyuanVO> detail(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        YingjiyuanVO detail = yingjiyuanService.selectByKey(id);
        return R.data(detail);
    }

    @PostMapping("/insert")
	@ApiLog("新增-应急预案")
    @ApiOperation(value = "新增-应急预案", notes = "传入Yingjiyuan", position = 3)
    public R insert(@RequestBody Yingjiyuan yingjiyuan, BladeUser user) {
		yingjiyuan.setCaozuoren(user.getUserName());
		yingjiyuan.setCaozuorenid(user.getUserId());
		yingjiyuan.setCaozuoshijian(DateUtil.now());
		yingjiyuan.setCreatetime(DateUtil.now());
        return R.status(yingjiyuanService.save(yingjiyuan));
    }

    @PostMapping("/update")
	@ApiLog("修改-应急预案")
    @ApiOperation(value = "修改-应急预案", notes = "传入Yingjiyuan", position = 4)
    public R update(@RequestBody Yingjiyuan yingjiyuan, BladeUser user) {
		yingjiyuan.setCaozuoren(user.getUserName());
		yingjiyuan.setCaozuorenid(user.getUserId());
		yingjiyuan.setCaozuoshijian(DateUtil.now());
        return R.status(yingjiyuanService.updateById(yingjiyuan));
    }

    @PostMapping("/del")
	@ApiLog("删除-应急预案")
    @ApiOperation(value = "删除-应急预案", notes = "传入应急预案id", position = 5)
    public R del(@RequestParam String id) {
        return R.status(yingjiyuanService.deleleYingjiyuan(id));
    }


    /****************************   配置表   ******************************/
    /**
     * 配置表新增
     */
    @PostMapping("/insertMap")
	@ApiLog("配置表新增-应急预案")
    @ApiOperation(value = "配置表新增-应急预案", notes = "传入yingjiyuanMap", position = 6)
    public R insertMap(@Valid @RequestBody Configure configure) {
        JSONObject jsonObject = JSONUtil.parseObj(configure.getBiaodancanshu());
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_yingjiyuan_map");
        return R.status(mapService.insertMap(configure));
    }
    /**
     * 配置表编辑
     */
    @PostMapping("/updateMap")
	@ApiLog("配置表编辑-应急预案")
    @ApiOperation(value = "配置表编辑-应急预案", notes = "传入biaodancanshu与id", position = 7)
    public R updateMap(String biaodancanshu, String id) {
        Configure configure = new Configure();
        JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
        configure.setId(id);
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_yingjiyuan_map");
        configure.setBiaodancanshu(biaodancanshu);
        return R.status(mapService.updateMap(configure));
    }
    /**
     * 配置表删除
     */
    @PostMapping("/delMap")
	@ApiLog("配置表删除-应急预案")
    @ApiOperation(value = "配置表删除-应急预案", notes = "传入id", position = 8)
    public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(mapService.delMap("anbiao_yingjiyuan_map", id));
    }

    /**
     * @Description: 根据单位id获取应急演练配置模块数据
     * @Param: [postId]
     * @return: org.springblade.core.tool.api.R<java.util.List>
     * @Author: elvis.he
     * @Date: 2019-04-28
     */
    @GetMapping("/listMap")
	@ApiLog("获取应急预案配置-应急预案")
    @ApiOperation(value = "获取应急预案配置-应急预案", notes = "传入deptId", position = 9)
    public R<JSONArray> listMap(Integer deptId) {
        List<Configure> list1 = mapService.selectMapList("anbiao_yingjiyuan_map", deptId);
        String str = "";
        for (int i = 0; i < list1.size(); i++) {
            //转换成json数据并put id
            JSONObject jsonObject = JSONUtil.parseObj(list1.get(i).getBiaodancanshu());
            jsonObject.put("id", list1.get(i).getId());
            if (!str.equals("")) {
                str = str + "," + jsonObject.toString();
            } else {
                str = jsonObject.toString();
            }
        }
        str = "[" + str + "]";
        JSONArray json = JSONUtil.parseArray(str);
        return R.data(json);
    }

}
