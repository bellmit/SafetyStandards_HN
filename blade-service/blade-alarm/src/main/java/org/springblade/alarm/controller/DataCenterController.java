package org.springblade.alarm.controller;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.alarm.entity.Stopvehicle;
import org.springblade.alarm.entity.VehicleRun;
import org.springblade.alarm.entity.VehicleRundetails;
import org.springblade.alarm.page.VehicleRunDetailsPage;
import org.springblade.alarm.page.VehicleRunPage;
import org.springblade.alarm.service.IDataCenterService;
import org.springblade.alarm.service.IStopvehicleService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.gps.entity.GpsVehicle;
import org.springblade.gps.entity.VehiclePT;
import org.springblade.gps.entity.VehiclePTCompany;
import org.springblade.gps.entity.VehicleStop;
import org.springblade.gps.feign.IGpsPointDataClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author th
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/620:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/alarm/dataCenter")
@Api(value = "数据中心接口", tags = "数据中心接口")
public class DataCenterController {
    private IDataCenterService service;
	private IGpsPointDataClient gpsPointDataClient;
	private IStopvehicleService stopvehicleService;
	@GetMapping("alarmMonthQingKuang")
	@ApiLog("数据中心-本月车辆运营情况")
	@ApiOperation(value = "数据中心-本月车辆运营情况", notes = "company 企业名称", position = 5)
	@ApiImplicitParam(name = "company", value = "当前单位名称", required = true)
    public R AlarmMonthqingkaung(String company){

			return R.data(service.alarmMothqingkaung(company));
	}

	@GetMapping("alarmMonthQushi")
	@ApiLog("数据中心-本月车辆报警报警趋势")
	@ApiOperation(value = "数据中心-本月车辆报警报警趋势", notes = "company 企业名称", position = 5)
	@ApiImplicitParam(name = "company", value = "当前单位名称", required = true)
	public R AlarmMonthQushi(String company){

		return R.data(service.alarmMonthQushi(company));
	}

	@GetMapping("alarmZhudongCount")
	@ApiLog("数据中心-本月报警比例")
	@ApiOperation(value = "数据中心-本月报警比例", notes = "company 企业名称", position = 5)
	@ApiImplicitParam(name = "company", value = "当前单位名称", required = true)
	public R AlarmZhudong(String company){

		return R.data(service.alarmZhudongCount(company));
	}

	@GetMapping("montalarmclassify")
	@ApiLog("数据中心-车辆月报警分类")
	@ApiOperation(value = "数据中心-车辆月报警分类", notes = "company 企业名称 type 0为主动防御 1 为车辆报警，不传为查全部", position = 5)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "company", value = "单位名称", required = true),
			@ApiImplicitParam(name = "type", value = "报警类型（0为主动防御 1 为车辆报警，不传为查全部）", required = true)
	})
	public R Alarmclassify(String company,Integer type){
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        if(type==null || type==0){
			//主动防御
			maps.addAll(service.monthZhudong(company));
		}
		if(type==null || type==1){
				//车辆报警
            maps.addAll(service.monthAlarm(company));
        }
        return  R.data(maps);

	}

	@GetMapping("alarmChuliCount")
	@ApiLog("数据中心-本月报警处理统计")
	@ApiOperation(value = "数据中心-本月报警处理统计", notes = "company 企业名称", position = 5)
	@ApiImplicitParam(name = "company", value = "当前单位名称", required = true)
	public R AlarmChuliCount(String company){

		return R.data(service.alarmChuliCount(company));
	}
	/**
	 * 获取gps车辆id
	 */
	@GetMapping("/Testgps")
	@ApiLog("获取gps车辆id")
	@ApiOperation(value = "获取gps车辆id", notes = "获取gps车辆id", position = 2)
	public R getgpsvehicle(@RequestParam("cph") String cpn, @RequestParam("color") String color){
		GpsVehicle gpsVehicle = gpsPointDataClient.getgpsvehicle(cpn, color);

		return  R.data(gpsVehicle);
	}

	@PostMapping("runVehicle")
	@ApiLog("数据中心-车辆周运行情况")
	@ApiOperation(value = "数据中心-车辆周运行情况", notes = "VehicleRunPage 对象", position = 6)
	public R runVehicle(@RequestBody VehicleRunPage vehicleRunPage){
			return R.data(service.selectrunvehicle(vehicleRunPage));
	}
	@PostMapping("runVehicleDetails")
	@ApiLog("数据中心-车辆周运行详情")
	@ApiOperation(value = "数据中心-车辆周运行详情", notes = "VehicleRunDetailsPage 对象", position = 6)
	public R runVehicleDetails(@RequestBody VehicleRunDetailsPage vehicleRunDetailsPage){

		VehicleRunDetailsPage list = service.selecterunvehicleDetails(vehicleRunDetailsPage);


		List<VehicleRundetails> list2=list.getRecords();
		List<VehiclePTCompany> getvehicle = gpsPointDataClient.getvehicle(vehicleRunDetailsPage.getCompany());
		System.out.println(getvehicle);
		for(VehicleRundetails a:list2){
			String cpn=a.getPlate();
			String color=a.getColor();
			for(VehiclePTCompany b:getvehicle){
				if(cpn.equals(b.getCph()) && color.equals(b.getPlatecolor())){
						a.setVehid(b.getId());
						break;
				}
			}

		}
		list.setRecords(list2);

		return R.data(list);
	}





}
