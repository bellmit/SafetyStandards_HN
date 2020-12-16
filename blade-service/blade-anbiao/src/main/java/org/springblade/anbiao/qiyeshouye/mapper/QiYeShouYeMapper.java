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
package org.springblade.anbiao.qiyeshouye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.qiyeshouye.entity.QiYeShouYe;
import org.springblade.anbiao.qiyeshouye.entity.QiYeTongJi;
import org.springblade.anbiao.qiyeshouye.page.QiYeTongJiPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/18
 * @描述
 */
public interface QiYeShouYeMapper extends BaseMapper<QiYeShouYe> {

	/**
	 * 本月车辆情况
	 * @param deptId
	 * @return
	 */
	QiYeShouYe selectMonthVehcile(@Param("deptId") String deptId);

	/**
	 * 报警统计（年）
	 * @param deptId
	 * @return
	 */
	QiYeShouYe selectYearAlarm(@Param("deptId") String deptId,@Param("year") String year);

	/**
	 * 处理趋势图
	 * @param deptId
	 * @return
	 */
	List<QiYeShouYe> selectYearAlarmTendency(@Param("deptId") String deptId,@Param("year") String year);

	/**
	 * 近七天报警统计
	 * @param deptId
	 * @return
	 */
	List<QiYeShouYe> selectSevenAlarmStatistics(@Param("deptId") String deptId);

}
