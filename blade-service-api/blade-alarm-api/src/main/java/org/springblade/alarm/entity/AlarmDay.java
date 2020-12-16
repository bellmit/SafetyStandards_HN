package org.springblade.alarm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/919:16
 */
@Data
@ApiModel(value = "AlarmDay", description = "AlarmDay 今日报警")
public class AlarmDay {
	/**
	 * gps 报警id
	 */
	@ApiModelProperty(value = "gps报警id")
	private String AlarmReportID;
	/**
	 * 车辆id
	 */
	private Integer VehId;
	/**
	 * gps开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private String BeginTime;
	/**
	 * 结束时间
	 */
	private String EndTime;

	/**
	 * 报警类型
	 */
	@ApiModelProperty(value = "报警类型")
	private String AlarmType;

	/**
	 * gps车牌
	 */
	@ApiModelProperty(value = "车牌")
	private String plateNumber;
	/**
	 * 主动防御车牌
	 */
	@ApiModelProperty(value = "主动防御车牌")
	private String plate;

	/**
	 * 主动安全报警时间
	 */
	@ApiModelProperty(value = "主动安全报警时间")
	private String GpsTime;
	/**
	 * 处理状态
	 */
	private String chulizhuangtai;
	/**
	 * 车牌颜色
	 */
	private String color;
	/**
	 * 形式速度
	 */
	private Integer Velocity;
	/**
	 * 超速等级
	 */
	private Integer status;
	/**
	 * 超速比
	 */
	private String ChaoSuBiShow;
	/**
	 * 限速值
	 */
	private Integer Limited;
	@ApiModelProperty(value = "道路名称")
	@TableField("Road_Name")
	private String roadName;
}
