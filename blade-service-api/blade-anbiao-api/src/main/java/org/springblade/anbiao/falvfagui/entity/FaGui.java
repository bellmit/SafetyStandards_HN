package org.springblade.anbiao.falvfagui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: SafetyStandards
 * @description: 法律法规-法规
 * @author: 呵呵哒
 **/
@Data
@TableName("anbiao_fagui")
@ApiModel(value = "Fagui对象", description = "Fagui对象")
public class FaGui implements Serializable {

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.UUID)
	@ApiModelProperty(value = "id")
	private String id;
	/**
	 * 单位id
	 */
	@ApiModelProperty(value = "单位id")
	private Integer deptId;
	/**
	 * 操作人
	 */
	@ApiModelProperty(value = "操作人")
	private String caozuoren;
	/**
	 * 操作人id
	 */
	@ApiModelProperty(value = "操作人id")
	private Integer caozuorenid;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;
	/**
	 * 法律法规名称
	 */
	@ApiModelProperty(value = "法律法规名称")
	private String falvfaguimingcheng;
	/**
	 * 颁布机关
	 */
	@ApiModelProperty(value = "颁布机关")
	private String banbujiguan;
	/**
	 * 颁布时间
	 */
	@ApiModelProperty(value = "颁布时间")
	private LocalDateTime banbushijian;
	/**
	 * 法律法规分类
	 */
	@ApiModelProperty(value = "法律法规分类")
	private String falvfaguifenlei;
	/**
	 * 摘要
	 */
	@ApiModelProperty(value = "摘要")
	private String zhaiyao;
	/**
	 * 说明
	 */
	@ApiModelProperty(value = "说明")
	private String shuoming;
	/**
	 * 使用部门
	 */
	@ApiModelProperty(value = "使用部门")
	private String shiyongbumen;
	/**
	 * 附件
	 */
	@ApiModelProperty(value = "附件")
	private String fujian;
	/**
	 *
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "单位名称")
	private String deptName;
	/**
	 * 是否删除 0 正常 1删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer is_deleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;

}
