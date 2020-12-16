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
package org.springblade.anbiao.cheliangziping.controller;


import cn.hutool.Hutool;
import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;


import org.springblade.anbiao.cheliangziping.entity.*;

import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;


import org.springblade.anbiao.cheliangziping.page.ZipinjianchajieguoPage;
import org.springblade.anbiao.cheliangziping.page.ZipinwenjianPage;
import org.springblade.anbiao.cheliangziping.service.IZipingjianchajieguocongbiaoService;
import org.springblade.anbiao.cheliangziping.service.IZipinjianchaneirongMubanService;
import org.springblade.anbiao.cheliangziping.service.IZipinwenjianServic;
import org.springblade.anbiao.cheliangziping.vo.ZipingwenjianVO;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.doc.biaozhunhuamuban.feign.IBiaozhunhuamubanClient;
import org.springblade.doc.safetyproductionfile.entity.SafetyProductionFile;
import org.springblade.doc.safetyproductionfile.feign.ISafetyProductionFileClient;
import org.springframework.web.bind.annotation.*;

import org.springblade.core.boot.ctrl.BladeController;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.time.LocalDateTime;
import java.util.*;

/**
 *  控制器
 *
 * @author Blade
 * @since 2019-09-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/zipinjianchaneirongmuban")
@Api(value = "自评", tags = "自评接口")
public class ZipinjianchaneirongMubanController extends BladeController {

	private IZipinjianchaneirongMubanService zipinjianchaneirongMubanService;

	private IZipingjianchajieguocongbiaoService ZipingjianchajieguocongbiaoService;

	private IZipinwenjianServic zipinwenjianServic;

	private ISafetyProductionFileClient iSafetyProductionFileClient;

	private IBiaozhunhuamubanClient iBiaozhunhuamubanClient;





	@GetMapping("/listzhouqi")
	@ApiLog("获取周期")
	@ApiOperation(value = "自评-获取周期", notes = "获取周期  ", position = 2)
	public R zhouqi(){

		List<ZipinZhouQI> zhouqi = ZipingjianchajieguocongbiaoService.zhouqi();





		return R.data(zhouqi);
	}

	@PostMapping("/table")
	@ApiLog("自评表")
	@ApiOperation(value = "自评-自评表", notes = "传入ZipingPage  运营类型 deptid  ", position = 2)
	public  R  table(@RequestBody ZipingQuery zipingPage){


		//根据企业id查询最新历史自评
		Zipinjiancha selectzipingjianchajieguo = zipinjianchaneirongMubanService.selectzipingjianchajieguo(zipingPage.getDeptid(),zipingPage.getZijianzhouqi());

		if(selectzipingjianchajieguo==null){
				//返回检查表
			Zipinjiancha datatable =new Zipinjiancha();

			//List<ZipinjianchaneirongMubanVO> selecttable = zipinjianchaneirongMubanService.selecttable(zipingPage.getYunyingleixing());
			datatable.setList(null);
			datatable.setZipinjiachaXiangQing(new ZipinjiachaXiangQing());

			return  R.data(datatable);
		}else{
				zipingPage.setId(selectzipingjianchajieguo.getId());//获取最新历史自评的id 根据id查询自评历史
			    zipingPage.setYunyingleixing(selectzipingjianchajieguo.getYunyingleixing());// 设置运营类型
			List<ZipinjianchaneirongMubanVO> selectjieguotable = zipinjianchaneirongMubanService.selectjieguotable(zipingPage);
			//返回检查表结果
			ZipinjiachaXiangQing jieguo=new ZipinjiachaXiangQing();
			//设置总检查项
			jieguo.setSum(String.valueOf(selectjieguotable.size()));
			jieguo.setXianchangjiancha(String.valueOf(zipinjianchaneirongMubanService.CountXianChangjiancha(zipingPage.getYunyingleixing())));
			int  ishege=0;
			for (ZipinjianchaneirongMubanVO a:selectjieguotable){
					if (a.getIsHege()==1){
						ishege++;
					}
			}
			//设置已检查项数量
			jieguo.setWanshan(String.valueOf(ishege));
			//设置未检查项
			jieguo.setWeiwanshan(String.valueOf(selectjieguotable.size()-ishege));
			//设置计算精度
				DecimalFormat df = new DecimalFormat("#0.00"); //保留小数点后两位
			Double issum=Double.valueOf(jieguo.getSum());
			Double  ishegejiancha=Double.valueOf(jieguo.getWanshan());
			//设置完善率
			 jieguo.setWanshanlv(df.format(ishegejiancha/issum*100)+"%");
			selectzipingjianchajieguo.setList(selectjieguotable);
			selectzipingjianchajieguo.setZipinjiachaXiangQing(jieguo);
			return  R.data(selectzipingjianchajieguo);


		}

	}

	@PostMapping("/addtable")
	@ApiLog("新增-检查结果项")
	@ApiOperation(value = "自评-新增自评", notes = "传入zipingjieguoPages", position = 3)
	public  R  addtable(@RequestBody ZipingQuery zipingPage,BladeUser  bladeUser){
		Zipinjiancha zip=new Zipinjiancha();
		Calendar c = Calendar.getInstance();

		int  year=c.get(Calendar.YEAR);//年
		String quarter="";


		if("周".equals(zipingPage.getZijianzhouqi())){
			int week = c.get(Calendar.WEEK_OF_YEAR);//周

			zip.setBiaoti(year+"年"+week+"周"+"企业自检");
			zip.setZhouqiCount(week);
		}else if("季度".equals(zipingPage.getZijianzhouqi())){
			int m=c.get(Calendar.MONTH);
			if (m >= 1 && m == 3) {
				quarter = "1";
			}
			else if (m >= 4 && m <= 6) {
				quarter = "2";
			}
			else if (m >= 7 && m <= 9) {
				quarter = "3";
			}
			else {
				quarter = "4";
			}
			zip.setBiaoti(year+"年"+quarter+"季度"+"企业自检");
			zip.setZhouqiCount(Integer.valueOf(quarter));
		}else if("月".equals(zipingPage.getZijianzhouqi())){
					int MONTH=c.get(Calendar.MONTH)+1;
			zip.setBiaoti(year+"年"+MONTH+"月"+"企业自检");
			zip.setZhouqiCount(MONTH);
		}else if("半年".equals(zipingPage.getZijianzhouqi())){
			int MONTH=c.get(Calendar.MONTH)+1;
			if(MONTH<=6){
				zip.setBiaoti(year+"年"+"上半年"+"企业自检");
				zip.setZhouqiCount(0);
			}else{
				zip.setBiaoti(year+"年"+"下半年"+"企业自检");
				zip.setZhouqiCount(1);
			}

		}else if("年".equals(zipingPage.getZijianzhouqi())){
			zip.setBiaoti(year+"年度"+"企业自检");
			zip.setZhouqiCount(year);
		}

		//根据运营类型查询检查项
		List<ZipinjianchaneirongMubanVO> selecttable = zipinjianchaneirongMubanService.selecttable(zipingPage.getYunyingleixing());

		List<Zipingjieguocongbiao> list=new ArrayList<Zipingjieguocongbiao>();


		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.UP);

		//总检查项
		Double sum=Double.valueOf(selecttable.size());
		//已检查项
		int tot=0;

		for(Zipingjieguocongbiao lists:list){
			if(lists.getIsHege()==1){
				tot++;
			}
		}
		Double index=Double.valueOf(tot);

		String zipid=IdUtil.simpleUUID();
		zip.setDeptName(zipingPage.getDeptname());
		zip.setId(zipid);

		zip.setYunyingleixing(zipingPage.getYunyingleixing());
		zip.setHegelv(Double.valueOf(nf.format(index/sum*100)));
		zip.setZijianzhouqi(zipingPage.getZijianzhouqi());
		zip.setIsWanjie(0);
		zip.setBeizhu(zipingPage.getBeizhu());
		zip.setDeptId(zipingPage.getDeptid());
		zip.setCaozuoshijian(LocalDateTime.now());
		zip.setCaozuoren(bladeUser.getUserName());
		zip.setZijianshijian(LocalDateTime.now());
		//报告时间
		zip.setBaogaoshijian(zipingPage.getBaogaoshijian());
		zip.setWanjie(0);
		System.out.println(zip.toString());
		//插入自检历史主表
		int a=zipinjianchaneirongMubanService.insretzipingmuban(zip);
		//插入从表
		for(ZipinjianchaneirongMubanVO aa:selecttable){
			Zipingjieguocongbiao zipjieguo=new Zipingjieguocongbiao();
			zipjieguo.setId(IdUtil.simpleUUID());
			zipjieguo.setZipinjianchaId(zipid);
			zipjieguo.setIsHege(0);
			zipjieguo.setBeizhu("");
			zipjieguo.setZipinjianchaxiangId(aa.getNeirongid());
			list.add(zipjieguo);


		}

		ZipingjianchajieguocongbiaoService.insertAll(list);
		return R.data("保存成功");
	}

	@PostMapping("/wanjie")
	@ApiLog("完结-状态")
	@ApiOperation(value = "完结-状态", notes = "传入id 修改完结状态 默认为0可编辑 1为不可编辑", position = 2)
	public R  wanjie(String  id){
		String date= DateUtil.now().toString();

				Integer updatewanjie = zipinjianchaneirongMubanService.updatewanjie(id, date);

				Zipinjiancha zipingjianchajieguoMuban = zipinjianchaneirongMubanService.selectByid(id);
				String wanshanlv = zipingjianchajieguoMuban.getZipinjiachaXiangQing().getWanshanlv();
				String chuliv=wanshanlv.substring(0,wanshanlv.length()-1);
				//更新主表处理率
				Integer  index= zipinjianchaneirongMubanService.updateChlilv(id,chuliv);

				return R.data(zipingjianchajieguoMuban);




	}
	@PostMapping("/del")
	@ApiLog("自评-删除")
	@ApiOperation(value = "自评-自评历史删除", notes = "传入id 删除 历史表 文档表 结果表", position = 2)
	public R delete(String id){
		zipinjianchaneirongMubanService.delete(id);

		return  R.success("删除成功");


	}
	@PostMapping("/detail")
	@ApiLog("自评-历史详情")
	@ApiOperation(value = "自评-历史详情", notes = " 传入自评表id", position = 2)
	public R detail(String id){
		Zipinjiancha zipingjianchajieguoMuban = zipinjianchaneirongMubanService.selectByid(id);


		return R.data(zipingjianchajieguoMuban);
	}
	@PostMapping("/list")
	@ApiLog("自评-历史分页")
	@ApiOperation(value = "自评-历史分页", notes = "传入ZipinjianchajieguoPage", position = 2)
	public R list(@RequestBody  ZipinjianchajieguoPage zipinjianchajieguoPage){
		System.out.println(zipinjianchajieguoPage.toString());
		return  R.data(zipinjianchaneirongMubanService.selectpage(zipinjianchajieguoPage));
	}
	@PostMapping("/listwendang")
	@ApiLog("自评-文档分页")
	@ApiOperation(value = "自评-文件分页", notes = "传入ZipinwenjianPage", position = 2)
	public R listwenjian(@RequestBody ZipinwenjianPage zipinjianchajieguoPage){
		System.out.println(zipinjianchajieguoPage.toString());


		return  R.data(zipinwenjianServic.selectpage(zipinjianchajieguoPage));
	}
	@PostMapping("/addwendang")
	@ApiLog("自评-文档新增")
	@ApiOperation(value = "自评-文档新增", notes = "传入ZipinwenjianPage 文件名称 内容id 检查项目  所属文档类型 文档路径", position = 2)
	public R Adawendang(@RequestBody ZipingWenDangList list,BladeUser user){
		List<Zipingwenjian> each=list.getList();
		for(Zipingwenjian Zipingwenjian:each){
			Zipingwenjian.setId(IdUtil.simpleUUID());
			Zipingwenjian.setCaozuoshijian(LocalDateTime.now().toString());
			Zipingwenjian.setCaozuoren(user.getUserName());
			zipinwenjianServic.insertwendang(Zipingwenjian);
		}



		return  R.success("新增成功");
	}


	@PostMapping("/delwendang")
	@ApiLog("自评-文档删除")
	@ApiOperation(value = "自评-文档删除", notes = "传入id 删除 文档", position = 2)
	public R deletewendang(String  id){
		zipinwenjianServic.deletawendang(id);
		return R.success("删除成功");


	}
	@PostMapping("/updatetable")
	@ApiLog("自评-表格检查更新")
	@ApiOperation(value = "自评-表格更新", notes = "传入ZipingQuery List  更新检查项", position = 2)
	public  R updatetable(@RequestBody ZipingQuery zipingQuery){
		String  msg="";
		List<Zipingjieguocongbiao> list = zipingQuery.getList();
		int count=0;

		for(Zipingjieguocongbiao a:list){


			if(a.getIsHege()==1){
				count++;
			}
          }
		Integer updatetable = ZipingjianchajieguocongbiaoService.updatetable(list);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.UP);
		//总检查项
		Double sum=Double.valueOf(list.size());
		//已检查项
		Double tot=Double.valueOf(count);
		String chulilv=nf.format(tot/sum*100);
		String  id=list.get(0).getZipinjianchaId();
		//更新主表处理率
		Integer  index= zipinjianchaneirongMubanService.updateChlilv(id,chulilv);
	   if(index!=null){
			msg="更新成功";
	   }else{
		   msg="更新失败";
	   }
		if(zipingQuery.getTableId()!=null && !"".equals(zipingQuery.getTableId())){
			Zipinjiancha zipingjianchajieguoMuban = zipinjianchaneirongMubanService.selectByid(zipingQuery.getTableId());
			return  R.data(zipingjianchajieguoMuban);
		}
		return  R.data(msg);
	}



	@PostMapping("/imgPreview")
	@ApiLog("预览-文件")
	@ApiOperation(value = "预览-文件", notes = "传入文件id，和所属文档类型", position = 9)
	public R imgPreview(@ApiParam(value = "文件id", required = true)@RequestParam Integer wenjianid,
										 @ApiParam(value = "所属文件类型", required = true)@RequestParam String suoshuwendangleixing){
		List<String> imgList = new ArrayList<String>();
		if("标准化文档".equals(suoshuwendangleixing)){
			 imgList = iBiaozhunhuamubanClient.getImgList(wenjianid);

		}else if("安全管理标准文档".equals(suoshuwendangleixing)){
			 imgList = iSafetyProductionFileClient.getImgList(wenjianid);

		}else{
			return R.fail("没有该类型");
		}

		return R.data(imgList);
	}


}
