package org.springblade.anbiao.richenganpai.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author th
 * @description: 日常首页数据视图类
 * @projectName SafetyStandards
 * @date 2019/6/69:59
 */
@Data
public class RichengIndexVo implements Serializable {
	/**
	 * 日期号数
	 */
	@ApiModelProperty(value = "日期号数")
	private Integer num;

	/**
	 * 日期
	 */
	@ApiModelProperty(value = "日期")
	private  String date;

	/**
	 * 总任务数
	 */
	@ApiModelProperty(value = "总任务数")
	private Integer zongrenwushu;

	/**
	 * 重要任务数
	 */
	@ApiModelProperty(value = "重要任务数")
	private Integer zhongyaorenwushu;

	/**
	 * 紧急任务数
	 */
	@ApiModelProperty(value = "紧急任务数")
	private Integer jinjirenwushu;
}
