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

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/31
 * @描述
 */
@Data
@ApiModel(value = "QiYeYunWeiShouYe对象", description = "QiYeYunWeiShouYe对象")
public class QiYeYunWeiShouYe implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "本周注册车辆数")
	private Integer vehicleNum;

	@ApiModelProperty(value = "本周注册企业数")
	private Integer qiyeNum;

	@ApiModelProperty(value = "本周注册驾驶员数")
	private Integer jiashiyuanNum;

	@ApiModelProperty(value = "总注册车辆数")
	private Integer vehicleZNum;

	@ApiModelProperty(value = "总注册企业数")
	private Integer qiyeZNum;

	@ApiModelProperty(value = "总注册驾驶员数")
	private Integer jiashiyuanZNum;

	@ApiModelProperty(value = "已生成安全标准化目录企业数")
	private Integer biaozhunhuaNum;

	@ApiModelProperty(value = "未绑定地区企业数")
	private Integer weibangdingAreaNum;

	@ApiModelProperty(value = "安全达标提醒分数")
	private Integer totalpoints;

	@ApiModelProperty(value = "安全达标总分")
	private Integer totalscore=1000;

	@ApiModelProperty(value = "安全达标提醒状态")
	private String totalpointsremark;

	@ApiModelProperty(value = "安全达标提醒更新时间")
	private String totalpointstime;

	@ApiModelProperty(value = "安标企业数")
	private Integer anbiaoqiyeshu=0;

	@ApiModelProperty(value = "注册企业数")
	private Integer qiyeshu;

	@ApiModelProperty(value = "安全达标超过同平台百分比")
	private String totalpointsrate;

}
