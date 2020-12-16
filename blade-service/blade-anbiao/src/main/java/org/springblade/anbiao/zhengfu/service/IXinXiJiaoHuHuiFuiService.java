/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Description:
 */
package org.springblade.anbiao.zhengfu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuHuiFu;
import org.springblade.anbiao.zhengfu.page.XinXiJiaoHuZhuTiPage;

/**
 * @author 呵呵哒
 * @描述
 */
public interface IXinXiJiaoHuHuiFuiService extends IService<XinXiJiaoHuHuiFu> {

	boolean insertSelective(XinXiJiaoHuHuiFu xinXiJiaoHuHuiFu);

	XinXiJiaoHuZhuTiPage selectHFALLPage(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);

}
