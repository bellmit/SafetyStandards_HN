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
package org.springblade.anbiao.yingjijiuyuan.entity;

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
 * @since 2019-04-25
 */
@Data
@TableName("anbiao_yuanpingshen")
@ApiModel(value = "Yuanpingshen对象", description = "Yuanpingshen对象")
public class Yuanpingshen implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    /**
     * 预案id
     */
    @ApiModelProperty(value = "预案id")
    private String yuanid;
    /**
     * 评审项目
     */
    @ApiModelProperty(value = "评审项目")
    private String pingshenxiangmu;
    /**
     * 评审类型
     */
    @ApiModelProperty(value = "评审类型")
    private String pingshenleixing;
    /**
     * 评审时间
     */
    @ApiModelProperty(value = "评审时间")
    private LocalDateTime pingshenshijian;
    /**
     * 评审人
     */
    @ApiModelProperty(value = "评审人")
    private String pingshenren;
    /**
     * 评审意见
     */
    @ApiModelProperty(value = "评审意见")
    private String pingshenyijian;
    /**
     * 评审内容及要求
     */
    @ApiModelProperty(value = "评审内容及要求")
    private String pingshenneirong;
    /**
     * 演练整改措施
     */
    @ApiModelProperty(value = "演练整改措施")
    private String zhenggaicuoshi;
    /**
     * 完善意见
     */
    @ApiModelProperty(value = "完善意见")
    private String yijian;
    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isdel = 0;
}
