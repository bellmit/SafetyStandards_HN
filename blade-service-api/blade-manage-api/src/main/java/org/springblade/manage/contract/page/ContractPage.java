package org.springblade.manage.contract.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ContractPage对象", description = "ContractPage对象")
public class ContractPage<T> extends BasePage<T> {

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
	 * 合同编号
	 */
	@ApiModelProperty(value = "合同编号")
	private String hetongbianhao;
}
