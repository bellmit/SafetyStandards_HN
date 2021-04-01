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
package org.springblade.anbiao.baobiaowenjian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类
 *
 * @author hyp
 * @since 2019-05-16
 */
@Data
@TableName("baobiao_baobiaowenjian")
@ApiModel(value = "BaobiaoWenjian对象", description = "BaobiaoWenjian对象")
public class BaobiaoWenjian implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标准化模板id
     */
    @ApiModelProperty(value = "标准化模板id")
    private Long muluid;
    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private Integer deptId;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    @TableField(exist = false)
    private String deptName;
    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    /**
     * 文件类型(1doc文件,2pdf文件,3图片文件夹,4excel文件)
     */
    @ApiModelProperty(value = "文件类型(1doc文件,2pdf文件,3图片文件夹,4excel文件)")
    @TableField("fileType")
    private Integer fileType;
    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String path;
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
    private LocalDateTime caozuoshijian;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;
    /**
     * 是否删除  0为否 1为是
     */
    @ApiModelProperty(value = "是否删除  0为否 1为是")
    private Integer isDeleted;
}
