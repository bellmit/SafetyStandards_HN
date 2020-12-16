package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 呵呵哒
 * @description: TODO
 * @projectName SafetyStandards
 */
@Data
@ApiModel(value = "GpsPlateVehid", description = "GpsPlateVehid")
public class GpsPlateVehid {
	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "cph")
	private String cph;
	/**
	 * 车辆gpsid
	 */
	@ApiModelProperty(value = "vehid")
	private Integer vehid;
}
