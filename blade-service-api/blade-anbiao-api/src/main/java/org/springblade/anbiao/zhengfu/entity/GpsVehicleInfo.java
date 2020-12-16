/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 */
@Data
@ApiModel(value = "GpsVehicleInfo对象", description = "GpsVehicleInfo对象")
public class GpsVehicleInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@ApiModelProperty(value = "序号")
	private Integer No;

	/**
	 * 车辆ID
	 */
	@ApiModelProperty(value = "车辆ID")
	private String vehicleID;

	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "车辆牌照")
	private String vehicleNo;

	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String vehicleColor;

	/**
	 * 终端号
	 */
	@ApiModelProperty(value = "终端号")
	private String DeviceID;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private String DeptID;

	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String DeptName;

	/**
	 * 车辆使用状态
	 */
	@ApiModelProperty(value = "车辆使用状态")
	private String VehState;

	/**
	 * 车辆性质
	 */
	@ApiModelProperty(value = "车辆性质")
	private String shiyongxingzhi;

	/**
	 * 报警状态
	 */
	@ApiModelProperty(value = "报警状态")
	private String alarmtype;

	/**
	 * 在线状态
	 */
	@ApiModelProperty(value = "在线状态（1:全部;2:上线;3:未上线;）")
	private Integer zaixian;

	/**
	 * 车辆状态
	 */
	@ApiModelProperty(value = "车辆状态（1:全部;2:监控车辆;3:停用;4:在用；）")
	private Integer zhuangtai;


}
