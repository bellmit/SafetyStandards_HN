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
package org.springblade.anbiao.yingjijiuyuan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.yingjijiuyuan.entity.Yingjizhuangbei;
import org.springblade.anbiao.yingjijiuyuan.mapper.YingjizhuangbeiMapper;
import org.springblade.anbiao.yingjijiuyuan.page.YingjizhuangbeiPage;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjizhuangbeiService;
import org.springblade.anbiao.yingjijiuyuan.vo.YingjizhuangbeiVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-04-29
 */
@Service
@AllArgsConstructor
public class YingjizhuangbeiServiceImpl extends ServiceImpl<YingjizhuangbeiMapper, Yingjizhuangbei> implements IYingjizhuangbeiService {

	private YingjizhuangbeiMapper mapper;

	@Override
	public IPage<YingjizhuangbeiVO> selectYingjizhuangbeiPage(IPage<YingjizhuangbeiVO> page, YingjizhuangbeiVO yingjizhuangbei) {
		return page.setRecords(baseMapper.selectYingjizhuangbeiPage(page, yingjizhuangbei));
	}

	@Override
	public boolean updateDel(String id) {
		return mapper.updateDel(id);
	}

	@Override
	public YingjizhuangbeiPage<YingjizhuangbeiVO> selectPageList(YingjizhuangbeiPage Page) {
		Integer total = mapper.selectTotal(Page);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%Page.getSize()==0){
				pagetotal = total / Page.getSize();
			}else {
				pagetotal = total / Page.getSize() + 1;
			}
		}
		if (pagetotal < Page.getCurrent()) {
			return Page;
		} else {
			Page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (Page.getCurrent() > 1) {
				offsetNo = Page.getSize() * (Page.getCurrent() - 1);
			}
			Page.setTotal(total);
			Page.setOffsetNo(offsetNo);
			List<YingjizhuangbeiVO> vehlist = mapper.selectPageList(Page);
			return (YingjizhuangbeiPage<YingjizhuangbeiVO>) Page.setRecords(vehlist);
		}
	}

	@Override
	public int selectTotal(YingjizhuangbeiPage Page) {
		return mapper.selectTotal(Page);
	}

	@Override
	public YingjizhuangbeiVO selectByIds(String id) {
		return mapper.selectByIds(id);
	}

}
