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
package org.springblade.anbiao.richenganpai.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springblade.anbiao.richenganpai.entity.Richenganpai;
import org.springblade.anbiao.richenganpai.page.RiChengAnPaiPage;
import org.springblade.anbiao.richenganpai.service.IRichenganpaiService;
import org.springblade.anbiao.richenganpai.vo.RichengIndexVo;
import org.springblade.anbiao.richenganpai.vo.RichenganpaiVO;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.system.feign.IDictClient;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.feign.IUserClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  控制器
 * @author Blade
 * @since 2019-06-06
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/richenganpai")
@Api(value = "日程安排", tags = "日程安排接口")
public class RichenganpaiController extends BladeController {

	private IRichenganpaiService richenganpaiService;

	private IDictClient dictClient;

	@GetMapping("/richengIndex")
	@ApiLog("日程首页数据-日程安排")
	@ApiOperation(value = "日程首页数据-日程安排", notes = "传入单位id,日期", position = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true),
		@ApiImplicitParam(name = "date", value = "日期(yyyy-MM-dd)", required = true)
	})
	public R<List<RichengIndexVo>> richengIndex(Integer deptId,String date, BladeUser user) {
		List<RichengIndexVo> list= richenganpaiService.selectRichengIndex(deptId,user.getUserId(),date);
		return R.data(list);
	}

	@PostMapping(value = "/getRiChengByDateList")
	@ApiLog("获取当天日程-日程安排")
	@ApiOperation(value = "获取当天日程-日程安排", notes = "传入riChengAnPaiPage", position = 3)
	public R<RiChengAnPaiPage<RichenganpaiVO>> getRiChengByDateList(@RequestBody RiChengAnPaiPage riChengAnPaiPage) {
		R r = new R();
		//排序条件
		////默认车辆牌照降序
		if(riChengAnPaiPage.getOrderColumns()==null){
			riChengAnPaiPage.setOrderColumn("renwukaishishijian");
		}else{
			riChengAnPaiPage.setOrderColumn(riChengAnPaiPage.getOrderColumns());
		}
		RiChengAnPaiPage<RichenganpaiVO> pages = richenganpaiService.selectByDate(riChengAnPaiPage);
		if(pages != null){
			r.setMsg("获取成功");
			r.setData(pages);
			r.setCode(200);
		}else{
			r.setMsg("获取成功,暂无数据");
			r.setCode(200);
		}
		return r;
	}

	@PostMapping(value = "/getRiChengChaoQiByDateList")
	@ApiLog("获取超期日程-日程安排")
	@ApiOperation(value = "获取超期日程-日程安排", notes = "传入riChengAnPaiPage", position = 3)
	public R<RiChengAnPaiPage<RichenganpaiVO>> getRiChengChaoQiByDateList(@RequestBody RiChengAnPaiPage riChengAnPaiPage) {
		R r = new R();
		//排序条件
		////默认车辆牌照降序
		if(riChengAnPaiPage.getOrderColumns()==null){
			riChengAnPaiPage.setOrderColumn("renwujiezhishijian");
		}else{
			riChengAnPaiPage.setOrderColumn(riChengAnPaiPage.getOrderColumns());
		}
		RiChengAnPaiPage<RichenganpaiVO> pages = richenganpaiService.selectChaoQiByDate(riChengAnPaiPage);
		if(pages != null){
			r.setMsg("获取成功");
			r.setData(pages);
			r.setCode(200);
		}else{
			r.setMsg("获取成功,暂无数据");
			r.setCode(200);
		}
		return r;
	}

	@PostMapping(value = "/getAnpaiByUserList")
	@ApiLog("获取当前用户安排的日程-日程安排")
	@ApiOperation(value = "获取当前用户安排的日程-日程安排", notes = "传入riChengAnPaiPage", position = 3)
	public R<RiChengAnPaiPage<RichenganpaiVO>> getAnpaiByUserList(@RequestBody RiChengAnPaiPage riChengAnPaiPage) {
		R r = new R();
		//排序条件
		////默认车辆牌照降序
		if(riChengAnPaiPage.getOrderColumns()==null){
			riChengAnPaiPage.setOrderColumn("renwukaishishijian");
		}else{
			riChengAnPaiPage.setOrderColumn(riChengAnPaiPage.getOrderColumns());
		}
		RiChengAnPaiPage<RichenganpaiVO> pages = richenganpaiService.selectAnpaiByUser(riChengAnPaiPage);
		if(pages != null){
			r.setMsg("获取成功");
			r.setData(pages);
			r.setCode(200);
		}else{
			r.setMsg("获取成功,暂无数据");
			r.setCode(200);
		}
		return r;
	}

	/**
	* 自定义分页
	*/
	@GetMapping("/page")
	@ApiIgnore
	@ApiLog("分页-日程安排")
	@ApiOperation(value = "分页-日程安排", notes = "传入richenganpai", position = 3)
	public R<IPage<RichenganpaiVO>> page(RichenganpaiVO richenganpai, Query query) {
		IPage<RichenganpaiVO> pages = richenganpaiService.selectRichenganpaiPage(Condition.getPage(query), richenganpai);
		return R.data(pages);
	}

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入richenganpai", position = 2)
	public R<Richenganpai> detail(String Id) {
		R r = new R();
		Richenganpai detail = richenganpaiService.selectByIds(Id);
		if(detail != null){
			r.setMsg("获取成功");
			r.setData(detail);
			r.setCode(200);
		}else{
			r.setMsg("获取成功,暂无数据");
			r.setCode(200);
		}
		return r;
	}

	/**
	 * 新增
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入richenganpai；zhixingrenIds(需传入id字符串，以英文逗号隔开)；zhixingrens(需传入名字字符串，以英文逗号隔开)", position = 6)
	public R submit(@RequestBody Richenganpai richenganpai) {
		R rs = new R();
		if (StringUtils.isBlank(richenganpai.getCaozuoshijian())){
			richenganpai.setCaozuoshijian(DateUtil.now());
		}
		if (richenganpai.getIsDeleted() != 0){
			richenganpai.setIsDeleted(0);
		}
//		String id = richenganpai.getZhixingrenIds();
//		String[] idsss = id.split(",");
//		//去除素组中重复的数组
//		List<String> listid = new ArrayList<String>();
//		for (int i=0; i<idsss.length; i++) {
//			if(!listid.contains(idsss[i])) {
//				listid.add(idsss[i]);
//			}
//		}
		//返回一个包含所有对象的指定类型的数组
//		String[]  idss= listid.toArray(new String[1]);
//		for(int i = 0;i< idss.length;i++){
//			richenganpai.setZhixingrenIds(idss[i]);
//			User user = richenganpaiService.getUserById(Integer.parseInt(idss[i]));
//			if(user == null){
//				rs.setMsg(idss[i]+"没有该人员");
//			}else{
//				richenganpai.setZhixingrens(user.getName());
//				boolean ss = richenganpaiService.insertSelective(richenganpai);
//				if(ss){
//					rs.setCode(200);
//					rs.setSuccess(true);
//					rs.setMsg("新增日程安排信息成功");
//				}else{
//					rs.setCode(500);
//					rs.setSuccess(false);
//					rs.setMsg("新增日程安排信息失败");
//				}
//			}
//		}
		boolean ss = richenganpaiService.insertSelective(richenganpai);
		if(ss){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("新增日程安排信息成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("新增日程安排信息失败");
		}
		return rs;
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入richenganpai；zhixingrenIds(需传入id字符串，以英文逗号隔开)；zhixingrens(需传入名字字符串，以英文逗号隔开)", position = 6)
	public R update(@RequestBody Richenganpai richenganpai) {
		R rs = new R();
		if (StringUtils.isBlank(richenganpai.getCaozuoshijian())){
			richenganpai.setCaozuoshijian(DateUtil.now());
		}
//		String id = richenganpai.getZhixingrenIds();
//////		String[] idsss = id.split(",");
//////		//去除素组中重复的数组
//////		List<String> listid = new ArrayList<String>();
//////		for (int i=0; i<idsss.length; i++) {
//////			if(!listid.contains(idsss[i])) {
//////				listid.add(idsss[i]);
//////			}
//////		}
//////		//返回一个包含所有对象的指定类型的数组
//////		String[]  idss= listid.toArray(new String[1]);
//////		for(int i = 0;i< idss.length;i++){
//////			richenganpai.setZhixingrenIds(idss[i]);
//////			User user = richenganpaiService.getUserById(Integer.parseInt(idss[i]));
//////			if(user == null){
//////				rs.setMsg(idss[i]+"没有该人员");
//////			}else{
//////				richenganpai.setZhixingrens(user.getName());
//////				boolean ss = richenganpaiService.updateSelective(richenganpai);
//////				if(ss){
//////					rs.setCode(200);
//////					rs.setSuccess(true);
//////					rs.setMsg("编辑日程安排信息成功");
//////				}else{
//////					rs.setCode(500);
//////					rs.setSuccess(false);
//////					rs.setMsg("编辑日程安排信息失败");
//////				}
//////			}
//////		}
		boolean ss = richenganpaiService.updateSelective(richenganpai);
		if(ss){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("编辑日程安排信息成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("编辑日程安排信息失败");
		}
		return rs;
	}

	/**
	 * 删除
	 */
	@GetMapping("/remove")
	@ApiLog("删除日程安排")
	@ApiOperation(value = "删除日程安排", notes = "传入日程安排ID、用户ID", position = 7)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Id", value = "日程安排ID", required = true),
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true),
		@ApiImplicitParam(name = "userName", value = "用户名称", required = true)
	})
	public R remove(@RequestParam Integer Id,Integer userId,String userName) {
		R rs = new R();
		String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		boolean ss = richenganpaiService.deleteBind(updateTime,userName,userId,Id);
		if(ss){
			rs.setCode(200);
			rs.setSuccess(true);
			rs.setMsg("删除日程安排信息成功");
		}else{
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setMsg("删除日程安排信息失败");
		}
		return rs;
	}



}
