package org.springblade.anbiao.jiashiyuan.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.jiashiyuan.entity.JiaShiYuan;
import org.springblade.anbiao.jiashiyuan.page.JiaShiYuanPage;
import org.springblade.anbiao.jiashiyuan.service.IJiaShiYuanService;
import org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO;
import org.springblade.common.constant.CommonConstant;
import org.springblade.common.tool.IdCardUtil;
import org.springblade.common.tool.RegexUtils;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.DigestUtil;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by you on 2019/4/22.
 */
@RestController
@RequestMapping("/anbiao/jiashiyuan")
@AllArgsConstructor
@Api(value = "驾驶员资料管理", tags = "驾驶员资料管理")
public class JiaShiYuanController {

	private IJiaShiYuanService iJiaShiYuanService;
	private IConfigureService mapService;
	private IFileUploadClient fileUploadClient;
	private ISysClient iSysClient;

	/**
	 * 新增
	 */
	@PostMapping("/insert")
	@ApiLog("新增-驾驶员资料管理")
	@ApiOperation(value = "新增-驾驶员资料管理", notes = "传入jiaShiYuan", position = 1)
	public R insert(@RequestBody JiaShiYuan jiaShiYuan,BladeUser user) {
		jiaShiYuan.setJiashiyuanleixing("驾驶员");
		jiaShiYuan.setCaozuoren(user.getUserName());
		jiaShiYuan.setCaozuorenid(user.getUserId());
		jiaShiYuan.setCaozuoshijian(DateUtil.now());
		jiaShiYuan.setCreatetime(DateUtil.now());

		if("男".equals(jiaShiYuan.getXingbie())){
			jiaShiYuan.setXingbie("1");
		}else if("女".equals(jiaShiYuan.getXingbie())){
			jiaShiYuan.setXingbie("2");
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
		return R.status(iJiaShiYuanService.save(jiaShiYuan));
	}

	/**
	 * 编辑
	 */
	@PostMapping("/update")
	@ApiLog("编辑-驾驶员资料管理")
	@ApiOperation(value = "编辑-驾驶员资料管理", notes = "编辑jiaShiYuan", position = 2)
	public R update(@RequestBody JiaShiYuan jiaShiYuan, BladeUser user) {
		System.out.println(jiaShiYuan.toString());

		if("男".equals(jiaShiYuan.getXingbie())){
			jiaShiYuan.setXingbie("1");
		}else if("女".equals(jiaShiYuan.getXingbie())){
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
	@ApiLog("删除-驾驶员资料管理")
	@ApiOperation(value = "删除-驾驶员资料管理", notes = "传入id", position = 3)
	public R del(String id) {
		return R.status(iJiaShiYuanService.updateDel(id));
	}

	/**
	 *  查询详情
	 */
	@GetMapping("/detail")
	@ApiLog("详情-驾驶员资料管理")
	@ApiOperation(value = "详情-驾驶员资料管理", notes = "传入id", position = 4)
	public R detail(String id) {
		JiaShiYuan detal=iJiaShiYuanService.selectByIds(id);
		//照片
		if(StrUtil.isNotEmpty(detal.getZhaopian())){
			detal.setZhaopian(fileUploadClient.getUrl(detal.getZhaopian()));
		}
		//身份证附件
		if(StrUtil.isNotEmpty(detal.getShenfenzhengfujian())){
			detal.setShenfenzhengfujian(fileUploadClient.getUrl(detal.getShenfenzhengfujian()));
		}
		//从业证附件
		if(StrUtil.isNotEmpty(detal.getCongyezhengfujian())){
			detal.setCongyezhengfujian(fileUploadClient.getUrl(detal.getCongyezhengfujian()));
		}
		//驾驶证附件
		if(StrUtil.isNotEmpty(detal.getJiashizhengfujian())){
			detal.setJiashizhengfujian(fileUploadClient.getUrl(detal.getJiashizhengfujian()));
		}
		//复印件
		if(StrUtil.isNotEmpty(detal.getFuyinjian())){
			detal.setFuyinjian(fileUploadClient.getUrl(detal.getFuyinjian()));
		}
		return R.data(detal);
	}

	/**
	 * 分页
	 */
	@PostMapping("/list")
	@ApiLog("分页-驾驶员资料管理")
	@ApiOperation(value = "分页-驾驶员资料管理", notes = "传入JiaShiYuanPage", position = 5)
	public R<JiaShiYuanPage<JiaShiYuanVO>> list(@RequestBody JiaShiYuanPage jiaShiYuanPage) {
		jiaShiYuanPage.setJiashiyuanleixing("驾驶员");
		JiaShiYuanPage<JiaShiYuanVO> pages = iJiaShiYuanService.selectPageList(jiaShiYuanPage);
		List<JiaShiYuanVO>  list=pages.getRecords();
		String log="[";
		for (int i = 0; i <list.size() ; i++) {
			//照片
			if(StrUtil.isNotEmpty(list.get(i).getZhaopian())){
				String str = list.get(i).getZhaopian();
				String str1 =str.substring(0, str.lastIndexOf("/"));
				String str2 =str.substring(str1.length()+1, str.length());
				log=log+"{\"name\":\""+str2+"\",\"url\":\""+str+"\",\"id\":\""+""+"\",\"savename\":\""+str2+"\"},";
				list.get(i).setZhaopian(fileUploadClient.getUrl(str2));
				if(StringUtils.isBlank(list.get(i).getZhaopian())){
					list.get(i).setZhaopian(log+"]");
				}
			}
			//身份证附件
			if(StrUtil.isNotEmpty(list.get(i).getShenfenzhengfujian())){
				String str = list.get(i).getShenfenzhengfujian();
				String str1 =str.substring(0, str.lastIndexOf("/"));
				String str2 =str.substring(str1.length()+1, str.length());
				log=log+"{\"name\":\""+str2+"\",\"url\":\""+str+"\",\"id\":\""+""+"\",\"savename\":\""+str2+"\"},";
				list.get(i).setShenfenzhengfujian(fileUploadClient.getUrl(str2));
				if(StringUtils.isBlank(list.get(i).getShenfenzhengfujian())){
					list.get(i).setShenfenzhengfujian(log+"]");
				}
			}
			//从业证附件
			if(StrUtil.isNotEmpty(list.get(i).getCongyezhengfujian())){
				String str = list.get(i).getCongyezhengfujian();
				String str1 =str.substring(0, str.lastIndexOf("/"));
				String str2 =str.substring(str1.length()+1, str.length());
				log=log+"{\"name\":\""+str2+"\",\"url\":\""+str+"\",\"id\":\""+""+"\",\"savename\":\""+str2+"\"},";
				list.get(i).setCongyezhengfujian(fileUploadClient.getUrl(str2));
				if(StringUtils.isBlank(list.get(i).getCongyezhengfujian())){
					list.get(i).setCongyezhengfujian(log+"]");
				}
			}
			//驾驶证附件
			if(StrUtil.isNotEmpty(list.get(i).getJiashizhengfujian())){
				String str = list.get(i).getJiashizhengfujian();
				String str1 =str.substring(0, str.lastIndexOf("/"));
				String str2 =str.substring(str1.length()+1, str.length());
				log=log+"{\"name\":\""+str2+"\",\"url\":\""+str+"\",\"id\":\""+""+"\",\"savename\":\""+str2+"\"},";
				list.get(i).setJiashizhengfujian(fileUploadClient.getUrl(str2));
				if(StringUtils.isBlank(list.get(i).getJiashizhengfujian())){
					list.get(i).setJiashizhengfujian(log+"]");
				}
			}
			//复印件
			if(StrUtil.isNotEmpty(list.get(i).getFuyinjian())){
				String str = list.get(i).getFuyinjian();
				String str1 =str.substring(0, str.lastIndexOf("/"));
				String str2 =str.substring(str1.length()+1, str.length());
				log=log+"{\"name\":\""+str2+"\",\"url\":\""+str+"\",\"id\":\""+""+"\",\"savename\":\""+str2+"\"},";
				list.get(i).setFuyinjian(fileUploadClient.getUrl(str2));
				if(StringUtils.isBlank(list.get(i).getFuyinjian())){
					list.get(i).setFuyinjian(log+"]");
				}
			}
		}
		return R.data(pages);
	}

	/********************************** 配置表 ***********************/

	/**
	 * 根据单位id获取配置模块数据
	 */
	@GetMapping("/listMap")
	@ApiLog("获取配置-驾驶员资料管理")
	@ApiOperation(value = "获取配置-驾驶员资料管理", notes = "传入deptId", position = 6)
	public R<JSONArray> listMap(Integer deptId) {
		List<Configure> list1=mapService.selectMapList("anbiao_jiashiyuan_map",deptId);
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
	@ApiLog("配置表新增-驾驶员资料管理")
	@ApiOperation(value = "配置表新增-驾驶员资料管理", notes = "传入biaodancanshu与deptId", position = 7)
	public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_jiashiyuan_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
	}
	/**
	 * 配置表编辑
	 */
	@PostMapping("/updateMap")
	@ApiLog("配置表编辑-驾驶员资料管理")
	@ApiOperation(value = "配置表编辑-驾驶员资料管理", notes = "传入biaodancanshu与id", position = 9)
	public R updateMap(String biaodancanshu,String id) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_jiashiyuan_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.updateMap(configure));
	}

	/**
	 * 配置表删除
	 */
	@PostMapping("/delMap")
	@ApiLog("配置表删除-驾驶员资料管理")
	@ApiOperation(value = "配置表删除-驾驶员资料管理", notes = "传入id", position = 8)
	public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
		return R.status(mapService.delMap("anbiao_jiashiyuan_map",id));
	}

