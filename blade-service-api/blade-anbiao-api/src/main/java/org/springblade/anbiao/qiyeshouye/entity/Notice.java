/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.qiyeshouye.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 *
 * @author hyp
 */
@Data
@ApiModel(value = "Notice对象", description = "Notice对象")
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private Integer id;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
	private String createUser;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;

	/**
	 * 修改者
	 */
	@ApiModelProperty(value = "修改者")
	private String updateUser;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private String updateTime;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private Integer status;

	/**
	 * 状态展示
	 */
	@ApiModelProperty(value = "状态展示")
	private String statusShow;

	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer is_deleted;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;

	/**
	 * 通知类型
	 */
	@ApiModelProperty(value = "通知类型")
	private Integer category;

	/**
	 * 发布日期
	 */
	@ApiModelProperty(value = "发布日期")
	private Date releaseTime;

	/**
	 * 内容
	 */
	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private String tenantCode;


}
