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
@TableName("baobiao_alarmsummary_cutofftime")
@ApiModel(value = "AlarmsummaryCutofftime对象", description = "AlarmsummaryCutofftime对象")
@Document(collection = "AlarmsummaryCutofftimeMG")
public class AlarmsummaryCutofftimeMG implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报警id
     */
    @ApiModelProperty(value = "报警id")
    @TableId("AlarmReportID")
    @Id
    private Long AlarmReportID;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    @TableField("VehId")
    private Integer VehId;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @TableField("BeginTime")
    private Long BeginTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @TableField("EndTime")
    private Long EndTime;
    /**
     * 最大速度
     */
    @ApiModelProperty(value = "最大速度")
    @TableField("MaxSpeed")
    private Integer MaxSpeed;
    /**
     * 报警类型
     */
    @ApiModelProperty(value = "报警类型")
    @TableField("AlarmType")
    private String AlarmType;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    @TableField("Longitude")
    private BigDecimal Longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    @TableField("Latitude")
    private BigDecimal Latitude;
    /**
     * 速度
     */
    @ApiModelProperty(value = "速度")
    @TableField("Velocity")
    private Integer Velocity;
    /**
     * 角度
     */
    @ApiModelProperty(value = "角度")
    @TableField("Angle")
    private Integer Angle;
    /**
     * 是否定位
     */
    @ApiModelProperty(value = "是否定位")
    @TableField("Local")
    private Integer Local;
    @TableField("Elevation")
    private BigDecimal Elevation;
    /**
     * 限速
     */
    @ApiModelProperty(value = "限速")
    @TableField("Limited")
    private Integer Limited;
    /**
     * 核定状态
     */
    @ApiModelProperty(value = "核定状态")
    @TableField("Passed")
    private Integer Passed;
    /**
     * 系统时间
     */
    @ApiModelProperty(value = "系统时间")
    @TableField("Time")
    private String Time;
    /**
     * 持续时间
     */
    @ApiModelProperty(value = "持续时间")
    @TableField("KeepTime")
    private Integer KeepTime;
    /**
     * 道路名称
     */
    @ApiModelProperty(value = "道路名称")
    @TableField("Road_Name")
    private String roadName;
    /**
     * 道路等级
     */
    @ApiModelProperty(value = "道路等级")
    @TableField("Road_Level")
    private String roadLevel;
    /**
     * 道路限速
     */
    @ApiModelProperty(value = "道路限速")
    @TableField("Road_Limited")
    private Integer roadLimited;
    /**
     * gps核定账号
     */
    @ApiModelProperty(value = "gps核定账号")
    @TableField("DisposeAlarmName")
    private String DisposeAlarmName;
    /**
     * gps核定时间
     */
    @ApiModelProperty(value = "gps核定时间")
    @TableField("DisposeAlarmTime")
    private String DisposeAlarmTime;
    /**
     * 处理方式
     */
    @ApiModelProperty(value = "处理方式")
    private String alarmcl;
    /**
     * 处理信息
     */
    @ApiModelProperty(value = "处理信息")
    private String alarmclmsg;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String alarmhdremark;
    /**
     * 推送状态
     */
    @ApiModelProperty(value = "推送状态")
    @TableField("PushState")
    private Integer PushState;
    /**
     * 核定人
     */
    @ApiModelProperty(value = "核定人")
    @TableField("verifyName")
    private String verifyName;
    /**
     * 核定时间
     */
    @ApiModelProperty(value = "核定时间")
    @TableField("verifyTime")
    private String verifyTime;
    /**
     * 平台1终端0
     */
    @ApiModelProperty(value = "平台1终端0")
    @TableField("AnalyzeMode")
    private Integer AnalyzeMode;
    @TableField("SysPassed")
    private Integer SysPassed;
    /**
     * 是否严重报警
     */
    @ApiModelProperty(value = "是否严重报警")
    private Integer status;
    /**
     * 同步入库时间
     */
    @ApiModelProperty(value = "同步入库时间")
    @TableField("SynTime")
    private String SynTime;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    @TableField("plateNumber")
    private String plateNumber;
    /**
     * 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private String color;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String company;
    /**
     * 营运类型
     */
    @ApiModelProperty(value = "营运类型")
    @TableField("OperatType")
    private String OperatType;
    /**
     * 结束速度
     */
    @ApiModelProperty(value = "结束速度")
    @TableField("EndSpeed")
    private Integer EndSpeed;
    /**
     * 移动距离
     */
    @ApiModelProperty(value = "移动距离")
    @TableField("Distance")
    private Integer Distance;
    /**
     * 道路限速2
     */
    @ApiModelProperty(value = "道路限速2")
    @TableField("Road_Limited2")
    private Integer roadLimited2;
    @TableField("IsSupplements")
    private Integer IsSupplements;
    /**
     * 推送时间
     */
    @ApiModelProperty(value = "推送时间")
    @TableField("CutoffTime")
    private Long CutoffTime;
    /**
     * 二次核定时间
     */
    @ApiModelProperty(value = "二次核定时间")
    @TableField("verifyTime2")
    private String verifyTime2;
    /**
     * gps报警id
     */
    @ApiModelProperty(value = "gps报警id")
    @TableField("AlarmID")
    private Long AlarmID;
    /**
     * 结束点经度
     */
    @ApiModelProperty(value = "结束点经度")
    @TableField("endLongitude")
    private BigDecimal endLongitude;
    /**
     * 结束点纬度
     */
    @ApiModelProperty(value = "结束点纬度")
    @TableField("endLatitude")
    private BigDecimal endLatitude;
    /**
     * 结束点道路名称
     */
    @ApiModelProperty(value = "结束点道路名称")
    @TableField("endRoadName")
    private String endRoadName;
    /**
     * 区域验证
     */
    @ApiModelProperty(value = "区域验证")
    @TableField("isRegionV")
    private String isRegionV;
    /**
     * 区域id
     */
    @ApiModelProperty(value = "区域id")
    @TableField("AnalyzeID")
    private Integer AnalyzeID;
    /**
     * 是否夜间
     */
    @ApiModelProperty(value = "是否夜间")
    @TableField("atNocturnal")
    private Integer atNocturnal;
    /**
     * 报警类型（区分是否异常报警）
     */
    @ApiModelProperty(value = "报警类型（区分是否异常报警）")
    @TableField("BaoJingType")
    private Integer BaoJingType;
    /**
     * 超速比
     */
    @ApiModelProperty(value = "超速比")
    @TableField("ChaoSuBi")
    private Integer ChaoSuBi;


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
