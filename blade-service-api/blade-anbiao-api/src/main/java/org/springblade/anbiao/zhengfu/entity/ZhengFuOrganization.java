/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @描述
 */
@Data
@ApiModel(value = "ZhengFuOrganization对象", description = "ZhengFuOrganization对象")
public class ZhengFuOrganization implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业ID")
	private String qiyeid;

	@ApiModelProperty(value = "企业名称")
	private String qiyemingcheng;

	@ApiModelProperty(value = "机构类型")
	private String jigouleixing;

	@ApiModelProperty(value = "所属省")
	private String province;

	@ApiModelProperty(value = "所属市")
	private String city;

	@ApiModelProperty(value = "所属县")
	private String country;

	@ApiModelProperty(value = "所属地区")
	private String areaName;

	@ApiModelProperty(value = "运管名称")
	private String yunguanmingcheng;

	@ApiModelProperty(value = "运管ID")
	private String yunguanid;

	@ApiModelProperty(value = "政府企业ID")
	private String deptId;

}
