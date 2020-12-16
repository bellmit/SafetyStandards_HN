/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.anbiao.cheliangguanli.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Cheliangjingying;
import org.springblade.anbiao.cheliangguanli.page.CheliangjingyingPage;
import org.springblade.anbiao.cheliangguanli.service.ICheliangjingyingService;
import org.springblade.anbiao.cheliangguanli.vo.CheliangjingyingVO;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/cheliangjingying")
@Api(value = "车辆经营", tags = "车辆经营")
public class CheliangjingyingController extends BladeController {
	private IConfigureService mapService;
	private ICheliangjingyingService cheliangjingyingService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiLog("详情-车辆经营")
	@ApiOperation(value = "详情-车辆经营", notes = "传入id", position = 1)
	public R detail(String id) {
		return R.data(cheliangjingyingService.selectByIds(id));
	}

	/**
	* 自定义分页
	*/
	@PostMapping("/list")
	@ApiLog("分页-车辆经营")
	@ApiOperation(value = "分页-车辆经营", notes = "传入CheliangjingyingPage", position = 2)
	public R<CheliangjingyingPage<CheliangjingyingVO>> list(@RequestBody CheliangjingyingPage Page) {
		CheliangjingyingPage<CheliangjingyingVO> pages = cheliangjingyingService.selectPageList(Page);
		return R.data(pages);
	}

	/**
	* 新增
	*/
	@PostMapping("/insert")
	@ApiLog("新增-车辆经营")
	@ApiOperation(value = "新增-车辆经营", notes = "传入cheliangjingying", position = 3)
	public R insert(@RequestBody Cheliangjingying cheliangjingying,BladeUser user) {
		cheliangjingying.setCaozuoren(user.getUserName());
		cheliangjingying.setCaozuorenid(user.getUserId());
		cheliangjingying.setCaozuoshijian(DateUtil.now());
		cheliangjingying.setCreatetime(DateUtil.now());
		if("".equals(cheliangjingying.getJingyingkaishiriqi())){
			cheliangjingying.setJingyingkaishiriqi(null);
		}
		if("".equals(cheliangjingying.getJingyingjiezhiriqi())){
			cheliangjingying.setJingyingjiezhiriqi(null);
		}
		if("".equals(cheliangjingying.getHetongyouxiaoqi())){
			cheliangjingying.setHetongyouxiaoqi(null);
		}
		if("".equals(cheliangjingying.getYunshuzhengfafangri())){
			cheliangjingying.setYunshuzhengfafangri(null);
		}
		if("".equals(cheliangjingying.getYunshuzhengyouxiaoqi())){
			cheliangjingying.setYunshuzhengyouxiaoqi(null);
		}
		if("".equals(cheliangjingying.getXingzhengxukeqixian())){
			cheliangjingying.setXingzhengxukeqixian(null);
		}
		if("".equals(cheliangjingying.getXingshizhengfafangri())){
			cheliangjingying.setXingshizhengfafangri(null);
		}
		if("".equals(cheliangjingying.getXingshizhengzhuceri())){
			cheliangjingying.setXingshizhengzhuceri(null);
		}
		if("".equals(cheliangjingying.getJianyanyouxiaoqi())){
			cheliangjingying.setJianyanyouxiaoqi(null);
		}
		return R.status(cheliangjingyingService.save(cheliangjingying));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiLog("修改-车辆经营")
	@ApiOperation(value = "修改-车辆经营", notes = "传入cheliangjingying", position = 4)
	public R update(@RequestBody Cheliangjingying cheliangjingying,BladeUser user) {
		cheliangjingying.setCaozuoren(user.getUserName());
		cheliangjingying.setCaozuorenid(user.getUserId());
		cheliangjingying.setCaozuoshijian(DateUtil.now());
		if("".equals(cheliangjingying.getCreatetime())){
			cheliangjingying.setCreatetime(DateUtil.now());
		}
		if("".equals(cheliangjingying.getJingyingkaishiriqi())){
			cheliangjingying.setJingyingkaishiriqi(null);
		}
		if("".equals(cheliangjingying.getJingyingjiezhiriqi())){
			cheliangjingying.setJingyingjiezhiriqi(null);
		}
		if("".equals(cheliangjingying.getHetongyouxiaoqi())){
			cheliangjingying.setHetongyouxiaoqi(null);
		}
		if("".equals(cheliangjingying.getYunshuzhengfafangri())){
			cheliangjingying.setYunshuzhengfafangri(null);
		}
		if("".equals(cheliangjingying.getYunshuzhengyouxiaoqi())){
			cheliangjingying.setYunshuzhengyouxiaoqi(null);
		}
		if("".equals(cheliangjingying.getXingzhengxukeqixian())){
			cheliangjingying.setXingzhengxukeqixian(null);
		}
		if("".equals(cheliangjingying.getXingshizhengfafangri())){
			cheliangjingying.setXingshizhengfafangri(null);
		}
		if("".equals(cheliangjingying.getXingshizhengzhuceri())){
			cheliangjingying.setXingshizhengzhuceri(null);
		}
		if("".equals(cheliangjingying.getJianyanyouxiaoqi())){
			cheliangjingying.setJianyanyouxiaoqi(null);
		}
		return R.status(cheliangjingyingService.updateById(cheliangjingying));
	}

	/**
	* 删除
	*/
	@PostMapping("/del")
	@ApiLog("删除-车辆经营")
	@ApiOperation(value = "删除-车辆经营", notes = "传入id", position = 5)
	public R del(@ApiParam(value = "id", required = true) @RequestParam String id) {
		return R.status(cheliangjingyingService.updateDel(id));
	}

/********************************** 配置表 ***********************/

	/**
	 * 根据单位id获取配置模块数据
	 */
	@GetMapping("/listMap")
	@ApiLog("获取配置-车辆经营")
	@ApiOperation(value = "获取配置-车辆经营", notes = "传入deptId", position = 6)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list1=mapService.selectMapList("anbiao_cheliangjingying_map",deptId);
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
	@ApiLog("配置表新增-车辆经营")
	@ApiOperation(value = "配置表新增-车辆经营", notes = "传入biaodancanshu与deptId", position = 7)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_cheliangjingying_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-车辆经营")
	@ApiOperation(value = "配置表编辑-车辆经营", notes = "传入biaodancanshu与id", position = 9)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_cheliangjingying_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-车辆经营")
	@ApiOperation(value = "配置表删除-车辆经营", notes = "传入id", position = 8)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_cheliangjingying_map",id));
	}
}
