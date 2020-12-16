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
package org.springblade.anbiao.cheliangguanli.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Cheliangguanchejiancha;
import org.springblade.anbiao.cheliangguanli.mapper.CheliangguanchejianchaMapper;
import org.springblade.anbiao.cheliangguanli.page.CheliangguanchejianchaPage;
import org.springblade.anbiao.cheliangguanli.service.ICheliangguanchejianchaService;
import org.springblade.anbiao.cheliangguanli.vo.CheliangguanchejianchaVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 * @author 呵呵哒
 */
@Service
@AllArgsConstructor
public class CheliangguanchejianchaServiceImpl extends ServiceImpl<CheliangguanchejianchaMapper, Cheliangguanchejiancha> implements ICheliangguanchejianchaService {

	private CheliangguanchejianchaMapper mapper;

	@Override
	public IPage<CheliangguanchejianchaVO> selectCheliangguanchejianchaPage(IPage<CheliangguanchejianchaVO> page, CheliangguanchejianchaVO cheliangguanchejiancha) {
		return page.setRecords(baseMapper.selectCheliangguanchejianchaPage(page, cheliangguanchejiancha));
	}

	@Override
	public boolean updateDel(String id) {
		return mapper.updateDel(id);
	}

	@Override
	public CheliangguanchejianchaPage<CheliangguanchejianchaVO> selectPageList(CheliangguanchejianchaPage Page) {
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
			List<CheliangguanchejianchaVO> vehlist = mapper.selectPageList(Page);
			return (CheliangguanchejianchaPage<CheliangguanchejianchaVO>) Page.setRecords(vehlist);
		}
	}

	@Override
	public CheliangguanchejianchaVO selectByIds(String id) {
		return mapper.selectByIds(id);
	}

}
