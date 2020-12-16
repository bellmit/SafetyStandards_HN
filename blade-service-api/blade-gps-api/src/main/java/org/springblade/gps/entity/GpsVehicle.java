package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 呵呵哒
 * @projectName SafetyStandards
 */
@Data
@ApiModel(value = "GpsVehicle", description = "GpsVehicle")
public class GpsVehicle {
	/**
	 * gps车辆id
	 */
	@ApiModelProperty(value = "gps车辆id")
	private Integer vehid;
	/**
	 * gps车辆牌照
	 */
	@ApiModelProperty(value = "gps车辆牌照")
	private String  cph;
	/**
	 * gps车辆颜色
	 */
	@ApiModelProperty(value = "gps车辆颜色")
	private String platecolor;
}
