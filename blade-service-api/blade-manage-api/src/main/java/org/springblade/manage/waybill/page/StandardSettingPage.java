package org.springblade.manage.waybill.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @description: StandardSettingPage
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "StandardSettingPage对象", description = "StandardSettingPage对象")
public class StandardSettingPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "年")
	private String year;
	@ApiModelProperty(value = "月")
	private String month;
	@ApiModelProperty(value = "月份")
	private String yue;
	@ApiModelProperty(value = "状态")
	private String zhuangtai;

}
