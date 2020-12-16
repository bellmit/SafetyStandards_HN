package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/314:35
 */
@Data
@ApiModel(value = "VehicleStop", description = "VehicleStop车辆停车信息")
public class VehicleStop {
	/**
	 * id
	 */
	@ApiModelProperty(value = "id")
	private String id;
	/**
	 * gps车辆id
	 */
	@ApiModelProperty(value = "gps车辆id")
	private String vehid;
	/**
	 * 车辆号
	 */
	@ApiModelProperty(value = "车辆号")
	private String plate;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String color;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String company;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private LocalDateTime begintime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private LocalDateTime endtime;
	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
	private Double lat;
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	private Double lon;
	/**
	 * 位置
	 */
	@ApiModelProperty(value = "位置")
	private String location;
	/**
	 * 插入时间
	 */
	@ApiModelProperty(value = "插入时间")
	private LocalDateTime Inserttime;
	/**
	 * 持续时间
	 */
	@ApiModelProperty(value = "插入时间")
	private Integer times;
}
