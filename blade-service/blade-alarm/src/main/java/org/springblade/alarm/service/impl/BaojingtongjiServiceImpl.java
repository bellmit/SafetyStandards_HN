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
package org.springblade.alarm.service.impl;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import org.springblade.alarm.entity.*;
import org.springblade.alarm.page.BaojingTJPage;
import org.springblade.alarm.vo.BaojingtongjiVO;
import org.springblade.alarm.mapper.BaojingtongjiMapper;
import org.springblade.alarm.service.IBaojingtongjiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-07-25
 */
@Service
@AllArgsConstructor
public class BaojingtongjiServiceImpl extends ServiceImpl<BaojingtongjiMapper, BaojingTJ> implements IBaojingtongjiService {
	private  BaojingtongjiMapper baojingtongjiMapper;
	@Override
	public IPage<BaojingtongjiVO> selectBaojingtongjiPage(IPage<BaojingtongjiVO> page, BaojingtongjiVO baojingtongji) {
		return page.setRecords(baseMapper.selectBaojingtongjiPage(page, baojingtongji));
	}

	@Override
	public int findtoto(BaojingTJPage baojingTJPage) {
		return baojingtongjiMapper.selectAlarmTotal(baojingTJPage);
	}

	@Override
	public BaojingTJPage selectAll(BaojingTJPage baojingTJPage) {
		Integer total =baojingtongjiMapper.selectAlarmTotal(baojingTJPage);
		if(baojingTJPage.getSize()==0){
			if(baojingTJPage.getTotal()==0){
				baojingTJPage.setTotal(total);
			}
			List<BaojingTJ> list=baojingtongjiMapper.TongjiPage(baojingTJPage);
			int  alarmcount=0;
			for(BaojingTJ a:list){
				alarmcount+=a.getChaosucisu();
			}
			baojingTJPage.setAlarmVehicle(list.size());
			baojingTJPage.setAlarmCount(alarmcount);
			baojingTJPage.setRecords(list);
			return  baojingTJPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / baojingTJPage.getSize() + 1;
		}
		if (pagetotal >= baojingTJPage.getCurrent() && pagetotal > 0) {
			baojingTJPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (baojingTJPage.getCurrent() > 1) {
				offsetNo = baojingTJPage.getSize() * (baojingTJPage.getCurrent() - 1);
			}
			baojingTJPage.setTotal(total);
			baojingTJPage.setOffsetNo(offsetNo);
			List<BaojingTJ> list=baojingtongjiMapper.TongjiPage(baojingTJPage);
			int  alarmcount=0;
			for(BaojingTJ a:list){
				 alarmcount+=a.getChaosucisu();
			}
			baojingTJPage.setAlarmVehicle(list.size());
			baojingTJPage.setAlarmCount(alarmcount);
			baojingTJPage.setRecords(list);
		}

		return baojingTJPage;
	}

	@Override
	public BaojingTJPage PilaoAll(BaojingTJPage baojingTJPage) {
		Integer total =baojingtongjiMapper.selectPilaoTotal(baojingTJPage);
		if(baojingTJPage.getSize()==0){
			if(baojingTJPage.getTotal()==0){
				baojingTJPage.setTotal(total);
			}
			List<PiLaoBaojingTJ> list=baojingtongjiMapper.pilaoTongjiPage(baojingTJPage);
			int count=0;
			for(PiLaoBaojingTJ a:list){
				count+=a.getPilaocisu();
			}
			baojingTJPage.setAlarmCount(count);
			baojingTJPage.setAlarmVehicle(list.size());
			baojingTJPage.setRecords(list);
			return  baojingTJPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / baojingTJPage.getSize() + 1;
		}
		if (pagetotal >= baojingTJPage.getCurrent() && pagetotal > 0) {
			baojingTJPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (baojingTJPage.getCurrent() > 1) {
				offsetNo = baojingTJPage.getSize() * (baojingTJPage.getCurrent() - 1);
			}

			baojingTJPage.setTotal(total);
			baojingTJPage.setOffsetNo(offsetNo);
			List<PiLaoBaojingTJ> list=baojingtongjiMapper.pilaoTongjiPage(baojingTJPage);
			int count=0;
			for(PiLaoBaojingTJ a:list){
				count+=a.getPilaocisu();
			}
			baojingTJPage.setAlarmCount(count);
			baojingTJPage.setAlarmVehicle(list.size());
			baojingTJPage.setRecords(list);
		}

		return baojingTJPage;
	}

