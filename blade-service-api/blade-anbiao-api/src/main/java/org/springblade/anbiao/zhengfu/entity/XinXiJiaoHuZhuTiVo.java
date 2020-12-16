/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTi
 */
package org.springblade.anbiao.zhengfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @描述
 */
@Data
@TableName("anbiao_xinxijiaohuzhutibiao")
@ApiModel(value = "XinXiJiaoHuZhuTiVo对象", description = "XinXiJiaoHuZhuTiVo对象")
public class XinXiJiaoHuZhuTiVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 单位名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;

	/**
	 * 单位ID
	 */
	@ApiModelProperty(value = "单位ID")
	private String deptId;
}
