package org.springblade.anbiao.jiashiyuan.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "JiaShiYuanPage对象", description = "JiaShiYuanPage对象")
public class JiaShiYuanPage<T> extends BasePage<T> {
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

	@ApiModelProperty(value = "驾驶员类型",required = true)
	private String jiashiyuanleixing;

	@ApiModelProperty(value = "ids")
	private String ids;

	@ApiModelProperty(value = "预警统计日期")
	private String tongjiriqi;

	@ApiModelProperty(value = "预警项id")
	private String tixingxiangqingid;

	@ApiModelProperty(value = "预警类型")
	private String tixingleixing;

	@ApiModelProperty(value = "预警类型")
	private String biaoshi;
}