	@Override
	public AlarmCountDay alarmCount(String company) {
		String date = DateUtil.format(new Date(), "yyyy-MM-dd");
		List<Map<String, Object>> gpsList = baojingtongjiMapper.alarmCount(company, date);

		List<Map<String, Object>> zhudongList = baojingtongjiMapper.zhudongCount(company, date);
		AlarmCountDay alarmCountDay=new AlarmCountDay();

		for (Map<String, Object> map : gpsList) {
			String baojingCount = map.get("baojingCount").toString();
		}
		gpsList.forEach(item->{
			String AlarmType=item.get("AlarmType").toString();//报警类型
			System.out.println(item.get("baojingCount"));
			Integer Count=Integer.valueOf(item.get("baojingCount").toString());//报警次数

			if("超速报警".equals(AlarmType)){
				alarmCountDay.setGpsChaosuCount(Count);
			}else if("疲劳驾驶报警".equals(AlarmType)){
				alarmCountDay.setGpsPilaoCount(Count);
			}else if("夜间行驶报警".equals(AlarmType)){
				alarmCountDay.setGpsYejianCount(Count);
			}else  if("无数据报警".equals(AlarmType)){
				 alarmCountDay.setGpsYichangCount(alarmCountDay.getGpsYichangCount()+Count);
			}else if("不定位报警".equals(AlarmType)){
				alarmCountDay.setGpsYichangCount(alarmCountDay.getGpsYichangCount()+Count);
			}
		});
		zhudongList.forEach(item->{
			String AlarmType=item.get("AlarmType").toString();//报警类型
			Integer Count=Integer.valueOf(item.get("baojingCount").toString());//报警次数
			if("疲劳驾驶报警".equals(AlarmType)){
				alarmCountDay.setZhudongJiashiyuanpilaoCount(Count);
			}else if("接打电话报警".equals(AlarmType)){
				alarmCountDay.setZhudongJiedadianhuaCount(Count);
			}else if("抽烟报警".equals(AlarmType)){
				alarmCountDay.setZhudongChouyanjiashiCount(Count);
			}else if("分神驾驶报警".equals(AlarmType)){
				alarmCountDay.setZhudongFenshenjiashiCount(Count);
			}else if("车距过近报警 ".equals(AlarmType)){
				alarmCountDay.setZhudongChejuguojinCount(Count);
			}else if("车道偏离报警".equals(AlarmType)){
				alarmCountDay.setZhudongChedaopianliCount(Count);
			}else  if("前向碰撞报警".equals(AlarmType)){
				alarmCountDay.setZhudongFangpenzhuangCount(Count);
			}
		});

		return alarmCountDay;
	}

	@Override
	public BaojingTJPage selectbudingwei(BaojingTJPage baojingTJPage) {
		Integer total =baojingtongjiMapper.selectbudinweiTotal(baojingTJPage);
		if(baojingTJPage.getSize()==0){
			if(baojingTJPage.getTotal()==0){
				baojingTJPage.setTotal(total);
			}
			List<BudingweiTongji> list=baojingtongjiMapper.budingwei(baojingTJPage);
			List<BudingweiCount> budingweicount = baojingtongjiMapper.budingweicount(baojingTJPage);
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			int index=0;
			for(BudingweiCount a:budingweicount){
				index+=a.getNumber();
			}
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			baojingTJPage.setAlarmCount(index);
			baojingTJPage.setRecords(list);
			return  baojingTJPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / baojingTJPage.getSize() + 1;
		}
		if (pagetotal >= baojingTJPage.getCurrent() && pagetotal > 0) {
			baojingTJPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (baojingTJPage.getCurrent() > 1) {
				offsetNo = baojingTJPage.getSize() * (baojingTJPage.getCurrent() - 1);
			}
			baojingTJPage.setTotal(total);
			baojingTJPage.setOffsetNo(offsetNo);
			List<BudingweiTongji> list=baojingtongjiMapper.budingwei(baojingTJPage);
			List<BudingweiCount> budingweicount = baojingtongjiMapper.budingweicount(baojingTJPage);
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			int index=0;
			for(BudingweiCount a:budingweicount){
				index+=a.getNumber();
			}
			baojingTJPage.setAlarmCount(index);
			baojingTJPage.setRecords(list);
		}

		return baojingTJPage;


	}

	@Override
	public BaojingTJPage selectbuzaixian(BaojingTJPage baojingTJPage) {

		Integer total =baojingtongjiMapper.selectbuzaixianTotal(baojingTJPage);
		if(baojingTJPage.getSize()==0){
			if(baojingTJPage.getTotal()==0){
				baojingTJPage.setTotal(total);
			}
			List<BudingweiTongji> list=baojingtongjiMapper.buzaixian(baojingTJPage);
			List<BudingweiCount> budingweicount = baojingtongjiMapper.buzaixiancount(baojingTJPage);
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			int index=0;
			for(BudingweiCount a:budingweicount){
				index+=a.getNumber();
			}
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			baojingTJPage.setAlarmCount(index);
			baojingTJPage.setRecords(list);
			return  baojingTJPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / baojingTJPage.getSize() + 1;
		}
		if (pagetotal >= baojingTJPage.getCurrent() && pagetotal > 0) {
			baojingTJPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (baojingTJPage.getCurrent() > 1) {
				offsetNo = baojingTJPage.getSize() * (baojingTJPage.getCurrent() - 1);
			}
			baojingTJPage.setTotal(total);
			baojingTJPage.setOffsetNo(offsetNo);
			List<BudingweiTongji> list=baojingtongjiMapper.buzaixian(baojingTJPage);
			List<BudingweiCount> budingweicount = baojingtongjiMapper.buzaixiancount(baojingTJPage);
			baojingTJPage.setAlarmVehicle(budingweicount.size());
			int index=0;
			for(BudingweiCount a:budingweicount){
				index+=a.getNumber();
			}
			baojingTJPage.setAlarmCount(index);
			baojingTJPage.setRecords(list);
		}

		return baojingTJPage;
	}


}
