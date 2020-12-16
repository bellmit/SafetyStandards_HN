package org.springblade.manage.settlement.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @description: SettlementPage
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SettlementPage对象", description = "SettlementPage对象")
public class SettlementPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
	/**
	 * 税率
	 */
	@ApiModelProperty(value = "税率")
	private Double  shuilv;
	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "车辆牌照")
	private String  cheliangpaizhao;
	/**
	 * 出库开始时间
	 */
	@ApiModelProperty(value = "出库开始时间")
	private String  outTimeStart;
	/**
	 * 出库结束时间
	 */
	@ApiModelProperty(value = "出库结束时间")
	private String  outTimeEnd;
	/**
	 * 是否查看
	 */
	@ApiModelProperty(value = "是否查看")
	private String type;

}
