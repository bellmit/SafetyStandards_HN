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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author jx
 * @since 2019-10-20
 */
@Data
@TableName("baobiao_gpsfuelveh")
@ApiModel(value = "Gpsfuelveh对象", description = "Gpsfuelveh对象")
public class Gpsfuelveh implements Serializable {

    private static final long serialVersionUID = 1L;

  private Integer cid;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String company;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    private String vehid;
    /**
     * 车辆牌照
     */
    @ApiModelProperty(value = "车辆牌照")
    private String plate;
    /**
     * 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private String color;
    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    @TableField("OperatType")
  private String OperatType;
    /**
     * 座位数
     */
    @ApiModelProperty(value = "座位数")
    private Integer seatnumber;
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    @TableField("Agroup")
  private String Agroup;
    /**
     * 路线
     */
    @ApiModelProperty(value = "路线")
    private String schname;


}
