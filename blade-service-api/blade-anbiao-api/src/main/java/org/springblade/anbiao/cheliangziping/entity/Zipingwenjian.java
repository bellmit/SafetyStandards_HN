package org.springblade.anbiao.cheliangziping.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/315:31
 */
@Data
@ApiModel(value = "ZIpingwenjian", description = "ZIpingwenjian")
public class Zipingwenjian {
	@ApiModelProperty(value = "id")
	private String id;
	@ApiModelProperty(value = "结果id",required=true)
	private  String zipinjianchaJieguoId;
	@ApiModelProperty(value = "文件名称",required=true)
	private String  wenjianmingcheng;
	@ApiModelProperty(value = "所属文档",required=true)
	private  String suoshuwendangleixing;
	@ApiModelProperty(value = "文件id",required=true)
	private Integer wenjianid;
	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;
	@ApiModelProperty(value = "操作人")
	private  String  caozuoren;
	@ApiModelProperty(value = "检查项名称",required=true)
	private String jianchaxiangmingcheng;
	@ApiModelProperty(value = "企业名称")
	private String  deptName;
}
