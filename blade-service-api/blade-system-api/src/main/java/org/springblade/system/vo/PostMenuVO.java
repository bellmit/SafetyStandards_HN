/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springblade.system.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.system.entity.PostMenu;

/**
 * 视图实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PostMenuVO对象", description = "PostMenuVO对象")
public class PostMenuVO extends PostMenu {
	private static final long serialVersionUID = 1L;

}
