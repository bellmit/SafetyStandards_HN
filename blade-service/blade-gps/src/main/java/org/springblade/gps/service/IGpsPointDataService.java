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
package org.springblade.gps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.poi.ss.formula.functions.T;
import org.springblade.gps.entity.GpsVehicle;
import org.springblade.gps.entity.VehicleNode;
import org.springblade.gps.entity.VehiclePTCompany;
import org.springblade.gps.entity.VehilePTData;
import org.springblade.gps.page.VehicleStopPage;
import org.springblade.gps.page.VehicleStopSumPage;

import java.util.List;

/**
 * gps点位数据 服务类
 *
 * @author hyp
 * @since 2019-05-17
 */
public interface IGpsPointDataService extends IService<T> {

    /**
     * 获取点位数据
     *
     * @param beginTime
     * @param endTime
     * @param vehId
     * @return
     */
    List<VehilePTData> selectPointData(String beginTime, String endTime, String vehId);
	/**
	 * 查询企业 全部车辆信息
	 */
	List<VehiclePTCompany>  selectcompanyAll(String company);
	/**
	 * 根据车牌号 车牌颜色获取 vehid
	 */
	GpsVehicle selectOneGpsVehicle(String cph, String color);
	/**
	 * 获取车辆停车信息
	 */
	VehicleStopPage    selectallofVehid(VehicleStopPage vehicleStopPage);
	/**
	 * 获取车辆一天停车情况
	 */
	 VehicleStopSumPage selectallofCompany(VehicleStopSumPage vehicleStopSumPage);

	/**
	 * 获取车辆树
	 *
	 * @param company
	 * @return
	 */
	List<VehicleNode> tree(String company);

}
