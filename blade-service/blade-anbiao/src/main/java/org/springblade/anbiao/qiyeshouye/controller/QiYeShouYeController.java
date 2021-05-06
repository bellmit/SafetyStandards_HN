/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicleController
 * Author:   呵呵哒
 * Date:     2020/7/3 9:42
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.controller;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.qiyeshouye.entity.*;
import org.springblade.anbiao.qiyeshouye.service.IQiYeShouYeService;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/qiYeShouYe")
@Api(value = "企业平台-首页", tags = "企业平台-首页")
public class QiYeShouYeController {

	private FileServer fileServer;

	private IQiYeShouYeService iQiYeShouYeService;

	@GetMapping(value = "/getMonthVehcile")
	@ApiLog("企业平台-本月车辆情况")
	@ApiOperation(value = "企业平台-本月车辆情况",position = 1)
	public R getMonthVehcile(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		return R.data(iQiYeShouYeService.selectMonthVehcile(deptId));
	}

	@GetMapping(value = "/getYearAlarm")
	@ApiLog("企业平台-报警统计（年）")
	@ApiOperation(value = "企业平台-报警统计（年）",position = 2)
	public R getYearAlarm(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId,@ApiParam(value = "年份", required = true) @RequestParam String year) throws IOException {
		return R.data(iQiYeShouYeService.selectYearAlarm(deptId,year));
	}

	@GetMapping(value = "/getYearAlarmTendency")
	@ApiLog("企业平台-处理趋势图")
	@ApiOperation(value = "企业平台-处理趋势图",position = 3)
	public R getYearAlarmTendency(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId,@ApiParam(value = "年份", required = true) @RequestParam String year) throws IOException {
		return R.data(iQiYeShouYeService.selectYearAlarmTendency(deptId,year));
	}

	@GetMapping(value = "/getSevenAlarmStatistics")
	@ApiLog("企业平台-近七天报警统计")
	@ApiOperation(value = "企业平台-近七天报警统计",position = 4)
	public R getSevenAlarmStatistics(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		return R.data(iQiYeShouYeService.selectSevenAlarmStatistics(deptId));
	}

	@GetMapping(value = "/selectOperational")
	@ApiLog("运维端首页-各类型数据统计(顶部)")
	@ApiOperation(value = "运维端首页-各类型数据统计(顶部)",position = 5)
	public R selectOperational(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		return R.data(iQiYeShouYeService.selectOperational(deptId));
	}

	@GetMapping(value = "/selectMarkRemind")
	@ApiLog("企业端-首页-安全达标提醒分数")
	@ApiOperation(value = "企业端-首页-安全达标提醒分数",position = 6)
	public R selectMarkRemind(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		R r = new R();
		QiYeYunWeiShouYe q = iQiYeShouYeService.selectMarkRemind(deptId);
		if(q == null){
			r.setCode(500);
			r.setMsg("暂无数据");
		}else{
			if(q.getTotalpoints() >= 800){
				q.setTotalpointsremark("已达标");
			}else{
				q.setTotalpointsremark("未达标");
			}
			String date = DateUtil.format(new Date(), "yyyy-MM-dd");
			q.setTotalpointstime(date);
			r.setData(q);
			r.setMsg("获取成功");
			r.setSuccess(true);
			r.setCode(200);
		}
		return r;
	}

	@GetMapping(value = "/selectControlRates")
	@ApiLog("企业端-安全达标(超过88%的平台企业)")
	@ApiOperation(value = "企业端-安全达标(超过88%的平台企业)",position = 7)
	public R selectControlRates(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		R r = new R();
		QiYeYunWeiShouYe qiYeYunWeiShouYe = new QiYeYunWeiShouYe();
		int sss = iQiYeShouYeService.selectGetByIdOnDeptId(deptId);
		if(sss > 0 ) {
			QiYeYunWeiShouYe q = iQiYeShouYeService.selectQiYeCount();
			QiYeYunWeiShouYe w = iQiYeShouYeService.selectABQiYeCount();
			QiYeYunWeiShouYe e = iQiYeShouYeService.selectMarkRemind(deptId);
			QiYeYunWeiShouYe qiYreYunWeiShouYe = new QiYeYunWeiShouYe();
			if (e == null) {
				r.setMsg("暂无数据");
				r.setCode(500);
			} else {
//			String.format("%.2f", x1)
				String Rates = String.format("%.2f", (((q.getQiyeshu() - w.getAnbiaoqiyeshu()) * 1.0) / q.getQiyeshu()) * 100) + "%";
				qiYreYunWeiShouYe.setTotalpointsrate(Rates);
				qiYreYunWeiShouYe.setTotalpoints(e.getTotalpoints());
				qiYreYunWeiShouYe.setTotalscore(1000);
				r.setData(qiYreYunWeiShouYe);
				r.setMsg("获取成功");
				r.setSuccess(true);
				r.setCode(200);
			}
		}else{
			qiYeYunWeiShouYe.setTotalpointsrate("0.00%");
			qiYeYunWeiShouYe.setTotalpoints(0);
			qiYeYunWeiShouYe.setTotalscore(1000);
			r.setMsg("该企业未生成安全标准化文件");
			r.setData(qiYeYunWeiShouYe);
			r.setCode(200);
		}
		return r;
	}

