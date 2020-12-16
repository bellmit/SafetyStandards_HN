package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/916:52
 */
@Data
@ApiModel(value = "AlarmCountDay", description = "gps主动安全报警当日统计")
public class AlarmCountDay {
	/**
	 * gps超速统计
	 */
	@ApiModelProperty(value = "gps超速统计")
	private Integer gpsChaosuCount=0;
	/**
	 * gps疲劳统计
	 */
	@ApiModelProperty(value = "gps疲劳统计")
	private Integer gpsPilaoCount=0;
	/**
	 * gps夜间统计
	 */
	@ApiModelProperty(value = "gps夜间统计")
	private Integer gpsYejianCount=0;
	/**
	 * gps异常统计
	 */
	@ApiModelProperty(value = "gps异常统计")
	private Integer gpsYichangCount=0;
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
	 *主动未系安全带统计
	 */
	@ApiModelProperty(value = "主动未系安全带统计")
	private Integer zhudongWeijianquandaiCount=0;
	/**
	 *主动分神驾驶统计
	 */
	@ApiModelProperty(value = "主动分神驾驶统计")
	private Integer zhudongFenshenjiashiCount=0;
	/**
	 *主动驾驶员疲劳统计
	 */
	@ApiModelProperty(value = "主动驾驶员疲劳统计")
	private Integer zhudongJiashiyuanpilaoCount=0;
	/**
	 *主动车距过近统计
	 */
	@ApiModelProperty(value = "主动车距过近统计")
	private Integer zhudongChejuguojinCount=0;
	/**
	 *主动车道偏离统计
	 */
	@ApiModelProperty(value = "主动车道偏离统计")
	private Integer zhudongChedaopianliCount=0;
	/**
	 *主动防碰撞统计
	 */
	@ApiModelProperty(value = "主动防碰撞统计")
	private Integer zhudongFangpenzhuangCount=0;
}
