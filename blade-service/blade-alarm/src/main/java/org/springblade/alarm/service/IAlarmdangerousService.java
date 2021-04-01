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

import org.springblade.alarm.entity.Alarmdangerous;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.alarm.entity.AlarmdangerousCount;
import org.springblade.alarm.page.AlarmPlatePage;
import org.springblade.alarm.page.AlarmdangerousPage;

import java.util.List;
import java.util.Map;

/**
 * VIEW 服务类
 *
 * @author Blade
 * @since 2019-11-13
 */
public interface IAlarmdangerousService extends IService<Alarmdangerous> {

	Map<String,Object>  yanzhongCount( String beginTime,String endTime, Integer deptId);

	/**
	 * gps严重 车牌 报警 次数
	 * @param alarmdangerousPage
	 * @return
	 */
	AlarmdangerousPage Gpsdangerous(AlarmdangerousPage alarmdangerousPage);

	/**
	 * 主动防御严重 车牌 报警 次数
	 * @param alarmdangerousPage
	 * @return
	 */
	AlarmdangerousPage  zhudongdangerous(AlarmdangerousPage alarmdangerousPage);
	/**
	 * gps 车牌报警 分页
	 */
	 AlarmPlatePage gpslistpage(AlarmPlatePage alarmPlatePage);
	/**
	 * 主动防御 车牌报警 分页
	 */
	AlarmPlatePage zhudonglistpage(AlarmPlatePage alarmPlatePage);

}
