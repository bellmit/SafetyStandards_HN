/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.yunwei.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/21
 * @描述
 */
@Data
@ApiModel(value = "YunWeiShouYe对象", description = "YunWeiShouYe对象")
public class YunWeiShouYe implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "本周注册车辆数")
	private Integer vehicleNum;

	@ApiModelProperty(value = "本周注册企业数")
	private Integer qiyeNum;

	@ApiModelProperty(value = "本周注册驾驶员数")
	private Integer jiashiyuanNum;

	@ApiModelProperty(value = "车辆总注册数")
	private Integer vehicleZNum;

	@ApiModelProperty(value = "企业总注册数")
	private String qiyeZNum;

	@ApiModelProperty(value = "驾驶员总注册数")
	private Integer jiashiyuanZNum;

	@ApiModelProperty(value = "已生成标准化企业数")
	private Integer biaozhunhuaNum;

	@ApiModelProperty(value = "未绑定地区企业数")
	private Integer weibangdingAreaNum;

}
