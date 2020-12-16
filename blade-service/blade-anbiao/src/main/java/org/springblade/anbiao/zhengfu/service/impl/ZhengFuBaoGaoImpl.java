/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuServiceImpl
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.zhengfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.ZhengFuBaoGao;
import org.springblade.anbiao.zhengfu.entity.ZhengFuBaoJingTongJiLv;
import org.springblade.anbiao.zhengfu.mapper.ZhengFuBaoGaoMapper;
import org.springblade.anbiao.zhengfu.page.ZhengFuBaoGaoPage;
import org.springblade.anbiao.zhengfu.service.IZhengFuBaoGaoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/20
 * @描述
 */
@Service
@AllArgsConstructor
public class ZhengFuBaoGaoImpl extends ServiceImpl<ZhengFuBaoGaoMapper, ZhengFuBaoGao> implements IZhengFuBaoGaoService {

	private ZhengFuBaoGaoMapper zhengFuBaoGaoMapper;


	@Override
	public ZhengFuBaoGaoPage selectALLPage(ZhengFuBaoGaoPage zhengFuBaoGaoPage) {
		Integer total = zhengFuBaoGaoMapper.selectAllTotal(zhengFuBaoGaoPage);
		if(zhengFuBaoGaoPage.getSize()==0){
			if(zhengFuBaoGaoPage.getTotal()==0){
				zhengFuBaoGaoPage.setTotal(total);
			}
			List<ZhengFuBaoGao> zhengFuBaoGaoList = zhengFuBaoGaoMapper.selectALLPage(zhengFuBaoGaoPage);
			zhengFuBaoGaoPage.setRecords(zhengFuBaoGaoList);
			return zhengFuBaoGaoPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zhengFuBaoGaoPage.getSize()==0){
				pagetotal = total / zhengFuBaoGaoPage.getSize();
			}else {
				pagetotal = total / zhengFuBaoGaoPage.getSize() + 1;
			}
		}
		if (pagetotal >= zhengFuBaoGaoPage.getCurrent()) {
			zhengFuBaoGaoPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zhengFuBaoGaoPage.getCurrent() > 1) {
				offsetNo = zhengFuBaoGaoPage.getSize() * (zhengFuBaoGaoPage.getCurrent() - 1);
			}
			zhengFuBaoGaoPage.setTotal(total);
			zhengFuBaoGaoPage.setOffsetNo(offsetNo);
			List<ZhengFuBaoGao> zhengFuBaoGaoList = zhengFuBaoGaoMapper.selectALLPage(zhengFuBaoGaoPage);
			zhengFuBaoGaoPage.setRecords(zhengFuBaoGaoList);
		}
		return zhengFuBaoGaoPage;
	}

}
