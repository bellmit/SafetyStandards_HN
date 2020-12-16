/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiController
 * Author:   呵呵哒
 * Date:     2020/6/20 17:24
 * Description:
 */
package org.springblade.anbiao.zhengfu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTi;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTiVo;
import org.springblade.anbiao.zhengfu.page.XinXiJiaoHuZhuTiPage;
import org.springblade.anbiao.zhengfu.service.IXinXiJiaoHuZhuTiService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/xinxijiaohuzhuti")
@Api(value = "政企互通-通知公告", tags = "政企互通-通知公告")
public class XinXiJiaoHuZhuTiController {

	private IXinXiJiaoHuZhuTiService iXinXiJiaoHuZhuTiService;

	@PostMapping("/insert")
	@ApiLog("新增-通知公告")
	@ApiOperation(value = "新增-通知公告", notes = "传入xinXiJiaoHuZhuTi", position = 1)
	public R insert(@RequestBody XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi) {
		UUID uuid = UUID.randomUUID();
		xinXiJiaoHuZhuTi.setId(uuid.toString());
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		xinXiJiaoHuZhuTi.setCaozuoshijian(formatStr2);
		boolean i = iXinXiJiaoHuZhuTiService.insertSelective(xinXiJiaoHuZhuTi);
		R rs = new R();
		if(i == true){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("新增-通知公告成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("新增-通知公告失败");
		}
		return rs;
	}

	@PostMapping("/update")
	@ApiLog("编辑-通知公告")
	@ApiOperation(value = "编辑-通知公告", notes = "传入xinXiJiaoHuZhuTi", position = 2)
	public R update(@RequestBody XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi) {
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		xinXiJiaoHuZhuTi.setCaozuoshijian(formatStr2);
		boolean i = iXinXiJiaoHuZhuTiService.updateByPrimaryKeySelective(xinXiJiaoHuZhuTi);
		R rs = new R();
		if(i == true){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("编辑-通知公告成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("编辑-通知公告失败");
		}
		return rs;
	}

	@PostMapping("/updateZhuangTai")
	@ApiLog("删除-通知公告")
	@ApiOperation(value = "删除-通知公告", notes = "传入数据id", position = 3)
	public R updateZhuangTai(@RequestBody XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi) {
		xinXiJiaoHuZhuTi.setZhuangtai("9");
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		xinXiJiaoHuZhuTi.setCaozuoshijian(formatStr2);
		boolean i = iXinXiJiaoHuZhuTiService.updateByPrimaryKey(xinXiJiaoHuZhuTi);
		R rs = new R();
		if(i == true){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("删除-通知公告成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("删除-通知公告失败");
		}
		return rs;
	}

	@PostMapping("/list")
	@ApiLog("分页-通知公告管理")
	@ApiOperation(value = "分页-通知公告管理", notes = "传入xinXiJiaoHuZhuTiPage", position = 4)
	public R<XinXiJiaoHuZhuTiPage<XinXiJiaoHuZhuTi>> list(@RequestBody XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage) {
		XinXiJiaoHuZhuTiPage<XinXiJiaoHuZhuTi> pages = iXinXiJiaoHuZhuTiService.selectALLPage(xinXiJiaoHuZhuTiPage);
		return R.data(pages);
	}

	@PostMapping("/getOne")
	@ApiLog("根据ID查询通知公告详情")
	@ApiOperation(value = "根据ID查询通知公告详情", notes = "传入数据id", position = 5)
	public R getOne(@RequestBody XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi) {
		XinXiJiaoHuZhuTi i = iXinXiJiaoHuZhuTiService.selectById(xinXiJiaoHuZhuTi);
		R rs = new R();
		if(i != null){
			rs.setData(i);
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("根据ID查询通知公告详情成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("根据ID查询通知公告详情失败");
		}
		return rs;
	}

	@GetMapping("/getQiYe")
	@ApiLog("获取送达企业列表")
	@ApiOperation(value = "获取送达企业列表", notes = "传入deptId", position = 6)
	public R getQiYe(String deptId) {
		Organization organization = iXinXiJiaoHuZhuTiService.selectGetLeiXing(deptId);
		List<XinXiJiaoHuZhuTiVo> i=null;
		if("shengZF".equals(organization.getJigouleixing())){
			i = iXinXiJiaoHuZhuTiService.selectGetQiYe(deptId,"shengZF");
		}

		if("shiZF".equals(organization.getJigouleixing())){
			i = iXinXiJiaoHuZhuTiService.selectGetQiYe(deptId,"shiZF");
		}

		if("xianZF".equals(organization.getJigouleixing())){
			i = iXinXiJiaoHuZhuTiService.selectGetQiYe(deptId,"xianZF");
		}

		R rs = new R();
		if(i.size() >= 0){
			rs.setData(i);
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("获取送达企业列表成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("获取送达企业列表失败");
		}
		return rs;
	}

	@GetMapping("/getQYZFHT")
	@ApiLog("根据企业ID获取通知详情")
	@ApiOperation(value = "根据企业ID获取通知详情", notes = "传入deptId", position = 7)
	public R getQYZFHT(String deptId) {
		return R.data(iXinXiJiaoHuZhuTiService.selectGetQYByOne(deptId));
	}
}
