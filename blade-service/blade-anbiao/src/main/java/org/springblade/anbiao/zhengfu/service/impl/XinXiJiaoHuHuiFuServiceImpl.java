/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuServiceImpl
 * Description:
 */
package org.springblade.anbiao.zhengfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuHuiFu;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTi;
import org.springblade.anbiao.zhengfu.mapper.XinXiJiaoHuHuiFuMapper;
import org.springblade.anbiao.zhengfu.mapper.XinXiJiaoHuZhuTiMapper;
import org.springblade.anbiao.zhengfu.page.XinXiJiaoHuZhuTiPage;
import org.springblade.anbiao.zhengfu.service.IXinXiJiaoHuHuiFuiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 呵呵哒
 * @描述
 */
@Service
@AllArgsConstructor
public class XinXiJiaoHuHuiFuServiceImpl extends ServiceImpl<XinXiJiaoHuHuiFuMapper, XinXiJiaoHuHuiFu> implements IXinXiJiaoHuHuiFuiService {

	private XinXiJiaoHuHuiFuMapper xinXiJiaoHuHuiFuMapper;

	private XinXiJiaoHuZhuTiMapper xiJiaoHuZhuTiMapper;

	@Override
	public boolean insertSelective(XinXiJiaoHuHuiFu xinXiJiaoHuHuiFu) {
		return xinXiJiaoHuHuiFuMapper.insertSelective(xinXiJiaoHuHuiFu);
	}

	@Override
	public XinXiJiaoHuZhuTiPage selectHFALLPage(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage) {
		Integer total = xiJiaoHuZhuTiMapper.selectHFAllTotal(xinXiJiaoHuZhuTiPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%xinXiJiaoHuZhuTiPage.getSize()==0){
				pagetotal = total / xinXiJiaoHuZhuTiPage.getSize();
			}else {
				pagetotal = total / xinXiJiaoHuZhuTiPage.getSize() + 1;
			}
		}
		if (pagetotal >= xinXiJiaoHuZhuTiPage.getCurrent()) {
			xinXiJiaoHuZhuTiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (xinXiJiaoHuZhuTiPage.getCurrent() > 1) {
				offsetNo = xinXiJiaoHuZhuTiPage.getSize() * (xinXiJiaoHuZhuTiPage.getCurrent() - 1);
			}
			xinXiJiaoHuZhuTiPage.setTotal(total);
			xinXiJiaoHuZhuTiPage.setOffsetNo(offsetNo);
			List<XinXiJiaoHuZhuTi> vehlist = xiJiaoHuZhuTiMapper.selectHFALLPage(xinXiJiaoHuZhuTiPage);
			xinXiJiaoHuZhuTiPage.setRecords(vehlist);
		}
		return xinXiJiaoHuZhuTiPage;
	}


}
