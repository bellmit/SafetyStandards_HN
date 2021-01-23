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
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.alarm.entity.AlarmWeichuliType;
import org.springblade.alarm.entity.Alarmhandleresult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 *  Mapper 接口
 *
 * @author elvis.he
 * @since 2019-05-12
 */
public interface AlarmhandleresultMapper extends BaseMapper<Alarmhandleresult> {

	/**
	 * 根据报警id串 查询处理记录
	 *
	 */
	List<Alarmhandleresult> selectIdList(Alarmhandleresult result);
	/**
	 * 根据报警id串 删除处理记录
	 *
	 */
	boolean removeByAlmIds(Alarmhandleresult result);

	/**
	 * 根据报警id查询处理详情
	 */
	Alarmhandleresult selectChuliDetail(Integer baojingid);
	/**
	 * 根据报警id查询是否被处理过
	 */
	List<Alarmhandleresult> selectBybaojin(String  id);

	/**
	 *根据ids和单位id查询报警数量
	 * @author: th
	 * @date: 2019/9/20 14:51
	 * @param idss
	 * @param deptName
	 * @return: int
	 */
    int selectAlarmCountByIdsAndDetpId(@Param("idss") String[] idss, @Param("deptName") String deptName);
	/**
	 * 查询当日未处理的gps报警统计
	 */
	List<AlarmWeichuliType>  gpsweichuli(@Param("company") String company, @Param("date") String date);

	/**
	 * 查询当天未处理的主动安全报警统计
	 * @param company
	 * @param date
	 * @return
	 */
	List<AlarmWeichuliType> zhudonganquanweichuli(@Param("company") String company,@Param("date") String date);
	/**
	 * 查询日报的id
	 */
	Integer selectOneribao(@Param("deptId")String deptId,@Param("date")String date);
	/**
	 *
	 */
	/**
	 * gps报警数 处理数
	 */
	AlarmBaojingTongji alarmCount(@Param("company")String company, @Param("date")String date);
 	/**
	 * 主动安全报警数 处理数
	 */
	AlarmBaojingTongji zhudongCount(@Param("company")String company,@Param("date")String date);
	/**
	 * 更新日报出率
	 */
	Integer  updateRibao(@Param("id")String id,@Param("chulilv")String chulilv);

	/**
	 * 更新二次处理信息
	 * @param twicechulixingshi
	 * @param twicechulimiaoshu
	 * @param twicechuliren
	 * @param twicechulishijian
	 * @param twicefujian
	 * @param twicechulirenid
	 * @return
	 */
	boolean updateAftertreatment(@RequestParam("twicechulixingshi") String twicechulixingshi, @RequestParam("twicechulimiaoshu") String twicechulimiaoshu, @RequestParam("twicechuliren") String twicechuliren,
								 @RequestParam("twicechulishijian") String twicechulishijian, @RequestParam("twicechulirenid") Integer twicechulirenid, @RequestParam("twicefujian") String twicefujian, @RequestParam("id") String id);

}
