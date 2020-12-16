/**
 * Copyright (C), 2015-2020,
 * FileName: ZhengFuBaoJingTongJi
 * Author:   呵呵哒
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
@ApiModel(value = "ZhengFuBaoJingTongJiLv对象", description = "ZhengFuBaoJingTongJiLv对象")
public class ZhengFuBaoJingTongJiLv implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "地区名称")
	private String areaname;

	@ApiModelProperty(value = "所属运管")
	private String zhengfuname;

	@ApiModelProperty(value = "所属运管ID")
	private String zhengfuid;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "报警总数")
	private Integer baojingzongshu;

	@ApiModelProperty(value = "GPS超速报警数")
	private Integer gpschaosu;

	@ApiModelProperty(value = "GPS疲劳驾驶报警数")
	private Integer gpspilao;

	@ApiModelProperty(value = "GPS夜间行驶报警数")
	private Integer gpsyejian;

	@ApiModelProperty(value = "GPS异常车辆报警数")
	private Integer gpsyichang;

	@ApiModelProperty(value = "GPS报警总数")
	private Integer gpsbaojingzongshu;

	@ApiModelProperty(value = "GPS报警处理总数")
	private Integer gpsbaojingclzongshu;

	@ApiModelProperty(value = "GPS报警处理lv")
	private String gpsbaojingzongcllv;

	@ApiModelProperty(value = "DMS疲劳驾驶报警数")
	private Integer dmspilao;

	@ApiModelProperty(value = "DMS抽烟报警数")
	private Integer dmschouyan;

	@ApiModelProperty(value = "DMS接打电话报警数")
	private Integer dmsjiedadianhua;

	@ApiModelProperty(value = "DMS分神驾驶报警数")
	private Integer dmsfenshen;

	@ApiModelProperty(value = "DMS报警总数")
	private Integer dmsbaojingzongshu;

	@ApiModelProperty(value = "DMS报警总处理数")
	private Integer dmsbaojingclzongshu;

	@ApiModelProperty(value = "DMS报警处理lv")
	private String dmsbaojingzongcllv;

	@ApiModelProperty(value = "报警车辆数")
	private Integer cheliangshu;

	@ApiModelProperty(value = "Gps超速报警处理lv")
	private String gpschaosucllv;

	@ApiModelProperty(value = "Gps疲劳报警处理lv")
	private String gpspilaocllv;

	@ApiModelProperty(value = "Gps夜间报警处理lv")
	private String gpsyejiancllv;

	@ApiModelProperty(value = "Gps异常报警处理lv")
	private String gpsyichangcllv;

	@ApiModelProperty(value = "DMS疲劳报警处理lv")
	private String dmspilaocllv;

	@ApiModelProperty(value = "DMS打电话报警处理lv")
	private String dmsjiedadianhuacllv;

	@ApiModelProperty(value = "DMS抽烟报警处理lv")
	private String dmschouyancllv;

	@ApiModelProperty(value = "DMS分神报警处理lv")
	private String dmsfenshencllv;

	@ApiModelProperty(value = "日期")
	private String date;

	@ApiModelProperty(value = "GPS超速报警处理数")
	private Integer chaosucl;

	@ApiModelProperty(value = "GPS疲劳报警处理数")
	private Integer pilaocl;

	@ApiModelProperty(value = "GPS夜间报警处理数")
	private Integer yejiancl;

	@ApiModelProperty(value = "GPS异常报警处理数")
	private Integer yichangcl;

	@ApiModelProperty(value = "DMS疲劳报警处理数")
	private Integer pilaoshipincl;

	@ApiModelProperty(value = "DMS打电话报警处理数")
	private Integer dadianhuacl;

	@ApiModelProperty(value = "DMS抽烟报警处理数")
	private Integer chouyancl;

	@ApiModelProperty(value = "DMS分神报警处理数")
	private Integer fenshencl;

	@ApiModelProperty(value = "报警总处理数")
	private Integer baojingclcishu;

	@ApiModelProperty(value = "报警总处理率")
	private String baojingzongcllv;

	@ApiModelProperty(value = "使用性质")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

}
