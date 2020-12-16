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
package org.springblade.anbiao.ts.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoWenjianVO;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.vo.*;
import org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO;
import org.springblade.anbiao.jiashiyuan.vo.ZhengjianshenyanVO;
import org.springblade.anbiao.ts.service.TsService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.system.entity.Dept;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author elvis.he
 * @since 2019-05-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/ts")
@Api(value = "临时数据同步", tags = "临时数据同步接口")
public class TsController  {

	private TsService tsService;


	@PostMapping("/dept")
	@ApiLog("同步企业-临时数据同步")
	@ApiOperation(value = "同步企业-临时数据同步", notes = "报告id", position = 2)
	public R dept (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> readAll = reader.readAll();
		List<Dept> all = reader.readAll(Dept.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> tsService.insertDept(item));
		all.forEach(item -> tsService.isnertOrg(item));
		return R.success("同步成功");
	}
	@PostMapping("/vehicle")
	@ApiLog("同步车辆-临时数据同步")
	@ApiOperation(value = "同步车辆-临时数据同步", notes = "同步车辆", position = 2)
	public R vehicle (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<Vehicle> all = reader.readAll(Vehicle.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getRuhushijian())){
				item.setRuhushijian(null);
			}
			if("".equals(item.getZhucedengjishijian())){
				item.setZhucedengjishijian(null);
			}
			if("".equals(item.getGuohushijian())){
				item.setGuohushijian(null);
			}
			if("".equals(item.getTuishishijian())){
				item.setTuishishijian(null);
			}
			if("".equals(item.getQiangzhibaofeishijian())){
				item.setQiangzhibaofeishijian(null);
			}
			if("".equals(item.getChuchangriqi())){
				item.setChuchangriqi(null);
			}
			if("".equals(item.getGpsanzhuangshijian())){
				item.setGpsanzhuangshijian(null);
			}
			tsService.insertVehicle(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangbaoxian")
	@ApiLog("同步车辆保险-临时数据同步")
	@ApiOperation(value = "同步车辆保险-临时数据同步", notes = "同步车辆保险", position = 2)
	public R cheliangbaoxian (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangbaoxianVO> all = reader.readAll(CheliangbaoxianVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getDengjishijian())){
				item.setDengjishijian(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangbaoxian(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/baoxianmingxi")
	@ApiLog("同步车辆保险明细-临时数据同步")
	@ApiOperation(value = "同步车辆保险明细-临时数据同步", notes = "同步车辆保险明细", position = 2)
	public R baoxianmingxi (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<BaoxianxinxiVO> all = reader.readAll(BaoxianxinxiVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			if("".equals(item.getQibaoshijian())){
				item.setQibaoshijian(null);
			}
			if("".equals(item.getZhongbaoshijian())){
				item.setZhongbaoshijian(null);
			}
			if("".equals(item.getChudanshijian())){
				item.setChudanshijian(null);
			}
			if("".equals(item.getLingqushijian())){
				item.setLingqushijian(null);
			}if("".equals(item.getZhengbenjiaojieshijian())){
				item.setZhengbenjiaojieshijian(null);
			}
			if("".equals(item.getFapiaojiaojieshijian())){
				item.setFapiaojiaojieshijian(null);
			}

			item.setCreatetime(DateUtil.now());
			tsService.insertBaoxianmingxi(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/chelianganquan")
	@ApiLog("同步车辆安全-临时数据同步")
	@ApiOperation(value = "同步车辆安全-临时数据同步", notes = "同步车辆安全", position = 2)
	public R chelianganquan (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<ChelianganquanshebeiVO> all = reader.readAll(ChelianganquanshebeiVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			item.setCreatetime(DateUtil.now());
			tsService.insertChelianganquan(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangdengjipingding")
	@ApiLog("同步车辆等级评定-临时数据同步")
	@ApiOperation(value = "同步车辆等级评定-临时数据同步", notes = "同步车辆等级评定", position = 2)
	public R cheliangdengjipingding (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangdengjipingdingVO> all = reader.readAll(CheliangdengjipingdingVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getPingdingriqi())){
				item.setPingdingriqi(null);
			}
			if("".equals(item.getPingdingyouxiaoqi())){
				item.setPingdingyouxiaoqi(null);
			}
			if("".equals(item.getJianceriqi())){
				item.setJianceriqi(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangdengjipingding(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangguanchejiancha")
	@ApiLog("同步车辆罐车检查-临时数据同步")
	@ApiOperation(value = "同步车辆罐车检查-临时数据同步", notes = "同步车辆罐车检查", position = 2)
	public R cheliangguanchejiancha (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangguanchejianchaVO> all = reader.readAll(CheliangguanchejianchaVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getJianyanriqi())){
				item.setJianyanriqi(null);
			}
			if("".equals(item.getXiacijianyanshijian())){
				item.setXiacijianyanshijian(null);
			}
			if("".equals(item.getXiacinianshenshijian())){
				item.setXiacinianshenshijian(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangguanchejiancha(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangjingying")
	@ApiLog("同步车辆经营-临时数据同步")
	@ApiOperation(value = "同步车辆经营-临时数据同步", notes = "同步车辆经营", position = 2)
	public R cheliangjingying (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangjingyingVO> all = reader.readAll(CheliangjingyingVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getJingyingkaishiriqi())){
				item.setJingyingkaishiriqi(null);
			}
			if("".equals(item.getJingyingjiezhiriqi())){
				item.setJingyingjiezhiriqi(null);
			}
			if("".equals(item.getHetongyouxiaoqi())){
				item.setHetongyouxiaoqi(null);
			}
			if("".equals(item.getYunshuzhengfafangri())){
				item.setYunshuzhengfafangri(null);
			}
			if("".equals(item.getYunshuzhengyouxiaoqi())){
				item.setYunshuzhengyouxiaoqi(null);
			}
			if("".equals(item.getXingzhengxukeqixian())){
				item.setXingzhengxukeqixian(null);
			}
			if("".equals(item.getXingshizhengfafangri())){
				item.setXingshizhengfafangri(null);
			}
			if("".equals(item.getXingshizhengzhuceri())){
				item.setXingshizhengzhuceri(null);
			}
			if("".equals(item.getJianyanyouxiaoqi())){
				item.setJianyanyouxiaoqi(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangjingying(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangyuejian")
	@ApiLog("同步车辆月检-临时数据同步")
	@ApiOperation(value = "同步车辆月检-临时数据同步", notes = "同步车辆月检", position = 2)
	public R cheliangyuejian (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangyuejianVO> all = reader.readAll(CheliangyuejianVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getJianchariqi())){
				item.setJianchariqi(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangyuejian(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangweihu")
	@ApiLog("同步车辆维护-临时数据同步")
	@ApiOperation(value = "同步车辆维护-临时数据同步", notes = "同步车辆维护", position = 2)
	public R cheliangweihu (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangweihuVO> all = reader.readAll(CheliangweihuVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getJinchangriqi())){
				item.setJinchangriqi(null);
			}
			if("".equals(item.getChuchangriqi())){
				item.setChuchangriqi(null);
			}
			if("".equals(item.getXiaciweihuriqi())){
				item.setXiaciweihuriqi(null);
			}
			if("".equals(item.getLurushijian())){
				item.setLurushijian(null);
			}
			item.setCreatetime(DateUtil.now());
			tsService.insertCheliangweihu(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/jiashiyuan")
	@ApiLog("同步驾驶员-临时数据同步")
	@ApiOperation(value = "同步驾驶员-临时数据同步", notes = "同步驾驶员", position = 2)
	public R jiashiyuan (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<JiaShiYuanVO> all = reader.readAll(JiaShiYuanVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getChushengshijian())){
				item.setChushengshijian(null);
			}
			if("".equals(item.getShenfenzhengyouxiaoqi())){
				item.setShenfenzhengyouxiaoqi(null);
			}
			if("".equals(item.getPingyongriqi())){
				item.setPingyongriqi(null);
			}
			if("".equals(item.getJiashizhengchulingriqi())){
				item.setJiashizhengchulingriqi(null);
			}
			if("".equals(item.getJiashizhengyouxiaoqi())){
				item.setJiashizhengyouxiaoqi(null);
			}
			if("".equals(item.getTijianyouxiaoqi())){
				item.setTijianyouxiaoqi(null);
			}
			if("".equals(item.getCongyezhengyouxiaoqi())){
				item.setCongyezhengyouxiaoqi(null);
			}
			if("".equals(item.getCongyezhengchulingri())){
				item.setCongyezhengchulingri(null);
			}
			if("".equals(item.getXiacichengxinkaoheshijian())){
				item.setXiacichengxinkaoheshijian(null);
			}
			if("".equals(item.getXiacijixujiaoyushijian())){
				item.setXiacijixujiaoyushijian(null);
			}
			if("".equals(item.getHuzhaoyouxiaoqi())){
				item.setHuzhaoyouxiaoqi(null);
			}
			if("".equals(item.getZhunjiazhengyouxiaoqi())){
				item.setZhunjiazhengyouxiaoqi(null);
			}
			if("".equals(item.getLizhishijian())){
				item.setLizhishijian(null);
			}
			if("".equals(item.getChengxinkaoheshijian())){
				item.setChengxinkaoheshijian(null);
			}
			if("".equals(item.getJixujiaoyushijian())){
				item.setJixujiaoyushijian(null);
			}
			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			tsService.insertJiashiyuan(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangrenyuan")
	@ApiLog("同步车辆人员-临时数据同步")
	@ApiOperation(value = "同步车辆人员-临时数据同步", notes = "同步车辆人员", position = 2)
	public R cheliangrenyuan (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangrenyuanbangdingVO> all = reader.readAll(CheliangrenyuanbangdingVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);

			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			tsService.insertCheliangrenyuan(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangnianshen")
	@ApiLog("同步车辆年审-临时数据同步")
	@ApiOperation(value = "同步车辆年审-临时数据同步", notes = "同步车辆年审", position = 2)
	public R cheliangnianshen (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangnianshenVO> all = reader.readAll(CheliangnianshenVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getJianyanriqi())){
				item.setJianyanriqi(null);
			}
			if("".equals(item.getJianyanyouxiaoqi())){
				item.setJianyanyouxiaoqi(null);
			}
			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			tsService.insertcheliangnianshen(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/cheliangbaofei")
	@ApiLog("同步车辆报废-临时数据同步")
	@ApiOperation(value = "同步车辆报废-临时数据同步", notes = "同步车辆报废", position = 2)
	public R cheliangbaofei (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<CheliangbaofeiVO> all = reader.readAll(CheliangbaofeiVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			if("".equals(item.getZhucedengjishijian())){
				item.setZhucedengjishijian(null);
			}
			if("".equals(item.getQiangzhibaofeiriqi())){
				item.setQiangzhibaofeiriqi(null);
			}
			if("".equals(item.getShijibaofeiriqi())){
				item.setShijibaofeiriqi(null);
			}
			tsService.insertCheliangbaofei(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/guanchejianchamingxi")
	@ApiLog("同步罐车检查明细-临时数据同步")
	@ApiOperation(value = "同步罐车检查明细-临时数据同步", notes = "同步罐车检查明细", position = 2)
	public R guanchejianchamingxi (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<GuanchejianchaxinxiVO> all = reader.readAll(GuanchejianchaxinxiVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			if("".equals(item.getJianceshijian())){
				item.setJianceshijian(null);
			}
			if("".equals(item.getDaoqishijian())){
				item.setDaoqishijian(null);
			}
			tsService.insertguanchejianchamingxi(item);
		});
		return R.success("同步成功");
	}
	@PostMapping("/zhengjianshenyan")
	@ApiLog("同步证件审验-临时数据同步")
	@ApiOperation(value = "同步证件审验-临时数据同步", notes = "同步证件审验", position = 2)
	public R zhengjianshenyan (MultipartFile file) throws IOException {
		ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
		List<Map<String,Object>> radAll = reader.readAll();
		List<ZhengjianshenyanVO> all = reader.readAll(ZhengjianshenyanVO.class);
		// TODO: 2019/7/1  insert 方法
		all.forEach(item -> {
			Integer deptId = tsService.getDeptIdByDeptName(item.getDeptName());
			item.setDeptId(deptId);
			if("".equals(item.getCreatetime())){
				item.setCreatetime(DateUtil.now());
			}
			if("".equals(item.getShenyanriqi())){
				item.setShenyanriqi(null);
			}
			if("".equals(item.getShenyanyouxiaoqi())){
				item.setShenyanyouxiaoqi(null);
			}
			tsService.insertZhengjianshenyan(item);
		});
		return R.success("同步成功");
	}


}
