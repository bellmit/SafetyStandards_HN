package org.springblade.manage.waybill.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WaybillPage对象", description = "WaybillPage对象")
public class WaybillPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

    @ApiModelProperty(value = "出库编号")
    private String outNum;

    @ApiModelProperty(value = "入库磅单序号")
    private String intoNum;

    @ApiModelProperty(value = "审核，0-未审核，1-已审核")
    private String status;

    @ApiModelProperty(value = "出库时间-开始")
    private String outTimeStart;

    @ApiModelProperty(value = "出库时间-结束")
    private String outTimeEnd;

    @ApiModelProperty(value = "入库时间-开始")
    private String intoTimeStart;

    @ApiModelProperty(value = "入库时间-结束")
    private String intoTimeEnd;

	@ApiModelProperty(value = "开始时间（yyyy-MM-dd）", required = true)
	private String beginTime;
	@ApiModelProperty(value = "结束时间（yyyy-MM-dd）", required = true)
	private String endTime;

}
