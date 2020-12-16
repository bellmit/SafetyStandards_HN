/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuServiceImpl
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.qiyeshouye.entity.QiYeOffLineTongJi;
import org.springblade.anbiao.qiyeshouye.entity.QiYeRiYunXingTongJi;
import org.springblade.anbiao.qiyeshouye.entity.QiYeTongJi;
import org.springblade.anbiao.qiyeshouye.mapper.QiYeTongJiMapper;
import org.springblade.anbiao.qiyeshouye.page.QiYeOffLineTongJiPage;
import org.springblade.anbiao.qiyeshouye.page.QiYeTongJiPage;
import org.springblade.anbiao.qiyeshouye.service.IQiYeTongJiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
@Service
@AllArgsConstructor
public class QiYeTongJiServiceImpl extends ServiceImpl<QiYeTongJiMapper, QiYeTongJi> implements IQiYeTongJiService {

	private QiYeTongJiMapper qiYeTongJiMapper;

	@Override
	public QiYeTongJiPage selectGetBJTJ(QiYeTongJiPage qiYeTongJiPage) {
		Integer total = qiYeTongJiMapper.selectGetBJTJTotal(qiYeTongJiPage);
		if(qiYeTongJiPage.getSize()==0){
			if(qiYeTongJiPage.getTotal()==0){
				qiYeTongJiPage.setTotal(total);
			}

			List<QiYeTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGetBJTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
			return qiYeTongJiPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%qiYeTongJiPage.getSize()==0){
				pagetotal = total / qiYeTongJiPage.getSize();
			}else {
				pagetotal = total / qiYeTongJiPage.getSize() + 1;
			}
		}
		if (pagetotal >= qiYeTongJiPage.getCurrent()) {
			qiYeTongJiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (qiYeTongJiPage.getCurrent() > 1) {
				offsetNo = qiYeTongJiPage.getSize() * (qiYeTongJiPage.getCurrent() - 1);
			}
			qiYeTongJiPage.setTotal(total);
			qiYeTongJiPage.setOffsetNo(offsetNo);
			List<QiYeTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGetBJTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return qiYeTongJiPage;
	}

	@Override
	public QiYeTongJiPage selectBJPMTJ(QiYeTongJiPage qiYeTongJiPage) {
		Integer total = qiYeTongJiMapper.selectBJTJPMTotal(qiYeTongJiPage);
		if(qiYeTongJiPage.getSize()==0){
			if(qiYeTongJiPage.getTotal()==0){
				qiYeTongJiPage.setTotal(total);
			}

			List<QiYeTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectBJPMTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
			return qiYeTongJiPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%qiYeTongJiPage.getSize()==0){
				pagetotal = total / qiYeTongJiPage.getSize();
			}else {
				pagetotal = total / qiYeTongJiPage.getSize() + 1;
			}
		}
		if (pagetotal >= qiYeTongJiPage.getCurrent()) {
			qiYeTongJiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (qiYeTongJiPage.getCurrent() > 1) {
				offsetNo = qiYeTongJiPage.getSize() * (qiYeTongJiPage.getCurrent() - 1);
			}
			qiYeTongJiPage.setTotal(total);
			qiYeTongJiPage.setOffsetNo(offsetNo);
			List<QiYeTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectBJPMTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return qiYeTongJiPage;
	}

	@Override
	public QiYeTongJiPage selectGetRYXBJTJ(QiYeTongJiPage qiYeTongJiPage) {
		Integer total = qiYeTongJiMapper.selectGetRYXBJTJTotal(qiYeTongJiPage);
		if(qiYeTongJiPage.getSize()==0){
			if(qiYeTongJiPage.getTotal()==0){
				qiYeTongJiPage.setTotal(total);
			}

			List<QiYeRiYunXingTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGetRYXBJTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
			return qiYeTongJiPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%qiYeTongJiPage.getSize()==0){
				pagetotal = total / qiYeTongJiPage.getSize();
			}else {
				pagetotal = total / qiYeTongJiPage.getSize() + 1;
			}
		}
		if (pagetotal >= qiYeTongJiPage.getCurrent()) {
			qiYeTongJiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (qiYeTongJiPage.getCurrent() > 1) {
				offsetNo = qiYeTongJiPage.getSize() * (qiYeTongJiPage.getCurrent() - 1);
			}
			qiYeTongJiPage.setTotal(total);
			qiYeTongJiPage.setOffsetNo(offsetNo);
			List<QiYeRiYunXingTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGetRYXBJTJ(qiYeTongJiPage);
			qiYeTongJiPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return qiYeTongJiPage;
	}

	@Override
	public QiYeOffLineTongJiPage<QiYeOffLineTongJi> selectGet24HoursOffLineTJ(QiYeOffLineTongJiPage qiYeOffLineTongJiPage) {
		Integer total = qiYeTongJiMapper.selectGet24HoursOffLineTJTotal(qiYeOffLineTongJiPage);
		if(qiYeOffLineTongJiPage.getSize()==0){
			if(qiYeOffLineTongJiPage.getTotal()==0){
				qiYeOffLineTongJiPage.setTotal(total);
			}

			List<QiYeOffLineTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGet24HoursOffLineTJ(qiYeOffLineTongJiPage);
			qiYeOffLineTongJiPage.setRecords(zhengFuBaoJingTongJiList);
			return qiYeOffLineTongJiPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%qiYeOffLineTongJiPage.getSize()==0){
				pagetotal = total / qiYeOffLineTongJiPage.getSize();
			}else {
				pagetotal = total / qiYeOffLineTongJiPage.getSize() + 1;
			}
		}
		if (pagetotal >= qiYeOffLineTongJiPage.getCurrent()) {
			qiYeOffLineTongJiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (qiYeOffLineTongJiPage.getCurrent() > 1) {
				offsetNo = qiYeOffLineTongJiPage.getSize() * (qiYeOffLineTongJiPage.getCurrent() - 1);
			}
			qiYeOffLineTongJiPage.setTotal(total);
			qiYeOffLineTongJiPage.setOffsetNo(offsetNo);
			List<QiYeOffLineTongJi> zhengFuBaoJingTongJiList = qiYeTongJiMapper.selectGet24HoursOffLineTJ(qiYeOffLineTongJiPage);
			qiYeOffLineTongJiPage.setRecords(zhengFuBaoJingTongJiList);
		}
		return qiYeOffLineTongJiPage;
	}
}