	@GetMapping(value = "/selectScheduleReminders")
	@ApiLog("企业端-安全达标-日历待办提醒")
	@ApiOperation(value = "企业端-安全达标-日历待办提醒)",position = 8)
	public R selectScheduleReminders(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId,
								@ApiParam(value = "日期", required = true) @RequestParam String dateTime) throws IOException {
		R r = new R();
		List<QiYeAnBiao> anBiaoList = iQiYeShouYeService.selectScheduleReminders(deptId,dateTime);
		if(anBiaoList == null){
			r.setMsg("暂无数据");
			r.setCode(500);
		}else{
			r.setData(anBiaoList);
			r.setMsg("获取成功");
			r.setSuccess(true);
			r.setCode(200);
		}
		return r;
	}

	@GetMapping(value = "/selectQiYeAnBiaoMuLu")
	@ApiLog("企业端-安全达标-安标目录得分对比表")
	@ApiOperation(value = "企业端-安全达标-安标目录得分对比表)",position = 9)
	public R selectQiYeAnBiaoMuLu(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		R r = new R();
		List<QiYeAnBiaoMuLu> anBiaoMuLuList = iQiYeShouYeService.selectQiYeAnBiaoMuLu(deptId);
		if(anBiaoMuLuList == null){
			r.setMsg("暂无数据");
			r.setCode(500);
		}else{
			r.setData(anBiaoMuLuList);
			r.setMsg("获取成功");
			r.setSuccess(true);
			r.setCode(200);
		}
		return r;
	}

	@GetMapping(value = "/selectPeriodControlRates")
	@ApiLog("企业端-安全达标-安标周期评分达标率")
	@ApiOperation(value = "企业端-安全达标-安标周期评分达标率)",position = 10)
	public R selectPeriodControlRates(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		R r = new R();
		QiYeAnBiaoPeriodRate qiYeAnBiaoPeriodRate = new QiYeAnBiaoPeriodRate();
		int sss = iQiYeShouYeService.selectGetByIdOnDeptId(deptId);
		if(sss > 0 ){
			QiYeAnBiaoPeriodRate anBiaoMuLuList = iQiYeShouYeService.selectPeriodControlRates(deptId);
			if(anBiaoMuLuList == null){
				r.setMsg("暂无数据");
				r.setCode(500);
			}else{
				r.setData(anBiaoMuLuList);
				r.setMsg("获取成功");
				r.setSuccess(true);
				r.setCode(200);
			}
		}else{
			qiYeAnBiaoPeriodRate.setMaxxiangshu(0);
			qiYeAnBiaoPeriodRate.setMaxdabiaoxiangshu(0);
			qiYeAnBiaoPeriodRate.setMindabiaoxiangshu(0);
			qiYeAnBiaoPeriodRate.setMinxiangshu(0);
			qiYeAnBiaoPeriodRate.setDabiaolv("0.00%");
			r.setMsg("该企业未生成安全标准化文件");
			r.setData(qiYeAnBiaoPeriodRate);
			r.setCode(200);
		}
		return r;
	}

	@GetMapping(value = "/selectSafetyTips")
	@ApiLog("企业端-安全达标-安全提示")
	@ApiOperation(value = "企业端-安全达标-安全提示)",position = 11)
	public R selectSafetyTips(@ApiParam(value = "企业ID", required = true) @RequestParam String deptId) throws IOException {
		R r = new R();
		List<QiYeAnBiaoSafetyTips> safetyTips = new ArrayList<>();
		List<QiYeAnBiaoSafetyTips> qiYeAnBiaoSafetyTips = iQiYeShouYeService.selectSafetyTips(deptId);
		if(qiYeAnBiaoSafetyTips == null){
			r.setMsg("暂无数据");
			r.setCode(500);
		}else{
			for (int i = 0;i<qiYeAnBiaoSafetyTips.size();i++){
				QiYeAnBiaoSafetyTips as = new QiYeAnBiaoSafetyTips();
				QiYeAnBiaoSafetyTips znum = iQiYeShouYeService.selectSafetyTipsZNum(deptId,qiYeAnBiaoSafetyTips.get(i).getIds());
				QiYeAnBiaoSafetyTips num = iQiYeShouYeService.selectSafetyTipsNum(deptId,qiYeAnBiaoSafetyTips.get(i).getIds());
				String name = qiYeAnBiaoSafetyTips.get(i).getName();
				as.setName(name);
				as.setTier(num.getTier());
				as.setMinxingnum(znum.getMinxingnum());
				as.setNotdabiaonum(num.getNotdabiaonum());
				as.setIds(qiYeAnBiaoSafetyTips.get(i).getIds());
				as.setDeptId(Integer.parseInt(deptId));
				safetyTips.add(i,as);
			}
			r.setData(safetyTips);
			r.setMsg("获取成功");
			r.setSuccess(true);
			r.setCode(200);
		}
		return r;
	}

}

