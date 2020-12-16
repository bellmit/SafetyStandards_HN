/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 */
package org.springblade.anbiao.jinritixing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import org.springblade.anbiao.jinritixing.entity.Yujingquanxian;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "YujingquanxianVO对象", description = "YujingquanxianVO对象")
public class YujingquanxianVO extends Yujingquanxian {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "预警项")
	private String yujingxiang;

	@ApiModelProperty(value = "单位名称")
	private String deptName;
	@ApiModelProperty(value = "预警项名称")
	private String title;
}
