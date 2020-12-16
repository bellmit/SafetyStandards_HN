/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/10/22
 * @描述
 */
@Data
@TableName("tts_message")
@ApiModel(value = "TTSMessageInfo对象", description = "TTSMessageInfo对象")
public class TtsMessageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Integer id;

	@ApiModelProperty(value = "时间")
	private String time;

	@ApiModelProperty(value = "内容")
	private String message;

	@ApiModelProperty(value = "类型")
	private String messageType;

	@ApiModelProperty(value = "速度")
	private String LastSpeed;

}
