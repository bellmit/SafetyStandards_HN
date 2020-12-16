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
package org.springblade.anbiao.ranyoubutie.entity;

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
 * @author jx
 * @since 2019-10-16
 */
@Data
@TableName("baobiao_fueltotalreport")
@ApiModel(value = "Fueltotalreport对象", description = "Fueltotalreport对象")
public class Fueltotalreport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 燃油补贴id
     */
    @ApiModelProperty(value = "燃油补贴id")
    @TableId(value = "FId", type = IdType.AUTO)
  private Long id;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    @TableField("vehId")
  private String vehId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String company;
    /**
     * 车辆牌照
     */
    @ApiModelProperty(value = "车辆牌照")
    @TableField("chepaihao")
    private String chepaihao;
    /**
     * 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private String color;
    /**
     * 路线
     */
    @ApiModelProperty(value = "路线方案名")
    private String scheme;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime starttime;
    /**
     * 开始地区id
     */
    @ApiModelProperty(value = "开始地区id")
    @TableField("startAreaId")
  private Integer startAreaId;
    /**
     * 开始地区名字
     */
    @ApiModelProperty(value = "起始区域名")
    @TableField("sereaName")
  private String sereaName;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endtime;
    /**
     * 结束地区id
     */
    @ApiModelProperty(value = "结束地区id")
    @TableField("endAreaId")
  private Integer endAreaId;
    /**
     * 结束地区名字
     */
    @ApiModelProperty(value = "结束区域名")
    @TableField("eareaName")
  private String eareaName;
    /**
     * 持续时间
     */
    @ApiModelProperty(value = "持续时间")
    @TableField("keepTime")
  private Integer keepTime;
    /**
     * 座位数
     */
    @ApiModelProperty(value = "座位数")
    @TableField("seatNumber")
  private Integer seatNumber;
    /**
     * 地区等级
     */
    @ApiModelProperty(value = "地区等级")
    @TableField("regionLevel")
  private String regionLevel;


}
