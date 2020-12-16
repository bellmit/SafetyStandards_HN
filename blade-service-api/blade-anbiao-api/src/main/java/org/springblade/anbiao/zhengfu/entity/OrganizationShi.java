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
 * @描述
 */
@Data
@ApiModel(value = "Organization对象", description = "Organization对象")
public class OrganizationShi implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private String Id;

	/**
	 * 上级ID
	 */
	@ApiModelProperty(value = "上级ID")
	private String parentId;

	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String deptName;

	/**
	 * 企业tree_code
	 */
	@ApiModelProperty(value = "企业tree_code")
	private String treeCode;

	/**
	 * 省
	 */
	@ApiModelProperty(value = "省")
	private String province;

	/**
	 * 市
	 */
	@ApiModelProperty(value = "市")
	private String city;

	/**
	 * 县
	 */
	@ApiModelProperty(value = "县")
	private String country;

}
