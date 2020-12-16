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

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author th
 * @since 2019-05-10
 */
@Data
@TableName("anbiao_biaozhunhuawenjian")
@ApiModel(value = "Biaozhunhuawenjian对象", description = "Biaozhunhuawenjian对象")
public class Biaozhunhuawenjian implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
    /**
     * 标准化模板id
     */
    @ApiModelProperty(value = "标准化模板id")
    private Integer biaozhunhuamubanId;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Integer deptId;
    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private Integer caozuorenid;
    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createtime;
    /**
     * 文件类型(1doc文件,2pdf文件,3图片文件夹)
     */
    @ApiModelProperty(value = "文件类型(1doc文件,2pdf文件,3图片文件夹)")
    @TableField("fileType")
  private Integer fileType;
    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String path;



	@ApiModelProperty(value = "是否删除")
	@TableLogic
	private Integer isDeleted;

	/**
	 * 累积访问次数
	 */
	@ApiModelProperty(value = "累积访问次数")
	private  Integer cumulativeVisits;

	/**
	 * 最后访问时间
	 */
	@ApiModelProperty(value = "最后访问时间")
	private  String lastPreviewTime;
}
