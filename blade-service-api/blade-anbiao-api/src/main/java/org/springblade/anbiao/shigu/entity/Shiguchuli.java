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
package org.springblade.anbiao.shigu.entity;

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
 * @author Blade
 */
@Data
@TableName("anbiao_shiguchuli")
@ApiModel(value = "Shiguchuli对象", description = "Shiguchuli对象")
public class Shiguchuli implements Serializable {

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
     * 事故报告id
     */
    @ApiModelProperty(value = "事故报告id")
    private String shigubaogaoid;
    /**
     * 人员伤亡和财产损失情况
     */
    @ApiModelProperty(value = "人员伤亡和财产损失情况")
    private String shangwangcaichansunshi;
    /**
     * 事故原因
     */
    @ApiModelProperty(value = "事故原因")
    private String shiguyuanyin;
    /**
     * 事故上报及续报情况
     */
    @ApiModelProperty(value = "事故上报及续报情况")
    private String shigushangbaoqingkuang;
    /**
     * 责任倒查情况
     */
    @ApiModelProperty(value = "责任倒查情况")
    private String zerendaochaqingkuang;
    /**
     * 事故责任人处罚情况
     */
    @ApiModelProperty(value = "事故责任人处罚情况")
    private String zerenrenchufaqingkuang;
    /**
     * 事故处理措施和落实情况
     */
    @ApiModelProperty(value = "事故处理措施和落实情况")
    private String chulicuoshiluoshiqingkuang;
    /**
     * 责任人教育情况
     */
    @ApiModelProperty(value = "责任人教育情况")
    private String zerenrenjiaoyuqingkuang;
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
