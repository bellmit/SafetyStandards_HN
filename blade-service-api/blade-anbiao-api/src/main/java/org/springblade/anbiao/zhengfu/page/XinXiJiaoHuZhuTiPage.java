/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Description:
 */
package org.springblade.anbiao.zhengfu.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "XinXiJiaoHuZhuTiPage对象", description = "XinXiJiaoHuZhuTiPage对象")
public class XinXiJiaoHuZhuTiPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业Id")
	private Integer deptId;

	@ApiModelProperty(value = "userId")
	private Integer userId;

	@ApiModelProperty(value = "主题名称")
	private String zhutimingcheng;

	@ApiModelProperty(value = "发送企业 id")
	private Integer fasongdanweiid;

	@ApiModelProperty(value = "送达企业 id")
	private Integer songdadanweiid;

	@ApiModelProperty(value = "类型（1：通知公告；2：安全查岗；3：文件下发；4：下发整改）", required = true)
	private Integer type;

	@ApiModelProperty(value = "主题Id")
	private String zhutiId;
}
