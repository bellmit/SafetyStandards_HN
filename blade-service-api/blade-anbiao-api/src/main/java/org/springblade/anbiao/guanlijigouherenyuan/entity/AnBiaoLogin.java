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
package org.springblade.anbiao.guanlijigouherenyuan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author Blade
 * @since 2020-09-09
 */
@Data
@TableName("anbiao_login")
@ApiModel(value = "AnBiaoLogin对象", description = "AnBiaoLogin对象")
public class AnBiaoLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
//	@TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 项目一
     */
    @ApiModelProperty(value = "项目一")
    private Integer project_one;

    /**
     * 项目二
     */
    @ApiModelProperty(value = "项目二")
    private Integer project_two;

	/**
	 * 项目三
	 */
	@ApiModelProperty(value = "项目三")
	private Integer project_three;

	/**
	 * 项目一
	 */
	@ApiModelProperty(value = "项目一")
	private Integer projectOne;

	/**
	 * 项目二
	 */
	@ApiModelProperty(value = "项目二")
	private Integer projectTwo;

	/**
	 * 项目三
	 */
	@ApiModelProperty(value = "项目三")
	private Integer projectThree;

    /**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createtime;

	/**
	 * 账号
	 */
	@ApiModelProperty(value = "账号",required = true)
	private String name;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码",required = true)
	private String password;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型",required = true)
	@TableField(exist = false)
	private String type;

}
