/**
 * Copyright (C), 2015-2020,
 * FileName: 北斗Vehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/8/31
 * @描述
 */
@Data
@ApiModel(value = "QiYeAnBiaoMuLu对象", description = "QiYeAnBiaoMuLu对象")
public class QiYeAnBiaoMuLu implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "目录名称")
	private String name;

	@ApiModelProperty(value = "标准得分")
	private Integer score;

	@ApiModelProperty(value = "本次得分")
	private Integer nowscores;

	@ApiModelProperty(value = "目录ID")
	private String muluid;

}
