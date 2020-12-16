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
package org.springblade.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.mp.base.TenantEntity;

/**
 * 实体类
 */
@Data
@TableName("blade_user")
@EqualsAndHashCode(callSuper = true)
public class User extends TenantEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Integer id;

	/**
	 * 账号
	 */
	@ApiModelProperty(value = "登录账号")
	private String account;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(value = "昵称")
	private String name;
	/**
	 * 真名
	 */
	@ApiModelProperty(value = "真名")
	private String realName;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;
	/**
	 * 手机
	 */
	@ApiModelProperty(value = "联系电话")
	private String phone;
	/**
	 * 生日
	 */
	@ApiModelProperty(value = "生日")
	private String birthday;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别 1/男 2/女")
	private Integer sex;
	/**
	 * 角色id
	 */
	@ApiModelProperty(value = "角色id")
	private String roleId;
	/**
	 * 机构id
	 */
	@ApiModelProperty(value = "机构id")
	private String deptId;
	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private String postId;
	/**
	 * 微信openid
	 */
	@ApiModelProperty(value = "微信openid")
	private String openid;

	/**
	 * 机构名称
	 */
	@ApiModelProperty(value = "所属单位")
	private String deptName;
	/**
	 * 岗位名称
	 */
	@ApiModelProperty(value = "岗位名称")
	private String postName;

	/**
	 * 地区
	 */
	@ApiModelProperty(value = "地区")
	private String areaname;

	/**
	 * 标题名称
	 */
	@ApiModelProperty(value = "标题名称")
	private String mingcheng;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTimes;

	/**
	 * 操作时间
	 */
	@ApiModelProperty(value = "操作时间")
	private String updateTimes;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private String zhuangtai;

	/**
	 * 机构id
	 */
	@ApiModelProperty(value = "机构id")
	private String jigouid;

	/**
	 * 部门id
	 */
	@ApiModelProperty(value = "部门id")
	private String bumenid;

	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private String gangweiid;
}
