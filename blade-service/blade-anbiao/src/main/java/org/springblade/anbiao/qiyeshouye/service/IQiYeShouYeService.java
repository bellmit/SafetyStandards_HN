/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.qiyeshouye.entity.*;
import org.springblade.anbiao.qiyeshouye.page.QiYeTpvehdataPage;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
public interface IQiYeShouYeService extends IService<QiYeShouYe> {

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
	QiYeShouYe selectYearAlarm(@Param("deptId") String deptId, @Param("year") String year);

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
	QiYeShouYe selectSevenAlarmStatistics(@Param("deptId") String deptId) throws UnsupportedEncodingException;

	/**
	 *运维端首页统计数据
	 * @param deptId
	 * @return
	 */
	List<QiYeYunWeiShouYe> selectOperational(@Param("deptId") String deptId);

	/**
	 * 首页安全达标提醒
	 * @param deptId
	 * @return
	 */
	QiYeYunWeiShouYe selectMarkRemind(@Param("deptId") String deptId);

	/**
	 *企业数
	 * @return
	 */
	QiYeYunWeiShouYe selectQiYeCount();
	/**
	 *安标企业数
	 * @return
	 */
	QiYeYunWeiShouYe selectABQiYeCount();

	/**
	 * 待办提醒
	 * @param deptId
	 * @param dateTime
	 * @return
	 */
	List<QiYeAnBiao> selectScheduleReminders(@Param("deptId") String deptId, @Param("dateTime") String dateTime);

	/**
	 * 安标目录得分对比表
	 * @return
	 */
	List<QiYeAnBiaoMuLu> selectQiYeAnBiaoMuLu(@Param("deptId") String deptId);

	/**
	 * 安标周期评分达标率
	 * @param deptId
	 * @return
	 */
	QiYeAnBiaoPeriodRate selectPeriodControlRates (@Param("deptId") String deptId);

	/**
	 * 安全提示
	 * @param deptId
	 * @return
	 */
	List<QiYeAnBiaoSafetyTips> selectSafetyTips (@Param("deptId") String deptId);

	/**
	 * 根据不达标项ID查询子小项总数
	 * @param deptId xiangId
	 * @return
	 */
	QiYeAnBiaoSafetyTips selectSafetyTipsZNum(@Param("deptId") String deptId,@Param("xiangId") Integer xiangId);

	/**
	 * 根据不达标项ID查询不达标子小项数
	 * @param deptId xiangId
	 * @return
	 */
	QiYeAnBiaoSafetyTips selectSafetyTipsNum(@Param("deptId") String deptId,@Param("xiangId") Integer xiangId);


}
