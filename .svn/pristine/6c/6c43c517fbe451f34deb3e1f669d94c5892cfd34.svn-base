package org.springblade.anbiao.ranyoubutie.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GpsfuelvehPage对象", description = "GpsfuelvehPage对象")
public class GpsfuelvehPage<T> extends BasePage<T> {

    private static final long serialVersionUID = 1L;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "单位名称")
    private String deptName;
    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID")
    private String deptId;
    /**
     * 车辆牌照
     */
    @ApiModelProperty(value="车辆牌照")
    private String chepaihao;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间")
    private String beginTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间")
    private String endTime;

    @ApiModelProperty(value="sql")
    private String sql;

    @ApiModelProperty(value="时间列表")
    private List<String> TimeString;
}
