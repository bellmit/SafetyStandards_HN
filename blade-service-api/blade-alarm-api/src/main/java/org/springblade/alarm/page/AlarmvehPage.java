package org.springblade.alarm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.common.BasePage;

@Data
@ApiModel(value = "AlarmvehPage", description = "AlarmvehPage")
public class AlarmvehPage<T>  extends BasePage<T>{

	@ApiModelProperty(value = "企业名字", required = true)
	private String  company;
	@ApiModelProperty(value = "时间", required = true)
	private String date;


//	@ApiModelProperty(value = "第几页", required = true)
//	private Integer current;
//	@ApiModelProperty(value = "每页显示数", required = true)
//	private Integer size;
//	@ApiModelProperty(value = "总数")
//	private Integer total;
//	@ApiModelProperty(value = "总页数")
//	private Integer pageTotal;
//	@ApiModelProperty(value = "偏移量")
//	private Integer offsetNo;
//	@ApiModelProperty(value = "正序/倒序")
//	private Integer order;
//	@ApiModelProperty(value = "排序字段")
//	private String orderColumn;
//
//	@ApiModelProperty(value = "分页数据")
//	private Object  records;
}
