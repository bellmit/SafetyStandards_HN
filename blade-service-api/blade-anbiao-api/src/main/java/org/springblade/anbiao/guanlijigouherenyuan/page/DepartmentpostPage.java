package org.springblade.anbiao.guanlijigouherenyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @author: 呵呵哒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DepartmentpostPage对象", description = "DepartmentpostPage对象")
public class DepartmentpostPage <T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
}
