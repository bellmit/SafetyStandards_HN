package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/714:35
 */
@Data
@ApiModel(value = "AlarmTimePage", description = "AlarmTimePage")
public class AlarmTimePage {
	@ApiModelProperty(value = "开始时间（yyyy-MM-dd HH:mm:ss）", required = true)
	private String beginTime;
	@ApiModelProperty(value = "结束时间（yyyy-MM-dd HH:mm:ss）", required = true)
	private String endTime;
	@ApiModelProperty(value = "车辆牌照", required = true)
	private String plateNumber;
	@ApiModelProperty(value = "车牌颜色", required = true)
	private String  color;
	@ApiModelProperty(value = "企业名称", required = true)
	private String company;


}
