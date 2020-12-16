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
 * @创建时间 2020/9/23
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrganizationPage对象", description = "OrganizationPage对象")
public class OrganizationPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "政府运管ID",required = true)
	private String deptId;

	@ApiModelProperty(value = "机构类型（企业总数：qiye;个体总数：geti;）",required = true)
	private String jigouleixing;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "法人代表")
	private String farendaibiao;

	@ApiModelProperty(value = "经营范围")
	private String jigouzizhi;

	@ApiModelProperty(value = "运管名称")
	private String yunguanmingcheng;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "县")
	private String country;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

}
