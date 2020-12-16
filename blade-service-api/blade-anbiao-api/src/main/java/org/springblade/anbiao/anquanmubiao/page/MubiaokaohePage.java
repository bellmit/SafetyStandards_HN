package org.springblade.anbiao.anquanmubiao.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/4/28.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MubiaokaohePage对象", description = "MubiaokaohePage对象")
public class MubiaokaohePage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;
	/**
	 * 安全工作方针与目标id
	 */
	@ApiModelProperty(value = "安全工作方针与目标id",required = true)
	private String aid;
}
