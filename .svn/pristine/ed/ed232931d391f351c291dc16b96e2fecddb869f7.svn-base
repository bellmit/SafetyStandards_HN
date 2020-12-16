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
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-06-28
 */
@Data
@TableName("baobiao_vehdailyreport")
@ApiModel(value = "Vehdailyreport对象", description = "Vehdailyreport对象")
public class Vehdailyreport implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer vehid;
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
     * 统计日期
     */
    @ApiModelProperty(value = "统计日期")
    private LocalDate date;
  @TableField("stopFlag")
  private Boolean stopFlag;
  @TableField("trackCount")
  private Integer trackCount;
  @TableField("locateCount")
  private Integer locateCount;
  @TableField("offsetCount")
  private Integer offsetCount;
  @TableField("lostSeconds")
  private Integer lostSeconds;
    /**
     * 里程统计
     */
    @ApiModelProperty(value = "里程统计")
    @TableField("mileageCount")
  private BigDecimal mileageCount;
  @TableField("invalidMileageCount")
  private BigDecimal invalidMileageCount;
  @TableField("oilUsedAmount")
  private BigDecimal oilUsedAmount;
  @TableField("runSeconds")
  private Integer runSeconds;
  @TableField("stopSeconds")
  private Integer stopSeconds;
  @TableField("stopOilUsedAmount")
  private BigDecimal stopOilUsedAmount;
  @TableField("mileageCountOfPulse")
  private BigDecimal mileageCountOfPulse;
  @TableField("mileageMaxOfPulse")
  private BigDecimal mileageMaxOfPulse;
    /**
     * 起点经度
     */
    @ApiModelProperty(value = "起点经度")
    private BigDecimal x;
    /**
     * 起点纬度
     */
    @ApiModelProperty(value = "起点纬度")
    private BigDecimal y;
    /**
     * 终点经度
     */
    @ApiModelProperty(value = "终点经度")
    private BigDecimal x2;
    /**
     * 终点纬度
     */
    @ApiModelProperty(value = "终点纬度")
    private BigDecimal y2;
 	 @TableField("alarmCount")
 	 private Integer alarmCount;
	  @TableField("speedAlarmCount")
	  private Integer speedAlarmCount;
 	 @TableField("speedAlarmNightCount")
 	 private Integer speedAlarmNightCount;
	  @TableField("tiredAlarmCount")
 	 private Integer tiredAlarmCount;
 	 @TableField("tiredAlarmNightCount")
 	 private Integer tiredAlarmNightCount;
	  @TableField("nightAlarmCount")
	  private Integer nightAlarmCount;
	  @TableField("outAlarmCount")
	  private Integer outAlarmCount;
  @TableField("otherAlarmCount")
  private Integer otherAlarmCount;
  @TableField("sendMessageCount")
  private Integer sendMessageCount;
  @TableField("trackQueryCount")
  private Integer trackQueryCount;
  @TableField("photoCount")
  private Integer photoCount;
  @TableField("photoQueryCount")
  private Integer photoQueryCount;
  @TableField("createTime")
  private LocalDateTime createTime;
	@ApiModelProperty(value = "开始位置")
  private String kaishiweizhi;
	@ApiModelProperty(value = "结束位置")
  private String jieshuweizhi;
	@ApiModelProperty(value = "行驶时间")
	private  String  xingshishijian;
	@ApiModelProperty(value = "平均速度")
	private String pingjunsudu;

	@ApiModelProperty(value = "停车时长")
	private String stopshijian;



}
