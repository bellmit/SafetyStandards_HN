package org.springblade.anbiao.guanlijigouherenyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/4/29.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PersonnelPage对象", description = "PersonnelPage对象")
public class PersonnelPage <T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;

	/**
	 * 人员id
	 */
	@ApiModelProperty(value = "人员id",required = true)
	private Integer userId;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String xingming;
	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private Integer postId;
	/**
	 * 单位id
	 */
	@ApiModelProperty(value = "单位id")
	private Integer deptId;
}
