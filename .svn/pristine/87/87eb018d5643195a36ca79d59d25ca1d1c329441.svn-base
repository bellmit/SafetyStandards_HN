package org.springblade.anbiao.jinritixing.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

import java.time.LocalDateTime;

/**
 * Created by you on 2019/5/7.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "JinritixingPage对象", description = "JinritixingPage对象")
public class JinritixingPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
//	@ApiModelProperty(value = "车辆牌照")
//	private String cheliangpaizhao;
    @ApiModelProperty(value = "驾驶员姓名")
    private String jiashiyuanxingming;
	@ApiModelProperty(value = "统计日期", required = true)
	private String tongjiriqi;
	@ApiModelProperty(value = "提醒类型", required = true)
	private String tixingleixing;
	@ApiModelProperty(value = "提醒详情",required = true)
	private String tixingxiangqing;
	@ApiModelProperty(value = "岗位id", required = true)
	private String postid;
}
