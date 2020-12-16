package org.springblade.anbiao.falvfagui.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @description: 法规分页对象
 * @author: 呵呵哒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FaGuiPage对象", description = "FaGuiPage对象")
public class FaGuiPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;
	/**
	 * 单位id
	 */
	@ApiModelProperty(value = "单位id",required=true)
	private Integer deptId;
	/**
	 * 颁布机关
	 */
	@ApiModelProperty(value = "颁布机关")
	private String banbujiguan;

}
