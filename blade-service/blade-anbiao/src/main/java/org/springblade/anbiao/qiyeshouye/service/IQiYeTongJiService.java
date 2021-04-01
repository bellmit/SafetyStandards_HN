/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.qiyeshouye.entity.*;
import org.springblade.anbiao.qiyeshouye.page.QiYeInOutAreaPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeOffLineTongJiPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeTongJiPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeTpvehdataPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
public interface IQiYeTongJiService extends IService<QiYeTongJi> {

	/**
	 * 报警统计汇总
	 * @param qiYeTongJiPage
	 * @return
	 */
	QiYeTongJiPage selectGetBJTJ(QiYeTongJiPage qiYeTongJiPage);

	/**
	 * 车辆报警排名
	 * @param qiYeTongJiPage
	 * @return
	 */
	QiYeTongJiPage selectBJPMTJ(QiYeTongJiPage qiYeTongJiPage);

	/**
	 * 日运行情况统计
	 * @param qiYeTongJiPage
	 * @return
	 */
	QiYeTongJiPage selectGetRYXBJTJ(QiYeTongJiPage qiYeTongJiPage);

	/**
	 * 24小时不在线统计
	 * @param qiYeOffLineTongJiPage
	 * @return
	 */
	QiYeOffLineTongJiPage<QiYeOffLineTongJi> selectGet24HoursOffLineTJ(QiYeOffLineTongJiPage qiYeOffLineTongJiPage);

	/**
	 * 进出区域统计
	 * @param qiYeInOutAreaPage
	 * @return
	 */
	QiYeInOutAreaPage<QiYeInOutAreaTongJi> selectGetInOutAreaTJ(QiYeInOutAreaPage qiYeInOutAreaPage);

	/**
	 * 企业在线车辆详情
	 * @param qiYeTpvehdataPage
	 * @return
	 */
	QiYeTpvehdataPage<QiYeTpvehdataTongJi> selecttpvehdataTJ(QiYeTpvehdataPage qiYeTpvehdataPage);


}
