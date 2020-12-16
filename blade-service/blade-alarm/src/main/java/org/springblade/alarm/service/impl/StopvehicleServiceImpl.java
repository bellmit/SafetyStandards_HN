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
package org.springblade.alarm.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.alarm.entity.Stopvehicle;
import org.springblade.alarm.vo.StopvehicleVO;
import org.springblade.alarm.mapper.StopvehicleMapper;
import org.springblade.alarm.service.IStopvehicleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.gps.entity.VehicleStop;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-12-04
 */
@Service
@AllArgsConstructor
public class StopvehicleServiceImpl extends ServiceImpl<StopvehicleMapper, Stopvehicle> implements IStopvehicleService {
	private  StopvehicleMapper stopvehicleMapper;

	@Override
	public IPage<StopvehicleVO> selectStopvehiclePage(IPage<StopvehicleVO> page, StopvehicleVO stopvehicle) {
		return page.setRecords(baseMapper.selectStopvehiclePage(page, stopvehicle));
	}

	@Override
	public int insertStopvehicle(List<VehicleStop> list) {
		return stopvehicleMapper.insertStopvehicle(list);
	}

	@Override
	public List<String> deptAll() {
		return stopvehicleMapper.deptAll();
	}

}
