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
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.ZhengFuBaoGao;
import org.springblade.anbiao.zhengfu.page.OrganizationPage;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoGaoPage;
import org.springblade.anbiao.zhengfu.service.IOrganizationService;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/organization")
@Api(value = "政府-组织树", tags = "政府-组织树")
public class OrganizationController {

	private FileServer fileServer;

	private IOrganizationService iOrganizationService;

	@GetMapping(value = "/getTree")
	@ApiLog("政府-获取政府组织树结构数据")
	@ApiOperation(value = "政府-获取政府组织树结构数据", notes = "传入Id",position = 1)
	public R getTree(@ApiParam(value = "人员ID", required = true) @RequestParam String Id) throws IOException {
		R r = new R();
		//1.根据人员id判断树形的上级
		Organization organization2 = null;
		List<Organization> shuju = new ArrayList<>();
		Organization organization1 = iOrganizationService.selectGetRenyuan(Id);
		if (organization1 != null){
			organization2 = iOrganizationService.selectGetGangWei(organization1.getParentId());
			shuju.add(organization2);
			if( !StringUtils.isBlank(organization2.getCountry()) ){
				//县级运管
				Organization xinxi = new Organization();
				List<Organization>  xinxixian = iOrganizationService.selectGetXian(organization2.getId().toString());
				xinxi.setXianlist(xinxixian);
				shuju.add(xinxi);
				r.setData(shuju);
				r.setMsg("县级运管");
				r.setCode(200);
			}else if(StringUtils.isBlank(organization2.getCountry()) && !StringUtils.isBlank(organization2.getCity())){
				//市级运管
				Organization xinxi = new Organization();
				List<Organization>	xi = iOrganizationService.selectGetXian(organization2.getId().toString());
				xinxi.setXianlist(xi);
				shuju.add(xinxi);
				r.setData(shuju);
				r.setMsg("市级运管");
				r.setCode(200);
			}else if(StringUtils.isBlank(organization2.getCity()) && !StringUtils.isBlank(organization2.getProvince())){
				//省级运管
				Organization xinxi = new Organization();
				List<Organization> xinxishi = iOrganizationService.selectGetShi(organization2.getId());
				for (int i=0; i<xinxishi.size(); i++) {
					List<Organization> xinxixian = iOrganizationService.selectGetXian(xinxishi.get(i).getId());
					xinxishi.get(i).setXianlist(xinxixian);
				}
				xinxi.setShilist(xinxishi);
				shuju.add(xinxi);
				r.setData(shuju);
				r.setMsg("省级运管");
				r.setCode(200);
			}else{
				r.setMsg("该人员无上级政府机构");
			}
		}else{
			r.setMsg("该人员岗位不是政府岗位");
		}
		return r;
	}

	@GetMapping(value = "/getZFQYList")
	@ApiLog("政府-企业列表")
	@ApiOperation(value = "政府-企业列表",position = 2)
	public R getZFQYList(String deptId) throws IOException {
		return R.data(iOrganizationService.selectGetZF(null,null,null,deptId));
	}

	@PostMapping(value = "/getList")
	@ApiLog("政府首页-企业/个体资料统计列表")
	@ApiOperation(value = "政府首页-企业/个体资料统计列表", notes = "传入organizationPage",position = 1)
	public R getList(@RequestBody OrganizationPage organizationPage) throws IOException {
		R r = new R();
		Organization jb = iOrganizationService.selectGetZFJB(organizationPage.getDeptId());
		if(!StringUtils.isBlank(jb.getProvince()) && StringUtils.isBlank(jb.getCity())){
			organizationPage.setProvince(organizationPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCity()) && StringUtils.isBlank(jb.getCountry())){
			organizationPage.setCity(organizationPage.getDeptId());
		}

		if(!StringUtils.isBlank(jb.getCountry())) {
			organizationPage.setCountry(organizationPage.getDeptId());
		}

		//排序条件
		////默认报警总数降序
		if(organizationPage.getOrderColumns()==null){
			organizationPage.setOrderColumn("");
		}else{
			organizationPage.setOrderColumn(organizationPage.getOrderColumns());
		}

		OrganizationPage<Organization> organizationList =  iOrganizationService.selectALLPage(organizationPage);
		if(organizationList != null){
			r.setData(organizationList);
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

