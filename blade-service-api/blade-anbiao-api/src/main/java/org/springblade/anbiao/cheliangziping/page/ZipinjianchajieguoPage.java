package org.springblade.anbiao.cheliangziping.page;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/314:57
 */

@Data
@ApiModel(value = "ZipinjianchajieguoPage", description = "ZipinjianchajieguoPage")
public class ZipinjianchajieguoPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;


	/**
	 * 企业 id
	 */
	@ApiModelProperty(value = "单位id",required = true)
	private Integer deptId;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")

	private String beginTime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")

	private String endTime;
	/**
	 * 自检周期
	 */
	@ApiModelProperty(value = "自检周期")
	private String zijianzhouqi;
}
