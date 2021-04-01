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
 * 应急预案-修订完善记录 实体类
 *
 * @author hyp
 * @since 2019-04-25
 */
@Data
@TableName("anbiao_yuanxiuding")
@ApiModel(value = "Yuanxiuding对象", description = "Yuanxiuding对象")
public class Yuanxiuding implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    /**
     * 应急预案id
     */
    @ApiModelProperty(value = "应急预案id")
    private String yuanid;
    /**
     * 应急预案名称
     */
    @ApiModelProperty(value = "应急预案名称")
    private String yuanmingcheng;
    /**
     * 修改依据
     */
    @ApiModelProperty(value = "修改依据")
    private String xiugaiyiju;
    /**
     * 修改条款
     */
    @ApiModelProperty(value = "修改条款")
    private String xiugaitiaokuan;
    /**
     * 修订时间
     */
    @ApiModelProperty(value = "修订时间")
    private LocalDateTime xiudingshijian;
    /**
     * 批准人
     */
    @ApiModelProperty(value = "批准人")
    private String pizhunren;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isdel = 0;


}
