package org.springblade.anbiao.yingjijiuyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 应急队伍 分页实体类
 * Program: SafetyStandards
 * @description: YingjiduiwuPage
 * @author: elvis.he
 * @create: 2019-04-28 14:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "YingjiduiwuPage对象", description = "YingjiduiwuPage对象")
public class YingjiduiwuPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;

}
