/**
 * Copyright (C), 2015-2020
 * FileName: YuJingXiangRecord
 * Author:   呵呵哒
 * Date:     2020/12/13 16:33
 * Description:
 */
package org.springblade.anbiao.jinritixing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/12/13
 * @描述
 */
@Data
@TableName("anbiao_yujingxiang_record")
@ApiModel(value = "YuJingXiangRecord对象", description = "YuJingXiangRecord对象")
public class YuJingXiangRecord implements Serializable {

	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	@TableId(value = "ID", type = IdType.UUID)
	private String id;

	/**
	 * 预警项ID
	 */
	@ApiModelProperty(value = "预警项ID")
	private String yujingxiangid;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private String dept_id;

	/**
	 * 操作时间
	 */
	@ApiModelProperty(value = "操作时间")
	private String updatetime;

	/**
	 * 规定时间
	 */
	@ApiModelProperty(value = "规定时间")
	private String time;

}
