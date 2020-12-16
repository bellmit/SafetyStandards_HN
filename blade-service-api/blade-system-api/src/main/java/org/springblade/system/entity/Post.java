package org.springblade.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author hyp
 */
@Data
@TableName("blade_post")
@ApiModel(value = "Post对象", description = "Post对象")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 人员id
	 */
	@ApiModelProperty(value = "人员id")
	private Integer userId;

	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private Integer postId;
	/**
	 * 是否默认
	 */
	@ApiModelProperty(value = "是否默认")
	private Integer isdefault;
}
