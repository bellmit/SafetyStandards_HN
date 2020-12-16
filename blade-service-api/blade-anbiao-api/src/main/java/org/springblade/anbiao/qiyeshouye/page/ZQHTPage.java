/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Author:   呵呵哒
 * Date:     2020/6/20 16:14
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/30
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ZQHTPage对象", description = "ZQHTPage对象")
public class ZQHTPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业ID", required = true)
	private Integer deptId;

	@ApiModelProperty(value = "类型（1：通知公告；2：安全查岗；3：文件下发；4：下发整改）", required = true)
	private Integer type;

	@ApiModelProperty(value = "开始时间")
	private String beginTime;

	@ApiModelProperty(value = "结束时间")
	private String endTime;

	@ApiModelProperty(value = "主题名称")
	private String zhutimingcheng;

	@ApiModelProperty(value = "主题ID")
	private String zhutiid;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

}
