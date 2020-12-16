package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/1414:59
 */
@Data
@ApiModel(value = "AlarmDangerZhudongCount", description = "AlarmDangerZhudongCount 主动防御严重报警统计")
public class AlarmDangerZhudongCount {
	/**
	 *主动接打电话统计
	 */
	@ApiModelProperty(value = "主动接打电话统计")
	private Integer zhudongJiedadianhuaCount=0;
	/**
	 *主动抽烟驾驶统计
	 */
	@ApiModelProperty(value = "主动抽烟驾驶统计")
	private Integer zhudongChouyanjiashiCount=0;
	/**
	 *主动驾驶员疲劳统计
	 */
	@ApiModelProperty(value = "主动驾驶员疲劳统计")
	private Integer zhudongJiashiyuanpilaoCount=0;
	/**
	 *主动分神驾驶统计
	 */
	@ApiModelProperty(value = "主动分神驾驶统计")
	private Integer zhudongFenshenjiashiCount=0;
}
