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
package org.springblade.anbiao.guanlijigouherenyuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类
 */
@Data
@TableName("anbiao_anquanhuiyi")
@ApiModel(value = "Anquanhuiyi对象", description = "Anquanhuiyi对象")
public class Anquanhuiyi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value = "id",type = IdType.UUID)
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Integer deptId;
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
     * 会议名称
     */
    @ApiModelProperty(value = "会议名称")
    private String huiyimingcheng;
    /**
     * 会议编号
     */
    @ApiModelProperty(value = "会议编号")
    private String huiyibianhao;
    /**
     * 会议类型
     */
    @ApiModelProperty(value = "会议类型")
    private String huiyileixing;
    /**
     * 会议形式
     */
    @ApiModelProperty(value = "会议形式")
    private String huiyixingshi;
    /**
     * 会议日期
     */
    @ApiModelProperty(value = "会议日期")
    private LocalDateTime huiyiriqi;
    /**
     * 主持人
     */
    @ApiModelProperty(value = "主持人")
    private String zhuchiren;
    /**
     * 记录人
     */
    @ApiModelProperty(value = "记录人")
    private String jiluren;
    /**
     * 会议地点
     */
    @ApiModelProperty(value = "会议地点")
    private String huiyididian;
    /**
     * 会议开始时间
     */
    @ApiModelProperty(value = "会议开始时间", required = true)
    private LocalDateTime huiyikaishishijian;
    /**
     * 会议结束时间
     */
    @ApiModelProperty(value = "会议结束时间")
    private LocalDateTime huiyijieshushijian;
    /**
     * 会议内容
     */
    @ApiModelProperty(value = "会议内容")
    private String huiyineirong;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
    /**
     * 会议照片
     */
    @ApiModelProperty(value = "会议照片")
    private String huiyizhaopian;

	/**
	 * 逻辑删除
	 */
	@ApiModelProperty(value = "逻辑删除")
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
