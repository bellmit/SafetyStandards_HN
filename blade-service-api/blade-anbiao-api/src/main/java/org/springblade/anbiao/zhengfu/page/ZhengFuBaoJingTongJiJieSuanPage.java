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
 * @创建时间 2020/6/20
 * @描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ZhengFuBaoJingTongJiJieSuanPage对象", description = "ZhengFuBaoJingTongJiJieSuanPage对象")
public class ZhengFuBaoJingTongJiJieSuanPage<T> extends BasePage<T> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "deptId")
	private String deptId;

	@ApiModelProperty(value = "deptName")
	private String deptName;

	@ApiModelProperty(value = "开始时间", required = true)
	private String begintime;

	@ApiModelProperty(value = "结束时间", required = true)
	private String endtime;

	@ApiModelProperty(value = "xiaJiDeptId")
	private String xiaJiDeptId;

	@ApiModelProperty(value = "是否处理('',未处理，已处理)")
	private String shifouchuli;

	@ApiModelProperty(value = "是否申诉('',未申诉，已申诉)")
	private String shifoushenshu;

	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

	@ApiModelProperty(value = "营运类型")
	private String shiyongxingzhi;

	@ApiModelProperty(value = "报警类型")
	private String alarmtype;

	@ApiModelProperty(value = "排序字段")
	private String orderColumns;

	@ApiModelProperty(value = "区分地区、企业报警排名")
	private String leiXing;

	@ApiModelProperty(value = "政府ID ")
	private String zhengfuid;

	@ApiModelProperty(value = "省ID ")
	private String province;

	@ApiModelProperty(value = "市ID ")
	private String city;

	@ApiModelProperty(value = "县ID ")
	private String country;

}
