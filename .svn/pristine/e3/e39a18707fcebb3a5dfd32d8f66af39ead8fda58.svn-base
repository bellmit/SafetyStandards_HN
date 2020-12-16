package org.springblade.anbiao.falvfagui.controller;

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
import org.springblade.anbiao.falvfagui.entity.Guanlizhidu;
import org.springblade.anbiao.falvfagui.page.GuanlizhiduPage;
import org.springblade.anbiao.falvfagui.service.IGuanlizhiduService;
import org.springblade.anbiao.falvfagui.vo.GuanlizhiduVO;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author :elvis.he
 * @program : SafetyStandards
 * @description: GuanlizhiduController
 * @create : 2019-04-24 15:50
 */
@RestController
@RequestMapping("/anbiao/guanlizhidu")
@AllArgsConstructor
@Api(value = "企业管理制度", tags = "企业管理制度")
public class GuanlizhiduController {
    private IGuanlizhiduService guanlizhiduService;
    private IConfigureService mapService;

    @PostMapping("/list")
	@ApiLog("分页-企业管理制度")
    @ApiOperation(value = "分页-企业管理制度", notes = "传入VehiclePage", position = 1)
    public R<GuanlizhiduPage<GuanlizhiduVO>> list(@RequestBody GuanlizhiduPage guanlizhidupage) {
        GuanlizhiduPage<GuanlizhiduVO> pages = guanlizhiduService.selectGuanlizhiduPage(guanlizhidupage);
        return R.data(pages);
    }


    @GetMapping("/detail")
	@ApiLog("详情-企业管理制度")
    @ApiOperation(value = "详情-企业管理制度", notes = "传入id", position = 2)
    public R<GuanlizhiduVO> detail(String id) {
        GuanlizhiduVO detail = guanlizhiduService.selectByKey(id);
        return R.data(detail);
    }

    @PostMapping("/insert")
	@ApiLog("新增-企业管理制度")
    @ApiOperation(value = "新增-企业管理制度", notes = "传入Guanlizhidu", position = 3)
    public R insert(@RequestBody Guanlizhidu guanlizhidu, BladeUser user) {
		guanlizhidu.setCaozuoren(user.getUserName());
		guanlizhidu.setCaozuorenid(user.getUserId());
		guanlizhidu.setCaozuoshijian(DateUtil.now());
		guanlizhidu.setCreatetime(DateUtil.now());
        return R.status(guanlizhiduService.save(guanlizhidu));
    }

    @PostMapping("/update")
	@ApiLog("修改-企业管理制度")
    @ApiOperation(value = "修改-企业管理制度", notes = "传入Guanlizhidu", position = 4)
    public R update(@RequestBody Guanlizhidu guanlizhidu, BladeUser user) {
		guanlizhidu.setCaozuoren(user.getUserName());
		guanlizhidu.setCaozuorenid(user.getUserId());
		guanlizhidu.setCaozuoshijian(DateUtil.now());
        return R.status(guanlizhiduService.updateById(guanlizhidu));
    }

    @PostMapping("/del")
	@ApiLog("删除-企业管理制度")
    @ApiOperation(value = "删除-企业管理制度", notes = "传入管理制度id", position = 5)
    public R del(@RequestParam String id) {
        return R.status(guanlizhiduService.deleleGuanlizhidu(id));
    }

    /********************************** 配置表 ***********************/
    /**
     * 配置表新增
     */
    @PostMapping("/insertMap")
	@ApiLog("配置表新增-企业管理制度")
    @ApiOperation(value = "配置表新增-企业管理制度", notes = "传入guanlizhiduMap", position = 6)
    public R insertMap(@Valid @RequestBody Configure configure) {
        JSONObject jsonObject = JSONUtil.parseObj(configure.getBiaodancanshu());
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_guanlizhidu_map");
        return R.status(mapService.insertMap(configure));
    }

    /**
     * 配置表编辑
     */
    @PostMapping("/updateMap")
	@ApiLog("配置表编辑-企业管理制度")
    @ApiOperation(value = "配置表编辑-企业管理制度", notes = "传入biaodancanshu与id", position = 7)
    public R updateMap(String biaodancanshu, String id) {
        Configure configure = new Configure();
        JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
        configure.setId(id);
        configure.setLabel(jsonObject.getStr("label"));
        configure.setShujubiaoziduan(jsonObject.getStr("prop"));
        configure.setTableName("anbiao_guanlizhidu_map");
        configure.setBiaodancanshu(biaodancanshu);
        return R.status(mapService.updateMap(configure));
    }

    /**
     * 配置表删除
     */
    @PostMapping("/delMap")
	@ApiLog("配置表删除-企业管理制度")
    @ApiOperation(value = "配置表删除-企业管理制度", notes = "传入id", position = 8)
    public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(mapService.delMap("anbiao_guanlizhidu_map", id));
    }

    /**
     * @Description: 根据岗位id获取管理制度配置模块数据
     * @Param: [postId]
     * @return: org.springblade.core.tool.api.R<java.util.List < org.springblade.anbiao.falvfagui.entity.GuanlizhiduMap>>
     * @Author: elvis.he
     * @date : 2019-04-28
     */
    @GetMapping("/listMap")
	@ApiLog("获取管理制度配置-企业管理制度")
    @ApiOperation(value = "获取管理制度配置-企业管理制度", notes = "传入deptId", position = 9)
    public R<JSONArray> listMap(Integer deptId) {
        List<Configure> list1 = mapService.selectMapList("anbiao_guanlizhidu_map", deptId);
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
