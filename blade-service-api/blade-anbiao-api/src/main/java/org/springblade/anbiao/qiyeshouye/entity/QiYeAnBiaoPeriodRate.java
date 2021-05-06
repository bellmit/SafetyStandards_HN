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
@ApiModel(value = "QiYeAnBiaoPeriodRate对象", description = "QiYeAnBiaoPeriodRate对象")
public class QiYeAnBiaoPeriodRate implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "共计大项数")
	private Integer maxxiangshu;

	@ApiModelProperty(value = "共计小项数")
	private Integer minxiangshu;

	@ApiModelProperty(value = "达标大项数")
	private Integer maxdabiaoxiangshu;

	@ApiModelProperty(value = "达标小项数")
	private Integer mindabiaoxiangshu;

	@ApiModelProperty(value = "达标率")
	private String dabiaolv;

}
