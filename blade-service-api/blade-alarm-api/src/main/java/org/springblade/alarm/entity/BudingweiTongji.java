package org.springblade.alarm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/1812:27
 */
@Data
@ApiModel(value = "BudingweiTongji", description = "BudingweiTongji")
public class BudingweiTongji {
	/**
	 * 车牌
	 */
	@ApiModelProperty(value = "车牌")
	private String plateNumber;
	/**
	 * 报警类型
	 */
	@ApiModelProperty(value = "报警类型")
	private String alarmType;
	/**
	 * 车辆类型
	 */
	@ApiModelProperty(value = "车辆类型")
	private String operatType;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private  String  color;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String company;
	/**
	 * 最后数据时间
	 */
	@ApiModelProperty(value = "最后回传时间")
	@TableField("lastTime")
	private LocalDateTime lastTime;
	/**
	 * 系统时间
	 */
	@ApiModelProperty(value = "最后数据时间")
	private LocalDateTime systime;
	/**
	 * 最后定位时间
	 */
	@ApiModelProperty(value = "最后定位时间")
	@TableField("lastlocateTime")
	private LocalDateTime lastlocateTime;
	/**
	 * 不定位时间
	 */
	@ApiModelProperty(value = "不定位时间")
	private String offlineTime;
	/**
	 * 创建日期
	 */
	@ApiModelProperty(value = "创建日期")
	@TableField("createDate")
	private LocalDate createDate;

}
