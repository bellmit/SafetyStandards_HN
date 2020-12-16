package org.springblade.anbiao.guanlijigouherenyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @description: Anquanhuiyi分页对象
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AnquanhuiyiPage对象", description = "AnquanhuiyiPage对象")
public class AnquanhuiyiPage <T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;
	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id")
	private Integer deptId;

}
