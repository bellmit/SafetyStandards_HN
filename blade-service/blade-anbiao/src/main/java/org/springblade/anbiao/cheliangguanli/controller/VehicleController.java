package org.springblade.anbiao.cheliangguanli.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.util.TextUtils;
import org.springblade.anbiao.cheliangguanli.entity.GpsVehicleDetail;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.entity.VehicleCP;
import org.springblade.anbiao.cheliangguanli.entity.VehicleCount;
import org.springblade.anbiao.cheliangguanli.page.CheliangrenyuanbangdingPage;
import org.springblade.anbiao.cheliangguanli.page.VehiclePage;
import org.springblade.anbiao.cheliangguanli.service.ICheliangrenyuanbangdingService;
import org.springblade.anbiao.cheliangguanli.service.IVehicleService;
import org.springblade.anbiao.cheliangguanli.vo.CheliangrenyuanbangdingVO;
import org.springblade.anbiao.cheliangguanli.vo.VehicleVO;
import org.springblade.anbiao.configure.entity.Configure;
import org.springblade.anbiao.configure.service.IConfigureService;
import org.springblade.anbiao.jiashiyuan.entity.JiaShiYuan;
import org.springblade.anbiao.jiashiyuan.service.IJiaShiYuanService;
import org.springblade.common.tool.CheckPhoneUtil;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.StringUtil;
import org.springblade.gps.entity.VehiclePT;
import org.springblade.gps.feign.IGpsPointDataClient;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :elvis.he
 * @program : SafetyStandards
 * @description: VehicleController
 * @create : 2019-04-22 17:50
 */
@RestController
@RequestMapping("/anbiao/vehicle")
@AllArgsConstructor
@Api(value = "车辆资料管理", tags = "车辆资料管理")
public class VehicleController {
    private IVehicleService vehicleService;
    private IConfigureService mapService;
	private IFileUploadClient fileUploadClient;
	private ICheliangrenyuanbangdingService cheliangrenyuanbangdingService;
	private IJiaShiYuanService iJiaShiYuanService;
	private ISysClient iSysClient;
	private IGpsPointDataClient iGpsPointDataClient;

    @PostMapping("/list")
	@ApiLog("分页-车辆资料管理")
    @ApiOperation(value = "分页-车辆资料管理", notes = "传入VehiclealarmweichuliPage", position = 1)
    public R<VehiclePage<VehicleVO>> list(@RequestBody VehiclePage vehiclepage) {
		vehiclepage.setCheliangleixing("2");
        VehiclePage<VehicleVO> pages = vehicleService.selectVehiclePage(vehiclepage);
		List<VehicleVO>  list=pages.getRecords();
//		for (int i = 0; i <list.size() ; i++) {
//			//车辆照片
//			if(StrUtil.isNotEmpty(list.get(i).getCheliangzhaopian())){
//				list.get(i).setCheliangzhaopian(fileUploadClient.getUrl(list.get(i).getCheliangzhaopian()));
//			}
//			//燃料消耗附件
//			if(StrUtil.isNotEmpty(list.get(i).getRanliaoxiaohaofujian())){
//				list.get(i).setRanliaoxiaohaofujian(fileUploadClient.getUrl(list.get(i).getRanliaoxiaohaofujian()));
//			}
//			//行驶证附件
//			if(StrUtil.isNotEmpty(list.get(i).getXingshifujian())){
//				list.get(i).setXingshifujian(fileUploadClient.getUrl(list.get(i).getXingshifujian()));
//			}
//		}
        return R.data(pages);
    }

    @GetMapping("/detail")
	@ApiLog("详情-车辆资料管理")
    @ApiOperation(value = "详情-车辆资料管理", notes = "传入id", position = 2)
    public R<VehicleVO> detail(String id) {
        VehicleVO detail = vehicleService.selectByKey(id);
		//车辆照片
//		if(StrUtil.isNotEmpty(detail.getCheliangzhaopian())){
//			detail.setCheliangzhaopian(fileUploadClient.getUrl(detail.getCheliangzhaopian()));
//		}
//		//燃料消耗附件
//		if(StrUtil.isNotEmpty(detail.getRanliaoxiaohaofujian())){
//			detail.setRanliaoxiaohaofujian(fileUploadClient.getUrl(detail.getRanliaoxiaohaofujian()));
//		}
//		//行驶证附件
//		if(StrUtil.isNotEmpty(detail.getXingshifujian())){
//			detail.setXingshifujian(fileUploadClient.getUrl(detail.getXingshifujian()));
//		}
        return R.data(detail);
    }

