/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Author:   呵呵哒
 * Date:     2020/6/20 16:14
 * Description:
 */
package org.springblade.anbiao.richenganpai.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/11/30
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RiChengAnPaiPage对象", description = "RiChengAnPaiPage对象")
public class RiChengAnPaiPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业ID", required = true)
	private Integer deptId;

	@ApiModelProperty(value = "待办状态（是否完成(0否,1是,2超期完成)）")
	private Integer isFinish;

	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	@ApiModelProperty(value = "日期", required = true)
	private String dateTime;

	@ApiModelProperty(value = "任务类型")
	private String renwuleixing;

	@ApiModelProperty(value = "任务标题")
	private String renwubiaoti;

	@ApiModelProperty(value = "类型（1:企业端安全标准化待办；2:企业端日程待办;null:运维端日程待办）")
	private Integer type;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

}
