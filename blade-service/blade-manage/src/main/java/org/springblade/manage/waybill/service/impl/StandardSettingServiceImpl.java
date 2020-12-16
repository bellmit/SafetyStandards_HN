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
import org.springblade.manage.waybill.entity.StandardSetting;
import org.springblade.manage.waybill.mapper.StandardSettingMapper;
import org.springblade.manage.waybill.page.StandardSettingPage;
import org.springblade.manage.waybill.service.IStandardSettingService;
import org.springblade.manage.waybill.vo.StandardSettingVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class StandardSettingServiceImpl extends ServiceImpl<StandardSettingMapper, StandardSetting> implements IStandardSettingService {

	private StandardSettingMapper standardSettingMapper;

	@Override
	public StandardSettingPage<StandardSettingVO> selectPageList(StandardSettingPage page) {
		int total = standardSettingMapper.selectTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}

			List<StandardSettingVO> list = standardSettingMapper.selectPageList(page);
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
			List<StandardSettingVO> list = standardSettingMapper.selectPageList(page);
			page.setRecords(list);
		}
		return page;
	}

	@Override
	public StandardSettingPage<StandardSettingVO> selectdefaultPageList(StandardSettingPage page) {
		int total = standardSettingMapper.selectdefaultTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}

			List<StandardSettingVO> list = standardSettingMapper.selectdefaultPageList(page);
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
			List<StandardSettingVO> list = standardSettingMapper.selectdefaultPageList(page);
			page.setRecords(list);
		}
		return page;
	}

	@Override
	public StandardSettingPage<StandardSettingVO> selecJiankong(StandardSettingPage page) {
		int total = standardSettingMapper.selectJiankongTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}

			List<StandardSettingVO> list = standardSettingMapper.selecJiankong(page);
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
			List<StandardSettingVO> list = standardSettingMapper.selecJiankong(page);
			page.setRecords(list);
		}
		return page;
	}

	@Override
	public List<StandardSettingVO> selecBenYueJiankong(StandardSettingPage page) {
		return standardSettingMapper.selecBenYueJiankong(page);
	}

	@Override
	public List<StandardSettingVO> selectByYunYing(StandardSettingPage page) {
		return standardSettingMapper.selectByYunYing(page);
	}

	@Override
	public StandardSettingVO selectByPlate(String vehicleId, String yue) {
		return standardSettingMapper.selectByPlate(vehicleId,yue);
	}

	@Override
	public List<StandardSettingVO> selectByZaiXian(StandardSettingPage page) {
		return standardSettingMapper.selectByZaiXian(page);
	}

	@Override
	public StandardSettingVO selectByYueDaBiao(StandardSettingPage page) {
		return standardSettingMapper.selectByYueDaBiao(page);
	}

	@Override
	public List<StandardSettingVO> selectByWanCheng(StandardSettingPage page) {
		return standardSettingMapper.selectByWanCheng(page);
	}

}
