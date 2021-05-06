/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.springblade.anbiao.cheliangguanli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.cheliangguanli.entity.BaoYangWeiXiu;
import org.springblade.anbiao.cheliangguanli.page.BaoYangWeiXiuPage;
import org.springblade.anbiao.cheliangguanli.vo.BaoYangWeiXiuVO;

/**
 *  服务类
 */
public interface IBaoYangWeiXiuService extends IService<BaoYangWeiXiu> {

	BaoYangWeiXiuVO selectByIds(String id);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	BaoYangWeiXiuPage<BaoYangWeiXiuVO> selectPageList(BaoYangWeiXiuPage Page);

}
