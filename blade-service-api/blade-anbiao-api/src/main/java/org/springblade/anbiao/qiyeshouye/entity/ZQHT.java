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
@ApiModel(value = "ZQHT对象", description = "ZQHT对象")
public class ZQHT implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "企业名称")
	private String deptName;

	@ApiModelProperty(value = "主题ID")
	private String zhutiid;

	@ApiModelProperty(value = "主题名称")
	private String zhutimingcheng;

	@ApiModelProperty(value = "主题正文")
	private String zhutizhengwen;

	@ApiModelProperty(value = "发起时间")
	private String faqishijian;

	@ApiModelProperty(value = "发起单位")
	private String fasongdanwei;

	@ApiModelProperty(value = "回复有效期")
	private String huifuyouxiaoqi;

	@ApiModelProperty(value = "状态")
	private String zhuangtai;

	@ApiModelProperty(value = "回复时间")
	private String huifushijian;

	@ApiModelProperty(value = "回复正文")
	private String huifuzhengwen;

	@ApiModelProperty(value = "回复者姓名")
	private String huifuzhename;


}
