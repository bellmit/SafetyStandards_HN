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
package org.springblade.gps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springblade.gps.entity.*;
import org.springblade.gps.page.VehicleStopPage;
import org.springblade.gps.page.VehicleStopSumPage;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * gps点位数据 Mapper 接口
 *
 * @author hyp
 * @since 2019-05-17
 */
public interface GpsPointDataMapper extends BaseMapper<T> {
    /**
     * 获取点位数据
     *
     * @param beginTime
     * @param endTime
     * @param vehId
     * @return
     */
//    @Qualifier("MyDataSourceConfig.DATASOURCE")
    List<VehilePTData> selectPointData(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("vehId") String vehId);
	/**
	 * 查询企业 全部车辆信息
	 */
	List<VehiclePTCompany>  selectcompanyAll(String company);
	/**
	 * 根据车牌号 车牌颜色获取 vehid
	 */
	GpsVehicle  selectOneGpsVehicle(@Param("cph") String cph, @Param("color") String color);
	/**
	 * 获取车辆停车信息
	 */
	List<VehicleStopData>    selectallofVehid(VehicleStopPage vehicleStopPage);
	/**
	 * 获取企业下的所有车辆停车点
	 */
	List<VehicleStopData>    selectallofCompany(VehicleStopSumPage vehicleStopSumPage);
	/**
	 * 分组查询车辆停车信息的车辆
	 */
	List<GpsPlateVehid>   selectPlateVehid(VehicleStopSumPage  vehicleStopSumPage);

	/**
	 * 获取车辆树
 *
	 * @param company
	 * @return
	 */
	List<VehicleNode> getVehiclesByCom(String company);

}
