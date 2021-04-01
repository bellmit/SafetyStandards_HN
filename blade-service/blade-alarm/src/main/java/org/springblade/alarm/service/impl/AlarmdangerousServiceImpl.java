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


import lombok.AllArgsConstructor;
import org.springblade.alarm.entity.*;

import org.springblade.alarm.mapper.AlarmdangerousMapper;
import org.springblade.alarm.page.AlarmPlatePage;
import org.springblade.alarm.page.AlarmdangerousPage;
import org.springblade.alarm.service.IAlarmdangerousService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springblade.alarm.vo.DriverbehaviorVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * VIEW 服务实现类
 *
 * @author Blade
 * @since 2019-11-13
 */
@Service
@AllArgsConstructor
public class AlarmdangerousServiceImpl extends ServiceImpl<AlarmdangerousMapper, Alarmdangerous> implements IAlarmdangerousService {

	private AlarmdangerousMapper alarmdangerousMapper;

	@Override
	public Map<String, Object> yanzhongCount(String beginTime, String endTime, Integer deptId) {
		//gps严重报警
		List<AlarmWeichuliType> alarm = alarmdangerousMapper.GpsCount(beginTime, endTime, deptId);
		//判断类型
		int index = 0; //记录 不在线 无数据报警总数
		Iterator<AlarmWeichuliType> it = alarm.iterator();
		while (it.hasNext()) {
			AlarmWeichuliType v = it.next();
			String alarmType = v.getAlarmType();
			int number = v.getNumber();
			if ("不定位报警".equals(alarmType) || "无数据报警".equals(alarmType)) {
				index += number;
				it.remove();
			}
		}
		AlarmWeichuliType last = new AlarmWeichuliType();
		last.setNumber(index);
		last.setAlarmType("异常车辆报警");
		if (index != 0) {
			alarm.add(last);
		}

		AlarmDangerGpsCout  alarmlist=new AlarmDangerGpsCout();
		for(AlarmWeichuliType a:alarm){
			String alarmtype=a.getAlarmType();
			 int number=a.getNumber();
			if("超速报警".equals(alarmtype)){
				alarmlist.setGpsChaosuCount(number);
			}else if("疲劳驾驶报警".equals(alarmtype)){
				alarmlist.setGpsPilaoCount(number);
			}else if("异常车辆报警".equals(alarmtype)){
				alarmlist.setGpsYichangCount(number);
			}else  if("夜间行驶报警".equals(alarmtype)){
				alarmlist.setGpsYejianCount(number);
			}

		}
		//主动防御严重报警
		List<AlarmWeichuliType> driver = alarmdangerousMapper.zhudongCount(beginTime, endTime, deptId);
		AlarmDangerZhudongCount driverlist=new AlarmDangerZhudongCount();
		for(AlarmWeichuliType a:driver){
			String alarmtype=a.getAlarmType();
			int number=a.getNumber();
			if("接打电话报警".equals(alarmtype)){
				driverlist.setZhudongJiedadianhuaCount(number);
			}else if("分神驾驶报警".equals(alarmtype)){
				driverlist.setZhudongFenshenjiashiCount(number);
			}else if("抽烟报警".equals(alarmtype)){
				driverlist.setZhudongChouyanjiashiCount(number);
			}else if("疲劳驾驶报警".equals(alarmtype)){
				driverlist.setZhudongJiashiyuanpilaoCount(number);
			}


		}



		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alarm", alarmlist);
		map.put("driver", driverlist);

		return map;
	}

	@Override
	public AlarmdangerousPage Gpsdangerous(AlarmdangerousPage alarmdangerousPage) {
		Integer total = alarmdangerousMapper.Gpsdangeroustotal(alarmdangerousPage);
		if (alarmdangerousPage.getSize() == 0) {
			if (alarmdangerousPage.getTotal() == 0) {
				alarmdangerousPage.setTotal(total);
			}
			List<AlarmdangerousCount> gpsdangerous = alarmdangerousMapper.Gpsdangerous(alarmdangerousPage);

			alarmdangerousPage.setRecords(gpsdangerous);
			return alarmdangerousPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / alarmdangerousPage.getSize() + 1;
		}
		if (pagetotal >= alarmdangerousPage.getCurrent() && pagetotal > 0) {
			alarmdangerousPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (alarmdangerousPage.getCurrent() > 1) {
				offsetNo = alarmdangerousPage.getSize() * (alarmdangerousPage.getCurrent() - 1);
			}

			alarmdangerousPage.setTotal(total);
			alarmdangerousPage.setOffsetNo(offsetNo);

			List<AlarmdangerousCount> gpsdangerous = alarmdangerousMapper.Gpsdangerous(alarmdangerousPage);

			alarmdangerousPage.setRecords(gpsdangerous);


			return alarmdangerousPage;
		}
		return  alarmdangerousPage;





	}

