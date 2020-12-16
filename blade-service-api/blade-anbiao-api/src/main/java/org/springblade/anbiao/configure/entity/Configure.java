package org.springblade.anbiao.configure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: SafetyStandards
 * @author: 呵呵哒
 **/
@Data
@ApiModel(value = "Configure对象", description = "Configure对象")
public class Configure implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@ApiModelProperty(value = "id")
	@TableId(value = "id",type = IdType.UUID)
	private String id;
	/**
	 * 单位id
	 */
	@ApiModelProperty(value = "单位id")
	private Integer deptId;
	/**
	 * 数据表字段
	 */
	@ApiModelProperty(value = "数据表字段")
	private String shujubiaoziduan;
	/**
	 * 实际字段
	 */
	@ApiModelProperty(value = "实际字段")
	private String shijiziduan;
	/**
	 * 字段含义
	 */
	@ApiModelProperty(value = "字段含义")
	private String label;
	/**
	 * 表单参数
	 */
	@ApiModelProperty(value = "表单参数")
	private String biaodancanshu;
	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer isdeleted;

	/**
	 * 表名
	 */
	@ApiModelProperty(value = "表名")
	private String tableName;
}
