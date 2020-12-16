package org.springblade.anbiao.jinritixing.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/6/4.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "YujingquanxianPage对象", description = "YujingquanxianPage对象")
public class YujingquanxianPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;

	@ApiModelProperty(value = "预警项id")
	private String yujingxiangid;

	@ApiModelProperty(value = "岗位id", required = true)
	private String postId;

	@ApiModelProperty(value = "预警项")
	private String yujingxiang;

	@ApiModelProperty(value = "预警分类")
	private String yujingfenlei;
}
