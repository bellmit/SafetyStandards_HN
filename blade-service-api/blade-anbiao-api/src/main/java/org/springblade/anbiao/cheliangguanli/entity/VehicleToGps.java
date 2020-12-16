/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Date:     2020/6/18 14:49
 * Description:
 */
package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.security.PrivateKey;
import java.time.LocalDateTime;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/18
 * @描述
 */
@Data
@TableName("anbiao_vehicle")
@ApiModel(value = "VehicleToGps对象", description = "VehicleToGps对象")
public class VehicleToGps implements Serializable {

	@TableId(value = "id", type = IdType.UUID)
	@ApiModelProperty(value = "主键")
	private String id;

	@ApiModelProperty(value = "车辆牌照",required = true)
	private String cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色",required = true)
	private String chepaiyanse;

	@ApiModelProperty(value = "终端id")
	private String zongduanid;

	@ApiModelProperty(value = "终端型号")
	private String zongduanxinghao;

	@ApiModelProperty(value = "SIM卡号")
	private String simnum;

	@ApiModelProperty(value = "操作时间")
	private LocalDateTime caozuoshijian;

	@ApiModelProperty(value = "创建时间",required = true)
	private LocalDateTime createtime;

	@ApiModelProperty(value = "机构ID")
	private String deptId;

	@ApiModelProperty(value = "机构名称")
	private String deptName;

	@ApiModelProperty(value = "车辆状态")
	private String cheliangzhuangtai;

	@ApiModelProperty(value = "车辆使用性质")
	private String shiyongxingzhi;
}
