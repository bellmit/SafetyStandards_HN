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
package org.springblade.alarm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.alarm.entity.AlarmsummaryCutofftime;
import org.springblade.alarm.page.AlarmPage;
import org.springblade.alarm.page.ShishiBaojingTongjiPage;
import org.springblade.alarm.page.VehicleRunDetailsPage;
import org.springblade.alarm.page.VehicleRunPage;
import org.springblade.alarm.vo.AlarmMonthQingkuang;
import org.springblade.alarm.vo.AlarmMonthQushi;
import org.springblade.alarm.vo.AlarmZhudongCount;
import org.springblade.alarm.vo.AlarmsummaryCutofftimeVO;

import java.util.List;
import java.util.Map;

/**
 *数据中心
 * @author: hyp
 * @date: 2019/11/6 20:23
 * @return:
 */
public interface IDataCenterService {
	/**
	 * 月车辆运营情况
	 * @param company
	 * @return
	 */
	List<AlarmMonthQingkuang> alarmMothqingkaung(String company);
	/**
	 *月车辆报警趋势
	 */
	List<AlarmMonthQushi>  alarmMonthQushi(String  company);
	/**
	 * 车辆报警 主动防御报警
	 */
	Map<String,Object> alarmZhudongCount(String company);
	/**
	 * 主动防御 当月统计
	 *
	 */
	List<Map<String,Object>>  monthZhudong(String company);
	/**
	 * 车辆报警 当月统计
	 *
	 */
	List<Map<String,Object>> monthAlarm(String company);

	/**
	 *报警处理统计
	 * @author: hyp
	 * @date: 2019/11/7 0:20
	 * @param company
	 * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 */
	List<Map<String,Object>>  alarmChuliCount(String company);
	/**
	 * 车辆7天运行统计 分页
	 */
	VehicleRunPage selectrunvehicle(VehicleRunPage vehicleRunPage);
	/**
	 * 车辆运行详情
	 */
	VehicleRunDetailsPage selecterunvehicleDetails(VehicleRunDetailsPage vehicleRunDetailsPage);
}
