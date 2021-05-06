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
package org.springblade.doc.biaozhunhuamuban.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author th
 * @since 2019-05-04
 */
@Data
@ApiModel(value = "BiaozhunhuamubanList对象", description = "BiaozhunhuamubanList对象")
public class BiaozhunhuamubanList implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	@TableId(value = "id", type = IdType.INPUT)
	private Integer id;
	/**
	 * 上级id
	 */
	@ApiModelProperty(value = "上级id")
	private Integer parentId;
	/**
	 * 单位id
	 */
	@ApiModelProperty(value = "单位id")
	private Integer deptId;
	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 排序号
	 */
	@ApiModelProperty(value = "排序号")
	private Integer sort;
	/**
	 * 所在层级
	 */
	@ApiModelProperty(value = "所在层级")
	private String tier;

	@ApiModelProperty(value = "运营类型")
	private Integer yunyingleixing;

	@ApiModelProperty(value = "上传文件信息提示")
	private String remark;

	@ApiModelProperty(value = "分值")
	private Integer score;

	@ApiModelProperty(value = "当前分值")
	private Integer nowscores;

	@ApiModelProperty(value = "星级")
	private Integer starlevel;

	@ApiModelProperty(value = "总分")
	private Integer totalpoints;

	@ApiModelProperty(value = "一级名称")
	private String parentName;

	@ApiModelProperty(value = "二级名称")
	private String erparentName;

//	@ApiModelProperty(value = "下级list")
//	private List<BiaozhunhuamubanList> childrenList;
}
