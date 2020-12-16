package org.springblade.anbiao.cheliangziping.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.common.BasePage;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/315:36
 */

@Data
@ApiModel(value = "ZipinwenjianPage", description = "ZipinwenjianPage")
public class ZipinwenjianPage <T> extends BasePage<T> {
	/**
	 * 检查结果id
	 */
	@ApiModelProperty(value = "检查结果id",required = true)
	private String jieguoid;

	/**
	 *
	 */
	private Integer deptId;
	/**
	 *  文档名
	 */

	private String wendangName;
}
