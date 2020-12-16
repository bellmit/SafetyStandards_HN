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
package org.springblade.anbiao.jiaoyupeixun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.jiaoyupeixun.entity.JiaoyupeixunRenyuan;
import org.springblade.anbiao.jiaoyupeixun.mapper.JiaoyupeixunRenyuanMapper;
import org.springblade.anbiao.jiaoyupeixun.page.JiaoyupeixunRenyuanPage;
import org.springblade.anbiao.jiaoyupeixun.service.IJiaoyupeixunRenyuanService;
import org.springblade.anbiao.jiaoyupeixun.vo.JiaoyupeixunRenyuanVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-04-25
 */
@Service
@AllArgsConstructor
public class JiaoyupeixunRenyuanServiceImpl extends ServiceImpl<JiaoyupeixunRenyuanMapper, JiaoyupeixunRenyuan> implements IJiaoyupeixunRenyuanService {

	private JiaoyupeixunRenyuanMapper jiaoyupeixunRenyuanMapper;

	@Override
	public IPage<JiaoyupeixunRenyuanVO> selectJiaoyupeixunRenyuanPage(IPage<JiaoyupeixunRenyuanVO> page, JiaoyupeixunRenyuanVO jiaoyupeixunRenyuan) {
		return page.setRecords(baseMapper.selectJiaoyupeixunRenyuanPage(page, jiaoyupeixunRenyuan));
	}

	@Override
	public boolean updateDel(String id) {
		return jiaoyupeixunRenyuanMapper.updateDel(id);
	}

	@Override
	public boolean insertRenYuan(JiaoyupeixunRenyuan jiaoyupeixunRenyuan) {
		return jiaoyupeixunRenyuanMapper.insertRenYuan(jiaoyupeixunRenyuan);
	}

	@Override
	public JiaoyupeixunRenyuanPage<JiaoyupeixunRenyuanVO> selectPageList(JiaoyupeixunRenyuanPage jiaoyupeixunRenyuanPage) {
		Integer total = jiaoyupeixunRenyuanMapper.selectTotal(jiaoyupeixunRenyuanPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%jiaoyupeixunRenyuanPage.getSize()==0){
				pagetotal = total / jiaoyupeixunRenyuanPage.getSize();
			}else {
				pagetotal = total / jiaoyupeixunRenyuanPage.getSize() + 1;
			}
		}
		if (pagetotal < jiaoyupeixunRenyuanPage.getCurrent()) {
			return jiaoyupeixunRenyuanPage;
		} else {
			jiaoyupeixunRenyuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (jiaoyupeixunRenyuanPage.getCurrent() > 1) {
				offsetNo = jiaoyupeixunRenyuanPage.getSize() * (jiaoyupeixunRenyuanPage.getCurrent() - 1);
			}
			jiaoyupeixunRenyuanPage.setTotal(total);
			jiaoyupeixunRenyuanPage.setOffsetNo(offsetNo);
			List<JiaoyupeixunRenyuanVO> vehlist = jiaoyupeixunRenyuanMapper.selectPageList(jiaoyupeixunRenyuanPage);
			return (JiaoyupeixunRenyuanPage<JiaoyupeixunRenyuanVO>) jiaoyupeixunRenyuanPage.setRecords(vehlist);
		}
	}

}
