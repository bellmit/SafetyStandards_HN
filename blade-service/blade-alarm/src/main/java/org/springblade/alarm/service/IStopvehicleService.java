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

import org.springblade.alarm.entity.Stopvehicle;
import org.springblade.alarm.vo.StopvehicleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.gps.entity.VehicleStop;

import java.util.List;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-12-04
 */
public interface IStopvehicleService extends IService<Stopvehicle> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param stopvehicle
	 * @return
	 */
	IPage<StopvehicleVO> selectStopvehiclePage(IPage<StopvehicleVO> page, StopvehicleVO stopvehicle);
	/**
	 * 批量插入
	 */
	int insertStopvehicle(List<VehicleStop> list);
	/**
	 * 查询哈密下面所有企业
	 */
	List<String> deptAll();

}
