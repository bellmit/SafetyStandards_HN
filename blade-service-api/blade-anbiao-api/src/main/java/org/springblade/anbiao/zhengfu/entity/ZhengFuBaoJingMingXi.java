/**
 * Copyright (C), 2015-2020,
 * FileName: ZhengFuBaoJingTongJi
 * Author:   呵呵哒
 * Date:     2020/7/7 20:29
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 呵呵哒
 * @描述
 */
@Data
@ApiModel(value = "ZhengFuBaoJingMingXi对象", description = "ZhengFuBaoJingMingXi对象")
public class ZhengFuBaoJingMingXi implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "持续时间")
	private String keeptimeShow;

	@ApiModelProperty(value = "报警ID")
	private String alarmReportID;

	@ApiModelProperty(value = "开始时间")
	private String beginTime;

	@ApiModelProperty(value = "结束时间")
	private String endTime;

	@ApiModelProperty(value = "最高速度")
	private String maxSpeed;

	@ApiModelProperty(value = "报警类型")
	private String alarmType;

	@ApiModelProperty(value = "经度")
	private String longitude;

	@ApiModelProperty(value = "纬度")
	private String latitude;

	@ApiModelProperty(value = "速度")
	private String velocity;

	@ApiModelProperty(value = "道路限速")
	private String limited;

	@ApiModelProperty(value = "地理位置")
	private String roadName;

	@ApiModelProperty(value = "道路等级")
	private String roadLevel;

	@ApiModelProperty(value = "道路限速")
	private String roadLimited;

	@ApiModelProperty(value = "车辆牌照")
	private String plate;

	@ApiModelProperty(value = "车牌颜色")
	private String color;

	@ApiModelProperty(value = "所属企业")
	private String company;

	@ApiModelProperty(value = "结束速度")
	private String endSpeed;

	@ApiModelProperty(value = "里程")
	private double distance;

	@ApiModelProperty(value = "处理状态")
	private String chulizhuangtai;

	@ApiModelProperty(value = "申诉状态")
	private String shensuzhuangtai;

	@ApiModelProperty(value = "处理形式")
	private String chulixingshi;

	@ApiModelProperty(value = "处理描述")
	private String chulimiaoshu;

	@ApiModelProperty(value = "申诉/处理人")
	private String chuliren;

	@ApiModelProperty(value = "申诉/处理人id")
	private String chulirenid;

	@ApiModelProperty(value = "处理时间")
	private String chulishijian;

	@ApiModelProperty(value = "附件")
	private String fujian;

	@ApiModelProperty(value = "备注")
	private String beizhu;

	@ApiModelProperty(value = "申诉形式")
	private String shensuxingshi;

	@ApiModelProperty(value = "申诉描述")
	private  String shensumiaoshu;

	@ApiModelProperty(value = "报警等级")
	private String alarmlevel;

	@ApiModelProperty(value = "报警时间")
	private String gpsTime;

	@ApiModelProperty(value = "车辆类型")
	private String operatType;

	@ApiModelProperty(value = "申诉/处理标识")
	private Integer remark;

	@ApiModelProperty(value = "开始行驶时间（疲劳驾驶）")
	private String calctime;

	@ApiModelProperty(value = "提醒消息ID")
	private String alarmGuid;

	@ApiModelProperty(value = "IC卡登签")
	private String icardsign;

	@ApiModelProperty(value = "超速比展示")
	private String ChaoSuBiShow;


}
