package org.springblade.app.yingjichuzhi.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "YingjichuzhileiPage对象", description = "YingjichuzhiPagelei对象")
public class YingjichuzhileiPage<T> extends BasePage<T> {
	private static final long serialVersionUID=1L;

	@ApiModelProperty(value = "应急处置id", required = true)
	private String yingjichuzhiid;

	@ApiModelProperty(value = "应急处置分类标题", required = false)
	private String title;

}
