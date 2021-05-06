package org.springblade.anbiao.cheliangguanli.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 车辆 异动实体类
 * Program: SafetyStandards
 * @author 呵呵哒
 * @description: VehiclesMoveInfoPage
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "VehiclesMoveInfoPage对象", description = "VehiclesMoveInfoPage对象")
public class VehiclesMoveInfoPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业ID", required = true)
	private String deptId;

    @ApiModelProperty(value = "车辆牌照")
    private String cheliangpaizhao;

	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;

}
