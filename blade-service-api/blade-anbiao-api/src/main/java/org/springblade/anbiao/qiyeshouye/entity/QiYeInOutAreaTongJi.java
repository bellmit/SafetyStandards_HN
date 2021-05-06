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
@ApiModel(value = "QiYeInOutAreaTongJi对象", description = "QiYeInOutAreaTongJi对象")
public class QiYeInOutAreaTongJi implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "车牌号")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	@ApiModelProperty(value = "营运类型")
	private String operatType;

	@ApiModelProperty(value = "区域名称")
	private String areaName;

	@ApiModelProperty(value = "区域类型")
	private String areaType;

	@ApiModelProperty(value = "停留时间")
	private String keeptimeShow;

	@ApiModelProperty(value = "进区域时间")
	private String inTime;

	@ApiModelProperty(value = "出区域时间")
	private String outTime;

	@ApiModelProperty(value = "进出次数")
	private String inOutTimes;

	@ApiModelProperty(value = "进出区域状态（1：进、2出）")
	private String IsAcross;

}
