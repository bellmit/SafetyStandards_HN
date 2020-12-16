package org.springblade.anbiao.jiashiyuan.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.jiashiyuan.entity.JiaShiYuan;
import org.springblade.anbiao.jiashiyuan.page.JiaShiYuanPage;
import org.springblade.anbiao.jiashiyuan.service.IJiaShiYuanService;
import org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by you on 2019/5/6.
 */
@RestController
@RequestMapping("/anbiao/yayunyuan")
@AllArgsConstructor
@Api(value = "押运员资料管理", tags = "押运员资料管理")
public class YayunyuanController {
	private IJiaShiYuanService iJiaShiYuanService;
	private IConfigureService mapService;

	/**
	 * 新增
	 */
	@PostMapping("/insert")
	@ApiLog("新增-押运员资料管理")
	@ApiOperation(value = "新增-押运员资料管理", notes = "传入jiaShiYuan", position = 1)
	public R insert(@RequestBody JiaShiYuan jiaShiYuan, BladeUser user) {
		if("男".equals(jiaShiYuan.getXingbie())){
			jiaShiYuan.setXingbie("1");
		}else{
			jiaShiYuan.setXingbie("2");
		}
		jiaShiYuan.setJiashiyuanleixing("押运员");
		jiaShiYuan.setCaozuoren(user.getUserName());
		jiaShiYuan.setCaozuorenid(user.getUserId());
		jiaShiYuan.setCaozuoshijian(DateUtil.now());
		jiaShiYuan.setCreatetime(DateUtil.now());
		if("".equals(jiaShiYuan.getChushengshijian())){
			jiaShiYuan.setChushengshijian(null);
		}
		if("".equals(jiaShiYuan.getShenfenzhengyouxiaoqi())){
			jiaShiYuan.setShenfenzhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getPingyongriqi())){
			jiaShiYuan.setPingyongriqi(null);
		}
		if("".equals(jiaShiYuan.getJiashizhengchulingriqi())){
			jiaShiYuan.setJiashizhengchulingriqi(null);
		}
		if("".equals(jiaShiYuan.getJiashizhengyouxiaoqi())){
			jiaShiYuan.setJiashizhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getTijianyouxiaoqi())){
			jiaShiYuan.setTijianyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getCongyezhengyouxiaoqi())){
			jiaShiYuan.setCongyezhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getCongyezhengchulingri())){
			jiaShiYuan.setCongyezhengchulingri(null);
		}
		if("".equals(jiaShiYuan.getXiacichengxinkaoheshijian())){
			jiaShiYuan.setXiacichengxinkaoheshijian(null);
		}
		if("".equals(jiaShiYuan.getXiacijixujiaoyushijian())){
			jiaShiYuan.setXiacijixujiaoyushijian(null);
		}
		if("".equals(jiaShiYuan.getHuzhaoyouxiaoqi())){
			jiaShiYuan.setHuzhaoyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getZhunjiazhengyouxiaoqi())){
			jiaShiYuan.setZhunjiazhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getLizhishijian())){
			jiaShiYuan.setLizhishijian(null);
		}
		if("".equals(jiaShiYuan.getChengxinkaoheshijian())){
			jiaShiYuan.setChengxinkaoheshijian(null);
		}
		if("".equals(jiaShiYuan.getJixujiaoyushijian())){
			jiaShiYuan.setJixujiaoyushijian(null);
		}
		if("".equals(jiaShiYuan.getTijianriqi())){
			jiaShiYuan.setTijianriqi(null);
		}
		return R.status(iJiaShiYuanService.save(jiaShiYuan));
	}

	/**
	 * 编辑
	 */
	@PostMapping("/update")
	@ApiLog("编辑-押运员资料管理")
	@ApiOperation(value = "编辑-押运员资料管理", notes = "编辑jiaShiYuan", position = 2)
	public R update(@RequestBody JiaShiYuan jiaShiYuan,BladeUser user) {
		if("男".equals(jiaShiYuan.getXingbie())){
			jiaShiYuan.setXingbie("1");
		}else{
			jiaShiYuan.setXingbie("2");
		}
		jiaShiYuan.setCaozuoren(user.getUserName());
		jiaShiYuan.setCaozuorenid(user.getUserId());
		jiaShiYuan.setCaozuoshijian(DateUtil.now());
		if("".equals(jiaShiYuan.getCreatetime())){
			jiaShiYuan.setCreatetime(DateUtil.now());
		}
		if("".equals(jiaShiYuan.getChushengshijian())){
			jiaShiYuan.setChushengshijian(null);
		}
		if("".equals(jiaShiYuan.getShenfenzhengyouxiaoqi())){
			jiaShiYuan.setShenfenzhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getPingyongriqi())){
			jiaShiYuan.setPingyongriqi(null);
		}
		if("".equals(jiaShiYuan.getJiashizhengchulingriqi())){
			jiaShiYuan.setJiashizhengchulingriqi(null);
		}
		if("".equals(jiaShiYuan.getJiashizhengyouxiaoqi())){
			jiaShiYuan.setJiashizhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getTijianyouxiaoqi())){
			jiaShiYuan.setTijianyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getCongyezhengyouxiaoqi())){
			jiaShiYuan.setCongyezhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getCongyezhengchulingri())){
			jiaShiYuan.setCongyezhengchulingri(null);
		}
		if("".equals(jiaShiYuan.getXiacichengxinkaoheshijian())){
			jiaShiYuan.setXiacichengxinkaoheshijian(null);
		}
		if("".equals(jiaShiYuan.getXiacijixujiaoyushijian())){
			jiaShiYuan.setXiacijixujiaoyushijian(null);
		}
		if("".equals(jiaShiYuan.getHuzhaoyouxiaoqi())){
			jiaShiYuan.setHuzhaoyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getZhunjiazhengyouxiaoqi())){
			jiaShiYuan.setZhunjiazhengyouxiaoqi(null);
		}
		if("".equals(jiaShiYuan.getLizhishijian())){
			jiaShiYuan.setLizhishijian(null);
		}
		if("".equals(jiaShiYuan.getChengxinkaoheshijian())){
			jiaShiYuan.setChengxinkaoheshijian(null);
		}
		if("".equals(jiaShiYuan.getJixujiaoyushijian())){
			jiaShiYuan.setJixujiaoyushijian(null);
		}
		if("".equals(jiaShiYuan.getTijianriqi())){
			jiaShiYuan.setTijianriqi(null);
		}
		return R.status(iJiaShiYuanService.updateById(jiaShiYuan));
	}

	/**
	 *  删除
	 */
	@PostMapping("/del")
	@ApiLog("删除-押运员资料管理")
	@ApiOperation(value = "删除-押运员资料管理", notes = "传入id", position = 3)
	public R del(String id) {
		return R.status(iJiaShiYuanService.updateDel(id));
	}

	/**
	 *  查询详情
	 */
	@GetMapping("/detail")
	@ApiLog("详情-押运员资料管理")
	@ApiOperation(value = "详情-押运员资料管理", notes = "传入id", position = 4)
	public R detail(String id) {
		return R.data(iJiaShiYuanService.selectByIds(id));
	}

	/**
	 * 分页
	 */
	@PostMapping("/list")
	@ApiLog("分页-押运员资料管理")
	@ApiOperation(value = "分页-押运员资料管理", notes = "传入JiaShiYuanPage", position = 5)
	public R<JiaShiYuanPage<JiaShiYuanVO>> list(@RequestBody JiaShiYuanPage jiaShiYuanPage) {
		jiaShiYuanPage.setJiashiyuanleixing("押运员");
		JiaShiYuanPage<JiaShiYuanVO> pages = iJiaShiYuanService.selectPageList(jiaShiYuanPage);
		return R.data(pages);
	}

	/********************************** 配置表 ***********************/

	/**
	 * 根据单位id获取配置模块数据
	 */
	@GetMapping("/listMap")
	@ApiLog("获取配置-押运员资料管理")
	@ApiOperation(value = "获取配置-押运员资料管理", notes = "传入deptId", position = 6)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list1=mapService.selectMapList("anbiao_yayunyuan_map",deptId);
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
	@ApiLog("配置表新增-押运员资料管理")
	@ApiOperation(value = "配置表新增-押运员资料管理", notes = "传入biaodancanshu与deptId", position = 7)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_yayunyuan_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-押运员资料管理")
	@ApiOperation(value = "配置表编辑-押运员资料管理", notes = "传入biaodancanshu与id", position = 9)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_yayunyuan_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-押运员资料管理")
	@ApiOperation(value = "配置表删除-押运员资料管理", notes = "传入id", position = 8)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_yayunyuan_map",id));
	}
}
