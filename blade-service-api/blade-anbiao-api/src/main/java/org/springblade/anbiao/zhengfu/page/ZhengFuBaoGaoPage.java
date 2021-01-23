/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Author:   呵呵哒
 * Date:     2020/6/20 16:14
 * Description:
 */
package org.springblade.anbiao.zhengfu.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @创建人 hyp
 * @创建时间 2020/6/20
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ZhengFuBaoGaoPage对象", description = "ZhengFuBaoGaoPage对象")
public class ZhengFuBaoGaoPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "deptId",required = true)
	private String deptId;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "县")
	private String country;

	@ApiModelProperty(value = "报告类型（12：周报；13：月报；2：预览图片；4：打包下载；）",required = true)
	private String property;

	@ApiModelProperty(value = "统计时间",required = true)
	private String time;

	@ApiModelProperty(value = "运管ID")
	private String yunguanId;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

	@ApiModelProperty(value = "运管名称")
	private String zhengfuname;
}
