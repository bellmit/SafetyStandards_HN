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
import org.springblade.alarm.entity.*;
import org.springblade.alarm.mapper.DataCenterMapper;
import org.springblade.alarm.page.VehicleRunDetailsPage;
import org.springblade.alarm.page.VehicleRunPage;
import org.springblade.alarm.service.IDataCenterService;
import org.springblade.alarm.vo.AlarmMonthQingkuang;
import org.springblade.alarm.vo.AlarmMonthQushi;
import org.springblade.alarm.vo.AlarmZhudongCount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据中心
 *
 * @author elvis.he
 * @since 2019-05-12
 */
@Service
@AllArgsConstructor
public class DataCenterServiceImpl  implements IDataCenterService {

    private DataCenterMapper dataCenterMapper;


	@Override
	public List<AlarmMonthQingkuang> alarmMothqingkaung(String company) {

		return dataCenterMapper.alarmMothqingkaung(company);
	}

	@Override
	public List<AlarmMonthQushi> alarmMonthQushi(String company) {
		return dataCenterMapper.alarmMonthQushi(company);
	}

	@Override
	public Map<String,Object> alarmZhudongCount(String company) {
		List<AlarmZhudongCount> month = dataCenterMapper.alarmZhudongCount(company);
		List<AlarmZhudongCount> lastmonth = dataCenterMapper.alarmZhudongCountLastmonth(company);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lastmonth",lastmonth);
		map.put("month",month);


		return map;
	}

	@Override
	public List<Map<String, Object>> monthZhudong(String company) {
		return dataCenterMapper.monthZhudong(company);
	}

	@Override
	public List<Map<String, Object>> monthAlarm(String company) {
		return dataCenterMapper.monthAlarm(company);
	}

    @Override
    public List<Map<String, Object>> alarmChuliCount(String company) {
        return dataCenterMapper.alarmChuliCount(company);
    }

	@Override
	public VehicleRunPage selectrunvehicle(VehicleRunPage vehicleRunPage) {
		Integer total = dataCenterMapper.selectrunvehicletotal(vehicleRunPage);
		if (vehicleRunPage.getSize() == 0) {
			if (vehicleRunPage.getTotal() == 0) {
				vehicleRunPage.setTotal(total);
			}
			List<VehicleRun> selectrunvehiclepage = dataCenterMapper.selectrunvehiclepage(vehicleRunPage);

			vehicleRunPage.setRecords(selectrunvehiclepage);
			return vehicleRunPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / vehicleRunPage.getSize() + 1;
		}
		if (pagetotal >= vehicleRunPage.getCurrent() && pagetotal > 0) {
			vehicleRunPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehicleRunPage.getCurrent() > 1) {
				offsetNo = vehicleRunPage.getSize() * (vehicleRunPage.getCurrent() - 1);
			}

			vehicleRunPage.setTotal(total);
			vehicleRunPage.setOffsetNo(offsetNo);

			List<VehicleRun> selectrunvehiclepage = dataCenterMapper.selectrunvehiclepage(vehicleRunPage);

			vehicleRunPage.setRecords(selectrunvehiclepage);



		}
		return vehicleRunPage;



	}

	@Override
	public VehicleRunDetailsPage selecterunvehicleDetails(VehicleRunDetailsPage vehicleRunDetailsPage) {
		Integer total = dataCenterMapper.selectrunvehicleDetailstotal(vehicleRunDetailsPage);
		if (vehicleRunDetailsPage.getSize() == 0) {
			if (vehicleRunDetailsPage.getTotal() == 0) {
				vehicleRunDetailsPage.setTotal(total);
			}
			List<VehicleRundetails> vehicleRundetails = dataCenterMapper.selectrunvehicleDetailsPage(vehicleRunDetailsPage);

			vehicleRunDetailsPage.setRecords(vehicleRundetails);
			return vehicleRunDetailsPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / vehicleRunDetailsPage.getSize() + 1;
		}
		if (pagetotal >= vehicleRunDetailsPage.getCurrent() && pagetotal > 0) {
			vehicleRunDetailsPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehicleRunDetailsPage.getCurrent() > 1) {
				offsetNo = vehicleRunDetailsPage.getSize() * (vehicleRunDetailsPage.getCurrent() - 1);
			}

			vehicleRunDetailsPage.setTotal(total);
			vehicleRunDetailsPage.setOffsetNo(offsetNo);

			List<VehicleRundetails> vehicleRundetails = dataCenterMapper.selectrunvehicleDetailsPage(vehicleRunDetailsPage);

			vehicleRunDetailsPage.setRecords(vehicleRundetails);



		}
		return vehicleRunDetailsPage;





	}
}
