package org.springblade.alarm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 报警处理页面中部统计 实体类
 *
 * @author elvis.he
 * @since 2019-05-09
 */
@Data
@ApiModel(value = "AlarmBaojingTongji对象", description = "AlarmBaojingTongji对象")
public class AlarmBaojingTongji implements Serializable {
    /**
     * 报警 率
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业名称")
    private String company;
    @ApiModelProperty(value = "报警类型")
    private String alarmType;
    @ApiModelProperty(value = "报警车辆数")
    private Integer vehCount;
    @ApiModelProperty(value = "报警次数")
    private Integer alarmCount;
    @ApiModelProperty(value = "报警处理数")
    private Integer handledCount;
    @ApiModelProperty(value = "报警处理率")
    private String handledRate;
    @ApiModelProperty(value = "统计日期 格式：yyyy-MM-dd")
    private String countDate;
}
