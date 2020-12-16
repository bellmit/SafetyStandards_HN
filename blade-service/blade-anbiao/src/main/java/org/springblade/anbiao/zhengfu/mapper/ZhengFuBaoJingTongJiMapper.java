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
import org.springblade.anbiao.zhengfu.entity.*;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoJingTongJiJieSuanPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 呵呵哒
 * @描述
 */
public interface ZhengFuBaoJingTongJiMapper extends BaseMapper<ZhengFuBaoJingTongJi> {

	/**
	 * 当月企业报警占比
	 * @param deptId
	 * @return
	 */
	List<ZhengFuBaoJingTongJi> selectGetZFBaoJing(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi>  selectGetZFBaoJing_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);
	/**
	 * 当年报警数、未处理数、当年处理率
	 * @param deptId
	 * @return
	 */
	ZhengFuBaoJingTongJi selectGetZFBaoJingYear(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi> selectGetZFBaoJingYear_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);
	/**
	 * 当月报警数、未处理数、当年处理率
	 * @param deptId
	 * @return
	 */
	ZhengFuBaoJingTongJi selectGetZFBaoJingMonth(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi> selectGetZFBaoJingMonth_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);
	/**
	 * 当年报警趋势、当年处警趋势
	 * @param deptId
	 * @return
	 */
	List<ZhengFuBaoJingTongJi> selectGetZFBaoJingQuShi(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi> selectGetZFBaoJingQuShi_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);

	/**
	 * 企业报警排名
	 * @param deptId
	 * @return
	 */
	List<ZhengFuBaoJingTongJi> selectGetZFQYBaoJingPaiMing(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi> selectGetZFQYBaoJingPaiMing_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);

	/**
	 * 地区报警排名
	 * @param deptId
	 * @return
	 */
	List<ZhengFuBaoJingTongJi> selectGetZFDQBaoJingPaiMing(@Param("deptId") String deptId);

	List<ZhengFuBaoJingTongJi> selectGetZFDQBaoJingPaiMing_XiaJi(@Param("xiaJiDeptId") String xiaJiDeptId);

	/**
	 * 报警结算统计
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiJieSuan> selectGetBJTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetBJTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 地区报警处理率统计
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiLv> selectGetDqLvTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetDqLvTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 企业报警处理率统计
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiLv> selectGetQYLvTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetQYLvTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * gps报警明细
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingMingXi> selectGetGPSMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetGPSMXTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * dms报警明细
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingMingXi> selectGetDMSMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetDMSMXTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 报警 vehicle明细
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingVehicle> selectGetVehicleMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetVehicleMXTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 所有报警明细
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingMingXi> selectGetAllMXTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectGetAllMXTJTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 根据政府id查询是否包含下级
	 * @param deptId
	 * @return
	 */
	List<ZhengFuBaoJingTongJi> selectGetZFYG(@Param("deptId") String deptId);

	/**
	 * 根据政府id查询地区报警车辆数
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiLv> selectGetZFBJCLS(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 地区报警排名
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiJieSuan> selectGetDQTJPMTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectDQTJPMTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 车辆报警排名
	 * @param zhengFuBaoJingTongJiJieSuanPage
	 * @return
	 */
	List<ZhengFuBaoJingTongJiJieSuan>  selectGetCLTJPMTJ(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);
	int selectCLTJPMTotal(ZhengFuBaoJingTongJiJieSuanPage zhengFuBaoJingTongJiJieSuanPage);

	/**
	 * 根据报警ID查询tts消息列表
	 * @param alarmGuId
	 * @return
	 */
	List<TtsMessageInfo> selectByAlarmGuId(String alarmGuId);
}
