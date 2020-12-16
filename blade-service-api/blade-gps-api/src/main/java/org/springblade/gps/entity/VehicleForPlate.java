package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/814:18
 */
@Data
@ApiModel(value = "VehicleForPlate", description = "VehicleForPlate")
public class VehicleForPlate {
	/**
	 * 车辆牌照
	 */
	private String cph;
	/**
	 * 车牌颜色
	 */
	private String platecolor;
}
