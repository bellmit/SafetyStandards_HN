package org.springblade.anbiao.jinritixing.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/5/10.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BaojingtongjiPage对象", description = "BaojingtongjiPage对象")
public class BaojingtongjiPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业名称", required = true)
	private  String company;

	@ApiModelProperty(value = "统计日期", required = true)
	private  String tongjiriqi;
}
