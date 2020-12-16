package org.springblade.anbiao.jiashiyuan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.jiashiyuan.entity.JiaShiYuan;

/**
 * Created by you on 2019/4/22.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "JiaShiYuanVO对象", description = "JiaShiYuanVO对象")
public class JiaShiYuanVO extends JiaShiYuan{

	private static final long serialVersionUID = 1L;

	/**
	 * 单位名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;

	/**
	 * 车辆牌照
	 */
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;

	/**
	 * 使用性质
	 */
	@ApiModelProperty(value = "使用性质")
	private String shiyongxingzhi;

	/**
	 * 车牌颜色
	 */
	@ApiModelProperty(value = "车牌颜色")
	private String chepaiyanse;

	/**
	 * 是否绑定标识
	 */
	@ApiModelProperty(value = "是否绑定标识")
	private String biaoshi;

}
