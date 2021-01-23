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

	/**
	 *24小时不在线报警
	 */
	@ApiModelProperty(value = "24小时不在线报警")
	private Integer buzaixianbaojing=0;

	/**
	 * 高速禁行报警
	 */
	@ApiModelProperty(value = "高速禁行")
	private Integer gaosujinxing=0;

	/**
	 * 驾驶员异常报警
	 */
	@ApiModelProperty(value = "驾驶员异常报警")
	private Integer jiashiyuanyichangbaojing=0;

	/**
	 * 行人碰撞预警
	 */
	@ApiModelProperty(value = "行人碰撞预警")
	private Integer xingrenpengzhuangyujing=0;
}
