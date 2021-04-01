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
package org.springblade.desk.service.impl;

import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.desk.entity.Notice;
import org.springblade.desk.mapper.NoticeMapper;
import org.springblade.desk.page.NoticePage;
import org.springblade.desk.service.INoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author hyp
 * @since 2020-12-29
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<NoticeMapper, Notice> implements INoticeService {

	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> selectNoticePage() {
		return noticeMapper.selectNoticePage();
	}

	@Override
	public NoticePage<Notice> selectGetAll(NoticePage noticePage) {
		Integer total = noticeMapper.selectGetAllTotal(noticePage);
		if(noticePage.getSize()==0){
			if(noticePage.getTotal()==0){
				noticePage.setTotal(total);
			}

			List<Notice> zhengFuBaoJingTongJiList = noticeMapper.selectGetAll(noticePage);
			noticePage.setRecords(zhengFuBaoJingTongJiList);
			return noticePage;
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

}
