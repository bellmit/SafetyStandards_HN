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
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author th
 * @since 2019-05-07
 */
@Data
@TableName("anbiao_template")
@ApiModel(value = "Template对象", description = "Template对象")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id主键
     */
    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 上传单位id
     */
    @ApiModelProperty(value = "上传单位id")
    private Integer deptId;


	/**
	 * 上传单位名称
	 */
	@ApiModelProperty(value = "上传单位名称")
	private String deptName;

    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private Integer caozuorenid;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "操作时间")
	private String createtime;


	/**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称")
    private String templateName;
    /**
     * 模板路径
     */
    @ApiModelProperty(value = "模板路径")
    private String templatePath;
    /**
     * 是否公开
     */
    @ApiModelProperty(value = "是否公开")
    private Integer isPublic;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;


}