	/**
	 * 驾驶员资料导入
	 * @author: Elvis
	 * @date: 2020/6/23 09:23
	 * @param
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("driverImportOne")
	@ApiLog("驾驶员资料-导入(本企业)")
	@ApiOperation(value = "驾驶员资料-导入(本企业)", notes = "file", position = 10)
	public  R driverImportOne(@RequestParam(value = "file") MultipartFile file, BladeUser user, String DeptId, String DeptName){

		ExcelReader reader = null;
		try {
			reader = ExcelUtil.getReader(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map<String,Object>> readAll = reader.readAll();
		int index=readAll.size();
		if(index>5000){

			return  R.fail("导入条目不能超过5000条");

		}
		int aa=0;
		int bb=0;
		List<JiaShiYuan> drivers=new ArrayList<>();
		boolean b=true;
		for(Map<String,Object> a:readAll){
			aa++;
			JiaShiYuan driver=new JiaShiYuan();
			String id= IdUtil.simpleUUID();
			driver.setId(id);
			driver.setDeptId(Integer.valueOf(DeptId));

			String tmp=String.valueOf(a.get("身份证号"));
			driver.setShenfenzhenghao(tmp);
			JiaShiYuanVO driverVO = iJiaShiYuanService.selectByCardNo(tmp);
			if(driverVO!=null){
				driver.setMsg("该驾驶员已存在");
				driver.setMsg2(false);
				bb++;
			}else{
				driver.setMsg2(true);
			}
			tmp = String.valueOf(a.get("驾驶员姓名"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiashiyuanxingming(tmp);
			}
			tmp = String.valueOf(a.get("性别"));
			if("男".equals(tmp)){
				driver.setXingbie("1");
			}else if("女".equals(tmp)){
				driver.setXingbie("2");
			}
			tmp = String.valueOf(a.get("出生日期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setChushengshijian(tmp);
			}
			tmp = String.valueOf(a.get("年龄"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setNianling(tmp);
			}
			tmp = String.valueOf(a.get("手机号码"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setShoujihaoma(tmp);
			}
			tmp = String.valueOf(a.get("从业类别"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setCongyerenyuanleixing(tmp);
			}
			tmp = String.valueOf(a.get("身份证有效期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setShenfenzhengyouxiaoqi(tmp);
			}
			tmp = String.valueOf(a.get("文化程度"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setWenhuachengdu(tmp);
			}
			tmp = String.valueOf(a.get("聘用日期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setPingyongriqi(tmp);
			}
			tmp = String.valueOf(a.get("机动驾驶员"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJidongjiashiyuan(tmp);
			}
			tmp = String.valueOf(a.get("驾驶员类型"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiashiyuanleixing(tmp);
			}
			tmp = String.valueOf(a.get("家庭住址"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiatingzhuzhi(tmp);
			}
			tmp = String.valueOf(a.get("准驾车型"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setZhunjiachexing(tmp);
			}
			tmp = String.valueOf(a.get("驾驶证号"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiashizhenghao(tmp);
			}
			tmp = String.valueOf(a.get("驾驶证初领日期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiashizhengchulingriqi(tmp);
			}
			tmp = String.valueOf(a.get("驾驶证有效期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiashizhengyouxiaoqi(tmp);
			}
			tmp = String.valueOf(a.get("驾龄"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJialing(tmp);
			}
			tmp = String.valueOf(a.get("从业资格证号"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setCongyezigezheng(tmp);
			}
			tmp = String.valueOf(a.get("部门"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setBumen(tmp);
			}
			tmp = String.valueOf(a.get("离辞职时间"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setLizhishijian(tmp);
			}
			tmp = String.valueOf(a.get("违法记分"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setWeifajifen(tmp);
			}
			tmp = String.valueOf(a.get("体检日期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setTijianriqi(tmp);
			}
			tmp = String.valueOf(a.get("体检有效期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setTijianyouxiaoqi(tmp);
			}
			tmp = String.valueOf(a.get("护照号码"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setHuzhaohaoma(tmp);
			}
			tmp = String.valueOf(a.get("护照类型"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setHuzhaoleibie(tmp);
			}
			tmp = String.valueOf(a.get("国家码"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setGuojiama(tmp);
			}
			tmp = String.valueOf(a.get("护照有效期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setHuzhaoyouxiaoqi(tmp);
			}
			tmp = String.valueOf(a.get("准驾证号"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setZhunjiazhenghao(tmp);
			}
			tmp = String.valueOf(a.get("准驾类型"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setZhunjialeixing(tmp);
			}
			tmp = String.valueOf(a.get("准运线"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setZhunyunxian(tmp);
			}
			tmp = String.valueOf(a.get("准驾证有效期"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setZhunjiazhengyouxiaoqi(tmp);
			}
			tmp = String.valueOf(a.get("缴纳标准"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiaonabiaozhun(tmp);
			}
			tmp = String.valueOf(a.get("缴纳金额"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setJiaonajine(tmp);
			}
			tmp = String.valueOf(a.get("风险金缴纳"));
			if(!StringUtil.isNotEmpty(tmp)){
				driver.setShifoujiaona(tmp);
			}
			driver.setCreatetime(DateUtil.now());
			if(user!=null){
				driver.setCaozuoren(user.getUserName());
				driver.setCaozuorenid(user.getUserId());
			}
			driver.setCaozuoshijian(DateUtil.now());

			drivers.add(driver);

		}
		if(bb>0){
			return  R.data(400,drivers,"导入失败");
		}else{
			b=iJiaShiYuanService.saveBatch(drivers);
			if(b){
				return  R.data(drivers,"成功导入:"+aa+"条");
			}else{
				return  R.fail("导入失败");
			}
		}
	}

//	/**
//	 * 驾驶员信息-导入
//	 * @author: elvis
//	 * @date: 2020/06/23 10:23
//	 * @param
//	 * @return: org.springblade.core.tool.api.R
//	 */
//	@PostMapping("driverImport")
//	@ApiLog("驾驶员信息-导入")
//	@ApiOperation(value = "驾驶员信息-导入", notes = "file", position = 10)
//	public  R driverImport(@RequestParam(value = "file") MultipartFile file, BladeUser user){
//
//		ExcelReader reader = null;
//		try {
//			reader = ExcelUtil.getReader(file.getInputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		List<Map<String,Object>> readAll = reader.readAll();
//		int index=readAll.size();
//		if(index>5000){
//			return  R.fail("导入条目不能超过5000条");
//		}
//		int aa=0;
//		int bb=0;
//		List<JiaShiYuan> drivers=new ArrayList<JiaShiYuan>();
//		boolean b=true;
//		for(Map<String,Object> a:readAll){
//			aa++;
//			JiaShiYuan driver=new JiaShiYuan();
//			Dept dept;
//			String id=IdUtil.simpleUUID();
//			driver.setId(id);
//			String deptname =  String.valueOf(a.get("机构名称"));
//			dept = iSysClient.getDeptByName(deptname);
//			if (dept != null){
//				driver.setDeptId(Integer.valueOf(dept.getId()));
//
//			}else{
//				driver.setMsg("机构不存在");
//				driver.setMsg2(false);
//				bb++;
//			}
////			driver.setDeptName(dept.getDeptName());
//
//			String tmp=String.valueOf(a.get("身份证号"));
//			driver.setShenfenzhenghao(tmp);
//			JiaShiYuanVO driverVO = iJiaShiYuanService.selectByCardNo(tmp);
//			if(driverVO!=null){
//				driver.setMsg("该驾驶员已存在");
//				driver.setMsg2(false);
//				bb++;
//			}else{
//				driver.setMsg2(true);
//			}
//
//			driver.setJiashiyuanxingming(String.valueOf(a.get("驾驶员姓名")));
//
//			tmp = String.valueOf(a.get("性别"));
//			if("男".equals(tmp)){
//				driver.setXingbie("1");
//			}else if("女".equals(tmp)){
//				driver.setXingbie("2");
//			}
//			driver.setChushengshijian((a.get("出生日期") == null) ? null : a.get("出生日期").toString());
//			driver.setNianling(String.valueOf(a.get("年龄")));
//			driver.setShoujihaoma(String.valueOf(a.get("手机号码")));
//			driver.setCongyerenyuanleixing(String.valueOf(a.get("从业类别")));
//			driver.setShenfenzhengyouxiaoqi((a.get("身份证有效期") == null) ? null : a.get("身份证有效期").toString());
//			driver.setWenhuachengdu(String.valueOf(a.get("文化程度")));
//			driver.setPingyongriqi((a.get("聘用日期") == null) ? null : a.get("聘用日期").toString());
//
//			driver.setJidongjiashiyuan(String.valueOf(a.get("机动驾驶员")));
//			driver.setJiashiyuanleixing("驾驶员");
//			driver.setJiatingzhuzhi(String.valueOf(a.get("家庭住址")));
//			driver.setZhunjiachexing(String.valueOf(a.get("准驾车型")));
//			driver.setJiashizhenghao(String.valueOf(a.get("驾驶证号")));
//			driver.setJiashizhengchulingriqi((a.get("驾驶证初领日期") == null) ? null : a.get("驾驶证初领日期").toString());
//			driver.setJiashizhengyouxiaoqi((a.get("驾驶证有效期") == null) ? null : a.get("驾驶证有效期").toString());
//			driver.setJialing(String.valueOf(a.get("驾龄")));
//			driver.setCongyezigezheng(String.valueOf(a.get("从业资格证号")));
//			driver.setBumen(String.valueOf(a.get("部门")));
//			driver.setLizhishijian((a.get("离辞职时间") == null) ? null : a.get("离辞职时间").toString());
//			driver.setWeifajifen(String.valueOf(a.get("违法记分")));
//			driver.setTijianriqi((a.get("体检日期") == null) ? null : a.get("体检日期").toString());
//			driver.setTijianyouxiaoqi((a.get("体检有效期") == null) ? null : a.get("体检有效期").toString());
//			driver.setHuzhaohaoma(String.valueOf(a.get("护照号码")));
//			driver.setHuzhaoleibie(String.valueOf(a.get("护照类型")));
//			driver.setGuojiama(String.valueOf(a.get("国家码")));
//			driver.setHuzhaoyouxiaoqi((a.get("护照有效期") == null) ? null : a.get("护照有效期").toString());
//			driver.setZhunjiazhenghao(String.valueOf(a.get("准驾证号")));
//			driver.setZhunjialeixing(String.valueOf(a.get("准驾类型")));
//			driver.setZhunyunxian(String.valueOf(a.get("准运线")));
//			driver.setZhunjiazhengyouxiaoqi((a.get("准驾证有效期") == null) ? null : a.get("准驾证有效期").toString());
//			driver.setJiaonabiaozhun(String.valueOf(a.get("缴纳标准")));
//			driver.setJiaonajine(String.valueOf(a.get("缴纳金额")));
//			driver.setShifoujiaona(String.valueOf(a.get("风险金缴纳")));
//			driver.setCreatetime(DateUtil.now());
//			if(user!=null){
//				driver.setCaozuoren(user.getUserName());
//				driver.setCaozuorenid(user.getUserId());
//			}
//
//			driver.setCaozuoshijian(DateUtil.now());
//
//			drivers.add(driver);
//		}
//		if(bb>0){
//			return  R.data(400,drivers,"导入失败");
//		}else{
//			b=iJiaShiYuanService.saveBatch(drivers);
//			if(b){
//				return  R.data(drivers,"成功导入:"+aa+"条");
//			}else{
//				return  R.fail("导入失败");
//			}
//		}
//	}

