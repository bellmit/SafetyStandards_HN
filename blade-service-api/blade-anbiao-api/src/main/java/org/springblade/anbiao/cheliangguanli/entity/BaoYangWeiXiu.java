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
package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_cheliang_baoyangweixiu")
@ApiModel(value = "BaoYangWeiXiu对象", description = "BaoYangWeiXiu对象")
public class BaoYangWeiXiu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 所属企业ID
     */
    @ApiModelProperty(value = "所属企业ID")
    private Integer deptId;

    /**
     * 送修司机ID
     */
    @ApiModelProperty(value = "送修司机ID")
    private String driverId;

    /**
     * 车辆ID
     */
    @ApiModelProperty(value = "车辆ID")
    private String vehicleId;

    /**
     * 维修类别ID
     */
    @ApiModelProperty(value = "维修类别ID")
    private String maintainDictId;

    /**
     * 预计完工日期
     */
    @ApiModelProperty(value = "预计完工日期")
    private String expectedCompletion;

    /**
     * 运修日期
     */
    @ApiModelProperty(value = "运修日期")
    private String sendDate;

    /**
     * 实际完工日期
     */
    @ApiModelProperty(value = "实际完工日期")
    private String actualCompletionDate;

    /**
     * 进场里程读数
     */
    @ApiModelProperty(value = "进场里程读数")
    private double inRangeMileage;

    /**
     * 进场油量读数
     */
    @ApiModelProperty(value = "进场油量读数")
    private double inTheOil;

    /**
     * 下次保养维修里程
     */
    @ApiModelProperty(value = "下次保养维修里程")
    private double nextMaintenanceMileage;

    /**
     * 下次保养维修日期
     */
    @ApiModelProperty(value = "下次保养维修日期")
    private String nextMaintenanceDate;

    /**
     * 维修单位
     */
    @ApiModelProperty(value = "维修单位")
    private String maintenanceDeptName;

    /**
     * 派修人ID
     */
    @ApiModelProperty(value = "派修人ID")
    private Integer sendRepairPersonId;

    /**
     * 接车司机ID
     */
    @ApiModelProperty(value = "接车司机ID")
    private Integer pickUpVehicleDriverId;

    /**
     * 接车时间
     */
    @ApiModelProperty(value = "接车时间")
    private String pickUpVehicleDate;

    /**
     * 备注/说明
     */
    @ApiModelProperty(value = "备注/说明")
    private String remark;

    /**
     * 保修项目小计
     */
    @ApiModelProperty(value = "保修项目小计")
    private Integer subtotalOfWarrantyItems;

    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;

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
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

    /**
     * 材料数量小计
     */
    @ApiModelProperty(value = "材料数量小计")
    private Integer subtotalOfMaterialQuantity;

	/**
	 * 材料小计
	 */
	@ApiModelProperty(value = "材料小计")
	private Integer materialSubtotal;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createtime;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
	private String createperson;

	/**
	 * 创建者ID
	 */
	@ApiModelProperty(value = "创建者ID")
	private Integer createid;

}
