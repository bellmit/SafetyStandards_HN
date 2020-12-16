package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 报警处理页 上部统计 实体类
 * Program: SafetyStandards
 *
 * @description: ShishiBaojingTongjiPage
 * @author: elvis.he
 * @create: 2019-05-15
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShishiBaojingTongjiPage对象", description = "ShishiBaojingTongjiPage对象")
public class ShishiBaojingTongjiPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业id", required = true)
    private String deptId;
    @ApiModelProperty(value = "企业名称", required = true)
    private String deptName;
    @ApiModelProperty(value = "开始时间（yyyy-MM-dd）", required = true)
    private String beginTime;
    @ApiModelProperty(value = "结束时间（yyyy-MM-dd）", required = true)
    private String endTime;
    @ApiModelProperty("机构名称")
    private String  jigouName;
}
