package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.common.BasePage;

/**
 * 驾驶员报警 分页实体类
 * Program: SafetyStandards
 *
 * @description: DriverAlarmPage
 * @author: elvis.he
 * @create: 2019-05-08
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DriverAlarmPage对象", description = "DriverAlarmPage对象")
public class DriverAlarmPage<T> extends BasePage<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业 id")
    private Integer deptId;
    @ApiModelProperty(value = "企业名称", required = true)
    private String deptName;
    @ApiModelProperty(value = "开始时间", required = true)
    private String beginTime;
    @ApiModelProperty(value = "结束时间", required = true)
    private String endTime;
    @ApiModelProperty(value = "报警类型", required = true)
    private String alarmType;
    @ApiModelProperty(value = "车辆牌照")
    private String cheliangpaizhao;
    @ApiModelProperty(value = "是否处理('',未处理，已处理)")
    private String shifouchuli;
    @ApiModelProperty(value = "是否申诉")
    private String shifoushenshu;
    @ApiModelProperty(value = "核定状态(核定报警（默认）、误报、未核定等)")
    private String hedingzhuangtai;

    private String imageNumber;

    @ApiModelProperty(value = "报警统计")
    private AlarmBaojingTongji baojingTongji;
	@ApiModelProperty("机构名称")
	private String  jigouName;
}
