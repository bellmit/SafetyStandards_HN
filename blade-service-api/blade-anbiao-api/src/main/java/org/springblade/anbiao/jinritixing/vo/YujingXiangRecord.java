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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@ApiModel(value = "YujingXiangRecord对象", description = "YujingXiangRecord对象")
public class YujingXiangRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "预警项id")
	private String yujingxiangid;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业id")
	private String dept_id;
}
