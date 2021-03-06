package org.springblade.anbiao.cheliangguanli.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/5/2.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BaoxiuxiangmumingxiPage对象", description = "BaoxiuxiangmumingxiPage对象")
public class BaoxiuxiangmumingxiPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "企业 id", required = true)
	private Integer deptId;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "车辆牌照")
	private String cheliangpaizhao;
	@ApiModelProperty(value = "车辆维护id", required = true)
	private String weihuid;
}
