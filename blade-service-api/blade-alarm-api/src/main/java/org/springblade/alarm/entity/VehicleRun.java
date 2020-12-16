package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/517:51
 */
@Data
@ApiModel(value = "VehicleRun", description = "VehicleRun")
public class VehicleRun {
	/**
	 * 车牌
	 */
	@ApiModelProperty(value = "车牌")
	private String plate;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String color;
	/**
	 * 运行时长
	 */
	@ApiModelProperty(value = "运行时长")
	private Integer runSeconds;
	/**
	 * 运行时长show
	 */
	@ApiModelProperty(value = "运行时长show")
	private String  xingshishijian;
	/**
	 * 停车时长
	 */
	@ApiModelProperty(value = "停车时长")
	private String stopshijian;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private String begintime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private String  endtime;
	/**
	 * 总里程
	 */
	@ApiModelProperty(value = "总里程")
	private BigDecimal licheng;
	/**
	 * 平均速度
	 */
	@ApiModelProperty(value = "平均速度")
	private Integer pingjunsudu;



}
