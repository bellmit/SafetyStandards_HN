/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicleController
 * Author:   呵呵哒
 * Date:     2020/7/3 9:42
 * Description:
 */
package org.springblade.anbiao.zhengfu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.AppVersionInfo;
import org.springblade.anbiao.zhengfu.page.AppVersionInfoPage;
import org.springblade.anbiao.zhengfu.service.IAppVersionInfoService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/27
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/appVersionInfo")
@Api(value = "App版本升级", tags = "App版本升级")
public class AppVersionInfoController {

	private IAppVersionInfoService iappVersionInfoService;

	@PostMapping("/insert")
	@ApiLog("新增-App版本升级文件")
	@ApiOperation(value = "新增-App版本升级文件", notes = "传入appVersionInfo", position = 1)
	public R insert(@RequestBody AppVersionInfo appVersionInfo) {
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		appVersionInfo.setCreatetime(formatStr2);
		appVersionInfo.setIsdeleted("0");
		boolean i = iappVersionInfoService.insertSelective(appVersionInfo);
		R rs = new R();
		if(i == true){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("新增-App版本升级文件成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("新增-App版本升级文件失败");
		}
		return rs;
	}

	@PostMapping(value = "/getList")
	@ApiLog("App版本升级详情")
	@ApiOperation(value = "App版本升级详情", notes = "传入appVersionInfoPage",position = 2)
	public R getList(@RequestBody AppVersionInfoPage appVersionInfoPage) throws IOException {
		return R.data(iappVersionInfoService.selectALLPage(appVersionInfoPage));
	}

	@PostMapping(value = "/update")
	@ApiLog("App版本升级-更新状态")
	@ApiOperation(value = "App版本升级-更新状态", notes = "传入appVersionInfoPage",position = 3)
	public R getLiupdatest(@RequestBody AppVersionInfo appVersionInfo) throws IOException {
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		appVersionInfo.setUpdatetime(formatStr2);
		return R.data(iappVersionInfoService.updateByPrimaryKey(appVersionInfo));
	}

}

