/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Author:   呵呵哒
 * Date:     2020/6/20 16:14
 * Description:
 */
package org.springblade.system.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @创建人 hyp
 * @创建时间 2020/7/27
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DictPage对象", description = "DictPage对象")
public class DictPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典编号 ")
	private String code;

	@ApiModelProperty(value = "字典名称 ")
	private String dictValue;

	@ApiModelProperty(value = "第几页(从1开始)")
	private Integer page;

	@ApiModelProperty(value = "每页条数")
	private Integer pagesize;

	@ApiModelProperty(value = "类型 ")
	private String type;

}
