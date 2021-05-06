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
package org.springblade.anbiao.qiyeshouye.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.qiyeshouye.entity.Notice;
import org.springblade.anbiao.qiyeshouye.mapper.NoticeMapper;
import org.springblade.anbiao.qiyeshouye.page.NoticePage;
import org.springblade.anbiao.qiyeshouye.service.INoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author hyp
 * @since 2020-12-29
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> selectNoticePage(Integer deptId) {
		return noticeMapper.selectNoticePage(deptId);
	}

	@Override
	public NoticePage<Notice> selectGetAll(NoticePage noticePage) {
		Integer total = noticeMapper.selectGetAllTotal(noticePage);
		if(noticePage.getSize()==0){
			if(noticePage.getTotal()==0){
				noticePage.setTotal(total);
			}

			if(noticePage.getTotal()==0){
				return noticePage;
			}else{
				List<Notice> zhengFuBaoJingTongJiList = noticeMapper.selectGetAll(noticePage);
				noticePage.setRecords(zhengFuBaoJingTongJiList);
				return noticePage;
			}
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%noticePage.getSize()==0){
				pagetotal = total / noticePage.getSize();
			}else {
				pagetotal = total / noticePage.getSize() + 1;
			}
		}
		if (pagetotal >= noticePage.getCurrent()) {
			noticePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (noticePage.getCurrent() > 1) {
				offsetNo = noticePage.getSize() * (noticePage.getCurrent() - 1);
			}
			noticePage.setTotal(total);
			noticePage.setOffsetNo(offsetNo);
			List<Notice> zhengFuBaoJingTongJiList = noticeMapper.selectGetAll(noticePage);
			noticePage.setRecords(zhengFuBaoJingTongJiList);
		}
		return noticePage;
	}

	@Override
	public boolean deleteBind(String updateTime, Integer updateUser, Integer Id) {
		return noticeMapper.deleteBind(updateTime, updateUser, Id);
	}

	@Override
	public Notice selectByIds(Integer Id) {
		return noticeMapper.selectByIds(Id);
	}

	@Override
	public boolean insertSelective(Notice notice) {
		return noticeMapper.insertSelective(notice);
	}

	@Override
	public boolean updateSelective(Notice notice) {
		return noticeMapper.updateSelective(notice);
	}


}
