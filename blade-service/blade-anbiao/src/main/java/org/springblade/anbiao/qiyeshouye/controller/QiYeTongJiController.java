/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicleController
 * Author:   呵呵哒
 * Date:     2020/7/3 9:42
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.qiyeshouye.entity.*;
import org.springblade.anbiao.qiyeshouye.page.QiYeInOutAreaPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeOffLineTongJiPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeTongJiPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeTpvehdataPage;
import org.springblade.anbiao.qiyeshouye.service.IQiYeTongJiService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/30
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/qiYeTongJi")
@Api(value = "企业平台-报警统计", tags = "企业平台-报警统计")
public class QiYeTongJiController {

	private IQiYeTongJiService iQiYeTongJiService;

	@PostMapping(value = "/getBJTJJS")
	@ApiLog("企业报警统计-报警统计汇总")
	@ApiOperation(value = "企业报警统计-报警统计汇总", notes = "传入qiYeTongJiPage",position = 1)
	public R<QiYeTongJiPage<QiYeTongJi>> getBJTJJS(@RequestBody QiYeTongJiPage qiYeTongJiPage) {
		//排序条件
		////默认报警总数降序
		if(qiYeTongJiPage.getOrderColumns()==null){
			qiYeTongJiPage.setOrderColumn("baojingcishu");
		}else{
			qiYeTongJiPage.setOrderColumn(qiYeTongJiPage.getOrderColumns());
		}
		QiYeTongJiPage<QiYeTongJi> pages = iQiYeTongJiService.selectGetBJTJ(qiYeTongJiPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getBJPMTJ")
	@ApiLog("企业报警统计-车辆报警排名")
	@ApiOperation(value = "企业报警统计-车辆报警排名", notes = "传入qiYeTongJiPage",position = 2)
	public R<QiYeTongJiPage<QiYeTongJi>> getBJPMTJ(@RequestBody QiYeTongJiPage qiYeTongJiPage) {
		//排序条件
		////默认报警总数降序
		if(qiYeTongJiPage.getOrderColumns()==null){
			qiYeTongJiPage.setOrderColumn("baojingcishu");
		}else{
			qiYeTongJiPage.setOrderColumn(qiYeTongJiPage.getOrderColumns());
		}
		QiYeTongJiPage<QiYeTongJi> pages = iQiYeTongJiService.selectBJPMTJ(qiYeTongJiPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getBJRYXTJ")
	@ApiLog("企业报警统计-日运行情况统计")
	@ApiOperation(value = "企业报警统计-日运行情况统计", notes = "传入qiYeTongJiPage",position = 2)
	public R<QiYeTongJiPage<QiYeRiYunXingTongJi>> getBJRYXTJ(@RequestBody QiYeTongJiPage qiYeTongJiPage) {
		//排序条件
		////默认报警总数降序
		if(qiYeTongJiPage.getOrderColumns()==null){
			qiYeTongJiPage.setOrderColumn("");
		}else{
			qiYeTongJiPage.setOrderColumn(qiYeTongJiPage.getOrderColumns());
		}
		QiYeTongJiPage<QiYeRiYunXingTongJi> pages = iQiYeTongJiService.selectGetRYXBJTJ(qiYeTongJiPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getQYOffLineTJ")
	@ApiLog("企业-24小时不在线车辆统计")
	@ApiOperation(value = "企业-24小时不在线车辆统计", notes = "传入qiYeOffLineTongJiPage",position = 5)
	public R<QiYeOffLineTongJiPage<QiYeOffLineTongJi>> getQYOffLineTJ(@RequestBody QiYeOffLineTongJiPage qiYeOffLineTongJiPage) {
		//排序条件
		////默认车辆牌照降序
		if(qiYeOffLineTongJiPage.getOrderColumns()==null){
			qiYeOffLineTongJiPage.setOrderColumn("cheliangpaizhao");
		}else{
			qiYeOffLineTongJiPage.setOrderColumn(qiYeOffLineTongJiPage.getOrderColumns());
		}
		QiYeOffLineTongJiPage<QiYeOffLineTongJi> pages = iQiYeTongJiService.selectGet24HoursOffLineTJ(qiYeOffLineTongJiPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getQYInOutAreaTJ")
	@ApiLog("企业-进出区域统计")
	@ApiOperation(value = "企业-进出区域统计", notes = "传入qiYeInOutAreaPage",position = 6)
	public R<QiYeInOutAreaPage<QiYeInOutAreaTongJi>> getQYInOutAreaTJ(@RequestBody QiYeInOutAreaPage qiYeInOutAreaPage) {
		//排序条件
		////默认车辆牌照降序
		if(qiYeInOutAreaPage.getOrderColumns()==null){
			qiYeInOutAreaPage.setOrderColumn("KeepTime");
		}else{
			qiYeInOutAreaPage.setOrderColumn(qiYeInOutAreaPage.getOrderColumns());
		}
		QiYeInOutAreaPage<QiYeInOutAreaTongJi> pages = iQiYeTongJiService.selectGetInOutAreaTJ(qiYeInOutAreaPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getTpvehdataTJ")
	@ApiLog("企业-在线车辆详情")
	@ApiOperation(value = "企业-在线车辆详情", notes = "传入qiYeTpvehdataPage",position = 7)
	public R<QiYeTpvehdataPage<QiYeTpvehdataTongJi>> getTpvehdataTJ(@RequestBody QiYeTpvehdataPage qiYeTpvehdataPage) {
		//排序条件
		////默认定位时间降序
		if(qiYeTpvehdataPage.getOrderColumns()==null){
			qiYeTpvehdataPage.setOrderColumn("LastLocateTime");
		}else{
			qiYeTpvehdataPage.setOrderColumn(qiYeTpvehdataPage.getOrderColumns());
		}
		QiYeTpvehdataPage<QiYeTpvehdataTongJi> pages = iQiYeTongJiService.selecttpvehdataTJ(qiYeTpvehdataPage);
		return R.data(pages);
	}

}

