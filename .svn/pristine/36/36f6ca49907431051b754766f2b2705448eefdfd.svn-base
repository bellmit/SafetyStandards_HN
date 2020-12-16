package org.springblade.gps.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/914:52
 */
@Data
@ApiModel(value = "VehicleStopData", description = "VehicleStopData")
public class VehicleStopData {
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	@TableField("Longitude")
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
	@TableField("Latitude")
	private BigDecimal latitude;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private LocalDateTime begintime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private LocalDateTime endtime;
	/**
	 * gps车辆id
	 */
	@ApiModelProperty(value = "gps车辆id")
	private Integer vehid;
	/**
	 * 速度
	 */
	@ApiModelProperty(value = "速度")
	private Integer speed;
	/**
	 * 持续时间
	 */
	@ApiModelProperty(value = "持续时间show")
	private String  timesShow;
	/**
	 * 持续时间
	 */
	@ApiModelProperty(value = "持续时间")
	private String  times;
	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "车辆牌照")
	private String  cph;
	/**
	 * 地理位置
	 */
	@ApiModelProperty(value = "位置")
	private String weihzi;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String platecolor;
	/**
	 * 停车次数
	 */
	@ApiModelProperty(value = "停车次数")
	private Integer stopcount;
	/**
	 * 百度纬度
	 */
	@ApiModelProperty(value = "百度纬度")
	private Double baidulat;
	/**
	 * 百度经度
	 */
	@ApiModelProperty(value = "百度经度")
	private Double baidulon;


}
