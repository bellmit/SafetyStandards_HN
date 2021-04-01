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
package org.springblade.desk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.desk.entity.Notice;
import org.springblade.desk.page.NoticePage;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author hyp
 * @since 2018-09-29
 */
public interface NoticeMapper extends BaseMapper<Notice> {

	/**
	 * 前N条数据
	 * @param number
	 * @return
	 */
	List<Notice> topList(Integer number);

	/**
	 * 获取当天通知公告
	 * @return
	 */
	List<Notice> selectNoticePage();

	/**
	 * 获取所有通知公告
	 * @param noticePage
	 * @return
	 */
	List<Notice> selectGetAll(NoticePage noticePage);
	int selectGetAllTotal(NoticePage noticePage);

}
