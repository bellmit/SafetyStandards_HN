/**
 * FileName: XinXiJiaoHuZhuServiceImpl
 */
package org.springblade.anbiao.zhengfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.zhengfu.entity.*;
import org.springblade.anbiao.zhengfu.mapper.ZhengFuBaoJingTongJiMapper;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoJingTongJiJieSuanPage;
import org.springblade.anbiao.zhengfu.service.IZhengFuBaoJingTongJiService;
import org.springblade.common.enumconstant.EnmuAlarm;
import org.springblade.common.tool.GpsToBaiduUtil;
import org.springblade.common.tool.LatLotForLocation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 呵呵哒
 */
@Service
@AllArgsConstructor
public class ZhengFuBaoJingTongJiServiceImpl extends ServiceImpl<ZhengFuBaoJingTongJiMapper, ZhengFuBaoJingTongJi> implements IZhengFuBaoJingTongJiService {

	private ZhengFuBaoJingTongJiMapper zhengFuBaoJingTongJiMapper;

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJing(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJing(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJing_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJing_XiaJi(xiaJiDeptId);
	}

	@Override
	public ZhengFuBaoJingTongJi selectGetZFBaoJingYear(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingYear(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJingYear_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingYear_XiaJi(xiaJiDeptId);
	}

	@Override
	public ZhengFuBaoJingTongJi selectGetZFBaoJingMonth(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingMonth(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJingMonth_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingMonth_XiaJi(xiaJiDeptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJingQuShi(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingQuShi(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFBaoJingQuShi_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFBaoJingQuShi_XiaJi(xiaJiDeptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFQYBaoJingPaiMing(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFQYBaoJingPaiMing(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFQYBaoJingPaiMing_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFQYBaoJingPaiMing_XiaJi(xiaJiDeptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFDQBaoJingPaiMing(String deptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFDQBaoJingPaiMing(deptId);
	}

	@Override
	public List<ZhengFuBaoJingTongJi> selectGetZFDQBaoJingPaiMing_XiaJi(String xiaJiDeptId) {
		return zhengFuBaoJingTongJiMapper.selectGetZFDQBaoJingPaiMing_XiaJi(xiaJiDeptId);
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetBJTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {

		Integer total = zhengFuBaoJingTongJiMapper.selectGetBJTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}

			List<ZhengFuBaoJingTongJiJieSuan> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetBJTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
			return zhengFuBaoJingTongJiJieSuanPage;

		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingTongJiJieSuan> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetBJTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetDqLvTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		List<ZhengFuBaoJingTongJi> zhengFuBaoJingTongJi = zhengFuBaoJingTongJiMapper.selectGetZFYG(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		if(zhengFuBaoJingTongJi.size() < 1){
			zhengFuBaoJingTongJiJieSuanPage.setXiaJiDeptId(zhengFuBaoJingTongJiJieSuanPage.getDeptId());
		}
		Integer total = zhengFuBaoJingTongJiMapper.selectGetDqLvTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetDqLvTJ(zhengFuBaoJingTongJiJieSuanPage);
			//List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiLvs = zhengFuBaoJingTongJiMapper.selectGetZFBJCLS(zhengFuBaoJingTongJiJieSuanPage);

			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetDqLvTJ(zhengFuBaoJingTongJiJieSuanPage);
			//List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiLvs = zhengFuBaoJingTongJiMapper.selectGetZFBJCLS(zhengFuBaoJingTongJiJieSuanPage);

			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetQYLvTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectGetQYLvTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetQYLvTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingTongJiLv> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetQYLvTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetGPSMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		if("未申诉".equals(zhengFuBaoJingTongJiJieSuanPage.getShifoushenshu()) && "已处理".equals(zhengFuBaoJingTongJiJieSuanPage.getShifouchuli())){
			zhengFuBaoJingTongJiJieSuanPage.setShifoushenshu("");
		}else if("已申诉".equals(zhengFuBaoJingTongJiJieSuanPage.getShifoushenshu()) && "未处理".equals(zhengFuBaoJingTongJiJieSuanPage.getShifouchuli())){
			zhengFuBaoJingTongJiJieSuanPage.setShifouchuli("");
		}else if("已申诉".equals(zhengFuBaoJingTongJiJieSuanPage.getShifoushenshu()) && "已处理".equals(zhengFuBaoJingTongJiJieSuanPage.getShifouchuli())){

		}
		Integer total = zhengFuBaoJingTongJiMapper.selectGetGPSMXTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(total==0){
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		//导出
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingMingXi> list = zhengFuBaoJingTongJiMapper.selectGetGPSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(list);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		//分页查询
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent() && pagetotal > 0) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingMingXi> rows = zhengFuBaoJingTongJiMapper.selectGetGPSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			rows.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(rows);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetDMSMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectGetDMSMXTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingMingXi> list=zhengFuBaoJingTongJiMapper.selectGetDMSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(list);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent() && pagetotal > 0) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingMingXi> list = zhengFuBaoJingTongJiMapper.selectGetDMSMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(list);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetVehicleMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectGetVehicleMXTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}

			List<ZhengFuBaoJingVehicle> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetVehicleMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
			return zhengFuBaoJingTongJiJieSuanPage;

		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingVehicle> zhengFuBaoJingTongJiList = zhengFuBaoJingTongJiMapper.selectGetVehicleMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetAllMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectGetAllMXTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingMingXi> list=zhengFuBaoJingTongJiMapper.selectGetAllMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(list);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent() && pagetotal > 0) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingMingXi> list = zhengFuBaoJingTongJiMapper.selectGetAllMXTJ(zhengFuBaoJingTongJiJieSuanPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
//				else if(item.getRemark()==1){
//					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setChulizhuangtai(byValue.desc);
//					item.setShensuzhuangtai("未申诉");
//				}else{
//					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
//					item.setShensuzhuangtai(byValue.desc);
//					item.setChulizhuangtai("未处理");
//					item.setShensumiaoshu(item.getChulimiaoshu());
//					item.setShensuxingshi(item.getChulixingshi());
//					item.setChulimiaoshu("");
//					item.setChulixingshi("");
//				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude());
					double lon = Double.parseDouble(item.getLongitude());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP).toString());
					String LocalName= LatLotForLocation.getProvince(item.getLatitude(),item.getLongitude());
					item.setRoadName(LocalName);
				}
			});
			zhengFuBaoJingTongJiJieSuanPage.setRecords(list);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetDQTJPMTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectDQTJPMTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingTongJiJieSuan> organizationList = zhengFuBaoJingTongJiMapper.selectGetDQTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingTongJiJieSuan> organizationList = zhengFuBaoJingTongJiMapper.selectGetDQTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage selectGetCLTJPMTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectCLTJPMTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuBaoJingTongJiJieSuan> organizationList = zhengFuBaoJingTongJiMapper.selectGetCLTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoJingTongJiJieSuan> organizationList = zhengFuBaoJingTongJiMapper.selectGetCLTJPMTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

	@Override
	public List<TtsMessageInfo> selectByAlarmGuId(String alarmGuId) {
		return zhengFuBaoJingTongJiMapper.selectByAlarmGuId(alarmGuId);
	}

	@Override
	public ZhengFuBaoJingTongJiJieSuanPage<ZhengFuRiYunXingTongJi> selectGetCLRYXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage) {
		Integer total = zhengFuBaoJingTongJiMapper.selectCLRYXTJTotal(zhengFuBaoJingTongJiJieSuanPage);
		if(zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
			if(zhengFuBaoJingTongJiJieSuanPage.getTotal()==0){
				zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			}
			List<ZhengFuRiYunXingTongJi> organizationList = zhengFuBaoJingTongJiMapper.selectGetCLRYXTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
			return zhengFuBaoJingTongJiJieSuanPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoJingTongJiJieSuanPage.getSize()==0){
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoJingTongJiJieSuanPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoJingTongJiJieSuanPage.getCurrent()) {
			zhengFuBaoJingTongJiJieSuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoJingTongJiJieSuanPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoJingTongJiJieSuanPage.getSize() * (zhengFuBaoJingTongJiJieSuanPage.getCurrent() - 1);
			}
			zhengFuBaoJingTongJiJieSuanPage.setTotal(total);
			zhengFuBaoJingTongJiJieSuanPage.setOffsetNo(offsetNo);
			List<ZhengFuRiYunXingTongJi> organizationList = zhengFuBaoJingTongJiMapper.selectGetCLRYXTJ(zhengFuBaoJingTongJiJieSuanPage);
			zhengFuBaoJingTongJiJieSuanPage.setRecords(organizationList);
		}
		return zhengFuBaoJingTongJiJieSuanPage;
	}

}
