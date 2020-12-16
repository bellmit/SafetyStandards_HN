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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 实体类
 *
 * @author elvis.he
 * @since 2019-05-16
 */
@Data
@TableName("baobiao_baobiaomulu")
@ApiModel(value = "BaobiaoMulu对象", description = "BaobiaoMulu对象")
public class BaobiaoMulu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 上级id
     */
    @ApiModelProperty(value = "上级id")
    private Integer parentId;
    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private Integer deptId;
    @ApiModelProperty(value = "企业名称")
    @TableField(exist = false)
    private String deptName;
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
     * 文件物理路径
     */
    @ApiModelProperty(value = "文件物理路径")
    private String path;
    /**
     * 排序号
     */
    @ApiModelProperty(value = "排序号")
    private Integer sort;
    /**
     * 所在层级
     */
    @ApiModelProperty(value = "文件属性（1日报、2周报、3月报、4年报）")
    private Integer property;
    @ApiModelProperty(value = "操作人id")
    private Integer caozuorenid;
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    @ApiModelProperty(value = "操作时间")
    private LocalDateTime caozuoshijian;

    @ApiModelProperty(value = "报警处理率")
    private String processRate;
    /**
     * 统计日期
     */
    @ApiModelProperty(value = "监控日期（日报:年-月-日，其它：年/月/日 - 年/月/日")
    private String countdate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;
    @TableField(value = "is_deleted")
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;
    @TableField(value = "is_handled")
    @ApiModelProperty(value = "是否处理  0为否 1为是")
    private Integer isHandled;
    @ApiModelProperty(value = "处理人")
    private String handledUser;
    @ApiModelProperty(value = "处理时间")
    private LocalDateTime handledTime;
    @ApiModelProperty(value = "累计访问次数")
    private Integer cumulativeVisits;


    @ApiModelProperty(value = "最后访问时间")
    private String lastPreviewTime;
}
