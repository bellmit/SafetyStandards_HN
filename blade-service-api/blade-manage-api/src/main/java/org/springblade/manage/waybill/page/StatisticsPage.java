package org.springblade.manage.waybill.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @program: SafetyStandards
 * @author: 呵呵哒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AnnualverificationPage对象", description = "AnnualverificationPage对象")
public class StatisticsPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "开始时间（yyyy-MM-dd）", required = true)
	private String beginTime;
	@ApiModelProperty(value = "结束时间（yyyy-MM-dd）", required = true)
	private String endTime;
	@ApiModelProperty(value = "收入")
	private String  shouru;
	@ApiModelProperty(value = "支出")
	private String  zhichu;
	@ApiModelProperty(value = "燃油")
	private String  ranyou;
	@ApiModelProperty(value = "交通费")
	private String  jiaotiong;
	@ApiModelProperty(value = "维修")
	private String  weixiu;
	@ApiModelProperty(value = "保险")
	private String  baoxian;
	@ApiModelProperty(value = "车辆年审")
	private String  vehiclenianshen;
	@ApiModelProperty(value = "驾驶员年审")
	private String  drivenianshen;
	@ApiModelProperty(value = "其他")
	private String  qita;
}
