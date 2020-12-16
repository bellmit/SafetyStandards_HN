package org.springblade.anbiao.guanlijigouherenyuan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Huiyirenyuan;

/**
 * @program: SafetyStandards
 * @author: 呵呵哒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HuiyirenyuanVO对象", description = "HuiyirenyuanVO对象")
public class HuiyirenyuanVO extends Huiyirenyuan {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构名
	 */
	@ApiModelProperty(value = "机构名")
	private String deptName;
}
