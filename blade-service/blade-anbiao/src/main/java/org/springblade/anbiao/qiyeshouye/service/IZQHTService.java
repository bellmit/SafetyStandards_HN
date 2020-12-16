/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.qiyeshouye.entity.ZQHT;
import org.springblade.anbiao.qiyeshouye.page.ZQHTPage;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
public interface IZQHTService extends IService<ZQHT> {

	/**
	 * 政企互通-列表
	 * @param zqhtPage
	 * @return
	 */
	ZQHTPage selectGetTJ(ZQHTPage zqhtPage);

}
