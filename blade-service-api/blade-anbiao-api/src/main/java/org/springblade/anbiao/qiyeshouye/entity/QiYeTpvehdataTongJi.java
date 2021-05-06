/**
 * Copyright (C), 2015-2020,
 * FileName: 北斗Vehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/31
 * @描述
 */
@Data
@ApiModel(value = "QiYeTpvehdataTongJi对象", description = "QiYeTpvehdataTongJi对象")
public class QiYeTpvehdataTongJi implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "车辆ID")
	private String Vehid;

	@ApiModelProperty(value = "企业ID")
	private String DeptID;

	@ApiModelProperty(value = "企业名称")
	private String DeptName;

	@ApiModelProperty(value = "车辆状态（0：在用；1：停用；2：）")
	private Integer Cheliangzhuangtai;

	@ApiModelProperty(value = "车牌号")
	private String VeNumber;

	@ApiModelProperty(value = "车牌颜色")
	private String VeColor;

	@ApiModelProperty(value = "使用性质")
	private String Shiyongxingzhi;

	@ApiModelProperty(value = "终端ID")
	private String DeviceID;

	@ApiModelProperty(value = "经度")
	private BigDecimal Longitude;

	@ApiModelProperty(value = "纬度")
	private BigDecimal Latitude;

	@ApiModelProperty(value = "速度")
	private Integer Velocity;

	@ApiModelProperty(value = "方向")
	private Integer Angle;

	@ApiModelProperty(value = "定位标识（1：定位）")
	private String Locate;

	@ApiModelProperty(value = "定位时间")
	private String LastLocateTime;

	@ApiModelProperty(value = "数据更新时间")
	private String Systime;

	@ApiModelProperty(value = "数据入库时间")
	private String Time;

	@ApiModelProperty(value = "报警标识（1：报警）")
	private String Alarm;

	@ApiModelProperty(value = "报警类型")
	private String AlarmNote;

	@ApiModelProperty(value = "定位地点")
	private String LocalName;


}
