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
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("anbiao_biaozhunhuamuban")
@ApiModel(value = "Biaozhunhuamuban对象", description = "Biaozhunhuamuban对象")
public class Biaozhunhuamuban implements Serializable {

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
	 * 类型（文件，目录，记录..）
	 */
	@ApiModelProperty(value = "类型（文件，目录，记录..）")
	private String type;
	/**
	 * 物理路径
	 */
	@ApiModelProperty(value = "物理路径")
	private String path;
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
	private Integer caozuorenid;
	private String caozuoren;
	private String caozuoshijian;

	@ApiModelProperty(value = "是否删除")
	@TableLogic
	private Integer isDeleted;

	@ApiModelProperty(value = "文件性质(法律法规,规章制度,操作规程....)")
	private String fileProperty;

	@ApiModelProperty(value = "安标性质(安标16项及子项分类)")
	private String anbiaoProperty;

	@ApiModelProperty(value = "文件所属人id")
	private Integer fileSuoshurenId;


	@ApiModelProperty(value = "文档编号")
	private String documentNumber;

	@ApiModelProperty(value = "模板路径")
	private String mubanPath;

	@ApiModelProperty(value = "是否编辑")
	private Integer isEdit;

	@ApiModelProperty(value = "运营类型")
	private Integer yunyingleixing;

	@ApiModelProperty(value = "累计访问次数")
	private Integer cumulativeVisits;


	@ApiModelProperty(value = "最后访问时间")
	private String lastPreviewTime;

}
