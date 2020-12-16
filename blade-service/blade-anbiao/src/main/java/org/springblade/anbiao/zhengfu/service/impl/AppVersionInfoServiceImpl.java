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
import org.springblade.anbiao.zhengfu.entity.AppVersionInfo;
import org.springblade.anbiao.zhengfu.mapper.AppVersionInfoMapper;
import org.springblade.anbiao.zhengfu.page.AppVersionInfoPage;
import org.springblade.anbiao.zhengfu.service.IAppVersionInfoService;
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
public class AppVersionInfoServiceImpl extends ServiceImpl<AppVersionInfoMapper, AppVersionInfo> implements IAppVersionInfoService {

	private AppVersionInfoMapper appVersionInfoMapper;

	@Override
	public boolean insertSelective(AppVersionInfo appVersionInfo) {
		return appVersionInfoMapper.insertSelective(appVersionInfo);
	}

	@Override
	public AppVersionInfoPage selectALLPage(AppVersionInfoPage appVersionInfoPage) {
		Integer total = appVersionInfoMapper.selectAllTotal(appVersionInfoPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%appVersionInfoPage.getSize()==0){
				pagetotal = total / appVersionInfoPage.getSize();
			}else {
				pagetotal = total / appVersionInfoPage.getSize() + 1;
			}
		}
		if (pagetotal >= appVersionInfoPage.getCurrent()) {
			appVersionInfoPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (appVersionInfoPage.getCurrent() > 1) {
				offsetNo = appVersionInfoPage.getSize() * (appVersionInfoPage.getCurrent() - 1);
			}
			appVersionInfoPage.setTotal(total);
			appVersionInfoPage.setOffsetNo(offsetNo);
			List<AppVersionInfo> vehlist = appVersionInfoMapper.selectALLPage(appVersionInfoPage);
			appVersionInfoPage.setRecords(vehlist);
		}
		return appVersionInfoPage;
	}

	@Override
	public boolean updateByPrimaryKey(AppVersionInfo appVersionInfo) {
		return appVersionInfoMapper.updateByPrimaryKey(appVersionInfo);
	}
}
