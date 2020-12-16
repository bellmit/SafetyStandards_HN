/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * limitations under the License.
 */
package org.springblade.anbiao.cheliangguanli.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import org.springblade.anbiao.cheliangguanli.entity.Guacheziliao;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GuacheziliaoVO对象", description = "GuacheziliaoVO对象")
public class GuacheziliaoVO extends Guacheziliao {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

}
