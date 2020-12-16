/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 */
package org.springblade.anbiao.cheliangguanli.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import org.springblade.anbiao.cheliangguanli.entity.Chelianganquanshebei;

/**
 * 视图实体类
 * @author 呵呵哒
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ChelianganquanshebeiVO对象", description = "ChelianganquanshebeiVO对象")
public class ChelianganquanshebeiVO extends Chelianganquanshebei {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;
}
