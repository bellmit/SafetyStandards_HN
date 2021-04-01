package org.springblade.anbiao.shigu.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 事故报告调查处理-事故处理 分页实体类
 * Program: SafetyStandards
 *
 * @description: ShiguchuliPage
 * @author: hyp
 * @create2021-04-29 09:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShiguchuliPage对象", description = "ShiguchuliPage对象")
public class ShiguchuliPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;
}
