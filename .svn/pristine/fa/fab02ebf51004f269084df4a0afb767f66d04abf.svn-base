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
package org.springblade.alarm.service;

import org.springblade.alarm.entity.Vehdailyreport;
import org.springblade.alarm.page.VehdailyreportPage;
import org.springblade.alarm.vo.VehdailyreportVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-06-28
 */
public interface IVehdailyreportService extends IService<Vehdailyreport> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param vehdailyreport
	 * @return
	 */
	IPage<VehdailyreportVO> selectVehdailyreportPage(IPage<VehdailyreportVO> page, VehdailyreportVO vehdailyreport);

	/**
	 * 查询 日行里程数 表
	 * @param vehdailyreportPage
	 * @return
	 */
	VehdailyreportPage  selectall(VehdailyreportPage vehdailyreportPage);

}
