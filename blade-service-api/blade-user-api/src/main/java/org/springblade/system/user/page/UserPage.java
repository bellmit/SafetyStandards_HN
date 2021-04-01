package org.springblade.system.user.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 人员 分页实体类
 * Program: SafetyStandards
 * @description: UserPage
 * @author: hyp
 * @create: 2020-10-28 11:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserPage对象", description = "UserPage对象")
public class UserPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "账号")
	private String account;
	@ApiModelProperty(value = "姓名")
	private String realName;
	@ApiModelProperty(value = "账号状态")
	private String zhuangtai;
}
