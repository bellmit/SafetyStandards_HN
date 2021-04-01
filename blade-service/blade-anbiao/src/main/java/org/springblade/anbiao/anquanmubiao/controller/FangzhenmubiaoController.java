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
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.anquanmubiao.entity.Fangzhenmubiao;
import org.springblade.anbiao.anquanmubiao.page.FangzhenmubiaoPage;
import org.springblade.anbiao.anquanmubiao.service.IFangzhenmubiaoService;
import org.springblade.anbiao.anquanmubiao.vo.FangzhenmubiaoVO;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 安全目标-安全工作方针与目标 控制器
 *
 * @author hyp
 * @since 2019-04-28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/fangzhenmubiao")
@Api(value = "安全目标-安全工作方针与目标", tags = "安全目标-安全工作方针与目标")
public class FangzhenmubiaoController {

    private IFangzhenmubiaoService fangzhenmubiaoService;
    private IConfigureService mapService;

    @PostMapping("/list")
	@ApiLog("分页查询-安全目标")
    @ApiOperation(value = "分页查询-安全目标", notes = "传入FangzhenmubiaoPage", position = 1)
    public R<FangzhenmubiaoPage<FangzhenmubiaoVO>> list(@RequestBody FangzhenmubiaoPage fangzhenmubiaopage) {
        FangzhenmubiaoPage<FangzhenmubiaoVO> pages = fangzhenmubiaoService.selectFangzhenmubiaoPage(fangzhenmubiaopage);
        return R.data(pages);
    }


    @GetMapping("/detail")
	@ApiLog("查看详情-安全目标")
    @ApiOperation(value = "查看详情-安全目标", notes = "传入id", position = 2)
    public R<FangzhenmubiaoVO> detail(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        FangzhenmubiaoVO detail = fangzhenmubiaoService.selectByKey(id);
        return R.data(detail);
    }

    @PostMapping("/insert")
	@ApiLog("新增-安全目标")
    @ApiOperation(value = "新增-安全目标", notes = "传入Fangzhenmubiao", position = 3)
    public R insert(@RequestBody Fangzhenmubiao fangzhenmubiao,BladeUser user) {
		fangzhenmubiao.setCaozuoren(user.getUserName());
		fangzhenmubiao.setCaozuorenid(user.getUserId());
		fangzhenmubiao.setCaozuoshijian(DateUtil.now());
		fangzhenmubiao.setCreatetime(DateUtil.now());
        return R.status(fangzhenmubiaoService.save(fangzhenmubiao));
    }

    @PostMapping("/update")
	@ApiLog("修改-安全目标")
    @ApiOperation(value = "修改-安全目标", notes = "传入Fangzhenmubiao", position = 4)
    public R update(@RequestBody Fangzhenmubiao fangzhenmubiao,BladeUser user) {
		fangzhenmubiao.setCaozuoren(user.getUserName());
		fangzhenmubiao.setCaozuorenid(user.getUserId());
		fangzhenmubiao.setCaozuoshijian(DateUtil.now());
		if("".equals(fangzhenmubiao.getCreatetime())){
			fangzhenmubiao.setCreatetime(DateUtil.now());
		}
        return R.status(fangzhenmubiaoService.updateById(fangzhenmubiao));
    }

    @PostMapping("/del")
	@ApiLog("删除-安全工作方针与目标")
    @ApiOperation(value = "删除-安全工作方针与目标", notes = "传入安全工作方针与目标id", position = 5)
    public R del(@RequestParam String id) {
        return R.status(fangzhenmubiaoService.deleleFangzhenmubiao(id));
    }

    /****************************   配置表   ******************************/
    /**
     * 配置表新增
     */
    @PostMapping("/insertMap")
	@ApiLog("安全目标-新增-配置表")
    @ApiOperation(value = "新增-配置表", notes = "传入FangzhenmubiaoMap", position = 6)
    public R insertMap(@Valid @RequestBody Configure configure) {
        JSONObject jsonObject = JSONUtil.parseObj(configure.getBiaodancanshu());
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_fangzhenmubiao_map");
        return R.status(mapService.insertMap(configure));
    }

    /**
     * 配置表编辑
     */
    @PostMapping("/updateMap")
	@ApiLog("安全目标-编辑-配置表")
    @ApiOperation(value = "编辑-配置表", notes = "传入biaodancanshu与id", position = 7)
    public R updateMap(String biaodancanshu, String id) {
        Configure configure = new Configure();
        JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
        configure.setId(id);
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_fangzhenmubiao_map");
        configure.setBiaodancanshu(biaodancanshu);
        return R.status(mapService.updateMap(configure));
    }

    /**
     * 配置表删除
     */
    @PostMapping("/delMap")
	@ApiLog("安全目标-删除-配置表")
    @ApiOperation(value = "删除-配置表", notes = "传入id", position = 8)
    public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(mapService.delMap("anbiao_fangzhenmubiao_map", id));
    }

    /**
     * @Description: 根据单位id获取事故报告配置模块数据
     * @Param: [postId]
     * @return: org.springblade.core.tool.api.R<java.util.List < org.springblade.anbiao.anquanmubiao.vo.FangzhenmubiaoMap>>
     * @Author: hyp
     * @Date2021-04-28
     */
    @GetMapping("/listMap")
	@ApiLog("安全工作方针-模块数据")
    @ApiOperation(value = "获取安全工作方针-与目标配置模块数据", notes = "传入deptId", position = 9)
    public R<JSONArray> listMap(Integer deptId) {
        List<Configure> list1 = mapService.selectMapList("anbiao_fangzhenmubiao_map", deptId);
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
