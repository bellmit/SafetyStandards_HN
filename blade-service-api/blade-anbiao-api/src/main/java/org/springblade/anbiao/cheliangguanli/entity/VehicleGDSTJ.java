package org.springblade.anbiao.cheliangguanli.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: SafetyStandards
 * @description: Vehicle
 * @author: hyp
 * @create: 2021-01-16 14:00
 **/
@Data
@ApiModel(value = "VehicleGDSTJ对象", description = "VehicleGDSTJ对象")
public class VehicleGDSTJ implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "车辆牌照")
    private String cheliangpaizhao;

	@ApiModelProperty(value = "所属地市")
	private String areaName;

	@ApiModelProperty(value = "统计日期")
	private String dateShow;

	@ApiModelProperty(value = "新增车辆数(所有)")
	private Integer xzshu = 0;

	@ApiModelProperty(value = "当前总车辆数(所有)")
	private Integer zyshu = 0;

	@ApiModelProperty(value = "停用车辆数(所有)")
	private Integer tyshu = 0;

	@ApiModelProperty(value = "删除车辆数(所有)")
	private Integer scshu = 0;

	@ApiModelProperty(value = "车辆类型")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "新增车辆数(道路货物运输)")
	private Integer dlhwxzshu = 0;

	@ApiModelProperty(value = "新增车辆数(道路危险品运输)")
	private Integer dlwxpxzshu = 0;

	@ApiModelProperty(value = "新增车辆数(道路旅客运输)")
	private Integer dllkxzshu = 0;

	@ApiModelProperty(value = "当前总车辆数(道路货物运输)")
	private Integer dlhwzyshu = 0;

	@ApiModelProperty(value = "当前总车辆数(道路危险品运输)")
	private Integer dlwxpzyshu = 0;

	@ApiModelProperty(value = "当前总车辆数(道路旅客运输)")
	private Integer dllkzyshu = 0;

	@ApiModelProperty(value = "停用车辆数(道路货物运输)")
	private Integer dlhwtyshu = 0;

	@ApiModelProperty(value = "停用车辆数(道路危险品运输)")
	private Integer dlwxptyshu = 0;

	@ApiModelProperty(value = "停用车辆数(道路旅客运输)")
	private Integer dllktyshu = 0;

	@ApiModelProperty(value = "删除车辆数(道路货物运输)")
	private Integer dlhwscshu = 0;

	@ApiModelProperty(value = "删除车辆数(道路危险品运输)")
	private Integer dlwxpscshu = 0;

	@ApiModelProperty(value = "删除车辆数(道路旅客运输)")
	private Integer dllkscshu = 0;

	@ApiModelProperty(value = "企业ID")
	private Integer deptId;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	@ApiModelProperty(value = "车辆状态")
	private String cheliangzhuangtai;

	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;

	@ApiModelProperty(value = "创建时间")
	private String createtime;

	@ApiModelProperty(value = "操作人")
	private String caozuoren;

}
