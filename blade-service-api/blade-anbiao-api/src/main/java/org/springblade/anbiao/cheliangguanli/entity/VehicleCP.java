package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: SafetyStandards
 * @description: Vehicle
 * @author: elvis
 * @create2021-04-22 14:00
 **/
@Data
@TableName("anbiao_vehicle")
@ApiModel(value = "Vehicle对象", description = "Vehicle对象")
public class VehicleCP implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "车辆牌照",required = true)
    private String cheliangpaizhao;

}