	@GetMapping(value = "/getJSYByVehicle")
	@ApiLog("企业-查询驾驶员绑定车辆")
	@ApiOperation(value = "企业-查询驾驶员绑定车辆", notes = "传入jiashiyuanid",position = 13)
	public R<Vehicle> getJSYByVehicle(String jiashiyuanid) {
		R rs = new R();

		List<Vehicle> vehicleList = iJiaShiYuanService.selectByCar(jiashiyuanid);
		if (vehicleList != null) {
			rs.setCode(200);
			rs.setData(vehicleList);
			rs.setMsg("获取成功");
		} else {
			rs.setCode(500);
			rs.setMsg("获取失败");
		}
		return rs;
	}

	@PostMapping("/resetPassword")
	@ApiLog("初始化密码")
	@ApiOperation(value = "初始化密码", notes = "传入ids", position = 15)
	public R resetPassword(@ApiParam(value = "ids", required = true) @RequestParam String ids,BladeUser user) {
		JiaShiYuan jiaShiYuan = new JiaShiYuan();
		jiaShiYuan.setDenglumima(DigestUtil.encrypt(CommonConstant.DEFAULT_PASSWORD));
		jiaShiYuan.setCaozuoshijian(LocalDateTime.now().toString());
		jiaShiYuan.setCaozuoren(user.getUserName());
		jiaShiYuan.setCaozuorenid(user.getUserId());
		boolean temp = iJiaShiYuanService.updatePassWord(jiaShiYuan.getDenglumima(),ids);
		return R.status(temp);
	}

