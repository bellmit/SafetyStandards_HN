package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/1317:37
 */
@Data
@ApiModel(value = "严重报警 车辆统计", description = "严重报警 车辆统计")
public class AlarmdangerousCount {
	/**
	 * 报警次数
	 */
	@ApiModelProperty(value = "报警次数")
	private Integer number;
	/**
	 * 车牌
	 */
	@ApiModelProperty(value = "车牌")
	private String plateNumber;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String color;
}
