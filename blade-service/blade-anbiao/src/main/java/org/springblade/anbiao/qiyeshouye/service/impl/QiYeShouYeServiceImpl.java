/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuServiceImpl
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.qiyeshouye.entity.*;
import org.springblade.anbiao.qiyeshouye.mapper.QiYeShouYeMapper;
import org.springblade.anbiao.qiyeshouye.page.QiYeTpvehdataPage;
import org.springblade.anbiao.qiyeshouye.service.IQiYeShouYeService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
@Service
@AllArgsConstructor
public class QiYeShouYeServiceImpl extends ServiceImpl<QiYeShouYeMapper, QiYeShouYe> implements IQiYeShouYeService {

	private QiYeShouYeMapper qiYeShouYeMapper;


	@Override
	public QiYeShouYe selectMonthVehcile(String deptId) {
		return qiYeShouYeMapper.selectMonthVehcile(deptId);
	}

	@Override
	public QiYeShouYe selectYearAlarm(String deptId,String year) {
		return qiYeShouYeMapper.selectYearAlarm(deptId,year);
	}

	@Override
	public List<QiYeShouYe> selectYearAlarmTendency(String deptId,String year) {
		return qiYeShouYeMapper.selectYearAlarmTendency(deptId,year);
	}

	@Override
	public QiYeShouYe selectSevenAlarmStatistics(String deptId) throws UnsupportedEncodingException {
		List<QiYeShouYe> qiYeShouYes = qiYeShouYeMapper.selectSevenAlarmStatistics(deptId);
		QiYeShouYe qiYeShouYeList = new QiYeShouYe();
		Integer sevenzongbaojingshu = 0;
		Integer sevenzongweichulishu = 0;
		Integer sevengpsweichulishu = 0;
		Integer sevenshebeiweichulishu = 0;
		Integer sevenzongchulishu = 0;
		for (int i=0;i<qiYeShouYes.size();i++) {
			sevenzongbaojingshu += qiYeShouYes.get(i).getBaojingcishu();
			sevenzongweichulishu += qiYeShouYes.get(i).getWeichulizongshu();
			sevengpsweichulishu += qiYeShouYes.get(i).getBdweichulishu();
			sevenshebeiweichulishu += qiYeShouYes.get(i).getSbweichulishu();
			sevenzongchulishu += qiYeShouYes.get(i).getChulizongshu();
		}
		if(sevenzongchulishu == 0 || sevenzongbaojingshu ==0){
			qiYeShouYeList.setSevenchulilv("0.00%");
		}else{
			double lv = (sevenzongchulishu*1.0/sevenzongbaojingshu);
			//##.00%   百分比格式，后面不足2位的用0补齐
			DecimalFormat df1 = new DecimalFormat("0.00%");
			String sevenchulilv = df1.format(lv);
			byte[] b = sevenchulilv.getBytes("UTF-8");
			String n = new String(b,"UTF-8");
			qiYeShouYeList.setSevenchulilv(n);
		}
		qiYeShouYeList.setSevenzongbaojingshu(sevenzongbaojingshu);
		qiYeShouYeList.setSevenzongweichulishu(sevenzongweichulishu);
		qiYeShouYeList.setSevengpsweichulishu(sevengpsweichulishu);
		qiYeShouYeList.setSevenshebeiweichulishu(sevenshebeiweichulishu);
		qiYeShouYeList.setSevenList(qiYeShouYes);
		return qiYeShouYeList;
	}

	@Override
	public List<QiYeYunWeiShouYe> selectOperational(String deptId) {
		return qiYeShouYeMapper.selectOperational(deptId);
	}

	@Override
	public QiYeYunWeiShouYe selectMarkRemind(String deptId) {
		return qiYeShouYeMapper.selectMarkRemind(deptId);
	}

	@Override
	public QiYeYunWeiShouYe selectQiYeCount() {
		return qiYeShouYeMapper.selectQiYeCount();
	}

	@Override
	public QiYeYunWeiShouYe selectABQiYeCount() {
		return qiYeShouYeMapper.selectABQiYeCount();
	}

	@Override
	public List<QiYeAnBiao> selectScheduleReminders(String deptId, String dateTime) {
		return qiYeShouYeMapper.selectScheduleReminders(deptId, dateTime);
	}

	@Override
	public List<QiYeAnBiaoMuLu> selectQiYeAnBiaoMuLu(String deptId) {
		return qiYeShouYeMapper.selectQiYeAnBiaoMuLu(deptId);
	}

	@Override
	public QiYeAnBiaoPeriodRate selectPeriodControlRates(String deptId) {
		return qiYeShouYeMapper.selectPeriodControlRates(deptId);
	}

	@Override
	public List<QiYeAnBiaoSafetyTips> selectSafetyTips(String deptId) {
		return qiYeShouYeMapper.selectSafetyTips(deptId);
	}

	@Override
	public QiYeAnBiaoSafetyTips selectSafetyTipsZNum(String deptId, Integer xiangId) {
		return qiYeShouYeMapper.selectSafetyTipsZNum(deptId, xiangId);
	}

	@Override
	public QiYeAnBiaoSafetyTips selectSafetyTipsNum(String deptId, Integer xiangId) {
		return qiYeShouYeMapper.selectSafetyTipsNum(deptId, xiangId);
	}

}
