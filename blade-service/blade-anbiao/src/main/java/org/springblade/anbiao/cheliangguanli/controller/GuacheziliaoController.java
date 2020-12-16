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
package org.springblade.anbiao.cheliangguanli.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.page.VehiclePage;
import org.springblade.anbiao.cheliangguanli.service.IVehicleService;
import org.springblade.anbiao.cheliangguanli.vo.VehicleVO;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.StringUtil;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  控制器
 *
 * @author hyp
 * @since 2020-10-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/guacheziliao")
@Api(value = "挂车资料", tags = "挂车资料")
public class GuacheziliaoController extends BladeController {
	private IConfigureService mapService;
	private IVehicleService vehicleService;
	private IFileUploadClient fileUploadClient;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-挂车资料")
	@ApiOperation(value = "详情-挂车资料", notes = "传入guacheziliao", position = 1)
	public R detail(String id) {
		VehicleVO detail = vehicleService.selectByKey(id);
		//车辆照片
		if(StrUtil.isNotEmpty(detail.getCheliangzhaopian())){
			detail.setCheliangzhaopian(fileUploadClient.getUrl(detail.getCheliangzhaopian()));
		}
		//燃料消耗附件
		if(StrUtil.isNotEmpty(detail.getRanliaoxiaohaofujian())){
			detail.setRanliaoxiaohaofujian(fileUploadClient.getUrl(detail.getRanliaoxiaohaofujian()));
		}
		//行驶证附件
		if(StrUtil.isNotEmpty(detail.getXingshifujian())){
			detail.setXingshifujian(fileUploadClient.getUrl(detail.getXingshifujian()));
		}
		return R.data(detail);
	}

	/**
	* 自定义分页
	*/
	@PostMapping("/list")
	@ApiLog("分页-挂车资料")
	@ApiOperation(value = "分页-挂车资料", notes = "传入GuacheziliaoPage", position = 2)
	public R<VehiclePage<VehicleVO>> list(@RequestBody VehiclePage vehiclepage) {
		vehiclepage.setCheliangleixing("1");
		VehiclePage<VehicleVO> pages = vehicleService.selectVehiclePage(vehiclepage);
		List<VehicleVO>  list=pages.getRecords();
		for (int i = 0; i <list.size() ; i++) {
			//车辆照片
			if(StrUtil.isNotEmpty(list.get(i).getCheliangzhaopian())){
				list.get(i).setCheliangzhaopian(fileUploadClient.getUrl(list.get(i).getCheliangzhaopian()));
			}
			//燃料消耗附件
			if(StrUtil.isNotEmpty(list.get(i).getRanliaoxiaohaofujian())){
				list.get(i).setRanliaoxiaohaofujian(fileUploadClient.getUrl(list.get(i).getRanliaoxiaohaofujian()));
			}
			//行驶证附件
			if(StrUtil.isNotEmpty(list.get(i).getXingshifujian())){
				list.get(i).setXingshifujian(fileUploadClient.getUrl(list.get(i).getXingshifujian()));
			}
		}
		return R.data(pages);
	}
	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-挂车资料")
	@ApiOperation(value = "新增-挂车资料", notes = "传入guacheziliao", position = 3)
	public R insert(@RequestBody Vehicle vehicle,BladeUser user) {
		vehicle.setCaozuoren(user.getUserName());
		vehicle.setCaozuorenid(user.getUserId());
		vehicle.setCaozuoshijian(LocalDateTime.now());
		vehicle.setCreatetime(LocalDateTime.now());
		if("".equals(vehicle.getRuhushijian())){
			vehicle.setRuhushijian(null);
		}
		if("".equals(vehicle.getZhucedengjishijian())){
			vehicle.setZhucedengjishijian(null);
		}
		if("".equals(vehicle.getGuohushijian())){
			vehicle.setGuohushijian(null);
		}
		if("".equals(vehicle.getTuishishijian())){
			vehicle.setTuishishijian(null);
		}
		if("".equals(vehicle.getQiangzhibaofeishijian())){
			vehicle.setQiangzhibaofeishijian(null);
		}
		if("".equals(vehicle.getChuchangriqi())){
			vehicle.setChuchangriqi(null);
		}
		if("".equals(vehicle.getGpsanzhuangshijian())){
			vehicle.setGpsanzhuangshijian(null);
		}
		String str="1";
		//登录页
		if(StringUtil.isNotBlank(vehicle.getCheliangzhaopian())){
			fileUploadClient.updateCorrelation(vehicle.getCheliangzhaopian(),str);
		}
		return R.status(vehicleService.save(vehicle));
	}
	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-挂车资料")
	@ApiOperation(value = "修改-挂车资料", notes = "传入guacheziliao", position = 4)
	public R update(@RequestBody Vehicle vehicle,BladeUser user) {
		vehicle.setCaozuoren(user.getUserName());
		vehicle.setCaozuorenid(user.getUserId());
		vehicle.setCaozuoshijian(LocalDateTime.now());
		if("".equals(vehicle.getCreatetime())){
			vehicle.setCreatetime(LocalDateTime.now());
		}
		if("".equals(vehicle.getRuhushijian())){
			vehicle.setRuhushijian(null);
		}
		if("".equals(vehicle.getZhucedengjishijian())){
			vehicle.setZhucedengjishijian(null);
		}
		if("".equals(vehicle.getGuohushijian())){
			vehicle.setGuohushijian(null);
		}
		if("".equals(vehicle.getTuishishijian())){
			vehicle.setTuishishijian(null);
		}
		if("".equals(vehicle.getQiangzhibaofeishijian())){
			vehicle.setQiangzhibaofeishijian(null);
		}
		if("".equals(vehicle.getChuchangriqi())){
			vehicle.setChuchangriqi(null);
		}
		if("".equals(vehicle.getGpsanzhuangshijian())){
			vehicle.setGpsanzhuangshijian(null);
		}
		return R.status(vehicleService.updateById(vehicle));
	}

	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-挂车资料")
	@ApiOperation(value = "删除-挂车资料", notes = "传入id", position = 5)
	public R del(@ApiParam(value = "id", required = true) @RequestParam String id) {
		return R.status(vehicleService.deleleVehicle(id));
	}

/********************************** 配置表 ***********************/

	/**
	 * 根据单位id获取配置模块数据
	 */
	@GetMapping("/listMap")
	@ApiLog("获取配置-挂车资料")
	@ApiOperation(value = "获取配置-挂车资料", notes = "传入deptId", position = 6)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list1=mapService.selectMapList("anbiao_guacheziliao_map",deptId);
		String str="";
		for (int i = 0; i <list1.size() ; i++) {
			//转换成json数据并put id
			JSONObject jsonObject = JSONUtil.parseObj(list1.get(i).getBiaodancanshu());
			jsonObject.put("id",list1.get(i).getId());
			if(!str.equals("")){
				str=str+","+jsonObject.toString();
			}else{
				str=jsonObject.toString();
			}
		}
		str="["+str+"]";
		JSONArray json= JSONUtil.parseArray(str);
		return R.data(json);
	}

	/**
	 * 配置表新增
	 */
	@PostMapping("/insertMap")
	@ApiLog("配置表新增-挂车资料")
	@ApiOperation(value = "配置表新增-挂车资料", notes = "传入biaodancanshu与deptId", position = 7)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_guacheziliao_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-挂车资料")
	@ApiOperation(value = "配置表编辑-挂车资料", notes = "传入biaodancanshu与id", position = 9)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_guacheziliao_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-挂车资料")
	@ApiOperation(value = "配置表删除-挂车资料", notes = "传入id", position = 8)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_guacheziliao_map",id));
	}
}
