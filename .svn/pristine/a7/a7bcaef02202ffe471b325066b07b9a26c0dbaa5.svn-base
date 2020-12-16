package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.common.BasePage;

import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/814:20
 */
@Data
@ApiModel(value = "VehicleForPlate", description = "VehicleForPlate")
public class VehicleDetailPage <T> extends BasePage<T> {
	/**
	 * deptId
	 */
	@ApiModelProperty(value = "deptId")
	private Integer deptId;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String company;
	/**
	 * 车牌 车牌颜色 数组
	 */
	@ApiModelProperty(value = "车牌 车辆颜色")
	private List<VehicleForPlate> list;

	@ApiModelProperty("车辆信息list")
	private List<VehiclePT> ptList;
}
