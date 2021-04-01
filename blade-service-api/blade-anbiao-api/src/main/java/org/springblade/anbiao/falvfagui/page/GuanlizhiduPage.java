package org.springblade.anbiao.falvfagui.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * 管理制度 分页实体类
 *
 * @program: SafetyStandards
 * @description: GuanlizhiduPage
 * @author: hyp
 * @create2021-04-26 09:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GuanlizhiduPage对象", description = "GuanlizhiduPage对象")
public class GuanlizhiduPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id", required = true)
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    private String deptName;

    @ApiModelProperty(value = "文件名称")
    private String wenjianmingcheng;

    @ApiModelProperty(value = "发布日期 开始时间")
    private String fbbegintime;
    @ApiModelProperty(value = "发布日期 结束时间")
    private String fbendtime;

}
