/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicleController
 * Author:   呵呵哒
 * Date:     2020/7/3 9:42
 * Description:
 */
package org.springblade.anbiao.zhengfu.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.ZhengFuOrganization;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYeNew;
import org.springblade.anbiao.zhengfu.service.IOrganizationService;
import org.springblade.anbiao.zhengfu.service.IZhengFuShouYeNewService;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.common.tool.InterfaceUtil;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/24
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/zhengFuShouYeNew")
@Api(value = "政府-首页数据统计(new)", tags = "政府-首页数据统计(new)")
public class ZhengFuShouYeNewController {

	private IZhengFuShouYeNewService iZhengFuShouYeService;

	private IOrganizationService iOrganizationService;

	private FileServer fileServer;

	@GetMapping(value = "/getOne")
	@ApiLog("政府-企业总数、个体总数、车辆总数、在线车辆数")
	@ApiOperation(value = "政府-企业总数、个体总数、车辆总数、在线车辆数", notes = "传入deptId",position = 1)
	public R getOne(String deptId) throws IOException {
		R rs = new R();
		//获取前一天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String date = DateUtil.format(calendar.getTime(), "yyyy-MM-dd");
		List<ZhengFuShouYeNew>  zhengFuShouYeNew ;
		if(!StringUtils.isBlank(deptId)){
			if("5446".equals(deptId)){
				String xiaJiDeptId = deptId;
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetOne(null,xiaJiDeptId,date);
			}else{
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetOne(deptId,null,date);
			}
			List<ZhengFuOrganization> zhengFuOrganizations = null;
			if(zhengFuShouYeNew != null){
				if(zhengFuShouYeNew.size() >= 1){
					String dept = "";
					Integer RegisterCount = 0;
					Integer OnLineCount = 0;
					for (int p = 0; p < zhengFuShouYeNew.size(); p++){
						Organization jb = iOrganizationService.selectGetZFJB(zhengFuShouYeNew.get(p).getZhengfuid());
						if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
							zhengFuOrganizations = iOrganizationService.selectGetZF(zhengFuShouYeNew.get(p).getZhengfuid(),null,null,null);
						}

						if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
							zhengFuOrganizations = iOrganizationService.selectGetZF(null,zhengFuShouYeNew.get(p).getZhengfuid(),null,null);
						}

						if(!StringUtils.isBlank(jb.getCountry())){
							zhengFuOrganizations = iOrganizationService.selectGetZF(null,null,zhengFuShouYeNew.get(p).getZhengfuid(),null);
						}
						for (int i = 0; i < zhengFuOrganizations.size(); i++) {
							if(zhengFuOrganizations.get(i).getJigouleixing().equals("qiye")){
								dept += zhengFuOrganizations.get(i).getQiyeid() + ',';
							}
						}
					}
					String url = fileServer.getGpsVehiclePath() + "/GetMonitorInfo?dept=" + dept;
					String jsonstr = InterfaceUtil.getUrlData(url.replace(" ", "%20"));
					JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonstr);

					for (int i = 0; i < jsonArray.size(); i++){
						RegisterCount += (Integer)jsonArray.getJSONObject(i).get("RegisterCount");
						OnLineCount += (Integer)jsonArray.getJSONObject(i).get("zaixian");
					}
					zhengFuShouYeNew.get(0).setZcvehnumb(RegisterCount);
					zhengFuShouYeNew.get(0).setSxvehnum(OnLineCount);
				}else{
					Organization jb = iOrganizationService.selectGetZFJB(deptId);
					if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
						zhengFuOrganizations = iOrganizationService.selectGetZF(deptId,null,null,null);
					}

