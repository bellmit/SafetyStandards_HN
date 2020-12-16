package org.springblade.anbiao.shigu.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 事故报告调查处理-事故报告 分页实体类
 * Program: SafetyStandards
 *
 * @description: ShigubaogaoPage
 * @author: elvis.he
 * @create: 2019-04-28 16:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShigubaogaoPage对象", description = "ShigubaogaoPage对象")
public class ShigubaogaoPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;
    @ApiModelProperty(value = "车辆牌照")
    private String cheliangpaizhao;

}
