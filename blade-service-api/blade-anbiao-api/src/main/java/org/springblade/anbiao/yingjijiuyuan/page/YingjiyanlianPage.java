package org.springblade.anbiao.yingjijiuyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 应急演练 分页实体类
 * Program: SafetyStandards
 * @description: YingjiyanlianPage
 * @author: hyp
 * @create2021-04-26 17:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "YingjiyanlianPage对象", description = "YingjiyanlianPage对象")
public class YingjiyanlianPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;
	@ApiModelProperty(value = "应急演练计划")
	private String jihua;
}
