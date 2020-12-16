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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.StringUtil;
import org.springblade.manage.waybill.entity.Operations;
import org.springblade.manage.waybill.entity.Statistics;
import org.springblade.manage.waybill.page.OperationsPage;
import org.springblade.manage.waybill.page.StatisticsPage;
import org.springblade.manage.waybill.service.IOperationsService;
import org.springblade.manage.waybill.service.IStatisticsService;
import org.springblade.manage.waybill.vo.OperationsVO;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/manage/operations")
@Api(value = "货运管理-费用管理", tags = "货运管理-费用管理")
public class OperationsController extends BladeController {

	private IOperationsService operationsService;


	private IFileUploadClient fileUploadClient;


	private IStatisticsService iStatisticsService;

	/**
	 * 详情
	 */
	@PostMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入主键id", position = 1)
	public R<OperationsVO> detail(@RequestParam String id) {
		OperationsVO detail = operationsService.selectDetail(id);
		//附件
		if(StrUtil.isNotEmpty(detail.getFujian())){
			String[] a=detail.getFujian().split(",");
			String str="[";
			for (int i = 0; i <a.length ; i++) {
				if(i==0){
					str=str+fileUploadClient.getUrl(a[i]).substring(1,fileUploadClient.getUrl(a[i]).length()-1);
				}else{
					str=str+","+fileUploadClient.getUrl(a[i]).substring(1,fileUploadClient.getUrl(a[i]).length()-1);
				}
			}
			detail.setFujian(str+"]");
		}
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@PostMapping("/list")
	@ApiOperation(value = "列表", notes = "传入page", position = 2)
	public R<OperationsPage<OperationsVO>> list(@RequestBody OperationsPage page ) {
		OperationsPage<OperationsVO> list = operationsService.selectPageList(page);
		return R.data(list);
	}
	/**
	 * 新增
	 */
	@PostMapping("/insert")
	@ApiOperation(value = "新增", notes = "传入operations", position = 3)
	public R<Operations> save(@Valid @RequestBody Operations operations, BladeUser user) {
		Operations obj=new Operations();
		String msg = null;
		if(StringUtil.isNotBlank(operations.getVehicleId())){
			String ids= IdUtil.simpleUUID();
			operations.setId(ids);
			operations.setCreateTime(LocalDateTime.now().toString());
			operations.setCreateUser(user.getUserName());
			operations.setUpdateTime(LocalDateTime.now().toString());
			operations.setUpdateUser(user.getUserName());
			//代表从APP新增 默认为未审核状态
			if(operations.getBiaozhi()==1){
				operations.setStatus(1);
			}
			String type=operations.getType();
			//执行本身模块新增
			 operationsService.save(operations);
			//执行其他模块新增
			for (int i = 1; i <8 ; i++) {
				if(!type.equals(i+"")){
					operations.setType(i+"");
					operations.setId(IdUtil.simpleUUID());
					operations.setJine(new BigDecimal(0));
					operationsService.save(operations);
				}
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
	@ApiOperation(value = "修改", notes = "传入operations", position = 4)
	public R update(@Valid @RequestBody Operations operations, BladeUser user) {
		Operations obj=new Operations();
		String msg = null;
		//判断
		if(operations.getVehicleId() != null ){
			operations.setUpdateTime(LocalDateTime.now().toString());
			operations.setUpdateUser(user.getUserName());
			operationsService.updateById(operations);
		}else{
			msg="保存失败";
		}
		return  R.data(obj,msg);
	}

	/**
	 * 删除
	 */
	@PostMapping("/del")
	@ApiOperation(value = "删除", notes = "传入id", position = 7)
	public R remove(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		boolean flag=operationsService.removeById(id);
		return R.status(flag);
	}
	/**
	 * 统计列表
	 */
	@PostMapping("/listTotal")
	@ApiOperation(value = "统计列表", notes = "传入page", position = 9)
	public R<StatisticsPage<Statistics>> listTotal(@RequestBody StatisticsPage page ) {
		StatisticsPage<Statistics> list = iStatisticsService.selectPageList(page);
		return R.data(list);
	}


}
