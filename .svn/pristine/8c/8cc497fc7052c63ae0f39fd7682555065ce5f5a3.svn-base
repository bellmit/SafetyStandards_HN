package org.springblade.anbiao.baobiaowenjian.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @description: 报表目录对象
 * @author: elvis.he
 * @create: 2019-05-16
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "报表目录对象", description = "报表目录对象")
public class BaobiaoWenjianPage<T> extends BasePage<T> {

    private static final long serialVersionUID = 1L;
    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id", required = true)
    private Integer deptId;

    @ApiModelProperty(value = "统计日期(日报：2019-05-20；周报：2019-21；月报：2019-5；年报：2019)", required = true)
    private String countDate;

    @ApiModelProperty(value = "报表属性（1日报、2周报、3月报、4年报）", required = true)
    private Integer property;

}
