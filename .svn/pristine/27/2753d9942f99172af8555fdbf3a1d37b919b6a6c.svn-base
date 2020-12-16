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
package org.springblade.anbiao.ranyoubutie.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.anbiao.ranyoubutie.entity.Fueltotalreport;
import org.springblade.anbiao.ranyoubutie.page.FueltotalreportPage;
import org.springblade.anbiao.ranyoubutie.vo.FueltotalreportVO;
import org.springblade.anbiao.ranyoubutie.mapper.FueltotalreportMapper;
import org.springblade.anbiao.ranyoubutie.service.IFueltotalreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 *  服务实现类
 *
 * @author jx
 * @since 2019-10-16
 */
@Service
@AllArgsConstructor
public class FueltotalreportServiceImpl extends ServiceImpl<FueltotalreportMapper, Fueltotalreport> implements IFueltotalreportService {

	private FueltotalreportMapper mapper;

	@Override
	public IPage<FueltotalreportVO> selectFueltotalreportPage(IPage<FueltotalreportVO> page, FueltotalreportVO fueltotalreport) {
		return page.setRecords(baseMapper.selectFueltotalreportPage(page, fueltotalreport));
	}

	@Override
	public FueltotalreportPage<FueltotalreportVO> selectAllList(FueltotalreportPage page) {
		Integer total = mapper.selectTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}
			List<FueltotalreportVO> vehlist = mapper.selectAllList(page);
			page.setRecords(vehlist);
			return page;

		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%page.getSize()==0){
				pagetotal = total / page.getSize();
			}else {
				pagetotal = total / page.getSize() + 1;
			}
		}
		if (pagetotal < page.getCurrent()) {
			return page;
		} else {
			page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (page.getCurrent() > 1) {
				offsetNo = page.getSize() * (page.getCurrent() - 1);
			}
			page.setTotal(total);
			page.setOffsetNo(offsetNo);
			List<FueltotalreportVO> vehlist = mapper.selectAllList(page);
			return (FueltotalreportPage<FueltotalreportVO>) page.setRecords(vehlist);
		}
	}

}
