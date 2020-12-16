/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 */
package org.springblade.anbiao.guanlijigouherenyuan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DepartmentpostVO对象", description = "DepartmentpostVO对象")
public class DepartmentpostVO extends Departmentpost {
	private static final long serialVersionUID = 1L;

	/**
	 * 机构名
	 */
	@ApiModelProperty(value = "机构名")
	private String deptName;

}
