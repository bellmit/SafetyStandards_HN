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
package org.springblade.anbiao.falvfagui.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.anbiao.falvfagui.entity.Anquanshengchan;
import org.springblade.anbiao.falvfagui.page.AnquanshengchanPage;
import org.springblade.anbiao.falvfagui.vo.AnquanshengchanVO;
import org.springblade.anbiao.falvfagui.mapper.AnquanshengchanMapper;
import org.springblade.anbiao.falvfagui.service.IAnquanshengchanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-04-24
 */
@Service
@AllArgsConstructor
public class AnquanshengchanServiceImpl extends ServiceImpl<AnquanshengchanMapper, Anquanshengchan> implements IAnquanshengchanService {

	private AnquanshengchanMapper anquanshengchanMapper;

	@Override
	public IPage<AnquanshengchanVO> selectAnquanshengchanPage(IPage<AnquanshengchanVO> page, AnquanshengchanVO anquanshengchan) {
		return page.setRecords(baseMapper.selectAnquanshengchanPage(page, anquanshengchan));
	}

	@Override
	public boolean insertAnQuanShengChan(Anquanshengchan anquanshengchan) {
		return anquanshengchanMapper.insertAnQuanShengChan(anquanshengchan);
	}

	@Override
	public boolean updateDel(String id) {
		return anquanshengchanMapper.updateDel(id);
	}

	@Override
	public AnquanshengchanPage<AnquanshengchanVO> selectPageList(AnquanshengchanPage anquanshengchanPage) {
		Integer total = anquanshengchanMapper.selectTotal(anquanshengchanPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%anquanshengchanPage.getSize()==0){
				pagetotal = total / anquanshengchanPage.getSize();
			}else {
				pagetotal = total / anquanshengchanPage.getSize() + 1;
			}
		}
		if (pagetotal < anquanshengchanPage.getCurrent()) {
			return anquanshengchanPage;
		} else {
			anquanshengchanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (anquanshengchanPage.getCurrent() > 1) {
				offsetNo = anquanshengchanPage.getSize() * (anquanshengchanPage.getCurrent() - 1);
			}
			anquanshengchanPage.setTotal(total);
			anquanshengchanPage.setOffsetNo(offsetNo);
			List<AnquanshengchanVO> vehlist = anquanshengchanMapper.selectPageList(anquanshengchanPage);
			return (AnquanshengchanPage<AnquanshengchanVO>) anquanshengchanPage.setRecords(vehlist);
		}
	}

	@Override
	public AnquanshengchanVO selectByIds(String id) {
		return anquanshengchanMapper.selectByIds(id);
	}

}
