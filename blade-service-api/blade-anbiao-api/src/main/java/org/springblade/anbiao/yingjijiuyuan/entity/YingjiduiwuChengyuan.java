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

/**
 * 应急救援-应急队伍-队伍成员 实体类
 *
 * @author hyp
 * @since 2019-04-29
 */
@Data
@TableName("anbiao_yingjiduiwu_chengyuan")
@ApiModel(value = "YingjiduiwuChengyuan对象", description = "YingjiduiwuChengyuan对象")
public class YingjiduiwuChengyuan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 应急队伍id
     */
    @ApiModelProperty(value = "应急队伍id")
    private String duiwuid;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String bumen;
    /**
     * 成员姓名
     */
    @ApiModelProperty(value = "成员姓名")
    private String xingming;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    private String zhiwu;
    /**
     * 应急救援职责
     */
    @ApiModelProperty(value = "应急救援职责")
    private String zhize;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String dianhua;
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
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isdel = 0;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
