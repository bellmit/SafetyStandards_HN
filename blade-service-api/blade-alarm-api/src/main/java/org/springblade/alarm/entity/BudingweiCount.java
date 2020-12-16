package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/1811:57
 */
@Data
@ApiModel(value = "BudingweiCount", description = "BudingweiCount")
public class BudingweiCount {
	/**
	 * 报警次数
	 */
	@ApiModelProperty(value = "报警次数")
	private Integer  number;
	/**
	 * 报警车牌
	 */
	@ApiModelProperty(value = "报警车牌")
	private String plateNumber;
}
