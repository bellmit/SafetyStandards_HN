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
import org.springblade.anbiao.qiyeshouye.entity.ZQHT;
import org.springblade.anbiao.qiyeshouye.mapper.ZQHTMapper;
import org.springblade.anbiao.qiyeshouye.page.ZQHTPage;
import org.springblade.anbiao.qiyeshouye.service.IZQHTService;
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
public class ZQHTServiceImpl extends ServiceImpl<ZQHTMapper, ZQHT> implements IZQHTService {

	private ZQHTMapper zqhtMapper;

	@Override
	public ZQHTPage selectGetTJ(ZQHTPage zqhtPage) {
		Integer total = zqhtMapper.selectGetTJTotal(zqhtPage);
		if(zqhtPage.getSize()==0){
			if(zqhtPage.getTotal()==0){
				zqhtPage.setTotal(total);
			}

			List<ZQHT> zqhtList = zqhtMapper.selectGetTJ(zqhtPage);
			zqhtPage.setRecords(zqhtList);
			return zqhtPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zqhtPage.getSize()==0){
				pagetotal = total / zqhtPage.getSize();
			}else {
				pagetotal = total / zqhtPage.getSize() + 1;
			}
		}
		if (pagetotal >= zqhtPage.getCurrent()) {
			zqhtPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zqhtPage.getCurrent() > 1) {
				offsetNo = zqhtPage.getSize() * (zqhtPage.getCurrent() - 1);
			}
			zqhtPage.setTotal(total);
			zqhtPage.setOffsetNo(offsetNo);
			List<ZQHT> zqhtList = zqhtMapper.selectGetTJ(zqhtPage);
			zqhtPage.setRecords(zqhtList);
		}
		return zqhtPage;
	}
}
