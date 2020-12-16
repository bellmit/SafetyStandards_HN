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
 * 应急救援-应急预案 实体类
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_yingjiyuan")
@ApiModel(value = "Yingjiyuan对象", description = "Yingjiyuan对象")
public class Yingjiyuan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "企业 名称")
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
    @ApiModelProperty(value = "年度 ")
    private Integer niandu;
    /**
     * 预案名称
     */
    @ApiModelProperty(value = "预案名称")
    private String yuanmingcheng;
    /**
     * 预案类型
     */
    @ApiModelProperty(value = "预案类型")
    private String yuanleixing;
    /**
     * 预案编号
     */
    @ApiModelProperty(value = "预案编号")
    private String yuanbianhao;
    /**
     * 批准时间
     */
    @ApiModelProperty(value = "批准时间")
    private LocalDateTime pizhunshijian;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String banbenhao;
    /**
     * 预案有效期
     */
    @ApiModelProperty(value = "预案有效期")
    private LocalDateTime yuanyouxiaoqi;
    /**
     * 预案级别
     */
    @ApiModelProperty(value = "预案级别")
    private String yuanjibie;
    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用(0:启用，1停用)")
    private Integer shifouqiyong;
    /**
     * 预案内容
     */
    @ApiModelProperty(value = "预案内容")
    private String yuanneirong;
    /**
     * 现场处置要点
     */
    @ApiModelProperty(value = "现场处置要点")
    private String xianchangchuzhiyaodian;
    /**
     * 应急队伍保障
     */
    @ApiModelProperty(value = "应急队伍保障")
    private String yingjiduiwubaozhang;
    /**
     * 其他保障
     */
    @ApiModelProperty(value = "其他保障")
    private String qitabaozhang;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isdel = 0;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
