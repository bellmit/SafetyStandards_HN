package org.springblade.anbiao.cheliangziping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/218:48
 */
@Data
@ApiModel(value = "Zipingjieguocongbiao", description = "Zipingjieguocongbiao")
public class Zipingjieguocongbiao {
	@TableId(value = "id")
	@ApiModelProperty(value = "id",required=true)
	private String	  id;
	@ApiModelProperty(value = "检查表id",required=true)
	private Integer	  zipinjianchaxiangId;
	@ApiModelProperty(value = "检查状态 0未检查 1检查",required=true)
	private Integer  isHege;
	@ApiModelProperty(value = "备注")
	private  String  beizhu;
	@ApiModelProperty(value = "主表id")
	private String zipinjianchaId;

}
