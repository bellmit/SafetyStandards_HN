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
@ApiModel(value = "YuJingXiangPage对象", description = "YuJingXiangPage对象")
public class YuJingXiangPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "预警分类")
	private String yujingfenlei;

}
