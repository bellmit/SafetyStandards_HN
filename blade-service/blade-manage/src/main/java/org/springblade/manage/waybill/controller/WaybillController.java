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
package org.springblade.manage.waybill.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.manage.settlement.entity.Settlement;
import org.springblade.manage.settlement.service.ISettlementService;
import org.springblade.manage.waybill.entity.Waybill;
import org.springblade.manage.waybill.entity.WaybillFujian;
import org.springblade.manage.waybill.page.WaybillPage;
import org.springblade.manage.waybill.service.IWaybillFujianService;
import org.springblade.manage.waybill.service.IWaybillService;
import org.springblade.manage.waybill.vo.WaybillVO;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  控制器
 *
 * @author jx
 * @since 2019-08-07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/manage/waybill")
@Api(value = "货运管理", tags = "货运管理")
public class WaybillController extends BladeController {

	private IWaybillService waybillService;

	private ISettlementService settlementService;

	private IWaybillFujianService waybillFujianService;

	private IFileUploadClient fileUploadClient;


	/**
	* 货运单详情
	*/
	@PostMapping("/detail")
	@ApiLog("货运单详情")
	@ApiOperation(value = "货运单详情", notes = "传入主键id", position = 1)
	public R<Map<String, String>> detail(@RequestParam String id) {
		HashMap map = new HashMap();
		Waybill detail = waybillService.selectDetail(id);
		//入库附件
		if(StrUtil.isNotEmpty(detail.getOfujian())){
			detail.setOfujian(fileUploadClient.getUrl(detail.getOfujian()));
		}
		//出库附件
		if(StrUtil.isNotEmpty(detail.getIfujian())){
			detail.setIfujian(fileUploadClient.getUrl(detail.getIfujian()));
		}

		//燃油 过路 其他费用附件
		List<WaybillFujian> list=waybillFujianService.selectbyWayId(id);
		for (int i = 0; i <list.size() ; i++) {
			if(StrUtil.isNotEmpty(list.get(i).getFujian())){
				list.get(i).setFujian(fileUploadClient.getUrl(list.get(i).getFujian()));
			}
		}
		detail.setWaybillFujian(list);
		map.put("detail",detail);
		return R.data(map);
	}

	/**
	* 分页 
	*/
	@PostMapping("/list")
	@ApiLog("货运单列表")
	@ApiOperation(value = "货运单列表", notes = "传入WaybillPage", position = 2)
	public R<WaybillPage<WaybillVO>> list(@RequestBody WaybillPage page ) {
		WaybillPage<WaybillVO> list = waybillService.selectWaybillPageList(page);
		return R.data(list);
	}

	/**
	* 货运单新增
	*/
	@PostMapping("/insert")
	@ApiLog("货运单新增")
	@ApiOperation(value = "货运单新增", notes = "传入waybill", position = 4)
	public R<Waybill> save(@Valid @RequestBody Waybill waybill, BladeUser user) {
		waybill.setStatus(1);
		Waybill obj=new Waybill();
		String msg = null;
		Settlement settlement = new Settlement();
		//判断入库、出库附件是否填写
		if(waybill.getOfujian() != null && !"".equals(waybill.getOfujian())&&
				waybill.getIfujian() != null && !"".equals(waybill.getIfujian())){
			String ids=IdUtil.simpleUUID();
			waybill.setId(ids);
			waybill.setCreateTime(LocalDateTime.now().toString());
			waybill.setCreateUser(user.getUserName());
			waybill.setUpdateTime(LocalDateTime.now().toString());
			waybill.setUpdateUser(user.getUserName());
			boolean flag = waybillService.save(waybill);
			if(flag==true){
				//报表
				settlement.setDeptId(waybill.getDeptId());
				settlement.setWaybillId(ids);
				settlement.setZhuanghuoshijian(waybill.getOutTime());
				settlement.setXiehuoshijian(waybill.getIntoTime());
				settlement.setVehicleId(waybill.getVehicleId());
				settlement.setZhuanghuodi(waybill.getForwardeUnit());
				settlement.setXiehuodi(waybill.getReceiveUnit());
				settlement.setHuowumingcheng(waybill.getGoods());
				settlement.setZhuanghuoliang(waybill.getOnetWeight().toString());
				settlement.setXiehuoliang(waybill.getInetWeight().toString());
				settlement.setRukuxuhao(waybill.getIntoNum());
				settlement.setChukuxuhao(waybill.getOutNum());
				double bangcha=waybill.getInetWeight()-waybill.getOnetWeight();
				settlement.setBangcha(bangcha+"");
				settlement.setJiesuanliang(waybill.getJiesuanshu().toString());
				settlement.setDanjia(waybill.getDanjia());
				settlement.setCreatetime(LocalDateTime.now());
				settlement.setCreateuser(user.getUserName());
				settlement.setCaozuoshijian(LocalDateTime.now());
				settlement.setCaozuoren(user.getUserName());
				//计算总价
				double jine=Integer.parseInt(waybill.getDanjia())*(waybill.getInetWeight()/1000);
				settlement.setJine(jine+"");
				settlementService.save(settlement);
				List<WaybillFujian> ways=waybill.getWaybillFujian();
				if(ways.size()>0){
					for (int i = 0; i <ways.size() ; i++) {
						ways.get(i).setWaybillId(ids);
					}
					waybillFujianService.saveBatch(ways);
				}
				obj=waybill;
				msg="保存成功";
			}
		}else{
			msg="保存失败";
		}
		return  R.data(obj,msg);
	}

