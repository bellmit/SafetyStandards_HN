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
import org.springblade.alarm.entity.AlarmDay;
import org.springblade.alarm.entity.Driverbehavior;
import org.springblade.alarm.page.AlarmTimePage;
import org.springblade.alarm.page.DriverAlarmPage;
import org.springblade.alarm.page.ShishiBaojingTongjiPage;
import org.springblade.alarm.vo.DriverbehaviorVO;

import java.util.List;
import java.util.Map;

/**
 * 驾驶员行为报警 服务类
 *
 * @author elvis.he
 * @since 2019-05-12
 */
public interface IDriverbehaviorService extends IService<Driverbehavior> {

    /**
     * 自定义分页
     *
     * @param driverAlarmPage
     * @return
     */
    DriverAlarmPage selectAlarmPage(DriverAlarmPage driverAlarmPage);

    /**
     * 查询报警处理页面上部  实时报警统计
     */
    Map<String, Object> selectShishiBaojingTongji(ShishiBaojingTongjiPage page);

    /**
     * 根据报警id 查询报警详情
     */
    DriverbehaviorVO selectAlarmDetail(String id);

    /**
     * 查询主动防御是否报警
     * @param shishiBaojingTongjiPage
     * @return
     */
    Map<String, Object> selectShifouBaojing(ShishiBaojingTongjiPage shishiBaojingTongjiPage);
	/**
	 * 今日主动防御报警
	 */
	List<DriverbehaviorVO> zhudongDay(String company,String AlarmType);
	/***
	 * 所有主动安全报警查询
	 */
	DriverAlarmPage selectdriverbehaviorPage(DriverAlarmPage driverAlarmPage);
	/**
	 * 查询时间段的主动防御报警
	 */
	List<Driverbehavior> timeZhudong(AlarmTimePage alarmTimePage);
}
