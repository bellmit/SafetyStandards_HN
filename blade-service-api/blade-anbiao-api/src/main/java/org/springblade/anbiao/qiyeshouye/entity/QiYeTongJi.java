/**
 * Copyright (C), 2015-2020,
 * FileName: 北斗Vehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/31
 * @描述
 */
@Data
@ApiModel(value = "QiYeTongJi对象", description = "QiYeTongJi对象")
public class QiYeTongJi implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String cid;

	@ApiModelProperty(value = "企业名称")
	private String company;

	@ApiModelProperty(value = "车牌号")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	@ApiModelProperty(value = "营运类型")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "总报警次数")
	private Integer baojingcishu;

	@ApiModelProperty(value = "主动安全报警次数")
	private Integer zhudongbaojingcishu;

	@ApiModelProperty(value = "北斗报警次数")
	private Integer beidoubaojingcishu;

	@ApiModelProperty(value = "报警车辆数")
	private Integer baojingcheliangshu;

	@ApiModelProperty(value = "日期")
	private String date;

	@ApiModelProperty(value = "北斗超速报警数")
	private Integer chaosu;

	@ApiModelProperty(value = "北斗疲劳驾驶报警数")
	private Integer pilao;

	@ApiModelProperty(value = "北斗夜间行驶报警数")
	private Integer yejian;

	@ApiModelProperty(value = "北斗异常车辆报警数")
	private Integer yichang;

	@ApiModelProperty(value = "主动安全疲劳驾驶报警数")
	private Integer dmspilao;

	@ApiModelProperty(value = "主动安全抽烟报警数")
	private Integer dmschouyan;

	@ApiModelProperty(value = "主动安全接打电话报警数")
	private Integer dmsdadianhua;

	@ApiModelProperty(value = "主动安全分神驾驶报警数")
	private Integer dmsfenshen;

	@ApiModelProperty(value = "单车报警比")
	private String danchebaojingbi;

	@ApiModelProperty(value = "车辆数")
	private Integer cheliangshu;



}
