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
import java.time.LocalDateTime;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-12-04
 */
@Data
@TableName("baobiao_stopvehicle")
@ApiModel(value = "Stopvehicle对象", description = "Stopvehicle对象")
public class Stopvehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * gps车辆id
     */
    @ApiModelProperty(value = "gps车辆id")
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
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String company;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime begintime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endtime;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double lat;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double lon;
    /**
     * 位置
     */
    @ApiModelProperty(value = "位置")
    private String location;
    /**
     * 插入时间
     */
    @ApiModelProperty(value = "插入时间")
    @TableField("Inserttime")
  private LocalDateTime Inserttime;
    /**
     * 持续时间毫秒
     */
    @ApiModelProperty(value = "持续时间毫秒")
    private Integer times;


}
