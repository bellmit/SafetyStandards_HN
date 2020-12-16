/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicleController
 * Description:
 */
package org.springblade.anbiao.zhengfu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.zhengfu.entity.*;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoJingTongJiJieSuanPage;
import org.springblade.anbiao.zhengfu.service.IOrganizationService;
import org.springblade.anbiao.zhengfu.service.IZhengFuBaoJingTongJiService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author 呵呵哒
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/zhengFuBaoJingTongJi")
@Api(value = "政府-报警数据统计", tags = "政府-报警数据统计")
public class ZhengFuBaoJingTongJiController {

	private IZhengFuBaoJingTongJiService iZhengFuBaoJingTongJiService;

	private IOrganizationService iOrganizationService;

	@GetMapping(value = "/getZFBJQiYeList")
	@ApiLog("政府-企业报警占比")
	@ApiOperation(value = "政府-企业报警占比", notes = "传入deptId或者xiaJiDeptId",position = 1)
	public R getZFBJQiYeList(String deptId,String xiaJiDeptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId) && StringUtils.isBlank(xiaJiDeptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId或者xiaJiDeptId");
			return rs;
		}

		if(!StringUtils.isBlank(deptId)){
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJing(deptId);
			if(zhengFuBaoJingTongJis != null){
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			}else{
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}

		if(!StringUtils.isBlank(xiaJiDeptId)){
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJing_XiaJi(xiaJiDeptId);
			if(zhengFuBaoJingTongJis != null){
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			}else{
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		return rs;
	}

	@GetMapping(value = "/getZFBJYearList")
	@ApiLog("政府报警统计-报警处理情况(年)")
	@ApiOperation(value = "政府报警统计-报警处理情况(年)", notes = "传入deptId或者xiaJiDeptId",position = 2)
	public R getZFBJYearList(String deptId,String xiaJiDeptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId) && StringUtils.isBlank(xiaJiDeptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId或者xiaJiDeptId");
			return rs;
		}
		if(!StringUtils.isBlank(deptId)) {
			ZhengFuBaoJingTongJi zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingYear(deptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		if(!StringUtils.isBlank(xiaJiDeptId)){
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingYear_XiaJi(xiaJiDeptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		return rs;
	}

	@GetMapping(value = "/getZFBJMonthList")
	@ApiLog("政府报警统计-报警处理情况(月)")
	@ApiOperation(value = "政府报警统计-报警处理情况(月)", notes = "传入deptId或者xiaJiDeptId",position = 3)
	public R getZFBJMonthList(String deptId,String xiaJiDeptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId) && StringUtils.isBlank(xiaJiDeptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId或者xiaJiDeptId");
			return rs;
		}
		if(!StringUtils.isBlank(deptId)) {
			ZhengFuBaoJingTongJi zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth(deptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		if(!StringUtils.isBlank(xiaJiDeptId)){
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth_XiaJi(xiaJiDeptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		return rs;
	}

	@GetMapping(value = "/getZFBJMonthListNew")
	@ApiLog("政府报警统计-报警处理情况(月)_new")
	@ApiOperation(value = "政府报警统计-报警处理情况(月)_new", notes = "传入deptId,type",position = 10)
	public R getZFBJMonthListNew(String deptId,int type,int size) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId");
			return rs;
		}

		ZhengFuBaoJingTongJi zhengFuBaoJingTongJi = null;
		List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = null;
		if(type == 1){
			if(!StringUtils.isBlank(deptId)){
				Organization organization2 = iOrganizationService.selectGetGangWei(deptId);
				if( !StringUtils.isBlank(organization2.getCountry()) ){
					zhengFuBaoJingTongJi = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth(deptId);
				}else{
					zhengFuBaoJingTongJi = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth(deptId);
					if(size > 0){
						zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth_XiaJi(deptId);
					}else{
						zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth_XiaJi(deptId);
					}
				}
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}else{
			if(!StringUtils.isBlank(deptId)) {
				zhengFuBaoJingTongJi = iZhengFuBaoJingTongJiService.selectGetZFBaoJingMonth(deptId);
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}
		if(zhengFuBaoJingTongJi != null && zhengFuBaoJingTongJis == null){
			rs.setCode(200);
			rs.setData(zhengFuBaoJingTongJi);
			rs.setMsg("获取成功");
		}else if(zhengFuBaoJingTongJi != null && zhengFuBaoJingTongJis != null){
			rs.setCode(200);
			zhengFuBaoJingTongJi.setXjlist(zhengFuBaoJingTongJis);
			rs.setData(zhengFuBaoJingTongJi);
			rs.setMsg("获取成功");
		}else{
			rs.setCode(500);
			rs.setMsg("获取成功，无数据");
		}
		return rs;
	}

	@GetMapping(value = "/getZFBJQSList")
	@ApiLog("政府报警统计-当年报警、处警趋势(年)")
	@ApiOperation(value = "政府报警统计-当年报警、处警趋势(年)", notes = "传入deptId或者xiaJiDeptId",position = 4)
	public R getZFBJQSList(String deptId,String xiaJiDeptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId) && StringUtils.isBlank(xiaJiDeptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId或者xiaJiDeptId");
			return rs;
		}
		if(!StringUtils.isBlank(deptId)) {
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingQuShi(deptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		if(!StringUtils.isBlank(xiaJiDeptId)){
			List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFBaoJingQuShi_XiaJi(xiaJiDeptId);
			if (zhengFuBaoJingTongJis != null) {
				rs.setCode(200);
				rs.setData(zhengFuBaoJingTongJis);
				rs.setMsg("获取成功");
			} else {
				rs.setCode(500);
				rs.setMsg("获取失败");
				return rs;
			}
		}
		return rs;
	}

	@GetMapping(value = "/getZFQYBJPMList")
	@ApiLog("政府报警统计-企业报警排名")
	@ApiOperation(value = "政府报警统计-企业报警排名", notes = "传入deptId",position = 4)
	public R getZFQYBJPMList(String deptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId");
			return rs;
		}
		List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = null;
		String xiaJiDeptId = null;
		Organization jb = iOrganizationService.selectGetZFJB(deptId);
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			xiaJiDeptId = deptId;
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFQYBaoJingPaiMing_XiaJi(xiaJiDeptId);
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			xiaJiDeptId = deptId;
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFQYBaoJingPaiMing_XiaJi(xiaJiDeptId);
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFQYBaoJingPaiMing(deptId);
		}

		if (zhengFuBaoJingTongJis != null) {
			rs.setCode(200);
			rs.setData(zhengFuBaoJingTongJis);
			rs.setMsg("获取成功");
		} else {
			rs.setCode(500);
			rs.setMsg("获取失败");
		}
		return rs;
	}

	@GetMapping(value = "/getZFDQBJPMList")
	@ApiLog("政府报警统计-地区报警排名")
	@ApiOperation(value = "政府报警统计-地区报警排名", notes = "传入deptId",position = 4)
	public R getZFDQBJPMList(String deptId) throws IOException {
		R rs = new R();
		if(StringUtils.isBlank(deptId)){
			rs.setCode(500);
			rs.setMsg("请传人参数deptId");
			return rs;
		}
		List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJis = null;
		String xiaJiDeptId = null;
		Organization jb = iOrganizationService.selectGetZFJB(deptId);
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			xiaJiDeptId = deptId;
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFDQBaoJingPaiMing_XiaJi(xiaJiDeptId);
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			xiaJiDeptId = deptId;
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFDQBaoJingPaiMing_XiaJi(xiaJiDeptId);
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoJingTongJis = iZhengFuBaoJingTongJiService.selectGetZFDQBaoJingPaiMing(deptId);
		}

		if (zhengFuBaoJingTongJis != null) {
			rs.setCode(200);
			rs.setData(zhengFuBaoJingTongJis);
			rs.setMsg("获取成功");
		} else {
			rs.setCode(500);
			rs.setMsg("获取失败");
		}
		return rs;
	}

	@PostMapping(value = "/getZFBJTJJS")
	@ApiLog("政府报警统计-报警统计结算")
	@ApiOperation(value = "政府报警统计-报警统计结算", notes = "传入deptId或者xiaJiDeptId",position = 4)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan>> getZFBJTJJS(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		//排序条件
		////默认报警总数降序
		if(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns()==null){
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn("chaoSuBaoJing");
		}else{
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns());
		}
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan> pages = iZhengFuBaoJingTongJiService.selectGetBJTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFDQBJCLLVTJ")
	@ApiLog("政府报警统计-地区报警处理率")
	@ApiOperation(value = "政府报警统计-地区报警处理率", notes = "传入deptId或者xiaJiDeptId",position = 5)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFDQBJCLLVTJ(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetDqLvTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFQYBJCLLVTJ")
	@ApiLog("政府报警统计-企业报警处理率")
	@ApiOperation(value = "政府报警统计-企业报警处理率", notes = "传入deptId或者xiaJiDeptId",position = 6)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFQYBJCLLVTJ(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Organization jb = iOrganizationService.selectGetZFJB(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoJingTongJiJieSuanPage.setXiaJiDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetQYLvTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFGPSBJMX")
	@ApiLog("政府报警统计-GPS报警详情明细")
	@ApiOperation(value = "政府报警统计-GPS报警详情明细", notes = "传入deptId或者xiaJiDeptId",position = 7)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFGPSBJMX(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetGPSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFDMSBJMX")
	@ApiLog("政府报警统计-DMS报警详情明细")
	@ApiOperation(value = "政府报警统计-DMS报警详情明细", notes = "传入deptId或者xiaJiDeptId",position = 8)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFDMSBJMX(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetDMSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFVehicleBJMX")
	@ApiLog("政府报警统计-报警车辆详情明细")
	@ApiOperation(value = "政府报警统计-报警车辆详情明细", notes = "传入deptId",position = 9)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFVehicleBJMX(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetVehicleMXTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFALLBJMX")
	@ApiLog("政府报警统计-所有报警详情明细")
	@ApiOperation(value = "政府报警统计-所有报警详情明细", notes = "传入deptId",position = 10)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv>> getZFALLBJMX(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiLv> pages = iZhengFuBaoJingTongJiService.selectGetAllMXTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFDQBJTJPM")
	@ApiLog("政府报警统计-地区报警排名")
	@ApiOperation(value = "政府报警统计-地区报警排名", notes = "传入zhengFuBaoJingTongJiJieSuanPage",position = 15)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan>> getZFDQBJTJPM(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {

		Organization jb = iOrganizationService.selectGetZFJB(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoJingTongJiJieSuanPage.setXiaJiDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		//排序条件
		////默认报警总数降序
		if(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns()==null){
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn("");
		}else{
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns());
		}
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan> pages = iZhengFuBaoJingTongJiService.selectGetDQTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@PostMapping(value = "/getZFCLBJTJPM")
	@ApiLog("政府报警统计-车辆报警排名")
	@ApiOperation(value = "政府报警统计-车辆报警排名", notes = "传入zhengFuBaoJingTongJiJieSuanPage",position = 16)
	public R<ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan>> getZFCLBJTJPM(@RequestBody ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {

		Organization jb = iOrganizationService.selectGetZFJB(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			zhengFuBaoJingTongJiJieSuanPage.setDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			zhengFuBaoJingTongJiJieSuanPage.setXiaJiDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}

		//排序条件
		////默认报警总数降序
		if(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns()==null){
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn("");
		}else{
			zhengFuBaoJingTongJiJieSuanPage.setOrderColumn(zhengFuBaoJingTongJiJieSuanPage.getOrderColumns());
		}
		ZhengFuBaoJingTongJiJieSuanPage<ZhengFuBaoJingTongJiJieSuan> pages = iZhengFuBaoJingTongJiService.selectGetCLTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
		return R.data(pages);
	}

	@GetMapping(value = "/getAlarmGuIdList")
	@ApiLog("获取报警统计-提醒消息")
	@ApiOperation(value = "获取报警统计-提醒消息", notes = "alarmGuId",position = 2)
	public R getAlarmGuIdList(String alarmGuId){
		R rs = new R();
		if(StringUtils.isBlank(alarmGuId)){
			rs.setData(null);
			rs.setMsg("tts消息获取失败，暂无数据");
			rs.setCode(500);
			return rs;
		}else{
			List<TtsMessageInfo> ttsMessageInfos = iZhengFuBaoJingTongJiService.selectByAlarmGuId(alarmGuId);
			if(ttsMessageInfos == null){
				rs.setData(null);
				rs.setMsg("tts消息获取失败，暂无数据");
				rs.setCode(500);
				return rs;
			}else{
				rs.setData(ttsMessageInfos);
				rs.setMsg("获取成功");
				rs.setCode(200);
				return rs;
			}
		}
	}

}

