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
package org.springblade.alarm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springblade.alarm.entity.AlarmWeichuliType;
import org.springblade.alarm.entity.Alarmdangerous;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.alarm.entity.AlarmdangerousCount;
import org.springblade.alarm.page.AlarmPlatePage;
import org.springblade.alarm.page.AlarmdangerousPage;
import org.springblade.alarm.vo.DriverbehaviorVO;

import java.util.List;

/**
 * VIEW Mapper 接口
 *
 * @author Blade
 * @since 2019-11-13
 */
public interface AlarmdangerousMapper extends BaseMapper<Alarmdangerous> {
	/**
	 * gps 严重统计
	 * @param beginTime
	 * @param endTime
	 * @param company
	 * @return
	 */
	List<AlarmWeichuliType> GpsCount(@Param("beginTime") String beginTime, @Param("endTime")String endTime,@Param("company") String company);

	/**
	 * 主动安全 严重统计
	 * @param beginTime
	 * @param endTime
	 * @param company
	 * @return
	 */
	List<AlarmWeichuliType> zhudongCount(@Param("beginTime") String beginTime, @Param("endTime")String endTime,@Param("company") String company);

	/**
	 * gps严重 车牌 报警 次数
	 * @param alarmdangerousPage
	 * @return
	 */
	List<AlarmdangerousCount> Gpsdangerous(AlarmdangerousPage alarmdangerousPage);
	/**
	 * gps严重 车牌 报警 次数 total
	 */
	Integer Gpsdangeroustotal(AlarmdangerousPage alarmdangerousPage);

	/**
	 * 主动防御严重 车牌 报警 次数
	 * @param alarmdangerousPage
	 * @return
	 */
	List<AlarmdangerousCount> zhudongdangerous(AlarmdangerousPage alarmdangerousPage);
	/**
	 * 主动防御严重 车牌 报警 次数 total
	 */
	Integer zhudongdangeroustotal(AlarmdangerousPage alarmdangerousPage);
	/**
	 *  gps严重分页
	 * @return
	 */
	List<Alarmdangerous> selectGpspage(AlarmPlatePage alarmPlatePage);
	/**
	 * gps严重报警 条数
	 */
	Integer selectGpspagetotal(AlarmPlatePage alarmPlatePage);

	/**
	 * 主动防御严重分页
	 * @param alarmPlatePage
	 * @return
	 */
	List<DriverbehaviorVO> selectZhudongpage(AlarmPlatePage alarmPlatePage);

	/**主动防御严重报警 条数
	 *
	 * @param alarmPlatePage
	 * @return
	 */
	Integer selectZhudongpagetotal(AlarmPlatePage alarmPlatePage);





}
