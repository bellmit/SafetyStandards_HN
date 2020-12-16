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
package org.springblade.anbiao.anquanmubiao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 安全工作方针与目标实体类
 *
 * @author elvis.he
 * @since 2019-04-28
 */
@Data
@TableName("anbiao_fangzhenmubiao")
@ApiModel(value = "Fangzhenmubiao对象", description = "Fangzhenmubiao对象")
public class Fangzhenmubiao implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    @TableField("dept_id")
    private Integer deptId;
    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    @TableField(exist = false)
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
     * 年度
     */
    @ApiModelProperty(value = "年度")
    private Integer niandu;
    /**
     * 制定日期
     */
    @ApiModelProperty(value = "制定日期")
    private LocalDateTime zhidingriqi;
    /**
     * 方针名称
     */
    @ApiModelProperty(value = "方针名称")
    private String mingcheng;
    /**
     * 重大以上安全事故数
     */
    @ApiModelProperty(value = "重大以上安全事故数")
    private Integer shigushu = 0;
    /**
     * 年度责任事故死亡率（人/百万车公里）
     */
    @ApiModelProperty(value = "年度责任事故死亡率（人/百万车公里）")
    private BigDecimal siwanglv = new BigDecimal(0);
    /**
     * 人员受伤率（人/百万车公里）
     */
    @ApiModelProperty(value = "人员受伤率（人/百万车公里）")
    private BigDecimal shoushanglv = new BigDecimal(0);
    /**
     * 年度责任事故率（人/百万车公里）
     */
    @ApiModelProperty(value = "年度责任事故率（人/百万车公里）")
    private BigDecimal shigulv = new BigDecimal(0);
    /**
     * 财产损失
     */
    @ApiModelProperty(value = "财产损失")
    private BigDecimal caichansunshi = new BigDecimal(0);
    /**
     * 方针内容
     */
    @ApiModelProperty(value = "方针内容")
    private String neirong;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;
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
