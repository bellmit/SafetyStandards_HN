package org.springblade.gps.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.common.BasePage;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/915:53
 */
@Data
@ApiModel(value = "VehicleStopPage", description = "VehicleStopPage")
public class VehicleStopPage extends BasePage {
	/**
	 * 车辆id
	 */
	@ApiModelProperty(value = "车辆id")
	private Integer vehid;
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
	 * 时间筛选
	 */
	@ApiModelProperty(value = "时间筛选")
	private String  timequery;
}