	@Override
	public  AlarmdangerousPage zhudongdangerous(AlarmdangerousPage alarmdangerousPage) {
		Integer total = alarmdangerousMapper.zhudongdangeroustotal(alarmdangerousPage);
		if (alarmdangerousPage.getSize() == 0) {
			if (alarmdangerousPage.getTotal() == 0) {
				alarmdangerousPage.setTotal(total);
			}
			List<AlarmdangerousCount> gpsdangerous = alarmdangerousMapper.zhudongdangerous(alarmdangerousPage);

			alarmdangerousPage.setRecords(gpsdangerous);
			return alarmdangerousPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / alarmdangerousPage.getSize() + 1;
		}
		if (pagetotal >= alarmdangerousPage.getCurrent() && pagetotal > 0) {
			alarmdangerousPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (alarmdangerousPage.getCurrent() > 1) {
				offsetNo = alarmdangerousPage.getSize() * (alarmdangerousPage.getCurrent() - 1);
			}

			alarmdangerousPage.setTotal(total);
			alarmdangerousPage.setOffsetNo(offsetNo);

			List<AlarmdangerousCount> gpsdangerous = alarmdangerousMapper.zhudongdangerous(alarmdangerousPage);

			alarmdangerousPage.setRecords(gpsdangerous);


			return alarmdangerousPage;
		}
		return  alarmdangerousPage;

	}

	@Override
	public AlarmPlatePage gpslistpage(AlarmPlatePage alarmPlatePage) {
		Integer total = alarmdangerousMapper.selectGpspagetotal(alarmPlatePage);
		if (alarmPlatePage.getSize() == 0) {
			if (alarmPlatePage.getTotal() == 0) {
				alarmPlatePage.setTotal(total);
			}
			List<Alarmdangerous> alarmdangerous = alarmdangerousMapper.selectGpspage(alarmPlatePage);

			alarmPlatePage.setRecords(alarmdangerous);
			return alarmPlatePage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / alarmPlatePage.getSize() + 1;
		}
		if (pagetotal >= alarmPlatePage.getCurrent() && pagetotal > 0) {
			alarmPlatePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (alarmPlatePage.getCurrent() > 1) {
				offsetNo = alarmPlatePage.getSize() * (alarmPlatePage.getCurrent() - 1);
			}

			alarmPlatePage.setTotal(total);
			alarmPlatePage.setOffsetNo(offsetNo);

			List<Alarmdangerous> alarmdangerous = alarmdangerousMapper.selectGpspage(alarmPlatePage);

			alarmPlatePage.setRecords(alarmdangerous);


			return alarmPlatePage;
		}
		return  alarmPlatePage;
	}

	@Override
	public AlarmPlatePage zhudonglistpage(AlarmPlatePage alarmPlatePage) {
		Integer total = alarmdangerousMapper.selectZhudongpagetotal(alarmPlatePage);
		if (alarmPlatePage.getSize() == 0) {
			if (alarmPlatePage.getTotal() == 0) {
				alarmPlatePage.setTotal(total);
			}
			List<DriverbehaviorVO> driverbehaviors = alarmdangerousMapper.selectZhudongpage(alarmPlatePage);

			alarmPlatePage.setRecords(driverbehaviors);
			return alarmPlatePage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / alarmPlatePage.getSize() + 1;
		}
		if (pagetotal >= alarmPlatePage.getCurrent() && pagetotal > 0) {
			alarmPlatePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (alarmPlatePage.getCurrent() > 1) {
				offsetNo = alarmPlatePage.getSize() * (alarmPlatePage.getCurrent() - 1);
			}

			alarmPlatePage.setTotal(total);
			alarmPlatePage.setOffsetNo(offsetNo);

			List<DriverbehaviorVO> driverbehaviors = alarmdangerousMapper.selectZhudongpage(alarmPlatePage);

			alarmPlatePage.setRecords(driverbehaviors);


			return alarmPlatePage;
		}





		return alarmPlatePage;
	}

}
