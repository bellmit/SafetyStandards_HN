package org.springblade.gps.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.common.BasePage;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/1013:43
 */
@Data
@ApiModel(value = "VehicleStopSumPage", description = "VehicleStopSumPage")
public class VehicleStopSumPage extends BasePage {
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private String begintime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "endtime")
	private String endtime;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String company;
}
