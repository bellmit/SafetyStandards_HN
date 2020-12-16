package org.springblade.anbiao.jiashiyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/5/6.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "JiashiyuanheimingdanPage对象", description = "JiashiyuanheimingdanPage对象")
public class JiashiyuanheimingdanPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;

	@ApiModelProperty(value = "驾驶员姓名")
	private String jiashiyuanxingming;
}
