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
package org.springblade.system.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.tool.node.INode;
import org.springblade.system.entity.Dept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 视图实体类
 *
 * @author Chill
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DeptVO对象", description = "DeptVO对象")
public class DeptVO extends Dept implements INode {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 父节点ID
	 */
	private Integer parentId;

	/**
	 * 子孙节点
	 */
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<INode> children;

	@Override
	public List<INode> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		return this.children;
	}

	/**
	 * 上级部门
	 */
	private String parentName;

	private String label;

	private String treeCode;

	private String extendType;

	private String title;

	private Integer value;

	private Integer key;

	/**
	 * 是否存在下级
	 */
	@ApiModelProperty(value = "是否存在下级(1 存在 0不存在)")
	private Integer existChild;

	/**
	 * 登录页附件
	 */
	@ApiModelProperty(value = "login页附件")
	@TableField(exist = false)
	private String loginPhoto;

	/**
	 * home页附件
	 */
	@ApiModelProperty(value = "home页附件")
	@TableField(exist = false)
	private String homePhoto;
	/**
	 * 简介页附件
	 */
	@ApiModelProperty(value = "简介页附件")
	@TableField(exist = false)
	private String profilePhoto;

	/**
	 * 登录页附件
	 */
	@ApiModelProperty(value = "login页附件(app)")
	@TableField(exist = false)
	private String loginPhotoApp;
	/**
	 * home页附件
	 */
	@ApiModelProperty(value = "home页附件(app)")
	@TableField(exist = false)
	private String homePhotoApp;
	/**
	 * 简介页附件
	 */
	@ApiModelProperty(value = "简介页附件(app)")
	@TableField(exist = false)
	private String profilePhotoApp;


}
