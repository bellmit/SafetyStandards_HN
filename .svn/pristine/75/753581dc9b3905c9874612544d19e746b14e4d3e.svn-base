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
package org.springblade.anbiao.anquanmubiao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.anquanmubiao.entity.Mubiaokaohe;
import org.springblade.anbiao.anquanmubiao.mapper.MubiaokaoheMapper;
import org.springblade.anbiao.anquanmubiao.page.MubiaokaohePage;
import org.springblade.anbiao.anquanmubiao.service.IMubiaokaoheService;
import org.springblade.anbiao.anquanmubiao.vo.MubiaokaoheVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-04-28
 */
@Service
@AllArgsConstructor
public class MubiaokaoheServiceImpl extends ServiceImpl<MubiaokaoheMapper, Mubiaokaohe> implements IMubiaokaoheService {

	private MubiaokaoheMapper mubiaokaoheMapper;

	@Override
	public IPage<MubiaokaoheVO> selectMubiaokaohePage(IPage<MubiaokaoheVO> page, MubiaokaoheVO mubiaokaohe) {
		return page.setRecords(baseMapper.selectMubiaokaohePage(page, mubiaokaohe));
	}

	@Override
	public boolean updateDel(String id) {
		return mubiaokaoheMapper.updateDel(id);
	}

	@Override
	public boolean insertMuBiaoKaoHe(Mubiaokaohe mubiaokaohe) {
		return mubiaokaoheMapper.insertMuBiaoKaoHe(mubiaokaohe);
	}

	@Override
	public MubiaokaohePage<MubiaokaoheVO> selectPageList(MubiaokaohePage mubiaokaohePage) {
		Integer total = mubiaokaoheMapper.selectTotal(mubiaokaohePage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%mubiaokaohePage.getSize()==0){
				pagetotal = total / mubiaokaohePage.getSize();
			}else {
				pagetotal = total / mubiaokaohePage.getSize() + 1;
			}
		}
		if (pagetotal < mubiaokaohePage.getCurrent()) {
			return mubiaokaohePage;
		} else {
			mubiaokaohePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (mubiaokaohePage.getCurrent() > 1) {
				offsetNo = mubiaokaohePage.getSize() * (mubiaokaohePage.getCurrent() - 1);
			}
			mubiaokaohePage.setTotal(total);
			mubiaokaohePage.setOffsetNo(offsetNo);
			List<MubiaokaoheVO> vehlist = mubiaokaoheMapper.selectPageList(mubiaokaohePage);
			return (MubiaokaohePage<MubiaokaoheVO>) mubiaokaohePage.setRecords(vehlist);
		}
	}

	@Override
	public MubiaokaoheVO selectByIds(String id) {
		return mubiaokaoheMapper.selectByIds(id);
	}

}
