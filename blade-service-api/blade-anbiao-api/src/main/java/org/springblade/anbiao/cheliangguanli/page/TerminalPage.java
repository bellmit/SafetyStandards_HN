package org.springblade.anbiao.cheliangguanli.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.BasePage;

/**
 * Created by you on 2019/5/1.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TerminalPage对象", description = "TerminalPage对象")
public class TerminalPage<T> extends BasePage<T> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业 ID", required = true)
	private Integer deptId;

	@ApiModelProperty(value = "终端类型")
	private String terminalType;

	@ApiModelProperty(value = "终端型号")
	private String terminalModel;

	@ApiModelProperty(value = "生产厂家")
	private String terminalManufacturer;

}
