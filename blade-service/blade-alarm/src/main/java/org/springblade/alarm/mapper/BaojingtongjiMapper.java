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
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springblade.alarm.entity.BaojingTJ;
import org.springblade.alarm.entity.BudingweiCount;
import org.springblade.alarm.entity.BudingweiTongji;
import org.springblade.alarm.entity.PiLaoBaojingTJ;
import org.springblade.alarm.page.BaojingTJPage;
import org.springblade.alarm.vo.BaojingtongjiVO;

import java.util.List;
import java.util.Map;

/**
 *  Mapper 接口
 *
 * @author Blade
 * @since 2019-07-25
 */
public interface BaojingtongjiMapper extends BaseMapper<BaojingTJ> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param baojingtongji
	 * @return
	 */
	List<BaojingtongjiVO> selectBaojingtongjiPage(IPage page, BaojingtongjiVO baojingtongji);

	/**
	 * 	超速统计
	 * @param baojingTJPage
	 * @return
	 */

	int selectAlarmTotal(BaojingTJPage baojingTJPage);

	List<BaojingTJ> TongjiPage(BaojingTJPage baojingTJPage);

	/**
	 * 疲劳统计
	 */
	int  selectPilaoTotal(BaojingTJPage baojingTJPage);
	List<PiLaoBaojingTJ> pilaoTongjiPage(BaojingTJPage baojingTJPage);

	/**
	 * gps当日报警统计
	 *
	 */
	List<Map<String,Object>> alarmCount(@Param("company") String company, @Param("date") String date);
	/**
	 * 主动安全报警统计
	 */
	List<Map<String,Object>> zhudongCount(@Param("company") String company, @Param("date") String date);
	/**
	 * 24小时不定位
	 */
	List<BudingweiTongji>   budingwei(BaojingTJPage baojingTJPage);
	/**
	 * 24小时不定位车辆 报警统计
	 */
	List<BudingweiCount>  budingweicount(BaojingTJPage baojingTJPage);
	int selectbudinweiTotal(BaojingTJPage  baojingTJPage);
	/**
	 * 24小时不在线
	 */
	List<BudingweiTongji>   buzaixian(BaojingTJPage baojingTJPage);
	int  selectbuzaixianTotal(BaojingTJPage baojingTJPage);
	/**
	 * 24小时不在线车辆统计
	 */

	List<BudingweiCount>  buzaixiancount(BaojingTJPage baojingTJPage);
}
