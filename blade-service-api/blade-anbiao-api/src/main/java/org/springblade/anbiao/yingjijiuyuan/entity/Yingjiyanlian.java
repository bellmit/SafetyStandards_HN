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
 * 应急演练 实体类
 *
 * @author hyp
 * @since 2019-04-26
 */
@Data
@TableName("anbiao_yingjiyanlian")
@ApiModel(value = "应急演练对象", description = "应急演练对象")
public class Yingjiyanlian implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
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
     * 演练计划id
     */
    @ApiModelProperty(value = "演练计划id")
    private String jihuaid;
    /**
     * 应急演练计划
     */
    @ApiModelProperty(value = "应急演练计划")
    private String jihua;
    /**
     * 组织部门
     */
    @ApiModelProperty(value = "组织部门")
    private String zuzhibumen;
    /**
     * 参加部门单位
     */
    @ApiModelProperty(value = "参加部门单位")
    private String canjiabumen;
    /**
     * 参加人员
     */
    @ApiModelProperty(value = "参加人员")
    private String canjiarenyuan;
    /**
     * 演练过程
     */
    @ApiModelProperty(value = "演练过程")
    private String yanlianguocheng;
    /**
     * 效果评估
     */
    @ApiModelProperty(value = "效果评估")
    private String xiaoguopinggu;
    /**
     * 问题措施
     */
    @ApiModelProperty(value = "问题措施")
    private String wenticuoshi;
    /**
     * 演练照片
     */
    @ApiModelProperty(value = "演练照片")
    private String yanlianzhaopian;
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
