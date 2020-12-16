/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.zhengfu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.zhengfu.entity.AppVersionInfo;
import org.springblade.anbiao.zhengfu.page.AppVersionInfoPage;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/20
 * @描述
 */
public interface IAppVersionInfoService extends IService<AppVersionInfo> {

	/**
	 * 新增APP版本文件
	 * @param appVersionInfo
	 * @return
	 */
	boolean insertSelective(AppVersionInfo appVersionInfo);

	/**
	 * 查询所欲APP版本文件
	 * @param appVersionInfoPage
	 * @return
	 */
	AppVersionInfoPage selectALLPage(AppVersionInfoPage appVersionInfoPage);

	/**
	 * 更新状态
	 * @param appVersionInfo
	 * @return
	 */
	boolean updateByPrimaryKey(AppVersionInfo appVersionInfo);

}
