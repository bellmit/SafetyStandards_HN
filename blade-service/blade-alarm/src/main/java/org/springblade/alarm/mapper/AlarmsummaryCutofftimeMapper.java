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

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springblade.alarm.entity.AlarmDay;
import org.springblade.alarm.entity.AlarmsummaryCutofftime;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.alarm.page.AlarmPage;
import org.springblade.alarm.page.AlarmTimePage;
import org.springblade.alarm.page.ShishiBaojingTongjiPage;
import org.springblade.alarm.vo.AlarmsummaryCutofftimeVO;

import java.util.List;
import java.util.Map;

/**
 * 报警推送 Mapper 接口
 *
 * @author hyp
 * @since 2019-05-12
 */
public interface AlarmsummaryCutofftimeMapper extends BaseMapper<AlarmsummaryCutofftime> {

    /**
     * 自定义分页
     *
     * @param alarmPage
     * @return
     */
    List<AlarmsummaryCutofftimeVO> selectAlarmPage(AlarmPage alarmPage);

    /**
     * 统计
     *
     * @param alarmPage
     * @return
     */
    int selectAlarmTotal(AlarmPage alarmPage);

    /**
     * 查询报警车辆、次数、处理率
     *
     * @param page
     * @return
     */
    AlarmBaojingTongji selectBaojingtongji(AlarmPage page);

    /**
     * 查询报警车辆、次数、处理率
     *
     * @param page
     * @return
     */
    Map<String, Object> selectShishiBaojingTongji(ShishiBaojingTongjiPage page);

    /**
     * 根据报警id 查询报警详情
     */
    AlarmsummaryCutofftimeVO selectAlarmDetail(String id);
	/**
	 * 今日报警
	 */
//	List<AlarmsummaryCutofftimeVO> alarmDay(@Param("date")String date,@Param("company") String company, @Param("AlarmType") String AlarmType);
	List<AlarmsummaryCutofftimeVO> alarmDay(String company,String AlarmType);
    /**
     * 查询gps是否报警
     * @param shishiBaojingTongjiPage
     * @return
     */
    List<String> selectShifouBaojing(ShishiBaojingTongjiPage shishiBaojingTongjiPage);

    /**
     *根据机构id查询下级所有机构
     * @author: hyp
     * @date: 2019/10/18 11:10
     * @param deptId
     * @return: java.util.List<java.lang.String>
     */
    List<String> getCompany(Integer deptId);
	/**
	 * 根据时间段获取报警信息车辆报警
	 */
	List<AlarmsummaryCutofftime>  timeAlarm(AlarmTimePage alarmTimePage);
	/**
	 * 获取企业下的车辆类型
	 */
	List<String> findoperattype(String deptId);

	/**
	 * 根据企业ID、报警时间区间获取该企业的报警处理率
	 * @param beginTime
	 * @param endTime
	 * @param deptName
	 * @return
	 */
	List<AlarmsummaryCutofftimeVO> selectAlarmLv(@Param("beginTime") String beginTime,
												 @Param("endTime")String endTime,
												 @Param("deptName") String deptName);

	/**
	 * 更新报表处理率 property 文件属性（1日报、2周报、3月报、4年报）
	 * @param processRate
	 * @param deptId
	 * @param property
	 * @param countdate
	 * @return
	 */
	boolean updateBaoBiaoMuLu(@Param("processRate") String processRate,
							  @Param("deptId")String deptId,
							  @Param("property") String property,
							  @Param("countdate") String countdate,
							  @Param("countenddate") String countenddate);


}
