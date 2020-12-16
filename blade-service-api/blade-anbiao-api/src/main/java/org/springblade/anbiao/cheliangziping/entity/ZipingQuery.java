package org.springblade.anbiao.cheliangziping.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/218:51
 */
@Data
@ApiModel(value = "ZipingQuery", description = "ZipingQuery")
public class ZipingQuery {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业名称",required=true)
	private String deptname;
	@ApiModelProperty(value = "标题",required=true)
	private String biaoti;
	@ApiModelProperty(value = "自检周期",required=true)
	private String  zijianzhouqi;
	@ApiModelProperty(value = "运营类型",required=true)
	private String yunyingleixing;
	@ApiModelProperty(value = "部门id",required=true )
	private  Integer deptid;
	@ApiModelProperty(value = "检查结果ids 每项需要上传 ",required=true )
	private List<Zipingjieguocongbiao> list;
	@ApiModelProperty(value = "备注")
	private String beizhu;
	@ApiModelProperty(value = "完结 0未完结可编辑 1完结不可编辑" )
	private Integer wanjie;
	@ApiModelProperty("检查历史id")
	private String id;
	@ApiModelProperty("tableId")
	private String tableId;
	@ApiModelProperty("报告时间")
	private String  baogaoshijian;
}
