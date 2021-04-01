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
package org.springblade.anbiao.shigu.controller;

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
import org.springblade.anbiao.shigu.entity.Shigubaogao;
import org.springblade.anbiao.shigu.page.ShigubaogaoPage;
import org.springblade.anbiao.shigu.service.IShigubaogaoService;
import org.springblade.anbiao.shigu.vo.ShigubaogaoVO;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 事故报告调查处理-事故报告 控制器
 *
 * @author hyp
 * @since 2019-04-28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/shigubaogao")
@Api(value = "事故报告调查处理-事故报告", tags = "事故报告调查处理-事故报告")
public class ShigubaogaoController {

    private IShigubaogaoService shigubaogaoService;
    private IConfigureService mapService;

    @PostMapping("/list")
	@ApiLog("分页-事故报告")
    @ApiOperation(value = "分页-事故报告", notes = "传入ShigubaogaoPage", position = 1)
    public R<ShigubaogaoPage<ShigubaogaoVO>> list(@RequestBody ShigubaogaoPage shigubaogaopage) {
        ShigubaogaoPage<ShigubaogaoVO> pages = shigubaogaoService.selectShigubaogaoPage(shigubaogaopage);
        return R.data(pages);
    }

    @GetMapping("/detail")
	@ApiLog("详情-事故报告")
    @ApiOperation(value = "详情-事故报告", notes = "传入id", position = 2)
    public R<ShigubaogaoVO> detail(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        ShigubaogaoVO detail = shigubaogaoService.selectByKey(id);
        return R.data(detail);
    }

    @PostMapping("/insert")
	@ApiLog("新增-事故报告")
    @ApiOperation(value = "新增-事故报告", notes = "传入Shigubaogao", position = 3)
    public R insert(@RequestBody Shigubaogao shigubaogao, BladeUser user) {
		shigubaogao.setCaozuoren(user.getUserName());
		shigubaogao.setCaozuorenid(user.getUserId());
		shigubaogao.setCaozuoshijian(DateUtil.now());
		shigubaogao.setCreatetime(DateUtil.now());
        return R.status(shigubaogaoService.save(shigubaogao));
    }

    @PostMapping("/update")
	@ApiLog("修改-事故报告")
    @ApiOperation(value = "修改-事故报告", notes = "传入Shigubaogao", position = 4)
    public R update(@RequestBody Shigubaogao shigubaogao, BladeUser user) {
		shigubaogao.setCaozuoren(user.getUserName());
		shigubaogao.setCaozuorenid(user.getUserId());
		shigubaogao.setCaozuoshijian(DateUtil.now());
        return R.status(shigubaogaoService.updateById(shigubaogao));
    }

    @PostMapping("/del")
	@ApiLog("删除-事故报告")
    @ApiOperation(value = "删除-事故报告", notes = "传入事故报告id", position = 5)
    public R del(@RequestParam String id) {
        return R.status(shigubaogaoService.deleleShigubaogao(id));
    }

    /****************************   配置表   ******************************/
    /**
     * 配置表新增
     */
    @PostMapping("/insertMap")
	@ApiLog("配置表新增-事故报告")
    @ApiOperation(value = "配置表新增-事故报告", notes = "传入ShigubaogaoMap", position = 6)
    public R insertMap(@Valid @RequestBody Configure configure) {
        JSONObject jsonObject = JSONUtil.parseObj(configure.getBiaodancanshu());
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_shigubaogao_map");
        return R.status(mapService.insertMap(configure));
    }
    /**
     * 配置表编辑
     */
    @PostMapping("/updateMap")
	@ApiLog("配置表编辑-事故报告")
    @ApiOperation(value = "配置表编辑-事故报告", notes = "传入biaodancanshu与id", position = 7)
    public R updateMap(String biaodancanshu, String id) {
        Configure configure = new Configure();
        JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
        configure.setId(id);
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_shigubaogao_map");
        configure.setBiaodancanshu(biaodancanshu);
        return R.status(mapService.updateMap(configure));
    }
    /**
     * 配置表删除
     */
    @PostMapping("/delMap")
	@ApiLog("配置表删除-事故报告")
    @ApiOperation(value = "配置表删除-事故报告", notes = "传入id", position = 8)
    public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(mapService.delMap("anbiao_shigubaogao_map", id));
    }

    /**
     * @Description: 根据单位id获取事故报告配置模块数据
     * @Param: [postId]
     * @return: org.springblade.core.tool.api.R<java.util.List < org.springblade.anbiao.shigu.vo.ShigubaogaoMap>>
     * @Author: hyp
     * @Date2021-04-28
     */
    @GetMapping("/listMap")
	@ApiLog("获取事故报告配置-事故报告")
    @ApiOperation(value = "获取事故报告配置-事故报告", notes = "传入deptId", position = 9)
    public R<JSONArray> listMap(Integer deptId) {
        List<Configure> list1 = mapService.selectMapList("anbiao_shigubaogao_map", deptId);
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
