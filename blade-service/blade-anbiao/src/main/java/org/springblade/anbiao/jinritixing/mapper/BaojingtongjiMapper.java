/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 */
package org.springblade.anbiao.jinritixing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.jinritixing.entity.Baojingtongji;
import org.springblade.anbiao.jinritixing.page.BaojingtongjiPage;
import org.springblade.anbiao.jinritixing.vo.BaojingtongjiVO;

import java.util.List;

/**
 *  Mapper 接口
 * @author 呵呵哒
 */
public interface BaojingtongjiMapper extends BaseMapper<Baojingtongji> {

	List<BaojingtongjiVO> selectyues(BaojingtongjiPage Page);

	List<BaojingtongjiVO> selectdays(BaojingtongjiPage Page);
}
