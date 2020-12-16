package org.springblade.alarm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/621:26
 */
@Data
@ApiModel(value = "AlarmMonthQingkuang", description = "AlarmMonthQingkuang")
public class AlarmMonthQingkuang {
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
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	private String date;
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
	 * 在线比率
	 */
	@ApiModelProperty(value = "在线比率")
	private Integer onlineRate;
	/**
	 * 查找统计
	 */
	@ApiModelProperty(value = "查找统计")
	private Integer locateCount;
	/**
	 * 查找比率
	 */
	@ApiModelProperty(value = "查找比率")
	private Integer locateRate;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createtime;
}
