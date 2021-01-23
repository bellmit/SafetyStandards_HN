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
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.ZhengFuBaoGao;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoGaoPage;
import org.springblade.anbiao.zhengfu.service.IOrganizationService;
import org.springblade.anbiao.zhengfu.service.IZhengFuBaoGaoService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/9/16
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/zhengFuBaoGao")
@Api(value = "政府报告", tags = "政府报告")
public class ZhengFuBaoGaoController {

	private IZhengFuBaoGaoService iZhengFuBaoGaoService;
	private IOrganizationService iOrganizationService;

	@PostMapping(value = "/getList")
	@ApiLog("政府报告详情")
	@ApiOperation(value = "政府报告详情", notes = "传入zhengFuBaoGaoPage",position = 1)
	public R getList(@RequestBody ZhengFuBaoGaoPage zhengFuBaoGaoPage) throws IOException {
		R r = new R();
		Organization jb = iOrganizationService.selectGetZFJB(zhengFuBaoGaoPage.getDeptId());
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			zhengFuBaoGaoPage.setProvince(zhengFuBaoGaoPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			zhengFuBaoGaoPage.setCity(zhengFuBaoGaoPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoGaoPage.setCountry(zhengFuBaoGaoPage.getDeptId());
		}

		//排序条件
		if(zhengFuBaoGaoPage.getOrderColumns()==null){
			zhengFuBaoGaoPage.setOrderColumn("countenddate");
		}else{
			zhengFuBaoGaoPage.setOrderColumn(zhengFuBaoGaoPage.getOrderColumns());
		}


		ZhengFuBaoGaoPage<ZhengFuBaoGao> zhengFuBaoGaoList =  iZhengFuBaoGaoService.selectALLPage(zhengFuBaoGaoPage);
		if(zhengFuBaoGaoList != null){
			r.setData(zhengFuBaoGaoList);
			r.setSuccess(true);
			r.setMsg("获取成功");
		}else{
			r.setData(null);
			r.setSuccess(false);
			r.setMsg("获取失败");
		}
		return R.data(r);
	}

}

