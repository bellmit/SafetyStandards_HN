package org.springblade.anbiao.cheliangguanli.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/5/2.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CheliangdengjipingdingPage对象", description = "CheliangdengjipingdingPage对象")
public class CheliangdengjipingdingPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
//	@ApiModelProperty(value = "车辆牌照")
//	private String cheliangpaizhao;

	@ApiModelProperty(value = "ids")
	private String ids;

	@ApiModelProperty(value = "预警统计日期")
	private String tongjiriqi;

	@ApiModelProperty(value = "预警项id")
	private String tixingxiangqingid;

	@ApiModelProperty(value = "预警类型")
	private String tixingleixing;
}
