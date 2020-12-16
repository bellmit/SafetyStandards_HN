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
package org.springblade.anbiao.jiaoyupeixun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-04-25
 */
@Data
@TableName("anbiao_jiaoyupeixun")
@ApiModel(value = "Jiaoyupeixun对象", description = "Jiaoyupeixun对象")
public class Jiaoyupeixun implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键ID")
    private String id;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID",required = true)
    private Integer deptId;
    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    /**
     * 操作人ID
     */
    @ApiModelProperty(value = "操作人ID")
    private Integer caozuorenid;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;
    /**
     * 主题
     */
    @ApiModelProperty(value = "主题")
    private String zhuti;
    /**
     * 培训类型
     */
    @ApiModelProperty(value = "培训类型")
    private String peixunleixing;
    /**
     * 组织单位
     */
    @ApiModelProperty(value = "组织单位")
    private String zuzhibumen;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String fuzeren;
    /**
     * 学习形式
     */
    @ApiModelProperty(value = "学习形式")
    private String xuexixingshi;
    /**
     * 学习日期
     */
    @ApiModelProperty(value = "学习日期")
    private String xuexiriqi;
    /**
     * 学时
     */
    @ApiModelProperty(value = "学时")
    private String xueshi;
    /**
     * 主持人
     */
    @ApiModelProperty(value = "主持人")
    private String zhuchiren;
    /**
     * 应到人数
     */
    @ApiModelProperty(value = "应到人数")
    private String yingdaorenshu;
    /**
     * 实到人数
     */
    @ApiModelProperty(value = "实到人数")
    private String shidaorenshu;
    /**
     * 计划开始时间
     */
    @ApiModelProperty(value = "计划开始时间", required = true)
    private String jihuakaishishijian;
    /**
     * 培训费用
     */
    @ApiModelProperty(value = "培训费用")
    private String peixunfeiyong;
    /**
     * 考核单位
     */
    @ApiModelProperty(value = "考核单位")
    private String kaohedanwei;
    /**
     * 学习内容
     */
    @ApiModelProperty(value = "学习内容")
    private String xuexineirong;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
    /**
     * 学习照片
     */
    @ApiModelProperty(value = "学习照片")
    private String xuexizhaopian;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isdelete;

	/**
	 * 计划内容
	 */
	@ApiModelProperty(value = "计划内容")
	private String jihuaneirong;
	/**
	 * 计划是否完成
	 */
	@ApiModelProperty(value = "计划是否完成", required = true)
	private String jihuashifouwancheng;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
