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
package org.springblade.manage.waybill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.manage.waybill.entity.Operations;
import org.springblade.manage.waybill.mapper.OperationsMapper;
import org.springblade.manage.waybill.page.OperationsPage;
import org.springblade.manage.waybill.service.IOperationsService;
import org.springblade.manage.waybill.vo.OperationsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author hyp
 * @since 2019-11-28
 */
@Service
@AllArgsConstructor
public class OperationsServiceImpl extends ServiceImpl<OperationsMapper, Operations> implements IOperationsService {

	private OperationsMapper operationsMapper;

	@Override
	public OperationsPage<OperationsVO> selectPageList(OperationsPage page) {
		int total = operationsMapper.selectTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}

			List<OperationsVO> list = operationsMapper.selectPageList(page);
			page.setRecords(list);
			return page;

		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / page.getSize() + 1;
		}
		if (pagetotal >= page.getCurrent() && pagetotal > 0) {
			page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (page.getCurrent() > 1) {
				offsetNo = page.getSize() * (page.getCurrent() - 1);
			}
			page.setTotal(total);
			page.setOffsetNo(offsetNo);
			List<OperationsVO> list = operationsMapper.selectPageList(page);
			page.setRecords(list);
		}
		return page;
	}

	@Override
	public OperationsVO selectDetail(String id) {
		return operationsMapper.selectDetail(id);
	}



}
