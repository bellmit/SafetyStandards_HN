package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 报警处理页 中部统计 实体类
 * Program: SafetyStandards
 *
 * @description: BaojingtongjiPage
 * @author: hyp
 * @create2021-05-09
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BaojingtongjiPage对象", description = "BaojingtongjiPage对象")
public class BaojingtongjiPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业名称", required = true)
    private String company;
    @ApiModelProperty(value = "报警类型", required = true)
    private String alarmType;
    @ApiModelProperty(value = "统计日期 格式：yyyy-MM-dd", required = true)
    private String countDate;
}
