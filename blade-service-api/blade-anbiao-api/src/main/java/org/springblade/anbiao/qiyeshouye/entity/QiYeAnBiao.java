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
@ApiModel(value = "QiYeAnBiao对象", description = "QiYeAnBiao对象")
public class QiYeAnBiao implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "企业ID")
	private Integer deptId;

	@ApiModelProperty(value = "任务类型")
	private String renwuleixing;

	@ApiModelProperty(value = "任务标题")
	private String renwubiaoti;

	@ApiModelProperty(value = "创建人")
	private String anpairen;

	@ApiModelProperty(value = "创建人ID")
	private Integer anpairenId;

	@ApiModelProperty(value = "是否紧急(0否,1是)")
	private Integer isJinji=0;

	@ApiModelProperty(value = "是否重要(0否,1是)")
	private Integer isZhongyao=0;

	@ApiModelProperty(value = "任务开始时间")
	private String renwukaishishijian;

	@ApiModelProperty(value = "任务截止时间")
	private String renwujiezhishijian;

	@ApiModelProperty(value = "任务地点")
	private String renwudidian;

	@ApiModelProperty(value = "任务内容")
	private String renwuneirong;

	@ApiModelProperty(value = "自我评价")
	private String ziwozongjie;

	@ApiModelProperty(value = "是否删除")
	private Integer isDeleted=0;

	@ApiModelProperty(value = "操作人")
	private String caozuoren;

	@ApiModelProperty(value = "操作人id")
	private Integer caozuorenid;

	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;

	@ApiModelProperty(value = "是否完成(0否,1是,2超期完成)")
	private Integer isFinish=0;

	@ApiModelProperty(value = "完成人")
	private String finishuser;

	@ApiModelProperty(value = "完成人ID")
	private Integer finishuserid;

	@ApiModelProperty(value = "完成时间")
	private String finishtime;

	@ApiModelProperty(value = "完成描述")
	private String finishremark;

	@ApiModelProperty(value = "完成附件")
	private String finishimg;

	@ApiModelProperty(value = "审核状态(0:审核通过、1:审核驳回)")
	private Integer finishstatus=0;

	@ApiModelProperty(value = "标准化目录tier")
	private String tier;

	@ApiModelProperty(value = "标准化目录名称")
	private String tiername;

}
