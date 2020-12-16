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
package org.springblade.anbiao.ranyoubutie.service;

import org.springblade.anbiao.ranyoubutie.entity.Fueltotalreport;
import org.springblade.anbiao.ranyoubutie.page.FueltotalreportPage;
import org.springblade.anbiao.ranyoubutie.vo.FueltotalreportVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务类
 *
 * @author jx
 * @since 2019-10-16
 */
public interface IFueltotalreportService extends IService<Fueltotalreport> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param fueltotalreport
	 * @return
	 */
	IPage<FueltotalreportVO> selectFueltotalreportPage(IPage<FueltotalreportVO> page, FueltotalreportVO fueltotalreport);


	FueltotalreportPage<FueltotalreportVO> selectAllList(FueltotalreportPage page);

}
