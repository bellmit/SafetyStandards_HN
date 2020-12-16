/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTiPage
 * Author:   呵呵哒
 * Date:     2020/6/20 16:14
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/30
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "QiYeTongJiPage对象", description = "QiYeTongJiPage对象")
public class QiYeTongJiPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业ID", required = true)
	private Integer deptId;

	@ApiModelProperty(value = "开始时间", required = true)
	private String beginTime;

	@ApiModelProperty(value = "结束时间", required = true)
	private String endTime;

	@ApiModelProperty(value = "是否处理('',未处理，已处理)")
	private String shifouchuli;

	@ApiModelProperty(value = "是否申诉('',未申诉，已申诉)")
	private String shifoushenshu;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "报警类型")
	private String alarmtype;

	@ApiModelProperty(value = "使用性质")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

}
