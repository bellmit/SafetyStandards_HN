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
package org.springblade.manage.waybill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 实体类
 */
@Data
@TableName("manage_operations")
@ApiModel(value = "Operations对象", description = "Operations对象")
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
	@TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Integer deptId;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    private String vehicleId;
	/**
	 * 类型
	 */
	@ApiModelProperty(value = "交通费类型")
	private String leixing;
	/**
	 * 检验日期
	 */
	@ApiModelProperty(value = "检验日期")
  	private String jianyanriqi;
    /**
     * 是否合格
     */
    @ApiModelProperty(value = "是否合格")
    private String shifouhege;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal jine;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private String shijian;
	/**
	 * status
	 */
	@ApiModelProperty(value="审核状态")
	private Integer status;
    /**
     * 车辆维护单位
     */
    @ApiModelProperty(value = "车辆维护单位")
    private String weihudanwei;
	/**
	 * 车辆维护类别
	 */
	@ApiModelProperty(value = "车辆维护类别")
  	private String weihuleibie;
    /**
     * 进厂日期
     */
    @ApiModelProperty(value = "进厂日期")
    private String jinchangriqi;
    /**
     * 进厂里程
     */
    @ApiModelProperty(value = "进厂里程")
    private BigDecimal jinchanglicheng;
    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    private String chuchangriqi;
    /**
     * 下次维护时间
     */
    @ApiModelProperty(value = "下次维护时间")
    private String xiaciweihushijian;
    /**
     * 维护合同编号
     */
    @ApiModelProperty(value = "维护合同编号")
    private String weihuhetongbianhao;
    /**
     * 维护内容
     */
    @ApiModelProperty(value = "维护内容")
    private String weihuneirong;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String xingming;
    /**
     * 证件名称
     */
    @ApiModelProperty(value = "证件名称")
    private String zhengjianmingcheng;
    /**
     * 审验类型
     */
    @ApiModelProperty(value = "审验类型")
    private String shenyanleixing;
    /**
     * 审验机构
     */
    @ApiModelProperty(value = "审验机构")
    private String shenyanjigou;
    /**
     * 审验日期
     */
    @ApiModelProperty(value = "审验日期")
    private String shenyanriqi;
    /**
     * 有效日期
     */
    @ApiModelProperty(value = "有效日期")
    private String youxiaoqi;
    /**
     * 加油时间
     */
    @ApiModelProperty(value = "加油时间")
    private String refuelingTime;
    /**
     * 加油型号
     */
    @ApiModelProperty(value = "加油型号")
    private Integer fuelType;
    /**
     * 油卡编号
     */
    @ApiModelProperty(value = "油卡编号")
    private String oilcardNumber;
    /**
     * 加油量
     */
    @ApiModelProperty(value = "加油量")
    private BigDecimal fuelVolume;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;
    /**
     * 油表里程
     */
    @ApiModelProperty(value = "油表里程")
    private BigDecimal meterMileage;
    /**
     * 百公里油耗
     */
    @ApiModelProperty(value = "百公里油耗")
    private BigDecimal oilConsumption;
    /**
     * 是否有单据
     */
    @ApiModelProperty(value = "是否有单据")
    private String isBill;
    /**
     * 记录人
     */
    @ApiModelProperty(value = "记录人")
    private String jiluren;
    /**
     * 被保险人
     */
    @ApiModelProperty(value = "被保险人")
    private String beibaoxianren;
    /**
     * 登记人
     */
    @ApiModelProperty(value = "登记人")
    private String dengjiren;
    /**
     * 登记时间
     */
    @ApiModelProperty(value = "登记时间")
    private String dengjishijian;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型 1燃油费、2交通费、3维修费、4保险费、5车辆年审费、6驾驶员年审费、7其他费用")
    private String type;
    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户")
    private String createUser;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    /**
     * 更新用户
     */
    @ApiModelProperty(value = "更新用户")
    private String updateUser;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updateTime;
    /**
     * 0-未删除，1-已删除
     */
    @ApiModelProperty(value = "0-未删除，1-已删除")
    private Integer isDeleted;
	/**
	 * 附件
	 */
	@ApiModelProperty(value = "附件")
	private String fujian;
	/**
	 * 标志
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "标志 判断pc还是app录入")
	private Integer biaozhi;

}
