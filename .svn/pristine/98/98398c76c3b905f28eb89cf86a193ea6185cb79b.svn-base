package org.springblade.alarm.page;

import feign.Param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BaojingTJPage对象", description = "BaojingTJPage对象")
public class BaojingTJPage<T>  extends BasePage<T> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间 格式：yyyy-MM-dd", required = true)
	private String beginTime;
	@ApiModelProperty(value = "结束时间 格式：yyyy-MM-dd", required = true)
	private String  endTime;
	@ApiModelProperty(value = "企业名称", required = true)
	private  String  deptName;
	@ApiModelProperty(value = "报警车辆")
	private Integer   alarmVehicle;
	@ApiModelProperty(value = "报警次数")
	private Integer  alarmCount;


}
