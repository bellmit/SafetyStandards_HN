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
package org.springblade.anbiao.zhengfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYe;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYeNew;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/18
 * @描述
 */
public interface ZhengFuShouYeNewMapper extends BaseMapper<ZhengFuShouYeNew> {


	/**
	 * 查询企业总数、个体总数、车辆总数、在线车辆数
	 * @param deptId
	 * @param date
	 * @return
	 */
	ZhengFuShouYeNew selectGetOne(@Param("deptId") String deptId, @Param("date") String date);


	/**
	 * 查询超速报警次数、疲劳报警总数、夜间行驶报警次数、异常报警次数
	 * @param deptId
	 * @param year
	 * @param month
	 * @return
	 */
	ZhengFuShouYeNew selectGetTwo(@Param("deptId") String deptId, @Param("xiaJiDeptId") String xiaJiDeptId, @Param("year") Integer year, @Param("month") int month ,@Param("areaName") String areaName);

	/**
	 * 查询超速报警次数、疲劳报警总数、夜间行驶报警次数、异常报警次数(下钻)
	 * @param
	 * @param year
	 * @param month
	 * @return
	 */
	List<ZhengFuShouYeNew> selectGetTwoXJ(@Param("deptId") String deptId, @Param("xiaJiDeptId") String xiaJiDeptId, @Param("year") Integer year, @Param("month") int month ,@Param("areaName") String areaName);


	/**
	 *北斗报警、主动安全设备报警月趋势
	 * @param deptId
	 * @param year
	 * @return
	 */
	List<ZhengFuShouYeNew> selectGetThree(@Param("deptId") String deptId, @Param("xiaJiDeptId") String xiaJiDeptId, @Param("year") int year, @Param("areaName") String areaName);

	/**
	 *各地区详细报警数据表
	 * @param deptId
	 * @param year
	 * @param month
	 * @param date
	 * @param xiaJiDeptId
	 * @return
	 */
	List<ZhengFuShouYeNew> selectGetFour(@Param("deptId") String deptId,@Param("xiaJiDeptId") String xiaJiDeptId, @Param("year") int year, @Param("month") int month, @Param("date") String date);

}
