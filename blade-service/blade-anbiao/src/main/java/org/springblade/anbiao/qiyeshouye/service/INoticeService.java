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
package org.springblade.anbiao.qiyeshouye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.qiyeshouye.entity.Notice;
import org.springblade.anbiao.qiyeshouye.entity.QiYeShouYe;
import org.springblade.anbiao.qiyeshouye.page.NoticePage;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 服务类
 *
 * @author hyp
 * @since 2018-09-29
 */
public interface INoticeService extends IService<Notice> {

	/**
	 * 获取当天通知公告
	 * @return
	 */
	List<Notice> selectNoticePage(Integer deptId);

	/**
	 * 获取所有通知公告
	 * @param noticePage
	 * @return
	 */
	NoticePage<Notice> selectGetAll(NoticePage noticePage);

	/**
	 *
	 * @param updateTime
	 * @param updateUser
	 * @param Id
	 * @return
	 */
	boolean deleteBind(@RequestParam("updateTime") String updateTime,
					   @RequestParam("updateUser") Integer updateUser,
					   @RequestParam("Id") Integer Id);

	/**
	 * 根据ID查询通知公告详情
	 * @param Id
	 * @return
	 */
	Notice selectByIds(Integer Id);

	/**
	 * 新增通知公告
	 * @param notice
	 * @return
	 */
	boolean insertSelective(Notice notice);

	/**
	 * 根据ID修改通知公告相应信息
	 * @param notice
	 * @return
	 */
	boolean updateSelective(Notice notice);

}
