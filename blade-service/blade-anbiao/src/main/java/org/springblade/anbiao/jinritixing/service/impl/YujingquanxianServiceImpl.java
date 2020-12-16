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
package org.springblade.anbiao.jinritixing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.jinritixing.entity.Yujingquanxian;
import org.springblade.anbiao.jinritixing.mapper.YujingquanxianMapper;
import org.springblade.anbiao.jinritixing.page.YujingquanxianPage;
import org.springblade.anbiao.jinritixing.service.IYujingquanxianService;
import org.springblade.anbiao.jinritixing.vo.YujingquanxianVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class YujingquanxianServiceImpl extends ServiceImpl<YujingquanxianMapper, Yujingquanxian> implements IYujingquanxianService {

	private YujingquanxianMapper mapper;

	@Override
	public IPage<YujingquanxianVO> selectYujingquanxianPage(IPage<YujingquanxianVO> page, YujingquanxianVO yujingquanxian) {
		return page.setRecords(baseMapper.selectYujingquanxianPage(page, yujingquanxian));
	}

	@Override
	public YujingquanxianPage<YujingquanxianVO> selectAllYuJing(YujingquanxianPage yujingquanxianPage) {
		Integer total = baseMapper.selectAllYuJingTotal(yujingquanxianPage);
		if(yujingquanxianPage.getSize()==0){
			if(yujingquanxianPage.getTotal()==0){
				yujingquanxianPage.setTotal(total);
			}
			List<YujingquanxianVO> yuJingList = baseMapper.selectYuJingList(yujingquanxianPage);
			yujingquanxianPage.setRecords(yuJingList);
			return yujingquanxianPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%yujingquanxianPage.getSize()==0){
				pagetotal = total / yujingquanxianPage.getSize();
			}else {
				pagetotal = total / yujingquanxianPage.getSize() + 1;
			}
		}
		if (pagetotal >= yujingquanxianPage.getCurrent()) {
			yujingquanxianPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (yujingquanxianPage.getCurrent() > 1) {
				offsetNo = yujingquanxianPage.getSize() * (yujingquanxianPage.getCurrent() - 1);
			}
			yujingquanxianPage.setTotal(total);
			yujingquanxianPage.setOffsetNo(offsetNo);
			List<YujingquanxianVO> yuJingList = baseMapper.selectYuJingList(yujingquanxianPage);
			yujingquanxianPage.setRecords(yuJingList);
		}
		return yujingquanxianPage;
	}

	@Override
	public List<YujingquanxianVO> selectYuJingList(YujingquanxianPage page) {
		return mapper.selectYuJingList(page);
	}

	@Override
	public boolean delYuJing(YujingquanxianPage page) {
		return mapper.delYuJing(page);
	}

	@Override
	public void yujingjiesuan(YujingquanxianPage page) {
		mapper.yujingjiesuan(page);
	}

}
