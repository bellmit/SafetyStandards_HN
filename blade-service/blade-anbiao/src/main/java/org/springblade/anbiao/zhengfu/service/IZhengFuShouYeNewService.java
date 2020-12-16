/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.zhengfu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYe;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYeNew;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
public interface IZhengFuShouYeNewService extends IService<ZhengFuShouYeNew> {

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
