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
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/31
 * @描述
 */
@Data
@EqualsAndHashCode()
@ApiModel(value = "QiYeAnBiaoSafetyTips对象", description = "QiYeAnBiaoSafetyTips对象")
public class QiYeAnBiaoSafetyTips implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业ID")
	private Integer deptId;

	@ApiModelProperty(value = "项名称")
	private String name;

	@ApiModelProperty(value = "项ID")
	private Integer ids;

	@ApiModelProperty(value = "共计达标小项数")
	private Integer minxingnum;

	@ApiModelProperty(value = "未达标小项数")
	private Integer notdabiaonum;

	@ApiModelProperty(value = "未达标tier")
	private String tier;

}
