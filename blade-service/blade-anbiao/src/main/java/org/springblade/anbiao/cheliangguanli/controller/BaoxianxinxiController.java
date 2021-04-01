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
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Baoxianxinxi;
import org.springblade.anbiao.cheliangguanli.page.BaoxianxinxiPage;
import org.springblade.anbiao.cheliangguanli.service.IBaoxianxinxiService;
import org.springblade.anbiao.cheliangguanli.vo.BaoxianxinxiVO;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/baoxianxinxi")
@Api(value = "保险信息", tags = "保险信息")
public class BaoxianxinxiController extends BladeController {

	private IBaoxianxinxiService baoxianxinxiService;
	private IConfigureService mapService;
	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-保险信息")
	@ApiOperation(value = "详情-保险信息", notes = "传入id", position = 1)
	public R detail(String id) {
		return R.data(baoxianxinxiService.selectByIds(id));
	}

	/**
	* 自定义分页
	*/
	@PostMapping("/list")
	@ApiLog("分页-保险信息")
	@ApiOperation(value = "分页-保险信息", notes = "传入BaoxianxinxiPage", position = 2)
	public R<BaoxianxinxiPage<BaoxianxinxiVO>> list(@RequestBody BaoxianxinxiPage Page) {
		BaoxianxinxiPage<BaoxianxinxiVO> pages = baoxianxinxiService.selectPageList(Page);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-保险信息")
	@ApiOperation(value = "新增-保险信息", notes = "传入baoxianxinxi", position = 3)
	public R insert(@RequestBody Baoxianxinxi baoxianxinxi,BladeUser user) {
		if(user == null){
			baoxianxinxi.setCaozuoren("管理员");
			baoxianxinxi.setCaozuorenid(1);
		}else{
			baoxianxinxi.setCaozuoren(user.getUserName());
			baoxianxinxi.setCaozuorenid(user.getUserId());
		}
		baoxianxinxi.setCaozuoshijian(DateUtil.now());
		baoxianxinxi.setCreatetime(DateUtil.now());
		if("".equals(baoxianxinxi.getQibaoshijian())){
			baoxianxinxi.setQibaoshijian(null);
		}
		if("".equals(baoxianxinxi.getZhongbaoshijian())){
			baoxianxinxi.setZhongbaoshijian(null);
		}
		if("".equals(baoxianxinxi.getChudanshijian())){
			baoxianxinxi.setChudanshijian(null);
		}
		if("".equals(baoxianxinxi.getLingqushijian())){
			baoxianxinxi.setLingqushijian(null);
		}if("".equals(baoxianxinxi.getZhengbenjiaojieshijian())){
			baoxianxinxi.setZhengbenjiaojieshijian(null);
		}
		if("".equals(baoxianxinxi.getFapiaojiaojieshijian())){
			baoxianxinxi.setFapiaojiaojieshijian(null);
		}
		return R.status(baoxianxinxiService.save(baoxianxinxi));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-保险信息")
	@ApiOperation(value = "修改-保险信息", notes = "传入baoxianxinxi", position = 4)
	public R update(@RequestBody Baoxianxinxi baoxianxinxi,BladeUser user) {

		if(user == null){
			baoxianxinxi.setCaozuoren("管理员");
			baoxianxinxi.setCaozuorenid(1);
		}else{
			baoxianxinxi.setCaozuoren(user.getUserName());
			baoxianxinxi.setCaozuorenid(user.getUserId());
		}
		baoxianxinxi.setCaozuoshijian(DateUtil.now());
		if("".equals(baoxianxinxi.getCreatetime())){
			baoxianxinxi.setCreatetime(DateUtil.now());
		}
		if("".equals(baoxianxinxi.getQibaoshijian())){
			baoxianxinxi.setQibaoshijian(null);
		}
		if("".equals(baoxianxinxi.getZhongbaoshijian())){
			baoxianxinxi.setZhongbaoshijian(null);
		}
		if("".equals(baoxianxinxi.getChudanshijian())){
			baoxianxinxi.setChudanshijian(null);
		}
		if("".equals(baoxianxinxi.getLingqushijian())){
			baoxianxinxi.setLingqushijian(null);
		}if("".equals(baoxianxinxi.getZhengbenjiaojieshijian())){
			baoxianxinxi.setZhengbenjiaojieshijian(null);
		}
		if("".equals(baoxianxinxi.getFapiaojiaojieshijian())){
			baoxianxinxi.setFapiaojiaojieshijian(null);
		}
		return R.status(baoxianxinxiService.updateById(baoxianxinxi));
	}

	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-保险信息")
	@ApiOperation(value = "删除-保险信息", notes = "传入id", position = 5)
	public R del( @RequestParam String id) {
		return R.status(baoxianxinxiService.updateDel(id));
	}

/********************************** 配置表 ***********************/

	/**
	 * 根据单位id获取配置模块数据
	 */
	@GetMapping("/listMap")
	@ApiLog("获取-配置模块数据")
	@ApiOperation(value = "获取-配置模块数据", notes = "传入deptId", position = 6)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list1=mapService.selectMapList("anbiao_baoxianxinxi_map",deptId);
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
	@ApiLog("配置表新增-保险信息")
	@ApiOperation(value = "配置表新增-保险信息", notes = "传入biaodancanshu与deptId", position = 7)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_baoxianxinxi_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-保险信息")
	@ApiOperation(value = "配置表编辑-保险信息", notes = "传入biaodancanshu与id", position = 9)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_baoxianxinxi_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-保险信息")
	@ApiOperation(value = "配置表删除-保险信息", notes = "传入id", position = 8)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_baoxianxinxi_map",id));
	}
}
