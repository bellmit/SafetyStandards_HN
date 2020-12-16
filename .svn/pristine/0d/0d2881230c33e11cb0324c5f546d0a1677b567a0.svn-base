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
package org.springblade.alarm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-10-16
 */
@Data
@TableName("baobiao_driverbehaviorMG")
@ApiModel(value = "DriverbehaviorMG对象", description = "DriverbehaviorMG对象")
@Document(collection = "DriverbehaviorMG")
public class DriverbehaviorMG implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Long id;
    @TableField("AlarmNumber")
    private String AlarmNumber;
    @TableField("AlarmID")
    private Integer AlarmID;
    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private Integer cid;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String company;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    @TableField("VehID")
    private Integer VehID;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String plate;
    /**
     * 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private String color;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("FlagState")
    private String FlagState;
    /**
     * 报警类型
     */
    @ApiModelProperty(value = "报警类型")
    @TableField("AlarmType")
    private String AlarmType;
    /**
     * 报警等级
     */
    @ApiModelProperty(value = "报警等级")
    @TableField("Alarmlevel")
    private String Alarmlevel;
    /**
     * 速度
     */
    @ApiModelProperty(value = "速度")
    @TableField("Velocity")
    private Integer Velocity;
    /**
     * 海拔
     */
    @ApiModelProperty(value = "海拔")
    @TableField("High")
    private BigDecimal High;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    @TableField("Lon")
    private BigDecimal Lon;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    @TableField("Lat")
    private BigDecimal Lat;
    /**
     * gps设备时间
     */
    @ApiModelProperty(value = "gps设备时间")
    @TableField("GpsTime")
    private Long GpsTime;
    /**
     * 车辆状态
     */
    @ApiModelProperty(value = "车辆状态")
    @TableField("VehStatus")
    private String VehStatus;
    /**
     * 系统时间
     */
    @ApiModelProperty(value = "系统时间")
    @TableField("A_Time")
    private String aTime;
    @TableField("AlarmIDNumber")
    private String AlarmIDNumber;
    /**
     * 自编号
     */
    @ApiModelProperty(value = "自编号")
    @TableField("OwnNo")
    private String OwnNo;
    /**
     * 有无照片
     */
    @ApiModelProperty(value = "有无照片")
    @TableField("IsPicture")
    private Integer IsPicture;
    /**
     * 有无视频
     */
    @ApiModelProperty(value = "有无视频")
    @TableField("IsVideo")
    private Integer IsVideo;
    /**
     * 道路名称
     */
    @ApiModelProperty(value = "道路名称")
    @TableField("RoadName")
    private String RoadName;
    /**
     * 核定状态
     */
    @ApiModelProperty(value = "核定状态")
    @TableField("StateEx")
    private String StateEx;
    /**
     * 同步时间
     */
    @ApiModelProperty(value = "同步时间")
    @TableField("insertTime")
    private String insertTime;
    /**
     * 营运类型
     */
    @ApiModelProperty(value = "营运类型")
    @TableField("OperatType")
    private String OperatType;


    @ApiModelProperty(value = "处理/申诉人")
    private String chuliren;
    @ApiModelProperty(value = "处理/申诉人id")
    private Integer chulirenid;
    @ApiModelProperty(value = "处理/申诉时间")
    private String chulishijian;
    @ApiModelProperty(value = "处理状态")
    private String chulizhuangtai;
    @ApiModelProperty(value = "处理形式")
    private String chulixingshi;
    @ApiModelProperty(value = "处理描述")
    private String chulimiaoshu;
    @ApiModelProperty(value = "申诉状态")
    private String shensuzhuangtai;
    @ApiModelProperty(value = "申诉形式")
    private String shensuxingshi;
    @ApiModelProperty(value = "申诉描述")
    private String shensumiaoshu;
    @ApiModelProperty(value = "附件")
    private String fujian;
    @ApiModelProperty(value = "备注")
    private String beizhu;
    @ApiModelProperty(value = "排序号")
    private Integer orderNum;


}
