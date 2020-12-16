package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/717:22
 */
@Data
@ApiModel(value = "VehilePTData", description = "VehilePTData 时间段点位信息")
public class VehilePTData {
	/**
	 * 速度
	 */
	@ApiModelProperty(value = "速度")
	private Integer Speed;
	/**
	 * 维度
	 */
	@ApiModelProperty(value = "纬度")
	private Double longitude;
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	private Double latitude;
	/**
	 *gps里程表
	 */
	@ApiModelProperty(value = "gps里程表")
	private Integer gpsmileage;
	/**
	 * gps时间
	 */
	@ApiModelProperty(value = "gps时间")
	private LocalDateTime GpsTime;
	/**
	 * 车辆id
	 */
	@ApiModelProperty(value = "车辆id")
	private String VehId;
	/**
	 * 车牌
	 */
	@ApiModelProperty(value = "车牌")
	private String plate;
}
