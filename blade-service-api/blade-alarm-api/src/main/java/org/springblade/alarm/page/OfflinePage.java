package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.common.BasePage;

/**
 * 24小时不在线  分页实体类
 * Program: SafetyStandards
 *
 * @description: OfflinePage
 * @author: elvis.he
 * @create: 2019-05-11
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OfflinePage对象", description = "OfflinePage对象")
public class OfflinePage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id")
    private Integer deptId;
    @ApiModelProperty(value = "企业名称", required = true)
    private String deptName;
    @ApiModelProperty(value = "日期")
    private String countDate;
    @ApiModelProperty(value = "车辆牌照")
    private String chepaihao;
    @ApiModelProperty(value = "是否处理")
    private String shifouchuli;
	@ApiModelProperty(value = "是否申诉")
	private String shifoushenshu;
    @ApiModelProperty(value = "报警统计")
    private AlarmBaojingTongji baojingTongji;
	private String  company;
	@ApiModelProperty(value = "开始时间", required = true)
	private String beginTime;
	@ApiModelProperty(value = "结束时间", required = true)
	private String  endTime;
}
