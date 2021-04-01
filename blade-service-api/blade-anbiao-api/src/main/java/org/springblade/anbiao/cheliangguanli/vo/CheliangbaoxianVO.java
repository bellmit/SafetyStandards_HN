/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 */
package org.springblade.anbiao.cheliangguanli.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import org.springblade.anbiao.cheliangguanli.entity.Cheliangbaoxian;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CheliangbaoxianVO对象", description = "CheliangbaoxianVO对象")
public class CheliangbaoxianVO extends Cheliangbaoxian {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;
	@ApiModelProperty(value = "保险操作人")
	private String baoxiancaozuoren;

	@ApiModelProperty(value = "领取时间")
	private String lingqushijian;
	@ApiModelProperty(value = "保险操作人ID")
	private String baoxiancaozuorenid;
	@ApiModelProperty(value = "保险操作人")
	private String baoxiancaozuoshijian;
	@ApiModelProperty(value = "车辆类型")
	private String shiyongxingzhi;
	@ApiModelProperty(value = "保险信息创建时间")
	private String baoxiancreatetime;
	@ApiModelProperty(value = "车辆退市时间")
	private String tuishishijian;
	@ApiModelProperty(value = "保险明细ID")
	private String mingxiid;
	@ApiModelProperty(value = "保险明细投保公司")
	private String toubaogongsi;
	@ApiModelProperty(value = "保险单号")
	private String baoxiandanhao;
	@ApiModelProperty(value = "投保类型")
	private String toubaoleixing;
	@ApiModelProperty(value = "购买项目")
	private String goumaixiangmu;
	@ApiModelProperty(value = "购买金额")
	private String goumaijine;
	@ApiModelProperty(value = "保费")
	private String baofei;
	@ApiModelProperty(value = "起保时间")
	private String qibaoshijian;
	@ApiModelProperty(value = "终保时间")
	private String zhongbaoshijian;
	@ApiModelProperty(value = "出单时间")
	private String chudanshijian;
	@ApiModelProperty(value = "领取人")
	private String lingquren;

	@ApiModelProperty(value = "正本交接人")
	private String zhengbenjieshouren;
	@ApiModelProperty(value = "正本交接时间")
	private String zhengbenjiaojieshijian;
	@ApiModelProperty(value = "发票交接时间")
	private String fapiaojiaojieshijian;
	@ApiModelProperty(value = "发票交接人")
	private String fapiaojieshouren;
	@ApiModelProperty(value = "保险明细备注")
	private String mingxibeizhu;
	@ApiModelProperty(value = "保险明细附件")
	private String mingxifujian;
	@ApiModelProperty(value = "保险明细操作人")
	private String mingxicaozuoren;
	@ApiModelProperty(value = "保险明细操作人ID")
	private String mingxicaozuorenid;
	@ApiModelProperty(value = "保险明细操作时间")
	private String mingxicaozuoshijian;
	@ApiModelProperty(value = "保险明细创建时间")
	private String mingxicreatetime;

}