	@GetMapping("/selectByCL")
	@ApiLog("车牌搜索")
	@ApiOperation(value = "车牌搜索", notes = "传入postId,cheliangpaizhao", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "postId", value = "岗位id", required = true),
		@ApiImplicitParam(name = "cheliangpaizhao", value = "车辆牌照", required = false)
	})
	public R<List<VehicleCP>> selectByCL(String postId,String cheliangpaizhao) {
		Dept dept=iSysClient.selectByJGBM("机构",postId);
		List<VehicleCP> detail = vehicleService.selectCL(dept.getId().toString(),cheliangpaizhao);
		return R.data(detail);
	}

	@GetMapping("/selectByCPYS")
	@ApiLog("牌照和颜色-获取数据")
	@ApiOperation(value = "牌照和颜色-获取数据", notes = "传入cheliangpaizhao和chepaiyanse", position = 2)
	public R<Map<String,Object>> selectByCPYS(String cheliangpaizhao,String chepaiyanse) {
		Map<String,Object> map = new HashMap<String,Object>();
		VehicleVO vehicleVO = vehicleService.selectByCPYS(cheliangpaizhao,chepaiyanse);
		//车辆照片
		if(StrUtil.isNotEmpty(vehicleVO.getCheliangzhaopian())){
			vehicleVO.setCheliangzhaopian(fileUploadClient.getUrl(vehicleVO.getCheliangzhaopian()));
		}
		//燃料消耗附件
		if(StrUtil.isNotEmpty(vehicleVO.getRanliaoxiaohaofujian())){
			vehicleVO.setRanliaoxiaohaofujian(fileUploadClient.getUrl(vehicleVO.getRanliaoxiaohaofujian()));
		}
		//行驶证附件
		if(StrUtil.isNotEmpty(vehicleVO.getXingshifujian())){
			vehicleVO.setXingshifujian(fileUploadClient.getUrl(vehicleVO.getXingshifujian()));
		}

		map.put("cheliang",vehicleVO);

//		//根据当前车辆id获取当班驾驶员id
//		CheliangrenyuanbangdingPage Page=new CheliangrenyuanbangdingPage();
//		Page.setDeptId(vehicleVO.getDeptId());
//		Page.setCheliangid(vehicleVO.getId());
//		Page.setShifoudangban("0");
//		CheliangrenyuanbangdingPage<CheliangrenyuanbangdingVO> pages = cheliangrenyuanbangdingService.selectPageList(Page);

//		JiaShiYuan detal=new JiaShiYuan();
//		if(pages!=null){
//			//获取驾驶员信息
//			List<CheliangrenyuanbangdingVO> records = pages.getRecords();
//			if(records != null && records.size()>0){
//				detal=iJiaShiYuanService.selectByIds(records.get(0).getJiashiyuanid());
//			}
//			//照片
//			if(StrUtil.isNotEmpty(detal.getZhaopian())){
//				detal.setZhaopian(fileUploadClient.getUrl(detal.getZhaopian()));
//			}
//			//身份证附件
//			if(StrUtil.isNotEmpty(detal.getShenfenzhengfujian())){
//				detal.setShenfenzhengfujian(fileUploadClient.getUrl(detal.getShenfenzhengfujian()));
//			}
//			//从业证附件
//			if(StrUtil.isNotEmpty(detal.getCongyezhengfujian())){
//				detal.setCongyezhengfujian(fileUploadClient.getUrl(detal.getCongyezhengfujian()));
//			}
//			//驾驶证附件
//			if(StrUtil.isNotEmpty(detal.getJiashizhengfujian())){
//				detal.setJiashizhengfujian(fileUploadClient.getUrl(detal.getJiashizhengfujian()));
//			}
//			//复印件
//			if(StrUtil.isNotEmpty(detal.getFuyinjian())){
//				detal.setFuyinjian(fileUploadClient.getUrl(detal.getFuyinjian()));
//			}
//		}
//
//		map.put("jiashiyuan",detal);
		return R.data(map);
	}

    @PostMapping("/insert")
	@ApiLog("新增-车辆资料管理")
    @ApiOperation(value = "新增-车辆资料管理", notes = "传入Vehicle", position = 3)
    public R insert(@RequestBody Vehicle vehicle,BladeUser user) {
		VehicleVO vehicleVO = vehicleService.selectCPYS(vehicle.getCheliangpaizhao(),vehicle.getChepaiyanse());
		if(vehicleVO!=null){
			return R.fail("该车已存在");
		}
		vehicle.setCaozuoren(user.getUserName());
		vehicle.setCaozuorenid(user.getUserId());
		vehicle.setCaozuoshijian(LocalDateTime.now());
		vehicle.setCreatetime(LocalDateTime.now());
		if("".equals(vehicle.getRuhushijian())){
			vehicle.setRuhushijian(null);
		}
		if("".equals(vehicle.getZhucedengjishijian())){
			vehicle.setZhucedengjishijian(null);
		}
		if("".equals(vehicle.getGuohushijian())){
			vehicle.setGuohushijian(null);
		}
		if("".equals(vehicle.getTuishishijian())){
			vehicle.setTuishishijian(null);
		}
		if("".equals(vehicle.getQiangzhibaofeishijian())){
			vehicle.setQiangzhibaofeishijian(null);
		}
		if("".equals(vehicle.getChuchangriqi())){
			vehicle.setChuchangriqi(null);
		}
		if("".equals(vehicle.getGpsanzhuangshijian())){
			vehicle.setGpsanzhuangshijian(null);
		}

		if(!"".equals(vehicle.getYunyingshang())){
			String yys = StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeHtml(vehicle.getYunyingshang()));
			vehicle.setYunyingshang(yys);
		}
		String str="1";
		//登录页
		if(StringUtil.isNotBlank(vehicle.getCheliangzhaopian())){
			fileUploadClient.updateCorrelation(vehicle.getCheliangzhaopian(),str);
		}
        return R.status(vehicleService.save(vehicle));
    }

    @PostMapping("/update")
	@ApiLog("修改-车辆资料管理")
    @ApiOperation(value = "修改-车辆资料管理", notes = "传入Vehicle", position = 4)
    public R update(@RequestBody Vehicle vehicle,BladeUser user) {
		vehicle.setCaozuoren(user.getUserName());
		vehicle.setCaozuorenid(user.getUserId());
		vehicle.setCaozuoshijian(LocalDateTime.now());
		if("".equals(vehicle.getCreatetime())){
			vehicle.setCreatetime(LocalDateTime.now());
		}
		if("".equals(vehicle.getRuhushijian())){
			vehicle.setRuhushijian("");
		}
		if("".equals(vehicle.getZhucedengjishijian())){
			vehicle.setZhucedengjishijian("");
		}
		if("".equals(vehicle.getGuohushijian())){
			vehicle.setGuohushijian("");
		}
		if("".equals(vehicle.getTuishishijian())){
			vehicle.setTuishishijian("");
		}
		if("".equals(vehicle.getQiangzhibaofeishijian())){
			vehicle.setQiangzhibaofeishijian("");
		}
		if("".equals(vehicle.getChuchangriqi())){
			vehicle.setChuchangriqi("");
		}
		if("".equals(vehicle.getGpsanzhuangshijian())){
			vehicle.setGpsanzhuangshijian("");
		}

		if(!"".equals(vehicle.getYunyingshang())){
			String yys = StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeHtml(vehicle.getYunyingshang()));
			vehicle.setYunyingshang(yys);
		}
        return R.status(vehicleService.updateById(vehicle));
    }

    @PostMapping("/del")
	@ApiLog("删除-车辆资料管理")
    @ApiOperation(value = "删除-车辆资料管理", notes = "传入车辆id", position = 5)
    public R del(@RequestParam String id) {
        return R.status(vehicleService.deleleVehicle(id));
    }

	@PostMapping("/updateVehicleOutStatus")
	@ApiLog("停用-车辆资料管理")
	@ApiOperation(value = "停用-车辆资料管理", notes = "传入车辆id", position = 15)
	public R updateVehicleOutStatus(@RequestParam String id) {
		return R.status(vehicleService.updateVehicleOutStatus(id));
	}

	@PostMapping("/updateVehicleScrapStatus")
	@ApiLog("报废-车辆资料管理")
	@ApiOperation(value = "报废-车辆资料管理", notes = "传入车辆id", position = 16)
	public R updateVehicleScrapStatus(@RequestParam String id) {
		return R.status(vehicleService.updateVehicleScrapStatus(id));
	}

    /********************************** 配置表 ***********************/
    /**
     * 配置表新增
     */
    @PostMapping("/insertMap")
	@ApiLog("配置表新增-车辆资料管理")
    @ApiOperation(value = "配置表新增-车辆资料管理", notes = "传入biaodancanshu与deptId", position = 6)
    public R insertMap(String biaodancanshu,String deptId) {
		Configure configure=new Configure();
		JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setDeptId(Integer.parseInt(deptId));
		configure.setTableName("anbiao_vehicle_map");
		configure.setBiaodancanshu(biaodancanshu);
		return R.status(mapService.insertMap(configure));
    }

    /**
     * 配置表编辑
     */
    @PostMapping("/updateMap")
	@ApiLog("配置表编辑-车辆资料管理")
    @ApiOperation(value = "配置表编辑-车辆资料管理", notes = "传入biaodancanshu与id", position = 7)
    public R updateMap(String biaodancanshu, String id) {
        Configure configure = new Configure();
        JSONObject jsonObject = JSONUtil.parseObj(biaodancanshu);
		configure.setId(id);
		configure.setLabel(jsonObject.getStr("label"));
		configure.setShujubiaoziduan(jsonObject.getStr("prop"));
		configure.setTableName("anbiao_vehicle_map");
		configure.setBiaodancanshu(biaodancanshu);
        return R.status(mapService.updateMap(configure));
    }

    /**
     * 配置表删除
     */
    @PostMapping("/delMap")
	@ApiLog("配置表删除-车辆资料管理")
    @ApiOperation(value = "配置表删除-车辆资料管理", notes = "传入id", position = 8)
    public R delMap(@ApiParam(value = "主键id", required = true) @RequestParam String id) {
        return R.status(mapService.delMap("anbiao_vehicle_map", id));
    }

    /**
     * @Description: 根据岗位id获取车辆配置模块数据
     * @Param: [deptId]
     * @return: org.springblade.core.tool.api.R<java.util.List>
     * @Author: elvis.he
     * @date : 2019-04-28
     */
    @GetMapping("/listMap")
	@ApiLog("获取车辆配置-车辆资料管理")
    @ApiOperation(value = "获取车辆配置-车辆资料管理", notes = "传入deptId", position = 9)
    public R<JSONArray> listMap(Integer deptId) {
        List<Configure> list1 = mapService.selectMapList("anbiao_vehicle_map", deptId);
        String str = "";
        for (int i = 0; i < list1.size(); i++) {
            //转换成json数据并put id
            JSONObject jsonObject = JSONUtil.parseObj(list1.get(i).getBiaodancanshu());
            jsonObject.put("id", list1.get(i).getId());
            if (!str.equals("")) {
                str = str + "," + jsonObject.toString();
            } else {
                str = jsonObject.toString();
            }
        }
        str = "[" + str + "]";
        JSONArray json = JSONUtil.parseArray(str);
        return R.data(json);
    }
	/**
	 * 车辆资料导入
	 * @author: LH
	 * @date: 2019/8/19 16:23
	 * @param
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("vehicleImportOne")
	@ApiLog("车辆资料-导入(本企业)")
	@ApiOperation(value = "车辆资料-导入(本企业)", notes = "file", position = 10)
	public  R vehicleImportOne(@RequestParam(value = "file") MultipartFile file,BladeUser user,String DeptId,String DeptName){

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
		//导入数据成功条数
		int aa=0;
		int bb=0;
		List<Vehicle> vehicles=new ArrayList<Vehicle>();
		boolean b=true;
		for(Map<String,Object> a:readAll){
			aa++;
			Vehicle vehicle=new Vehicle();
			String id=IdUtil.simpleUUID();
			vehicle.setId(id);
			vehicle.setDeptId(Integer.valueOf(DeptId));
			vehicle.setDeptName(DeptName);

			String cheliangpaiz=String.valueOf(a.get("车辆牌照"));
			String chepaiyanse=String.valueOf(a.get("车牌颜色"));
			vehicle.setCheliangpaizhao(cheliangpaiz);
			vehicle.setChepaiyanse(chepaiyanse);
			VehicleVO vehicleVO = vehicleService.selectCPYS(cheliangpaiz,chepaiyanse);
			if(vehicleVO!=null){
				vehicle.setMsg("该车已存在");
				vehicle.setMsg2(false);
				bb++;
			}else{
				vehicle.setMsg2(true);
			}
			vehicle.setShiyongxingzhi(String.valueOf(a.get("使用性质")));
			vehicle.setJiashiyuanid(null);
			vehicle.setChangpai(String.valueOf(a.get("厂牌")));
			vehicle.setXinghao(String.valueOf(a.get("型号")));
			vehicle.setChejiahao(String.valueOf(a.get("车架号")));
			vehicle.setLuntaiguige(String.valueOf(a.get("轮胎规格")));
			vehicle.setCheshenyanse(String.valueOf(a.get("车身颜色")));
			vehicle.setHedingzaike(String.valueOf(a.get("核定载客")));
			vehicle.setYingyunnianxian(null);
			vehicle.setDengjizhengshubianhao(String.valueOf(a.get("车辆登记证书编号")));
			vehicle.setChelianglaiyuan(String.valueOf(a.get("车辆来源")));
			vehicle.setZhucedengjishijian(String.valueOf(a.get("注册登记日期")));
			vehicle.setRuhushijian(null);
			vehicle.setGuohushijian(null);
			vehicle.setTuishishijian(null);
			vehicle.setQiangzhibaofeishijian(String.valueOf(a.get("强制报废日期")));
			vehicle.setJieboyunshuzhenghao(String.valueOf(a.get("接驳运输证号")));
			vehicle.setYuancheliangpaizhao(String.valueOf(a.get("原车辆牌照")));
			vehicle.setCheliangzhuangtai("0");
			vehicle.setCheliangtingfangdiqu(null);
			vehicle.setDanganhao(String.valueOf(a.get("档案号")));
			vehicle.setBeiyongcheliang(String.valueOf(a.get("备用车辆")));
			vehicle.setYunyingshang(null);
			vehicle.setSuoshuchedui(null);
			vehicle.setXingshifujian(null);
			vehicle.setFujian(null);
			vehicle.setFadongjixinghao(String.valueOf(a.get("发动机型号")));
			vehicle.setFadongjihao(String.valueOf(a.get("发动机号")));
			vehicle.setFadongjipailianggonglv(String.valueOf(a.get("排量功率")));
			vehicle.setRanliaoleibie(String.valueOf(a.get("燃料类别")));
			vehicle.setRanyouxiaohao(null);
			vehicle.setPaifangbiaozhun(null);
			vehicle.setZhuanxiangfangshi(String.valueOf(a.get("转向方式")));
			vehicle.setChemenshezhi(String.valueOf(a.get("车门设置")));
			vehicle.setZhouju(String.valueOf(a.get("轴距")));
			vehicle.setChechang(String.valueOf(a.get("车长")));
			vehicle.setChekuan(String.valueOf(a.get("车宽")));
			vehicle.setChegao(String.valueOf(a.get("车高")));
			vehicle.setLuntaishu(null);
			vehicle.setChezhoushu(String.valueOf(a.get("车轴数")));
			vehicle.setGangbantanhuangpianshu(null);
			vehicle.setDipanxinghao(null);
			vehicle.setDonglileixing(null);
			vehicle.setZongzhiliang(String.valueOf(a.get("总质量")));
			vehicle.setZhengbeizhiliang(String.valueOf(a.get("整备质量")));
			vehicle.setLuntaizonglei(null);
			vehicle.setXuanguaxingshi(String.valueOf(a.get("悬挂形式")));
			vehicle.setXingchezhidongfangshi(null);
			vehicle.setZhidongqiqianlun(null);
			vehicle.setZhidongqihoulun(null);
			vehicle.setAbs(String.valueOf(a.get("ABS")));
			vehicle.setKongtiaoxitong(String.valueOf(a.get("空调系统")));
			vehicle.setHuanshuqi(String.valueOf(a.get("缓速器")));
			vehicle.setBiansuxiangxingshi(null);
			vehicle.setZhizhaochangshang(String.valueOf(a.get("制造厂商名称")));
			vehicle.setGouzhishuizhenghao(null);
			vehicle.setChuchangriqi(null);
			vehicle.setLeijilicheng(null);
			vehicle.setZhongduanfuwuqi(null);
//			vehicle.setCheliangdengji(String.valueOf(a.get("车辆等级")));
			vehicle.setWeishengjian(null);
			vehicle.setFadongjipailiang(null);
			vehicle.setCheliangwaikuochicun(null);
			vehicle.setRanliaoxiaohaofujian(null);
			vehicle.setBeizhu(null);
			vehicle.setGpsanzhuangshijian(null);
			vehicle.setZhinenghuaxitong(String.valueOf(a.get("智能化系统")));
			vehicle.setGps(null);
			vehicle.setXingshijiluyi(null);
			vehicle.setZongduanid(null);
			vehicle.setZongduanxinghao(null);
			vehicle.setCheliangzhaopian(null);
//			vehicle.setYunshujiezhi(String.valueOf(a.get("运输介质")));
			vehicle.setCreatetime(LocalDateTime.now());
			if(user!=null){
				vehicle.setCaozuoren(user.getUserName());
				vehicle.setCaozuorenid(user.getUserId());
			}
			vehicle.setCaozuoshijian(LocalDateTime.now());

			vehicles.add(vehicle);

		}
		if(bb>0){
			return  R.data(400, vehicles,"导入失败");
		}else{
			b=vehicleService.saveBatch(vehicles);
			if(b){
				return  R.success("成功导入:"+aa+"条");
			}else{
				return  R.fail("导入失败");
			}
		}
	}

	public static boolean isCarnumberNO(String carnumber) {
		String carnumRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})";

		if (TextUtils.isEmpty(carnumber)) {
			return false;
		}else {
			boolean ss = carnumber.matches(carnumRegex);
			return ss;
		}
	}

	/**
	 * 车辆信息--验证
	 * @author: elvis
	 * @date: 2020/06/19 10:23
	 * @update: 黄亚平 添加验证
	 * @param
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("vehicleImport")
	@ApiLog("车辆信息-验证")
	@ApiOperation(value = "车辆信息-验证", notes = "file", position = 10)
	public R vehicleImport(@RequestParam(value = "file") MultipartFile file,BladeUser user,@RequestParam Integer userId,@RequestParam String userName,@RequestParam int type){

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

		List<Vehicle> vehicles=new ArrayList<Vehicle>();
		if (type == 1){
			for(Map<String,Object> a:readAll){
				aa++;
				Vehicle vehicle=new Vehicle();
				Dept dept;
				String id=IdUtil.simpleUUID();
				vehicle.setId(id);
				String deptname =  String.valueOf(a.get("机构名称"));
				dept = iSysClient.getDeptByName(deptname);
				vehicle.setDeptId(Integer.valueOf(dept.getId()));
				vehicle.setCheliangpaizhao(String.valueOf(a.get("车辆牌照")));
				vehicle.setChepaiyanse(String.valueOf(a.get("车牌颜色")));
				if(StringUtils.isBlank((String) a.get("使用性质"))){
					vehicle.setShiyongxingzhi("");
				}else{
					vehicle.setShiyongxingzhi(String.valueOf(a.get("使用性质")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("车辆类型")))){
					vehicle.setXinghao("");
				}else{
					vehicle.setXinghao(String.valueOf(a.get("车辆类型")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("厂牌")))){
					vehicle.setChangpai("");
				}else{
					vehicle.setChangpai(String.valueOf(a.get("厂牌")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("车架号")))){
					vehicle.setChejiahao("");
				}else{
					vehicle.setChejiahao(String.valueOf(a.get("车架号")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("4G视频地址")))){
					vehicle.setYunyingshang("");
				}else{
					String yys = StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeHtml(String.valueOf(a.get("4G视频地址")).trim()));
					vehicle.setYunyingshang(yys);
				}

				if(StringUtils.isBlank(String.valueOf(a.get("运营商名称")))){
					vehicle.setYunyingshangmingcheng("");
				}else{
					vehicle.setYunyingshangmingcheng(String.valueOf(a.get("运营商名称")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("终端编号")))){
					vehicle.setZongduanid("");
				}else{
					vehicle.setZongduanid(String.valueOf(a.get("终端编号")).trim());
				}

				if(StringUtils.isBlank(String.valueOf(a.get("驾驶员")))){
					vehicle.setJiashiyuanxingming("");
				}else{
					vehicle.setJiashiyuanxingming(String.valueOf(a.get("驾驶员")).trim());
				}
				if(StringUtils.isBlank(String.valueOf(a.get("驾驶员电话")))){
					vehicle.setJiashiyuandianhua("");
				}else{
					vehicle.setJiashiyuandianhua(String.valueOf(a.get("驾驶员电话")).trim());
				}
				if(StringUtils.isBlank(String.valueOf(a.get("押运员")))){
					vehicle.setYayunyuanxingming("");
				}else{
					vehicle.setYayunyuanxingming(String.valueOf(a.get("押运员")).trim());
				}
				if(StringUtils.isBlank(String.valueOf(a.get("押运员电话")))){
					vehicle.setYayunyuandianhua("");
				}else{
					vehicle.setYayunyuandianhua(String.valueOf(a.get("押运员电话")).trim());
				}
				if(StringUtils.isBlank(String.valueOf(a.get("车主")))){
					vehicle.setChezhu("");
				}else{
					vehicle.setChezhu(String.valueOf(a.get("车主")).trim());
				}
				if(StringUtils.isBlank(String.valueOf(a.get("车主电话")))) {
					vehicle.setChezhudianhua("");
				}else{
					vehicle.setChezhudianhua(String.valueOf(a.get("车主电话")).trim());
				}

				vehicle.setCreatetime(LocalDateTime.now());
				if(user != null){
					vehicle.setCaozuoren(user.getUserName());
					vehicle.setCaozuorenid(user.getUserId());
				}else{
					vehicle.setCaozuoren(userName);
					vehicle.setCaozuorenid(userId);
				}
				vehicle.setCheliangzhuangtai("0");
				vehicles.add(vehicle);
				isDataValidity = vehicleService.insertSelective(vehicle);
			}
			if(isDataValidity == true){
				rs.setCode(200);
				rs.setMsg("数据导入成功");
				rs.setData(vehicles);
				return rs;
			}else{
				rs.setCode(500);
				rs.setMsg("数据导入失败");
				rs.setData(vehicles);
				return rs;
			}
		}else{
			for(Map<String,Object> a:readAll){
				aa++;
				Vehicle vehicle=new Vehicle();
				Dept dept;
				String deptname =  String.valueOf(a.get("机构名称")).trim();
				if(StringUtils.isBlank(deptname)){
					vehicle.setMsg("所属单位不能为空;");
					vehicle.setImportUrl("icon_cha.png");
					bb++;
				}
				dept = iSysClient.getDeptByName(deptname.trim());
				if (dept != null){
					vehicle.setDeptId(Integer.valueOf(dept.getId()));
					vehicle.setDeptName(deptname);
					vehicle.setImportUrl("icon_gou.png");

					String cheliangpaiz=String.valueOf(a.get("车辆牌照")).trim();
					if(StringUtils.isBlank(cheliangpaiz)){
						vehicle.setMsg("车辆牌照不能为空;");
						vehicle.setImportUrl("icon_cha.png");
						bb++;
					}else{
						if(isCarnumberNO(cheliangpaiz) == false){
							vehicle.setMsg("辆牌照格式不正确;");
							errorStr+=cheliangpaiz+"辆牌照格式不正确;";
							vehicle.setImportUrl("icon_cha.png");
							bb++;
						}else{
							vehicle.setImportUrl("icon_gou.png");
						}
					}
					String chepaiyanse=String.valueOf(a.get("车牌颜色")).trim();
					if(StringUtils.isBlank(chepaiyanse)){
						vehicle.setMsg("车牌颜色不能为空;");
						errorStr+="车牌颜色不能为空;";
						vehicle.setImportUrl("icon_cha.png");
						bb++;
					}else{
						VehicleVO vehicleVO = vehicleService.selectVehicleColor(chepaiyanse);
						if (vehicleVO == null || vehicleVO.getChepaiyanse() == null) {
							vehicle.setMsg("车牌颜色输入错误;");
							errorStr+="车牌颜色输入错误;";
							vehicle.setImportUrl("icon_cha.png");
							bb++;
						}else{
							vehicle.setImportUrl("icon_gou.png");
						}
					}
					vehicle.setCheliangpaizhao(cheliangpaiz);
					vehicle.setChepaiyanse(chepaiyanse);
					VehicleVO vehicleVO = vehicleService.selectCPYS(cheliangpaiz,chepaiyanse);
					if(vehicleVO!=null){
						vehicle.setImportUrl("icon_cha.png");
						errorStr+=vehicleVO.getCheliangpaizhao()+"该车已存在;";
						vehicle.setMsg(vehicleVO.getCheliangpaizhao()+"该车已存在;");
						bb++;
					}else{
						vehicle.setImportUrl("icon_gou.png");
					}
					for(Vehicle item : vehicles){
						if(item.getCheliangpaizhao().equals(cheliangpaiz) && item.getChepaiyanse().equals(chepaiyanse)){
							bb++;
						}
					}
					if(bb>0){
						vehicle.setImportUrl("icon_cha.png");
						errorStr+=cheliangpaiz+"车牌号重复；";
						vehicle.setMsg(cheliangpaiz+"车牌号重复；");
						bb++;
					}

					String zongduanid = String.valueOf(a.get("终端编号")).trim();
					VehicleVO vehicleVO1 = vehicleService.selectByZongDuan(zongduanid);
					if(vehicleVO1!=null){
						vehicle.setImportUrl("icon_cha.png");
						errorStr+=zongduanid+"该终端ID已存在;";
						vehicle.setZongduanid(zongduanid);
						vehicle.setMsg(zongduanid+"该终端ID已存在;");
						bb++;
					}else{
						vehicle.setImportUrl("icon_gou.png");
						vehicle.setZongduanid(zongduanid);
					}

					if(StringUtils.isBlank(String.valueOf(a.get("驾驶员")))){
						vehicle.setJiashiyuanxingming("");
					}else{
						vehicle.setJiashiyuanxingming(String.valueOf(a.get("驾驶员")).trim());
					}

					if(StringUtils.isBlank(String.valueOf(a.get("押运员")))){
						vehicle.setYayunyuanxingming("");
					}else{
						vehicle.setYayunyuanxingming(String.valueOf(a.get("押运员")).trim());
					}

					if(StringUtils.isBlank(String.valueOf(a.get("车主")))){
						vehicle.setChezhu("");
					}else{
						vehicle.setChezhu(String.valueOf(a.get("车主")).trim());
					}

					String phone = String.valueOf(a.get("驾驶员电话"));
					if(!StringUtils.isBlank(phone) && !phone.equals("null")){
						if(CheckPhoneUtil.isPhoneOrTel(phone) == false){
							vehicle.setMsg("驾驶员电话格式不正确;");
							errorStr+=phone+"驾驶员电话格式不正确;";
							vehicle.setImportUrl("icon_cha.png");
							vehicle.setJiashiyuandianhua(String.valueOf(a.get("驾驶员电话")).trim());
							bb++;
						}else{
							vehicle.setImportUrl("icon_gou.png");
							vehicle.setJiashiyuandianhua(String.valueOf(a.get("驾驶员电话")).trim());
						}
					}else{
						vehicle.setJiashiyuandianhua(String.valueOf(a.get("驾驶员电话")).trim());
					}

					String yyphone = String.valueOf(a.get("押运员电话"));
					if(!StringUtils.isBlank(yyphone) && !yyphone.equals("null")){
						if(CheckPhoneUtil.isPhoneOrTel(yyphone) == false){
							vehicle.setMsg("押运员电话格式不正确;");
							errorStr+=yyphone+"押运员电话格式不正确;";
							vehicle.setImportUrl("icon_cha.png");
							vehicle.setYayunyuandianhua(String.valueOf(a.get("押运员电话")).trim());
							bb++;
						}else{
							vehicle.setImportUrl("icon_gou.png");
							vehicle.setYayunyuandianhua(String.valueOf(a.get("押运员电话")).trim());
						}
					}else{
						vehicle.setYayunyuandianhua(String.valueOf(a.get("押运员电话")).trim());
					}

					String czphone = String.valueOf(a.get("车主电话"));
					if(!StringUtils.isBlank(czphone) && !czphone.equals("null")){
						if(CheckPhoneUtil.isPhoneOrTel(czphone) == false){
							vehicle.setMsg("车主电话格式不正确;");
							errorStr+=czphone+"车主电话格式不正确;";
							vehicle.setImportUrl("icon_cha.png");
							vehicle.setChezhudianhua(String.valueOf(a.get("车主电话")).trim());
							bb++;
						}else{
							vehicle.setImportUrl("icon_gou.png");
							vehicle.setChezhudianhua(String.valueOf(a.get("车主电话")).trim());
						}
					}else{
						vehicle.setChezhudianhua(String.valueOf(a.get("车主电话")).trim());
					}

				}else{
					vehicle.setMsg(deptname+"机构不存在;");
					vehicle.setImportUrl("icon_cha.png");
					bb++;
				}

				if(user == null){
					errorStr+="用户对象为空！";
					vehicle.setImportUrl("icon_cha.png");
				}else{
					vehicle.setImportUrl("icon_gou.png");
				}
				vehicles.add(vehicle);
			}
			if(bb>0){
				rs.setMsg(errorStr);
				rs.setCode(500);
				rs.setSuccess(false);
				rs.setData(vehicles);
				return rs;
			}else{
				rs.setCode(200);
				rs.setMsg("数据验证成功");
				rs.setData(vehicles);
				rs.setSuccess(true);
				return rs;
			}
		}
	}

	/**
	 * 车辆信息--确认导入
	 * @author: elvis
	 * @date: 2020/10/19 10:23
	 * @param
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("vehicleImportOk")
	@ApiLog("车辆信息-确认导入")
	@ApiOperation(value = "车辆信息-确认导入", notes = "vehicles", position = 10)
	public R vehicleImportOk(@RequestParam(value = "vehicles") String vehicles,BladeUser user,@RequestParam Integer userId,@RequestParam String userName){
		System.out.println("vehicles:"+vehicles);
		JSONArray json = JSONUtil.parseArray(vehicles);
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

		List<Vehicle> vehlist=new ArrayList<Vehicle>();
		for(Map<String,Object> a:lists){
			aa++;
			Vehicle vehicle=new Vehicle();
			Dept dept;
			String id=IdUtil.simpleUUID();
			vehicle.setId(id);
			String deptname =  String.valueOf(a.get("机构名称"));
			dept = iSysClient.getDeptByName(deptname);
			vehicle.setDeptId(Integer.valueOf(dept.getId()));
			vehicle.setCheliangpaizhao(String.valueOf(a.get("车辆牌照")));
			vehicle.setChepaiyanse(String.valueOf(a.get("车牌颜色")));
			if(StringUtils.isBlank((String) a.get("使用性质"))){
				vehicle.setShiyongxingzhi("");
			}else{
				vehicle.setShiyongxingzhi(String.valueOf(a.get("使用性质")).trim());
			}

			if(StringUtils.isBlank(String.valueOf(a.get("车辆类型")))){
				vehicle.setXinghao("");
			}else{
				vehicle.setXinghao(String.valueOf(a.get("车辆类型")).trim());
			}

			if(StringUtils.isBlank(String.valueOf(a.get("厂牌")))){
				vehicle.setChangpai("");
			}else{
				vehicle.setChangpai(String.valueOf(a.get("厂牌")).trim());
			}

			if(StringUtils.isBlank(String.valueOf(a.get("车架号")))){
				vehicle.setChejiahao("");
			}else{
				vehicle.setChejiahao(String.valueOf(a.get("车架号")).trim());
			}

			if(StringUtils.isBlank(String.valueOf(a.get("4G视频地址")))){
				vehicle.setYunyingshang("");
			}else{
//				vehicle.setYunyingshang(String.valueOf(a.get("4G视频地址")).trim());
				String yys = StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeHtml(String.valueOf(a.get("4G视频地址")).trim()));
				vehicle.setYunyingshang(yys);
			}

			if(StringUtils.isBlank(String.valueOf(a.get("运营商名称")).trim())){
				vehicle.setYunyingshangmingcheng("");
			}else{
				vehicle.setYunyingshangmingcheng(String.valueOf(a.get("运营商名称")).trim());
			}

			if(StringUtils.isBlank(String.valueOf(a.get("终端编号")))){
				vehicle.setZongduanid("");
			}else{
				vehicle.setZongduanid(String.valueOf(a.get("终端编号")).trim());
			}
			if(StringUtils.isBlank(String.valueOf(a.get("驾驶员")))){
				vehicle.setJiashiyuanxingming("");
			}else{
				vehicle.setJiashiyuanxingming(String.valueOf(a.get("驾驶员")).trim());
			}
			if(StringUtils.isNotBlank(String.valueOf(a.get("驾驶员电话")))){
				vehicle.setJiashiyuandianhua(String.valueOf(a.get("驾驶员电话")).trim());
			}
			if(StringUtils.isBlank(String.valueOf(a.get("押运员")))){
				vehicle.setYayunyuanxingming("");
			}else{
				vehicle.setYayunyuanxingming(String.valueOf(a.get("押运员")).trim());
			}
			if(StringUtils.isNotBlank(String.valueOf(a.get("押运员电话")))){
				vehicle.setYayunyuandianhua(String.valueOf(a.get("押运员电话")).trim());
			}
			if(StringUtils.isBlank(String.valueOf(a.get("车主")))){
				vehicle.setChezhu("");
			}else{
				vehicle.setChezhu(String.valueOf(a.get("车主")).trim());
			}
			if(StringUtils.isNotBlank(String.valueOf(a.get("车主电话")))){
				vehicle.setChezhudianhua(String.valueOf(a.get("车主电话")).trim());
			}
			vehicle.setCreatetime(LocalDateTime.now());
			if(user != null){
				vehicle.setCaozuoren(user.getUserName());
				vehicle.setCaozuorenid(user.getUserId());
			}else{
				vehicle.setCaozuoren(userName);
				vehicle.setCaozuorenid(userId);
			}
			vehicle.setCheliangzhuangtai("0");
			vehlist.add(vehicle);
			isDataValidity = vehicleService.insertSelective(vehicle);
		}
		if(isDataValidity == true){
			rs.setCode(200);
			rs.setMsg("数据导入成功");
			rs.setData(vehicles);
			return rs;
		}else{
			rs.setCode(500);
			rs.setMsg("数据导入失败");
			rs.setData(vehicles);
			return rs;
		}

	}

	@PostMapping("vehiceCount")
	@ApiLog("车辆统计")
	@ApiOperation(value = "车辆统计", notes = "传入deptId", position = 10)
	public  R vehiceCount(@ApiParam(value = "企业id", required = true) @RequestParam Integer deptId,@ApiParam(value = "企业名称", required = true) @RequestParam String company){
		List<VehiclePT> vehiclePT2 = iGpsPointDataClient.getVehiclePT2(company);
		int count = vehicleService.vehicleDayCount(deptId); //查询车辆总数
		VehicleCount vehicleCount=new VehicleCount();
		if(vehiclePT2==null){
					vehicleCount.setVehicleCount(count);
				return R.data(vehicleCount);
		}
		int zaiixan=0;//在线车辆
		int lixian=0;//离线车辆
		int xianzhi=0;//闲置车辆
		for(VehiclePT item:vehiclePT2){
			if("运行".equals(item.getStatus()) || "停车".equals(item.getStatus())){
				zaiixan++;
			}
			if("离线".equals(item.getStatus())){
				lixian++;
			}
			if("闲置".equals(item.getStatus())){
				xianzhi++;
			}

		}
		//List<String> xianzhilist = vehicleService.xianzhiVecleCount(deptId); //查询闲置总数

		vehicleCount.setVehicleCount(count); //设置企业车辆总数
		vehicleCount.setXianzhiVehicleCount(xianzhi);//设置闲置车子总数
		vehicleCount.setYunxingVehicleCount(zaiixan);//设置运行车辆总数
		vehicleCount.setLixianVehicleCount(lixian);//设置离线车辆总数
		vehicleCount.setWeixiuVehicleCount(0);//维修车辆无法判断默认为0
		return R.data(vehicleCount);

	}
	@PostMapping("vehicledetai")
	@ApiLog("车辆详情-车牌-车牌颜色")
	@ApiOperation(value = "车辆详情-车牌-颜色", notes = "传入车牌 车牌颜色", position = 11)
	public  R vehicledetai(@ApiParam(value = "车牌", required = true) @RequestParam String cheliangpaizhao,
						   @ApiParam(value = "车牌颜色", required = true) @RequestParam String chepaiyanse,
						   @ApiParam(value = "deptId", required = true) @RequestParam Integer deptId){
		Vehicle vehicle = vehicleService.vehileOne(cheliangpaizhao, chepaiyanse,deptId);
		return R.data(vehicle);
	}
	@PostMapping("/GPSVehicledetail")
	@ApiLog("获取车辆详情gps信息")
	@ApiOperation(value = "获取gps车辆详情", notes = "获取车辆gps详情", position = 2)
	public R getVehicledetail(@ApiParam(value = "单位名称", required = true) @RequestParam String plateNumber
		,@ApiParam(value = "单位名称", required = true) @RequestParam String company){
		List<VehiclePT> vehiclePT2 = iGpsPointDataClient.getVehiclePT2(company);
		GpsVehicleDetail gps=new GpsVehicleDetail();
		for(VehiclePT  index:vehiclePT2){
			if(plateNumber.equals(index.getCph())){
				gps.setVehiclestatus(index.getStatus());
				gps.setLongitude(index.getLongitude());
				gps.setGpstime(index.getGpstime());
				gps.setLatitude(index.getLatitude());
				break;
			}
		}
		return  R.data(gps);
	}

	@GetMapping("/getVehicleAll")
	@ApiLog("GPS获取车辆资料")
	@ApiOperation(value = "GPS获取车辆资料", notes = "传入caozuoshijian", position = 2)
	public R<List<VehicleVO>> getVehicleAll(String caozuoshijian) {
		List<VehicleVO> detail = vehicleService.selectVehicleAll(caozuoshijian);
		return R.data(detail);
	}

	@PostMapping("/updateDeptId")
	@ApiLog("车辆资料管理-车辆异动")
	@ApiOperation(value = "车辆资料管理-车辆异动", notes = "传入车辆ID,企业ID", position = 10)
	public R updateDeptId(@RequestParam String id,@RequestParam String deptId) {
		return R.status(vehicleService.updateDeptId(deptId,id));
	}


}
