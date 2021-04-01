package org.springblade.anbiao.yingjijiuyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 应急预案 分页实体类
 * Program: SafetyStandards
 * @description: YingjiyuanPage
 * @author: hyp
 * @create2021-04-26 11:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "YingjiyuanPage对象", description = "YingjiyuanPage对象")
public class YingjiyuanPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;
    @ApiModelProperty(value = "预案名称")
    private String yuanmingcheng;

}
