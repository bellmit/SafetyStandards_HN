/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.app.yingjichuzhi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.app.yingjichuzhi.entity.Yingjichuzhilei;
import org.springblade.app.yingjichuzhi.mapper.YingjichuzhiMapper;
import org.springblade.app.yingjichuzhi.mapper.YingjichuzhileiMapper;
import org.springblade.app.yingjichuzhi.page.YingjichuzhileiPage;
import org.springblade.app.yingjichuzhi.service.IYingjichuzhileiService;
import org.springblade.app.yingjichuzhi.vo.YingjichuzhileiVO;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.common.tool.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-05-07
 */
@Service
@AllArgsConstructor
public class YingjichuzhileiServiceImpl extends ServiceImpl<YingjichuzhileiMapper, Yingjichuzhilei> implements IYingjichuzhileiService {

	private YingjichuzhileiMapper yingjichuzhileiMapper;

	@Override
	public IPage<YingjichuzhileiVO> selectYingjichuzhileiPage(IPage<YingjichuzhileiVO> page, YingjichuzhileiVO yingjichuzhilei) {
		return page.setRecords(baseMapper.selectYingjichuzhileiPage(page, yingjichuzhilei));
	}

	@Override
	public YingjichuzhileiPage<YingjichuzhileiVO> selectPageList(YingjichuzhileiPage yingjichuzhileiPage) {
		Integer total = yingjichuzhileiMapper.selectTotal(yingjichuzhileiPage);
		System.out.println(total);
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / yingjichuzhileiPage.getSize() + 1;
		}
		if (pagetotal >= yingjichuzhileiPage.getCurrent() && pagetotal > 0) {
			yingjichuzhileiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (yingjichuzhileiPage.getCurrent() > 1) {
				offsetNo = yingjichuzhileiPage.getSize() * (yingjichuzhileiPage.getCurrent() - 1);
			}
			yingjichuzhileiPage.setTotal(total);
			yingjichuzhileiPage.setOffsetNo(offsetNo);
			List<YingjichuzhileiVO> yingjichuzhilist = yingjichuzhileiMapper.selectPageList(yingjichuzhileiPage);
			yingjichuzhileiPage.setRecords(yingjichuzhilist);
		}
		return yingjichuzhileiPage;
	}

	@Override
	public YingjichuzhileiVO selectByKey(String id) {
		return yingjichuzhileiMapper.selectByKey(id);
	}


}
