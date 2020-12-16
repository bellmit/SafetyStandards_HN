package org.springblade.alarm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 呵呵哒
 * @description: TODO
 * @projectName SafetyStandards
 */
@Data
@ApiModel(value = "AlarmMonthQushi", description = "AlarmMonthQushi")
public class AlarmMonthQushi {
	/**
	 * 日期
	 */
	@ApiModelProperty(value = "日期")
	private Integer day;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String company;
	/**
	 *车辆统计
	 */
	@ApiModelProperty(value = "车辆统计")
	private Integer vehicleCount;
	/**
	 * 运行车辆
	 */
	@ApiModelProperty(value = "运行车辆")
	private Integer onlineCount;
	/**
	 * 停置车辆
	 */
	@ApiModelProperty(value = "停置车辆")
	private Integer stopCount;
	/**
	 * 离线车辆
	 */
	@ApiModelProperty(value = "离线车辆")
	private Integer offlineCount;
	/**
	 * 报警车辆数
	 */
	@ApiModelProperty(value = "报警车辆数")
	private Integer vehiclealarmCount;

}

