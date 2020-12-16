package org.springblade.anbiao.jiaoyupeixun.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "JiaoyupeixunPage对象", description = "JiaoyupeixunPage对象")
public class JiaoyupeixunPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;


}
