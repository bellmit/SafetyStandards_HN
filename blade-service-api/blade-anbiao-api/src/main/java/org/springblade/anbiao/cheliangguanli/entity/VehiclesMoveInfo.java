/**
 * Copyright (C), 2015-2020
 * FileName: VehiclesMoveInfo
 * Author:   呵呵哒
 * Date:     2020/12/29 13:53
 * Description:
 */
package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/12/29
 * @描述
 */
@Data
@TableName("anbiao_vehicles_move_info")
@ApiModel(value = "VehiclesMoveInfo对象", description = "VehiclesMoveInfo对象")
public class VehiclesMoveInfo implements Serializable {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.UUID)
	@ApiModelProperty(value = "主键")
	private String id;

	@ApiModelProperty(value = "车辆ID",required = true)
	@TableField("vehId")
	private String vehId;

	@ApiModelProperty(value = "迁出企业ID",required = true)
	@TableField("outOfDeptId")
	private Integer outOfDeptId;

	@ApiModelProperty(value = "迁入企业ID",required = true)
	@TableField("inOfDeptId")
	private Integer inOfDeptId;

	@ApiModelProperty(value = "变更时间",required = true)
	@TableField("updateTime")
	private String updateTime;

	@ApiModelProperty(value = "操作人ID",required = true)
	@TableField("updateUserId")
	private String updateUserId;

	@ApiModelProperty(value = "操作人",required = true)
	@TableField("updateUser")
	private String updateUser;

	@ApiModelProperty(value = "附件")
	@TableField("fuJian")
	private String fuJian;

	@ApiModelProperty(value = "备注")
	@TableField("remark")
	private String remark;

	@ApiModelProperty(value = "迁入企业")
	private String inOfDeptName;

	@ApiModelProperty(value = "迁出企业")
	private String outOfDeptName;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

}