	@GetMapping(value = "/getJVPageList")
	@ApiLog("企业-驾驶员绑定车辆列表")
	@ApiOperation(value = "企业-驾驶员绑定车辆列表", notes = "传入jiaShiYuanPage",position = 16)
	public R<JiaShiYuanPage<JiaShiYuanVO>> getJVPageList(JiaShiYuanPage jiaShiYuanPage) throws IOException {
		R rs = new R();
		JiaShiYuanPage<JiaShiYuanVO> vehlist = iJiaShiYuanService.selectJVList(jiaShiYuanPage);
		if (vehlist != null) {
			rs.setCode(200);
			rs.setData(vehlist);
			rs.setMsg("获取成功");
		} else {
			rs.setCode(500);
			rs.setMsg("获取失败");
		}
		return rs;
	}

	@GetMapping("/getByIdJiaShiYuanList")
	@ApiLog("根据企业ID获取相应驾驶员信息")
	@ApiOperation(value = "根据企业ID获取相应驾驶员信息", notes = "传入deptId", position = 17)
	public R<List<JiaShiYuan>> getByIdJiaShiYuanList(String deptId) {
		List<JiaShiYuan> detail = iJiaShiYuanService.jiaShiYuanList(deptId);
		return R.data(detail);
	}

	/**
	 * 驾驶员信息--验证
	 * @update: 黄亚平 添加验证
	 * @param
	 */
	@PostMapping("driverImport")
	@ApiLog("驾驶员信息-验证")
	@ApiOperation(value = "驾驶员信息-验证", notes = "file", position = 10)
	public R driverImport(@RequestParam(value = "file") MultipartFile file,BladeUser user,@RequestParam Integer userId,@RequestParam String userName){
		R rs = new R();
		ExcelReader reader = null;
		try {
			reader = ExcelUtil.getReader(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//时间默认格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//验证数据成功条数
		int aa=0;
		//验证数据错误条数
		int bb=0;
		//全局变量，只要一条数据不对，就为false
		boolean isDataValidity=true;
		//错误信息
		String errorStr="";

		List<Map<String,Object>> readAll = reader.readAll();
		if(readAll.size()>5000){
			errorStr+="导入数据超过5000条，无法导入！";
			rs.setMsg(errorStr);
			rs.setCode(400);
			return rs;
		}

		List<JiaShiYuan> drivers= new ArrayList<>();
		for(Map<String,Object> a:readAll){
			aa++;
			JiaShiYuan driver=new JiaShiYuan();
			SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd");
			Dept dept;
			JiaShiYuanVO driverVO = null;
			String deptname =  String.valueOf(a.get("所属单位")).trim();
			if(StringUtils.isBlank(deptname)){
				driver.setMsg("所属单位不能为空;");
				driver.setImportUrl("icon_cha.png");
				errorStr+="所属单位不能为空;";
				bb++;
			}
			dept = iSysClient.getDeptByName(deptname.trim());
			if (dept != null){
				driver.setDeptId(Integer.valueOf(dept.getId()));
				driver.setImportUrl("icon_gou.png");
			}else{
				driver.setMsg(deptname+"所属单位不存在;");
				driver.setImportUrl("icon_cha.png");
				errorStr+=deptname+"所属单位不存在;";
				bb++;
			}
			String driverName = String.valueOf(a.get("驾驶员姓名")).trim();
			if(StringUtils.isBlank(driverName)){
				driver.setMsg("驾驶员姓名不能为空;");
				driver.setImportUrl("icon_cha.png");
				errorStr+="驾驶员姓名不能为空;";
				bb++;
			}else{
				driver.setJiashiyuanxingming(driverName);
				driver.setImportUrl("icon_gou.png");
			}
			String tmp = String.valueOf(a.get("身份证号")).trim();
			if(StringUtils.isBlank(tmp)){
				driver.setMsg("驾驶员身份证号不能为空;");
				driver.setImportUrl("icon_cha.png");
				errorStr+="驾驶员身份证号不能为空;";
				bb++;
			}else{
				//校验身份证是否合法
				if(IdCardUtil.isValidCard(tmp) == true){
					driver.setShenfenzhenghao(tmp);
					driverVO = iJiaShiYuanService.selectByCardNo(tmp);
					if(driverVO!=null){
						driver.setMsg(driverVO.getShenfenzhenghao()+"该驾驶员身份证号已存在;");
						driver.setImportUrl("icon_cha.png");
						errorStr+=driverVO.getShenfenzhenghao()+"该驾驶员身份证号已存在;";
						bb++;
					}else{
						driver.setShenfenzhenghao(tmp);
						driver.setImportUrl("icon_gou.png");
					}
				}else{
					driver.setMsg("该驾驶员身份证号不合法;");
					driver.setImportUrl("icon_cha.png");
					errorStr+="该驾驶员身份证号不合法;";
					bb++;
				}
			}
			//验证手机号码是否合法
			String shoujihaoma = String.valueOf(a.get("手机号码")).trim();
			if(StringUtils.isBlank(shoujihaoma)){
				driver.setMsg("手机号码不能为空;");
				driver.setImportUrl("icon_cha.png");
				errorStr+="手机号码不能为空;";
				bb++;
			}else{
				if(RegexUtils.checkMobile(shoujihaoma)){
					driver.setShoujihaoma(shoujihaoma);
					driver.setImportUrl("icon_gou.png");
				}else{
					driver.setMsg(shoujihaoma+"该手机号码不合法;");
					errorStr+=shoujihaoma+"该手机号码不合法;";
					driver.setImportUrl("icon_cha.png");
					bb++;
				}
			}
			drivers.add(driver);
		}
		if(bb>0){
			rs.setMsg(errorStr);
			rs.setCode(500);
			rs.setSuccess(false);
			rs.setData(drivers);
			return rs;
		}else{
			rs.setCode(200);
			rs.setMsg("数据验证成功");
			rs.setData(drivers);
			rs.setSuccess(true);
			return rs;
		}
	}

	/**
	 * 车辆信息--确认导入
	 * @author: elvis
	 * @date: 2020/10/19 10:23
	 * @param
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("driverImportOk")
	@ApiLog("驾驶员信息-确认导入")
	@ApiOperation(value = "驾驶员信息-确认导入", notes = "drivers", position = 10)
	public R driverImportOk(@RequestParam(value = "drivers") String drivers,BladeUser user,@RequestParam Integer userId,@RequestParam String userName){
		JSONArray json = JSONUtil.parseArray(drivers);
		List<Map<String,Object>> lists = (List)json;
		R rs = new R();
		//时间默认格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//验证数据成功条数
		int aa=0;
		//验证数据错误条数
		int bb=0;
		//全局变量，只要一条数据不对，就为false
		boolean isDataValidity=true;
		//错误信息
		String errorStr="";

		if(lists.size()>5000){
			errorStr+="导入数据超过5000条，无法导入！";
			rs.setMsg(errorStr);
			rs.setCode(400);
			return rs;
		}

		for(Map<String,Object> a:lists){
			aa++;
			JiaShiYuan driver=new JiaShiYuan();
			SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd");
			Dept dept;
			String id=IdUtil.simpleUUID();
			driver.setId(id);
			String deptname =  String.valueOf(a.get("所属单位")).trim();
			dept = iSysClient.getDeptByName(deptname.trim());
			driver.setDeptId(Integer.valueOf(dept.getId()));

			String driverName = String.valueOf(a.get("驾驶员姓名")).trim();
			driver.setJiashiyuanxingming(driverName);

			String tmp = String.valueOf(a.get("身份证号")).trim();
			driver.setShenfenzhenghao(tmp);
			//通过身份证获取性别
			Integer sex = IdCardUtil.getGender(tmp);
			if(1 == sex){
				driver.setXingbie("男");
			}else if(2 == sex){
				driver.setXingbie("女");
			}
			//通过身份证获取年龄
			Integer age = IdCardUtil.getAgeByCard(tmp);
			driver.setNianling(age.toString());
			//通过身份证获取生日日期
			Date chushengshijian = IdCardUtil.getBirthDate(tmp);
			driver.setChushengshijian(dateFormat2.format(chushengshijian));
			//验证手机号码是否合法
			String shoujihaoma = String.valueOf(a.get("手机号码")).trim();
			driver.setShoujihaoma(shoujihaoma);
			driver.setJiashiyuanleixing("驾驶员");
			driver.setDenglumima(DigestUtil.encrypt("123456"));
			driver.setIsdelete(0);
			driver.setCreatetime(DateUtil.now());
			driver.setCaozuoshijian(DateUtil.now());
			if(user!=null){
				driver.setCaozuoren(user.getUserName());
				driver.setCaozuorenid(user.getUserId());
			}
			isDataValidity = iJiaShiYuanService.insertSelective(driver);
		}
		if(isDataValidity == true){
			rs.setCode(200);
			rs.setMsg("数据导入成功");
			rs.setData(drivers);
			return rs;
		}else{
			rs.setCode(500);
			rs.setMsg("数据导入失败");
			rs.setData(drivers);
			return rs;
		}

	}

}
