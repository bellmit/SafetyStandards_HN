package org.springblade.anbiao.baobiaowenjian.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoMulu;

import java.time.LocalDateTime;

/**
 * 视图实体类
 *
 * @author hyp
 * @since 2019-05-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WenjianVO对象", description = "WenjianVO对象")
public class BaobiaoMuluVO extends BaobiaoMulu {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "推送日期（年-月-日）")
	private String createtimeshow;
	@ApiModelProperty(value = "总报警次数")
	private Integer baojingcishu;
	@ApiModelProperty(value = "超速报警")
	private Integer chaosu;
	@ApiModelProperty(value = "疲劳驾驶报警")
	private Integer pilao;
	@ApiModelProperty(value = "夜间行驶报警")
	private Integer yejian;
	@ApiModelProperty(value = "异常车辆报警")
	private Integer yichang;
	@ApiModelProperty(value = "抽烟报警")
	private Integer chouyan;
	@ApiModelProperty(value = "接打电话报警")
	private Integer dadianhua;
	@ApiModelProperty(value = "疲劳驾驶报警（视频）")
	private Integer pilaoshipin;
	@ApiModelProperty(value = "分神驾驶报警")
	private Integer fenshen;

}
