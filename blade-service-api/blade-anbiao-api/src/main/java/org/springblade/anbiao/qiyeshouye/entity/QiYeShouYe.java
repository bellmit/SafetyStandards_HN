/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/21
 * @描述
 */
@Data
@ApiModel(value = "QiYeShouYe对象", description = "QiYeShouYe对象")
public class QiYeShouYe implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "注册车辆数")
	private Integer zcvehnum;

	@ApiModelProperty(value = "运行车辆数")
	private Integer sxvehnum;

	@ApiModelProperty(value = "停置车辆数")
	private Integer tyvehnum;

	@ApiModelProperty(value = "离线车辆数")
	private Integer lxvehnum;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "日期")
	private String date;

	@ApiModelProperty(value = "报警总数")
	private Integer baojingcishu;

	@ApiModelProperty(value = "北斗设备报警数")
	private Integer bdbaojingcishu;

	@ApiModelProperty(value = "主动安全设备报警数")
	private Integer sbbaojingcishu;

	@ApiModelProperty(value = "北斗设备报警占比")
	private String bdzhanbi;

	@ApiModelProperty(value = "主动安全设备报警占比")
	private String sbzhanbi;

	@ApiModelProperty(value = "处理报警总数")
	private Integer baojingclcishu;

	@ApiModelProperty(value = "处理报警百分比")
	private String zongchulilv;

	@ApiModelProperty(value = "北斗设备报警处理数")
	private Integer bdbaojingclcishu;

	@ApiModelProperty(value = "北斗设备报警处理率")
	private String bdchulilv;

	@ApiModelProperty(value = "主动安全设备报警处理数")
	private Integer sbbaojingclcishu;

	@ApiModelProperty(value = "主动安全设备报警处理率")
	private String sbchulilv;

	@ApiModelProperty(value = "北斗设备未处理报警数")
	private Integer bdweichulishu;

	@ApiModelProperty(value = "主动安全设备未处理报警数")
	private Integer sbweichulishu;

	@ApiModelProperty(value = "正常处理报警数")
	private Integer zcbaojingclcishu;

	@ApiModelProperty(value = "超时处理报警数")
	private Integer csbaojingclcishu;

	@ApiModelProperty(value = "近7天报警总数")
	private Integer sevenzongbaojingshu;

	@ApiModelProperty(value = "近7天报警处理数")
	private Integer sevenzongchulishu;

	@ApiModelProperty(value = "近7天报警未处理数")
	private Integer sevenzongweichulishu;

	@ApiModelProperty(value = "近7天北斗设备报警总数")
	private Integer sevengpsbaojingshu;

	@ApiModelProperty(value = "近7天主动安全设备报警总数")
	private Integer sevenshebeibaojingshu;

	@ApiModelProperty(value = "近7天北斗设备报警处理数")
	private Integer sevengpschulishu;

	@ApiModelProperty(value = "近7天主动安全设备报警处理数")
	private Integer sevenshebeichulishu;

	@ApiModelProperty(value = "近7天北斗设备报警未处理数")
	private Integer sevengpsweichulishu;

	@ApiModelProperty(value = "近7天主动安全设备报警未处理数")
	private Integer sevenshebeiweichulishu;

	@ApiModelProperty(value = "近7天报警未处理率")
	private String sevenchulilv;

	@ApiModelProperty(value = "未处理报警数")
	private Integer weichulizongshu;

	@ApiModelProperty(value = "处理报警数")
	private Integer chulizongshu;

	@ApiModelProperty(value = "sevenList")
	private List<QiYeShouYe> sevenList;

}
