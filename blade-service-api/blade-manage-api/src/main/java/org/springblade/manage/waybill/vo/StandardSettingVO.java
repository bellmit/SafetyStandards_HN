/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.springblade.manage.waybill.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.manage.waybill.entity.StandardSetting;

/**
 * 视图实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "StandardSettingVO对象", description = "StandardSettingVO对象")
public class StandardSettingVO extends StandardSetting {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
	@ApiModelProperty(value = "企业id")
	private String deptId;
	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	/**
	 * 实际里程
	 */
	@ApiModelProperty(value = "实际里程")
	private String shiji;
	/**
	 * 达标里程
	 */
	@ApiModelProperty(value = "达标里程")
	private String dabiao;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private String zhuangtai;
	/**
	 * 完成率
	 */
	@ApiModelProperty(value = "完成率")
	private double wanchenglv;
	/**
	 * 在线率
	 */
	@ApiModelProperty(value = "在线率")
	private double zaixianlv;
	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;
	/**
	 * 合格率
	 */
	@ApiModelProperty(value = "合格率")
	private String hegelv;

}
