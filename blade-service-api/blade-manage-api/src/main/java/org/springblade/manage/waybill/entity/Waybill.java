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
import java.util.List;

/**
 * 实体类
 *
 * @author jx
 * @since 2019-08-07
 */
@Data
@TableName("manage_waybill")
@ApiModel(value = "Waybill对象", description = "Waybill对象")
public class Waybill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键idu
     */
    @ApiModelProperty(value = "主键id")
	@TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 出库编号
     */
    @ApiModelProperty(value = "出库编号")
    private String outNum;
    /**
     * 出库时间
     */
    @ApiModelProperty(value = "出库时间")
    private String outTime;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    private String vehicleId;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
    private Integer deptId;
    /**
     * 货物名称
     */
    @ApiModelProperty(value = "货物名称")
    private String goods;
    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private String guige;
    /**
     * 出库毛重
     */
    @ApiModelProperty(value = "出库毛重")
    @TableField("ogross_weight")
    private Double ogrossWeight;
    /**
     * 出库皮重
     */
    @ApiModelProperty(value = "出库皮重")
    @TableField("otare")
    private Double otare;
    /**
     * 出库净重
     */
    @ApiModelProperty(value = "出库净重")
    @TableField("onet_weight")
    private Double onetWeight;
    /**
     * 发货单位
     */
    @ApiModelProperty(value = "发货单位")
    private String forwardeUnit;
    /**
     * 收货单位
     */
    @ApiModelProperty(value = "收货单位")
    private String receiveUnit;
    /**
     * 运输单位
     */
    @ApiModelProperty(value = "运输单位")
    private String transportUnit;
    /**
     * 出库毛重时间
     */
    @ApiModelProperty(value = "出库毛重时间")
    @TableField("ogross_weight_time")
    private String ogrossWeightTime;
    /**
     * 出库皮重时间
     */
    @ApiModelProperty(value = "出库皮重时间")
    @TableField("otare_time")
    private String otareTime;
    /**
     * 司磅员
     */
    @ApiModelProperty(value = "司磅员")
    @TableField("osibangyuan")
    private String osibangyuan;
    /**
     * 销售部
     */
    @ApiModelProperty(value = "销售部")
    private String saleDept;
    /**
     * 厂生产管理部
     */
    @ApiModelProperty(value = "厂生产管理部")
    private String productDept;
    /**
     * 车间
     */
    @ApiModelProperty(value = "车间")
    private String workshop;
    /**
     * 提货
     */
    @ApiModelProperty(value = "提货")
    @TableField(" take_goods")
    private String takeGoods;
    /**
     * 入库磅单序号
     */
    @ApiModelProperty(value = "入库磅单序号")
    @TableField("into_num")
    private String intoNum;
    /**
     * 入库时间
     */
    @ApiModelProperty(value = "入库时间")
    @TableField("into_time")
    private String intoTime;
    /**
     * 入库毛重
     */
    @ApiModelProperty(value = "入库毛重")
    @TableField("igross_weight")
    private Double igrossWeight;
    /**
     * 入库皮重
     */
    @ApiModelProperty(value = "入库皮重")
    @TableField("itare")
    private Double itare;
    /**
     * 入库净重
     */
    @ApiModelProperty(value = "入库净重")
    @TableField("inet_weight")
    private Double inetWeight;
    /**
     * 入库毛重时间
     */
    @ApiModelProperty(value = "入库毛重时间")
    @TableField("igross_weight_time")
    private String igrossWeightTime;
    /**
     * 入库皮重时间
     */
    @ApiModelProperty(value = "入库皮重时间")
    @TableField("itare_time")
    private String itareTime;
    /**
     * 入库毛重司磅员
     */
    @ApiModelProperty(value = "入库毛重司磅员")
    @TableField("igross_weight_man")
    private String igrossWeightMan;
    /**
     * 入库皮重司磅员
     */
    @ApiModelProperty(value = "入库皮重司磅员")
    @TableField("itare_man")
    private String itareMan;
    /**
     * 结算数
     */
    @ApiModelProperty(value = "结算数")
    private Integer jiesuanshu;
    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    private String driver;
    /**
     * 入库里程
     */
    @ApiModelProperty(value = "入库里程")
    private String rukulicheng;
    /**
     * 出库里程
     */
    @ApiModelProperty(value = "出库里程")
    private String chukulicheng;
    /**
     * 回车里程
     */
    @ApiModelProperty(value = "回车里程")
    private String huichelicheng;
    /**
     * 燃油费
     */
    @ApiModelProperty(value = "燃油费")
    private String ranyoufei;
    /**
     * 过路费
     */
    @ApiModelProperty(value = "过路费")
    private String guolufei;
    /**
     * 其他费用
     */
    @ApiModelProperty(value = "其他费用")
    private String qitafei;
    /**
     * 出库附件
     */
    @ApiModelProperty(value = "出库附件")
    @TableField("ofujian")
    private String ofujian;
    /**
     * 入库附件
     */
    @ApiModelProperty(value = "入库附件")
    @TableField("ifujian")
    private String ifujian;
    /**
     * 其他附件
     */
    @ApiModelProperty(value = "其他附件")
    @TableField("tfujian")
    private String tfujian;
    /**
     * 1-已审核，0-未审核
     */
    @ApiModelProperty(value = "1-已审核，0-未审核")
    private Integer status;
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
	 * 燃油/过路 附件
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "燃油/过路 附件")
    private List<WaybillFujian> waybillFujian;
	/**
	 * 单价
	 */
	@ApiModelProperty(value = "单价")
	private String danjia;

}