					if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
						zhengFuOrganizations = iOrganizationService.selectGetZF(null,deptId,null,null);
					}

					if(!StringUtils.isBlank(jb.getCountry())){
						zhengFuOrganizations = iOrganizationService.selectGetZF(null,null,deptId,null);
					}
				}
				if(zhengFuOrganizations.size() < 1){
					R r = new R();
					String[] aa = new String[0];
					r.setData(aa);
					r.setCode(200);
					r.setMsg("获取成功");
					return r;
				}else {
					String dept = "";
					Integer RegisterCount = 0;
					Integer OnLineCount = 0;
					for (int i = 0; i < zhengFuOrganizations.size(); i++) {
						if(zhengFuOrganizations.get(i).getJigouleixing().equals("qiye")){
							dept += zhengFuOrganizations.get(i).getQiyeid() + ',';
						}
					}
					String url = fileServer.getGpsVehiclePath() + "/GetMonitorInfo?dept=" + dept;
					String jsonstr = InterfaceUtil.getUrlData(url.replace(" ", "%20"));
					JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonstr);

					for (int i = 0; i < jsonArray.size(); i++){
						RegisterCount += (Integer)jsonArray.getJSONObject(i).get("RegisterCount");
						OnLineCount += (Integer)jsonArray.getJSONObject(i).get("zaixian");
					}
					zhengFuShouYeNew.get(0).setZcvehnumb(RegisterCount);
					zhengFuShouYeNew.get(0).setSxvehnum(OnLineCount);
				}

				rs.setCode(200);
				rs.setData(zhengFuShouYeNew);
				rs.setMsg("获取成功");
			}else{
				rs.setCode(200);
				rs.setData(null);
				rs.setMsg("获取成功");
				return rs;
			}
		}else{
			rs.setCode(500);
			rs.setMsg("传入deptId");
		}
		return rs;
	}


	@GetMapping(value = "/getTwo")
	@ApiLog("政府-超速报警次数、疲劳报警总数、夜间行驶报警次数、异常报警次数")
	@ApiOperation(value = "政府-超速报警次数、疲劳报警总数、夜间行驶报警次数、异常报警次数", notes = "传入deptId",position = 2)
	public R getTwo(int type,String deptId,int size) throws IOException {
		R rs = new R();
		//获取前一天的日期
		Calendar cal = Calendar.getInstance();
		//日期
		int day = cal.get(Calendar.DATE);
		//月份
		int month = cal.get(Calendar.MONTH) + 1;
		//年份
		int year = cal.get(Calendar.YEAR);
		//一周的第几天
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		//一月中的第几天
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		//一年的第几天
		int doy = cal.get(Calendar.DAY_OF_YEAR);
		ZhengFuShouYeNew zhengFuShouYeNew = null;
		List<ZhengFuShouYeNew> zhengFuShouYeNews = null;
		if(type == 1){
			if(!StringUtils.isBlank(deptId)){
				Organization organization2 = iOrganizationService.selectGetGangWei(deptId);
				if( !StringUtils.isBlank(organization2.getCountry()) ){
					zhengFuShouYeNew = iZhengFuShouYeService.selectGetTwo(deptId,null, year, month, null);
				}else{
					zhengFuShouYeNew = iZhengFuShouYeService.selectGetTwo(deptId,null, year, month, null);
					if(size > 0){
						zhengFuShouYeNews = iZhengFuShouYeService.selectGetTwoXJ(null, deptId, year, month, null);
					}else{
						zhengFuShouYeNews = iZhengFuShouYeService.selectGetTwoXJ(null, deptId, year, month, null);
					}
				}
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}else{
			if(!StringUtils.isBlank(deptId)) {
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetTwo(deptId, null, year, month, null);
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}
		if(zhengFuShouYeNew != null && zhengFuShouYeNews == null){
			rs.setCode(200);
			rs.setData(zhengFuShouYeNew);
			rs.setMsg("获取成功");
		}else if(zhengFuShouYeNew != null && zhengFuShouYeNews != null){
			rs.setCode(200);
			zhengFuShouYeNew.setXjlist(zhengFuShouYeNews);
			rs.setData(zhengFuShouYeNew);
			rs.setMsg("获取成功");
		}else{
			rs.setCode(500);
			rs.setMsg("获取成功，无数据");
		}
		return rs;
	}

	@GetMapping(value = "/getThree")
	@ApiLog("政府-北斗报警、主动安全设备报警月趋势")
	@ApiOperation(value = "政府-北斗报警、主动安全设备报警月趋势", notes = "传入相关参数type：0本级；1：下钻；areaName：选中的地图区域名称；deptId：当前登录机构id",position = 3)
	public R<ZhengFuShouYeNew> getThree(int type,String deptId) throws IOException {
		R rs = new R();
		//获取前一天的日期
		Calendar cal = Calendar.getInstance();
		//日期
		int day = cal.get(Calendar.DATE);
		//月份
		int month = cal.get(Calendar.MONTH) + 1;
		//年份
		int year = cal.get(Calendar.YEAR);
		List<ZhengFuShouYeNew> zhengFuShouYeNew = null;
		if(type == 1){
			if(!StringUtils.isBlank(deptId)){
				Organization organization2 = iOrganizationService.selectGetGangWei(deptId);
				if( !StringUtils.isBlank(organization2.getCountry()) ){
					zhengFuShouYeNew = iZhengFuShouYeService.selectGetThree(deptId,null,year,null);
				}else{
					zhengFuShouYeNew = iZhengFuShouYeService.selectGetThree(deptId,null,year,null);
				}
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}else{
			if(!StringUtils.isBlank(deptId)) {
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetThree(deptId, null, year, null);
			}else{
				rs.setCode(500);
				rs.setMsg("传入deptId");
			}
		}
		if(zhengFuShouYeNew != null){
			rs.setCode(200);
			rs.setData(zhengFuShouYeNew);
			rs.setMsg("获取成功");
		}else{
			rs.setCode(500);
			rs.setMsg("获取成功，无数据");
			return rs;
		}
		return rs;
	}


	@GetMapping(value = "/getFour")
	@ApiLog("政府-各地区详细报警数据表")
	@ApiOperation(value = "政府-各地区详细报警数据表", notes = "传入deptId",position = 4)
	public R<ZhengFuShouYeNew> getFour(String deptId) throws IOException {
		R rs = new R();
		//获取前一天的日期
		Calendar cal = Calendar.getInstance();
		//日期
		int day = cal.get(Calendar.DATE);
		//月份
		int month = cal.get(Calendar.MONTH) + 1;
		//年份
		int year = cal.get(Calendar.YEAR);

		//获取前一天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String date = DateUtil.format(calendar.getTime(), "yyyy-MM");
		if(!StringUtils.isBlank(deptId)){
			Organization organization2 = iOrganizationService.selectGetGangWei(deptId);
			List<ZhengFuShouYeNew> zhengFuShouYeNew;
			if( !StringUtils.isBlank(organization2.getCountry()) ){
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetFour(null,deptId,year,month,date);
				if(zhengFuShouYeNew != null){
					rs.setCode(200);
					rs.setData(zhengFuShouYeNew);
					rs.setMsg("获取成功");
				}else{
					rs.setCode(500);
					rs.setMsg("获取失败");
				}
			}else{
				zhengFuShouYeNew = iZhengFuShouYeService.selectGetFour(deptId,null,year,month,date);
				if(zhengFuShouYeNew != null){
					rs.setCode(200);
					rs.setData(zhengFuShouYeNew);
					rs.setMsg("获取成功");
				}else{
					rs.setCode(500);
					rs.setMsg("获取失败");
				}
			}
		}else{
			rs.setCode(500);
			rs.setMsg("传入deptId");
		}
		return rs;
	}


}

