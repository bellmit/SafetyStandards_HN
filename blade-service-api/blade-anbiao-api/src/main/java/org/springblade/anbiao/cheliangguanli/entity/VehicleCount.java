package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/1013:17
 */
@Data
@TableName("anbiao_VehicleCount")
@ApiModel(value = "VehicleCount对象", description = "车辆统计")
public class VehicleCount {
	/**
	 * 企业总车辆数
	 */
	@ApiModelProperty(value = "企业总车辆数")
	private Integer  vehicleCount=0;
	/**
	 * 运行车辆总数
	 */
	@ApiModelProperty(value = "运行车辆总数")
	private Integer yunxingVehicleCount=0;
	/**
	 * 闲置车辆总数
	 */
	@ApiModelProperty(value = "闲置车辆总数")
	private Integer xianzhiVehicleCount=0;
	/**
	 * 离线车辆总数
	 */
	@ApiModelProperty(value = "离线车辆总数")
	private Integer lixianVehicleCount=0;
	/**
	 * 维修车辆总数
	 */
	@ApiModelProperty(value = "维修车辆总数")
	private Integer weixiuVehicleCount=0;
}