	/**
	* 修改 
	*/
	@PostMapping("/update")
	@ApiLog("货运单修改")
	@ApiOperation(value = "货运单修改", notes = "传入waybill", position = 5)
	public R update(@Valid @RequestBody Waybill waybill, BladeUser user) {
		Waybill obj=new Waybill();
		String msg = null;
		Settlement settlement = new Settlement();
		//判断入库、出库附件是否填写
		if(waybill.getOfujian() != null && !"".equals(waybill.getOfujian())&&
			waybill.getIfujian() != null && !"".equals(waybill.getIfujian())){
			waybill.setUpdateTime(LocalDateTime.now().toString());
			waybill.setUpdateUser(user.getUserName());
			boolean flag=waybillService.updateById(waybill);
			if(flag==true){
				//清楚报表数据重新生成
				settlementService.delBywaybillId(waybill.getId());
				//报表
				settlement.setDeptId(waybill.getDeptId());
				settlement.setWaybillId(waybill.getId());
				settlement.setZhuanghuoshijian(waybill.getOutTime());
				settlement.setXiehuoshijian(waybill.getIntoTime());
				settlement.setVehicleId(waybill.getVehicleId());
				settlement.setZhuanghuodi(waybill.getForwardeUnit());
				settlement.setXiehuodi(waybill.getReceiveUnit());
				settlement.setHuowumingcheng(waybill.getGoods());
				settlement.setZhuanghuoliang(waybill.getOnetWeight().toString());
				settlement.setXiehuoliang(waybill.getInetWeight().toString());
				settlement.setRukuxuhao(waybill.getIntoNum());
				settlement.setChukuxuhao(waybill.getOutNum());
				double bangcha=waybill.getInetWeight()-waybill.getOnetWeight();
				settlement.setBangcha(bangcha+"");
				settlement.setJiesuanliang(waybill.getJiesuanshu().toString());
				settlement.setDanjia(waybill.getDanjia());
				settlement.setCreatetime(LocalDateTime.now());
				settlement.setCreateuser(user.getUserName());
				settlement.setCaozuoshijian(LocalDateTime.now());
				settlement.setCaozuoren(user.getUserName());
				//计算总价
				double jine=Integer.parseInt(waybill.getDanjia())*(waybill.getInetWeight()/1000);
				settlement.setJine(jine+"");
				settlementService.save(settlement);
				//附件信息
				List<WaybillFujian> ways=waybill.getWaybillFujian();
				if(ways.size()>0){
					//清除原附件
					waybillFujianService.delBywaybillId(waybill.getId());
					for (int i = 0; i <ways.size() ; i++) {
						ways.get(i).setWaybillId(waybill.getId());
					}
					waybillFujianService.saveBatch(ways);
				}
				obj=waybill;
				msg="保存成功";
			}
		}else{
			msg="保存失败";
		}
		return  R.data(obj,msg);
	}


	/**
	* 删除 
	*/
	@PostMapping("/del")
	@ApiLog("货运单删除")
	@ApiOperation(value = "货运单删除", notes = "传入id", position = 7)
	public R remove(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		Waybill waybill=waybillService.getById(id);
		//清理对应附件
		if(StrUtil.isNotEmpty(waybill.getIfujian())){
			fileUploadClient.delByFileName(waybill.getIfujian());
		}
		if(StrUtil.isNotEmpty(waybill.getOfujian())){
			fileUploadClient.delByFileName(waybill.getOfujian());
		}
		//运单
		boolean flag=waybillService.removeById(id);
		if(flag==true){
			//清理对应附件
			List<WaybillFujian> list=waybillFujianService.selectbyWayId(id);
			for (int i = 0; i <list.size() ; i++) {
				if(StrUtil.isNotEmpty(list.get(i).getFujian())){
					fileUploadClient.delByFileName(list.get(i).getFujian());
				}
			}
			//报表
			settlementService.delBywaybillId(id);
			//附件
			waybillFujianService.delBywaybillId(id);
		}
		return R.status(flag);
	}

	/**
	 * 删除
	 */
	@PostMapping("/delFujian")
	@ApiLog("货运单燃油/过路费附件删除")
	@ApiOperation(value = "货运单燃油/过路费附件删除", notes = "传入id", position = 8)
	public R delFujian(@ApiParam(value = "主键id", required = true) @RequestParam Integer id) {
		//附件
		boolean flag=waybillFujianService.del(id);
		return R.status(flag);
	}

	
}
