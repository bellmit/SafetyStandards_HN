/**
 * Copyright (C), 2015-2020,
 * FileName: 北斗Vehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/10/12
 * @描述
 */
@Data
@ApiModel(value = "ZhengFuRiYunXingTongJi对象", description = "ZhengFuRiYunXingTongJi对象")
public class ZhengFuRiYunXingTongJi implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "企业名称")
	private String company;

	@ApiModelProperty(value = "车辆总数")
	private Integer vehicleCount;

	@ApiModelProperty(value = "上线车辆数")
	private Integer onlineCount;

	@ApiModelProperty(value = "离线车辆数")
	private Integer offlineCount;

	@ApiModelProperty(value = "上线率")
	private String onlineRate;

	@ApiModelProperty(value = "时间段")
	private String date;

	@ApiModelProperty(value = "定位车辆数")
	private Integer locateCount;

	@ApiModelProperty(value = "定位率")
	private String locateRate;

	@ApiModelProperty(value = "轨迹漂移率")
	private String DriftPositionRate;

	@ApiModelProperty(value = "轨迹完整率")
	private String IntactPositionRate;

	@ApiModelProperty(value = "数据合格率")
	private String QualifiedPositionRate;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	@ApiModelProperty(value = "营运类型")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "上线天数")
	private String DaysOnline;

	@ApiModelProperty(value = "所属地区")
	private String areaname;

	@ApiModelProperty(value = "所属运管")
	private String zhengfuname;

	@ApiModelProperty(value = "所属运管ID")
	private String zhengfuid;

}
