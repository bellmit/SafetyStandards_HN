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
package org.springblade.anbiao.cankaofangan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.cankaofangan.entity.Cankaofangan;
import org.springblade.anbiao.cankaofangan.vo.CankaofanganVO;

import java.util.List;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-06-14
 */
public interface ICankaofanganService extends IService<Cankaofangan> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param cankaofangan
	 * @return
	 */
	IPage<CankaofanganVO> selectCankaofanganPage(IPage<CankaofanganVO> page, CankaofanganVO cankaofangan);

	/**
	 *根据任务类型获取参考方案
	 * @author: th
	 * @date: 2019/6/14 16:49
	 * @param renwuleixing
	 * @return: org.springblade.anbiao.cankaofangan.entity.Cankaofangan
	 */
	List<Cankaofangan> getByRenwuleixing(String renwuleixing);
}
