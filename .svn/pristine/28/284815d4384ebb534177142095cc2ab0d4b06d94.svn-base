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
package org.springblade.doc.biaozhunhuamuban.vo;

import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.tool.node.INode;

import java.util.ArrayList;
import java.util.List;

/**
 * 视图实体类
 *
 * @author th
 * @since 2019-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BiaozhunhuamubanVO对象", description = "BiaozhunhuamubanVO对象")
public class BiaozhunhuamubanVO extends Biaozhunhuamuban implements INode {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键ID
	 */
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 下级文件数量
	 */
	@ApiModelProperty(value = "下级文件数")
	private Integer fileNum;

	/**
	 * 父节点ID
	 */
	@ApiModelProperty(value = "父节点idid")
	private Integer parentId;


	@ApiModelProperty(value = "层级编号")
	private String levelNumber;

	@ApiModelProperty(value = "图片列表")
	private List<String> imgList;

	@ApiModelProperty(value = "绑定来源(0是标准化文档，1是安全生产文档)")
	private Integer  docSource = 0;



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

	private String title;

}
