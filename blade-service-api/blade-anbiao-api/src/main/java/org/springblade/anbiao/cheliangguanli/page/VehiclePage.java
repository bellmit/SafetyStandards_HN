package org.springblade.anbiao.cheliangguanli.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 车辆 分页实体类
 * Program: SafetyStandards
 * @description: VehiclePage
 * @author: hyp
 * @create2021-04-25 11:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "VehiclePage对象", description = "VehiclePage对象")
public class VehiclePage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;

    @ApiModelProperty(value = "企业名称")
    private String deptName;

    @ApiModelProperty(value = "车辆牌照")
    private String cheliangpaizhao;

    @ApiModelProperty(value = "使用性质")
    private String shiyongxingzhi;

	@ApiModelProperty(value = "车辆类型(1，2)",required = true)
	private String cheliangleixing;

	@ApiModelProperty(value = "ids")
	private String ids;

	@ApiModelProperty(value = "统计日期")
	private String tongjiriqi;

	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;

	@ApiModelProperty(value = "终端ID")
	private String zongduanid;

	@ApiModelProperty(value = "预警项id")
	private String tixingxiangqingid;

	@ApiModelProperty(value = "预警类型")
	private String tixingleixing;

	@ApiModelProperty(value = "车辆状态")
	private String cheliangzhuangtai;

	@ApiModelProperty(value = "开始时间")
	private String begintime;

	@ApiModelProperty(value = "结束时间")
	private String endtime;

	@ApiModelProperty(value = "所属地市")
	private String areaName;
}
