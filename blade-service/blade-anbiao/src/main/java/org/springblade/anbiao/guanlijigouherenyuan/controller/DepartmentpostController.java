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
package org.springblade.anbiao.guanlijigouherenyuan.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost;
import org.springblade.anbiao.guanlijigouherenyuan.page.DepartmentpostPage;
import org.springblade.anbiao.guanlijigouherenyuan.page.PersonnelPage;
import org.springblade.anbiao.guanlijigouherenyuan.service.IDepartmentpostService;
import org.springblade.anbiao.guanlijigouherenyuan.service.IPersonnelService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.DepartmentpostVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/departmentpost")
@Api(value = "部门/岗位信息", tags = "部门/岗位信息")
public class DepartmentpostController extends BladeController {

	private IDepartmentpostService departmentpostService;

	private IConfigureService mapService;

	private ISysClient iSysClient;

	private IPersonnelService personnelService;


	@PostMapping("/list")
	@ApiLog("分页-部门/岗位信息")
	@ApiOperation(value = "分页-部门/岗位信息", notes = "传入anquanhuiyiPage", position = 1)
	public R<DepartmentpostPage<DepartmentpostVO>> list(@RequestBody DepartmentpostPage anquanhuiyiPage) {
		DepartmentpostPage<DepartmentpostVO> pages = departmentpostService.selectPageQuery(anquanhuiyiPage);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-部门/岗位信息")
	@ApiOperation(value = "新增-部门/岗位信息", notes = "传入departmentpost", position = 2)
	public R<Dept> save(@Valid @RequestBody Departmentpost departmentpost, BladeUser user) {
		Dept dept=new Dept();
		String type="岗位";
		//执行机构表新增
		String treeCode=iSysClient.selectByTreeCode(departmentpost.getParentId()).getTreeCode();
		dept.setTreeCode(treeCode);
		dept.setId(iSysClient.selectMaxId()+1);
		dept.setExtendType(departmentpost.getExtendType());
		dept.setDeptName(departmentpost.getMingcheng());
		dept.setFullName(departmentpost.getMingcheng());
		dept.setParentId(Integer.parseInt(departmentpost.getParentId()));
		boolean flag=iSysClient.insertDept(dept);

		//新增组织基本信息
		if(departmentpost.getMingcheng().equals("安全部")||departmentpost.getMingcheng().equals("安全员")){
			departmentpost.setGangweizhize("<p>\u200B1、严格执行安全生产的法律、法规、规章、规范和标准，组织落实相关管理部门的工作部署和要求；" +
				"<br><br>2、处理公司日常事务性工作的整体动作，及时将领导的指示精神予以传达、执行；" +
				"<br><br>3、协助安技办开展公司职工的安全宣传教育、培训工作；负责各种会议、重大安全生产活动的组织实施；" +
				"<br><br>4、做好来人来访的接待工作，用热情周到的服务，力求来访者满意。关心职工困难，维护职工合法权益，督促其他部门落实安全生产各项规章制度，参悟工伤事故的调查和处理；" +
				"<br><br>\u200B5、负责公司的车辆保险、承运人责任险和安全统筹工作。督促出险车辆的事故结案率和理赔、索赔工作；" +
				"<br><br>6、协调财务室、安技办做好安全生产设施、设备、抢险、救援、应急演练物资的采购、储备工作；" +
				"<br><br>7、做好与领导与职工的协调沟通工作，广泛征求职工对安全冬麦管理的意见或建议，为公司安全生产管理建议献策；" +
				"<br><br>8、组织职工开展安全生产活动，发动职工为安全生产提供合理化建议和举报事故隐患。<br></p>\n");
			departmentpost.setAnquanzhize("<P>     1、认真贯彻执行法律法规及有关安全生产的规章制度，并加以贯彻落实</P>");
		}

		departmentpost.setCaozuoren(user.getUserName());
		departmentpost.setCaozuorenid(user.getUserId());
		departmentpost.setCaozuoshijian(DateUtil.now());
		departmentpost.setCreatetime(DateUtil.now());
		departmentpost.setDeptId(dept.getId());
		departmentpost.setType(departmentpost.getExtendType());
		if(type.equals(departmentpost.getExtendType())){
			//新增岗位时默认给岗位赋权
			//String menuId="5,29,30,31,32";
			//默认给企业端赋权
			//String menuId="108,67,68,69,87,88,89,90,91,92,93,94,109,110,111,112,113,114,118,119,120,121,122,123,124,125,127,128,129,130,132,133,134,135,136,139,140";
			String menuId="67,68,109,87,88,89,110";
			iSysClient.ABgrant(dept.getId()+"", menuId);
		}else{

		}

		Dept obj=new Dept();
		if(flag==true){
			departmentpostService.saveOrUpdate(departmentpost);
			obj=iSysClient.selectById(dept.getId().toString());
		}
		String msg="操作成功";
		return  R.data(obj,msg);
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-部门/岗位信息")
	@ApiOperation(value = "修改-部门/岗位信息", notes = "传入departmentpost", position = 3)
	public R<Dept> update(@Valid @RequestBody Departmentpost departmentpost, BladeUser user) {
		//编辑机构信息
		Dept dept=iSysClient.selectById(departmentpost.getDeptId().toString());
		dept.setDeptName(departmentpost.getMingcheng());
		dept.setFullName(departmentpost.getMingcheng());
		dept.setSort(1);
		boolean flag=iSysClient.updateDept(dept);
		//修改基础信息
		departmentpost.setDeptId(dept.getId());
		departmentpost.setCaozuoren(user.getUserName());
		departmentpost.setCaozuorenid(user.getUserId());
		departmentpost.setCaozuoshijian(DateUtil.now());
		Dept obj=new Dept();
		if(flag==true){
			departmentpostService.updateById(departmentpost);
			obj=iSysClient.selectById(dept.getId().toString());
		}
		String msg="操作成功";
		return  R.data(obj,msg);
	}
	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-部门/岗位信息")
	@ApiOperation(value = "删除-部门/岗位信息", notes = "传入id", position = 4)
	public R remove(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		int i=iSysClient.selectCountByparentId(id);
		PersonnelPage Page=new PersonnelPage();
		Page.setPostId(Integer.parseInt(id));
		int j=personnelService.selectTotal(Page);
		int code=201;
		Object obj=new Object();
		String msg;
		if(i>0){
			msg="该组织下还存在下级，不能删除";
		}else if(j>0){
			msg="该岗位下还存在人员，不能删除";
		}else{
			boolean flag=iSysClient.removeById(id);
			//清楚企业基本信息
			departmentpostService.deletepost(departmentpostService.selectByPostId(id).getId());
			code=R.status(flag).getCode();
			obj=R.status(flag).getData();
			msg="删除成功";
		}
		return R.data(code,obj,msg);
	}
	@GetMapping("/detail")
	@ApiLog("详情-部门/岗位信息")
	@ApiOperation(value = "详情-部门/岗位信息", notes = "传入id", position = 5)
	public R<Departmentpost> detail(String id) {
		Departmentpost detail = departmentpostService.getById(id);
		return R.data(detail);
	}

	@GetMapping("/detailPost")
	@ApiLog("id详情-部门/岗位信息")
	@ApiOperation(value = "id详情-部门/岗位信息", notes = "传入id", position = 5)
	public R<Departmentpost> detailPost(String id) {
		Departmentpost detail = departmentpostService.selectByPostId(id);
		return R.data(detail);
	}
	/**
	* @Description: 获取岗位信息
	* @Param: [postId]
	* @return: org.springblade.core.tool.api.R<org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost>
	*/
	@GetMapping("/selectByPostId")
	@ApiLog("获取岗位信息-部门/岗位信息")
	@ApiOperation(value = "获取岗位信息-部门/岗位信息", notes = "传入岗位id", position = 5)
	public R<Departmentpost> selectByPostId(String postId) {
		Departmentpost detail = departmentpostService.selectByPostId(postId);
		return R.data(detail);
	}

	//-----------------配置表---------------------
	/**
	 * 配置表新增
	 */
	@PostMapping("/insertMap")
	@ApiLog("配置表新增-部门/岗位信息")
	@ApiOperation(value = "配置表新增-部门/岗位信息", notes = "传入biaodancanshu与deptId", position = 6)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_departmentpost_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-部门/岗位信息")
	@ApiOperation(value = "配置表编辑-部门/岗位信息", notes = "传入biaodancanshu与id", position = 6)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_departmentpost_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-部门/岗位信息")
	@ApiOperation(value = "配置表删除-部门/岗位信息", notes = "传入id", position = 7)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_departmentpost_map",id));
	}

	/**
	 * @Description: 根据单位id获取配置模块数据
	 * @Param: [postId]
	 */
	@GetMapping("/listMap")
	@ApiLog("获取配置-部门/岗位信息")
	@ApiOperation(value = "获取配置-部门/岗位信息", notes = "传入deptId", position = 8)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list=mapService.selectMapList("anbiao_departmentpost_map",deptId);
		String str="";
		for (int i = 0; i <list.size() ; i++) {
			//转换成json数据并put id
			JSONObject jsonObject = JSONUtil.parseObj(list.get(i).getBiaodancanshu());
			jsonObject.put("id",list.get(i).getId());
			if(!"".equals(str)){
				str=str+","+jsonObject.toString();
			}else{
				str=jsonObject.toString();
			}
		}
		str="["+str+"]";
		JSONArray json= JSONUtil.parseArray(str);
		return R.data(json);
	}


}
